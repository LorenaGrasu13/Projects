package presentation;

import bll.ClientBLL;
import bll.ProductBLL;
import model.Client;
import model.Employee;
import model.Product;

import javax.management.BadAttributeValueExpException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Controller class handles the interaction between the user interface (View) and the business logic layer (BLL).
 * It listens to user actions and triggers appropriate operations in response.
 */
public class Controller {
    private Employee e;
    private View view;
    private ViewEmployee viewE;
    private ViewClientOp viewCl;
    private ViewProductOp viewP;
    private ViewComandaOp viewO;
    private AddProduct viewAddProduct;
    private EditProduct viewEditProduct;
    private DeleteProduct viewDeleteProduct;
    private DisplayAllProducts viewAllProduct;
    private AddComanda viewAddComanda;
    private EditComanda viewEditComanda;
    private DeleteComanda viewDeleteComanda;
    private DisplayAllComanda viewAllComanda;

    /**
     * Constructs a Controller object with the specified Employee and View instances.
     *
     * @param em   the Employee instance associated with the controller
     * @param view the View instance associated with the controller
     */
    public Controller(Employee em, View view) {
        e = em;
        this.view = view;
        // ... Add listeners to the view.
        view.addLoginListener(new LoginListener());
    }

    /**
     * ActionListener implementation for the login button in the View.
     */
    class LoginListener implements ActionListener {

        /**
         * Handles the actionPerformed event triggered by the login button.
         *
         * @param e the ActionEvent object representing the event
         */
        public void actionPerformed(ActionEvent e) {
            String username = "";
            String password = "";
            username = view.getUserInput();
            password = view.getPassword();
            Employee e1 = new Employee(username, password);

            try {
                if (e1.test(username, password) == 1) {
                    System.out.println("Succes Login");
                    view.dispose();
                    viewE = new ViewEmployee();
                    viewE.setVisible(true);
                    viewE.addb1Listener(new b1Listener(viewE));
                    viewE.addb2Listener(new b2Listener(viewE));
                    viewE.addb3Listener(new b3Listener(viewE));
                } else throw new Exception("Login failed");
            } catch (Exception ex) {
                view.showError("Bad password or username");
            }
        }
    }
}
