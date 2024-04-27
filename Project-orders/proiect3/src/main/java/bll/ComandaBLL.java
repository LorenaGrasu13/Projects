package bll;

import bll.validators.AgeValidator;
import bll.validators.EmailValidator;
import bll.validators.StockValidator;
import bll.validators.Validator;
import dao.ComandaDAO;
import model.Client;
import model.Comanda;
import model.Product;
import presentation.ViewEmployee;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
/**
 * Business logic class for managing Comanda objects.
 */
public class ComandaBLL {
    private List<Validator<Product>> validators;
    private ComandaDAO comandaDAO;
    /**
     * Constructs a new instance of ComandaBLL.
     */
    public ComandaBLL() {
        validators = new ArrayList<Validator<Product>>();
        validators.add(new StockValidator());
        comandaDAO = new ComandaDAO();
    }
    /**
     * Finds a Comanda by its ID.
     *
     * @param id the ID of the Comanda
     * @return the found Comanda
     * @throws NoSuchElementException if the Comanda with the specified ID is not found
     */
    public Comanda findOrderById(int id) {
        Comanda o = comandaDAO.findById(id);
        if (o == null) {
            throw new NoSuchElementException("The order with id =" + id + " was not found!");
        }
        return o;
    }
    /**
     * Retrieves all Comanda objects.
     *
     * @return a list of all Comanda objects
     * @throws NoSuchElementException if the list of Comanda objects is empty
     */
    public List<Comanda> findAll() {
        List<Comanda> c= comandaDAO.findAll();
        if(c==null){
            throw new NoSuchElementException("The list Comanda is empty");
        }
        return c;
    }
    /**
     * Adds a new Comanda.
     *
     * @param c the Comanda to be added
     */
    public void addComanda(Comanda c){
        comandaDAO.insert(c);

    }
    /**
     * Edits an existing Comanda.
     *
     * @param id the ID of the Comanda to be edited
     * @param c  the updated Comanda object
     */
    public void editComanda(int id, Comanda c) {
        comandaDAO.update(id,c);
        }
    /**
     * Deletes a Comanda.
     *
     * @param c the Comanda to be deleted
     */
    public void deleteComanda(Comanda c){
        comandaDAO.delete(c);
    }
    /**
     * Creates a JTable with Comanda data.
     *
     * @param pane the JScrollPane to contain the JTable
     * @param c    the list of Comanda objects
     * @return the created JTable
     * @throws IllegalAccessException if there is an issue accessing the fields of the Comanda object
     */
    public JTable table(JScrollPane pane, List<Comanda> c) throws IllegalAccessException {
        return comandaDAO.Tabel(pane,c);
    }
}
