package start;

import bll.ClientBLL;
import bll.ComandaBLL;
import bll.ProductBLL;
import model.Client;
import model.Comanda;
import model.Employee;
import model.Product;
import presentation.Controller;
import presentation.View;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Start class is the entry point for the application.
 */
public class Start {
    protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

    public static void main(String[] args) throws SQLException {

        // Initialize BLL objects
        ClientBLL clientBll = new ClientBLL();
        ProductBLL productBll = new ProductBLL();
        ComandaBLL comandaBll = new ComandaBLL();

        // Create instances of model classes
        Client c1 = new Client();
        Client cl = new Client("Laur", "Italia", "raul@gmail.com", 23);
        Product p1 = new Product();
        Comanda o1 = new Comanda();

        try {
            // Perform various operations using BLL methods
            // Uncomment and modify the code as needed

            // clientBll.editClient(1111, cl);
            // p1 = productBll.findProductByName("Oua");
            // comandaBll.addComanda(com2);
            // o1 = comandaBll.findOrderById(3);
            // List<Client> clients = clientBll.findAll();
            // List<Comanda> orders = comandaBll.findAll();

            // Iterate over the retrieved objects and print their properties
            // for (Comanda com : orders) {
            //     System.out.println(com.toString());
            //     ReflectionExample.retrieveProperties(com);
            // }

            // clientBll.addClient(c2);
            // productBll.addProduct(p2);
            // comandaBll.addComanda(com2);
            // c1 = clientBll.findClientByName("Lorena");
            // p1 = productBll.findProductById(3);
            // o1 = comandaBll.findOrderById(4);

        } catch (Exception ex) {
            LOGGER.log(Level.INFO, ex.getMessage());
        }

        // Create an instance of Employee and View classes
        Employee e = new Employee();
        View view = new View(e);

        // Create a Controller object and associate it with the Employee and View
        Controller controller = new Controller(e, view);

        // Make the view visible
        view.setVisible(true);
    }
}
