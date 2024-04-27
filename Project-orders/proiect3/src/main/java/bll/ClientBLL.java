package bll;

import bll.validators.EmailValidator;
import bll.validators.Validator;
import bll.validators.AgeValidator;
import dao.ClientDAO;
import model.Client;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
/**
 * Business logic class for managing Client objects.
 */
public class ClientBLL {
    private List<Validator<Client>> validators;
    private ClientDAO clientDAO;
    /**
     * Constructs a new instance of ClientBLL.
     */
    public ClientBLL() {
        validators = new ArrayList<Validator<Client>>();
        validators.add(new EmailValidator());
        validators.add(new AgeValidator());

        clientDAO = new ClientDAO();
    }
    /**
     * Finds a Client by their ID.
     *
     * @param id the ID of the Client
     * @return the found Client
     * @throws NoSuchElementException if the Client with the specified ID is not found
     */
    public Client findClientById(int id) {
        Client c = clientDAO.findById(id);
        if (c == null) {
            throw new NoSuchElementException("The client with id =" + id + " was not found!");
        }
        return c;
    }
    /**
     * Finds a Client by their name.
     *
     * @param name the name of the Client
     * @return the found Client
     * @throws NoSuchElementException if the Client with the specified name is not found
     */
    public Client findClientByName(String name) {
        Client c = clientDAO.findByName(name);
        if (c == null) {
            throw new NoSuchElementException("The client with name = " + name + " was not found!");
        }
        return c;
    }
    /**
     * Retrieves all Clients.
     *
     * @return a list of all Clients
     * @throws NoSuchElementException if the list of Clients is empty
     */
    public List<Client> findAll() {
        List<Client> c= clientDAO.findAll();
        if(c==null){
            throw new NoSuchElementException("The list Client is empty");
        }
        return c;
    }
    /**
     * Adds a new Client.
     *
     * @param c the Client to be added
     */
    public void addClient(Client c){
        clientDAO.insert(c);
    }
    /**
     * Edits an existing Client.
     *
     * @param id the ID of the Client to be edited
     * @param c  the updated Client object
     */
    public void editClient(int id, Client c) {
        clientDAO.update(id, c);}
    /**
     * Deletes a Client.
     *
     * @param c the Client to be deleted
     */
    public void deleteClient(Client c){
        clientDAO.delete(c);
    }
    /**
     * Creates a JTable with Client data.
     *
     * @param pane the JScrollPane to contain the JTable
     * @param c    the list of Clients
     * @return the created JTable
     * @throws IllegalAccessException if there is an issue accessing the fields of the Client object
     */
    public JTable table(JScrollPane pane, List<Client> c) throws IllegalAccessException {
        return clientDAO.Tabel(pane,c);
    }
}
