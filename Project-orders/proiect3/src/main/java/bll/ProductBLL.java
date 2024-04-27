package bll;

import bll.validators.StockValidator;
import bll.validators.Validator;
import dao.ProductDAO;
import model.Client;
import model.Comanda;
import model.Product;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Business logic class for managing Product objects.
 */
public class ProductBLL {
    private List<Validator<Product>> validators;
    private ProductDAO productDAO;

    /**
     * Constructs a new instance of ProductBLL.
     */
    public ProductBLL() {
        validators = new ArrayList<>();
        validators.add(new StockValidator());

        productDAO = new ProductDAO();
    }

    /**
     * Finds a Product by its ID.
     *
     * @param id the ID of the Product
     * @return the found Product
     * @throws NoSuchElementException if the Product with the specified ID is not found
     */
    public Product findProductById(int id) {
        Product p = productDAO.findById(id);
        if (p == null) {
            throw new NoSuchElementException("The product with id =" + id + " was not found!");
        }
        return p;
    }

    /**
     * Finds a Product by its name.
     *
     * @param name the name of the Product
     * @return the found Product
     * @throws NoSuchElementException if the Product with the specified name is not found
     */
    public Product findProductByName(String name) {
        Product p = productDAO.findByName(name);
        if (p == null) {
            throw new NoSuchElementException("The product with name =" + name + " was not found!");
        }
        return p;
    }

    /**
     * Retrieves all Product objects.
     *
     * @return a list of all Product objects
     * @throws NoSuchElementException if the list of Product objects is empty
     */
    public List<Product> findAll() {
        List<Product> p = productDAO.findAll();
        if (p == null) {
            throw new NoSuchElementException("The list of Product is empty");
        }
        return p;
    }

    /**
     * Adds a new Product.
     *
     * @param p the Product to be added
     */
    public void addProduct(Product p) {
        productDAO.insert(p);
    }

    /**
     * Edits an existing Product.
     *
     * @param id the ID of the Product to be edited
     * @param p  the updated Product object
     */
    public void editProduct(int id, Product p) {
        productDAO.update(id, p);
    }

    /**
     * Deletes a Product.
     *
     * @param p the Product to be deleted
     * @throws NoSuchElementException if the list of Product objects is empty
     */
    public void deleteProduct(Product p) {
        List<Product> pr = productDAO.findAll();
        if (pr == null) {
            throw new NoSuchElementException("The list of Product is empty");
        } else {
            productDAO.delete(p);
        }
    }

    /**
     * Creates a JTable with Product data.
     *
     * @param pane the JScrollPane to contain the JTable
     * @param p    the list of Product objects
     * @return the created JTable
     * @throws IllegalAccessException if there is an issue accessing the fields of the Product object
     */
    public JTable table(JScrollPane pane, List<Product> p) throws IllegalAccessException {
        return productDAO.Tabel(pane, p);
    }
}
