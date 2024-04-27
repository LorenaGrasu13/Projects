/**
 * The dao package provides classes for data access operations.
 */
package dao;

import connection.ConnectionFactory;
import presentation.DisplayAllClients;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The AbstractDAO class is a generic class that provides common methods for data access operations.
 * @param <T> the type of object being accessed
 */
public class AbstractDAO<T> {
    /**
     * The logger instance for logging messages.
     */
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    /**
     * The class type of the objects being accessed.
     */
    private final Class<T> type;

    /**
     * Constructs an AbstractDAO object.
     */
    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Creates a SELECT query for the specified field.
     * @param field the field name
     * @return the SELECT query as a string
     */
    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    /**
     * Retrieves all objects of type T from the database.
     * @return a list of all objects
     */
    public List<T> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM " + type.getSimpleName();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Retrieves the object of type T with the specified ID from the database.
     * @param id the ID of the object
     * @return the object with the specified ID
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Retrieves the object of type T with the specified name from the database.
     * @param name the name of the object
     * @return the object with the specified name
     */
    public T findByName(String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("name");

        if (type.getSimpleName().equals("Product")) {
            query = createSelectQuery("ProductName");
        } else if (type.getSimpleName().equals("Client")) {
            query = createSelectQuery("clientName");
        }

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findByName " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Creates a list of objects from the ResultSet.
     * @param resultSet the ResultSet containing the data
     * @return a list of objects created from the ResultSet
     */
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T) ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Inserts an object into the database.
     * @param t the object to insert
     * @return the inserted object
     */
    public T insert(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "INSERT INTO " + type.getSimpleName() + " (";
        for (Field field : type.getDeclaredFields()) {
            query = query + field.getName() + ", ";
        }
        query = query.substring(0, query.length() - 2);
        query = query + ") VALUES (";
        for (Field field : type.getDeclaredFields()) {
            query = query + "?, ";
        }
        query = query.substring(0, query.length() - 2);
        query = query + ")";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            int i = 1;
            for (Field field : type.getDeclaredFields()) {
                field.setAccessible(true);
                statement.setObject(i, field.get(t));
                i++;
            }
            statement.executeUpdate();
            return t;
        } catch (SQLException | IllegalAccessException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Updates an object in the database with the specified ID.
     * @param id the ID of the object to update
     * @param t the updated object
     * @return the updated object
     */
    public T update(int id, T t) {
        T t1 = findById(id);
        Connection connection = null;
        PreparedStatement statement = null;
        String query = "UPDATE " + type.getSimpleName() + " SET ";
        for (Field field : type.getDeclaredFields()) {
            field.setAccessible(true);
            if (!field.getName().equals("id")) {
                query += field.getName() + "=?, ";
            }
        }
        query = query.substring(0, query.length() - 2);
        query += " WHERE id=?";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            int i = 1;
            for (Field field : type.getDeclaredFields()) {
                field.setAccessible(true);
                if (!field.getName().equals("id")) {
                    statement.setObject(i, field.get(t));
                    i++;
                }
            }
            statement.setInt(i, (Integer) getFieldValue(t1, "id"));
            statement.executeUpdate();
            return t;
        } catch (SQLException | IllegalAccessException | NoSuchFieldException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Deletes an object from the database.
     * @param t the object to delete
     */
    public void delete(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = "DELETE FROM " + type.getSimpleName() + " WHERE id=?";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            Integer i = (Integer) getFieldValue(t, "id");
            statement.setInt(1, i);
            statement.executeUpdate();
        } catch (SQLException | NoSuchFieldException | IllegalAccessException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    /**
     * Creates a JTable populated with data from the provided list.
     * @param panel the JScrollPane that will contain the table
     * @param list the list of objects to populate the table with
     * @return the created JTable
     * @throws IllegalAccessException if there is an illegal access to a field
     */
    public JTable Tabel(JScrollPane panel, List<T> list) throws IllegalAccessException {
        Object[][] obj = new Object[list.size()][];
        int i = 0;
        int j = 0;
        for (T item : list) {
            Object[] row = new Object[5];
            j = 0;
            for (Field field : type.getDeclaredFields()) {
                field.setAccessible(true);
                row[j] = field.get(item);
                j++;
            }
            obj[i] = row;
            i++;
        }
        String[] s = new String[j];
        int ii = 0;
        for (Field field : type.getDeclaredFields()) {
            field.setAccessible(true);
            s[ii] = field.getName();
            ii++;
        }
        JTable table = new JTable();
        panel.setViewportView(table);
        table.setModel(new DefaultTableModel(obj, s));
        return table;
    }

    /**
     * Retrieves the value of a field from an object.
     * @param object the object containing the field
     * @param fieldName the name of the field
     * @return the value of the field
     * @throws NoSuchFieldException if the field does not exist
     * @throws IllegalAccessException if there is an illegal access to the field
     */
    private Object getFieldValue(T object, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(object);
    }
}
