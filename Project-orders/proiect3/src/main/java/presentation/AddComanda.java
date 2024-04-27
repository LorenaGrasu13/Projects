package presentation;

import bll.ClientBLL;
import bll.ProductBLL;
import model.Client;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the GUI window for adding a new order.
 */
public class AddComanda extends JFrame {
    private JTextField t1 = new JTextField(5);
    private JComboBox<String> cb1 = new JComboBox<String>();
    private JComboBox<String> cb2 = new JComboBox<String>();
    private JTextField t4 = new JTextField(5);
    private JButton b2 = new JButton("Back");
    private JButton b = new JButton("Add");

    private List<Product> p = new ArrayList<Product>();
    private ProductBLL productBLL = new ProductBLL();
    private List<Client> c = new ArrayList<Client>();
    private ClientBLL clientBLL = new ClientBLL();

    /**
     * Creates an instance of AddComanda window.
     */
    public AddComanda() {
        c = clientBLL.findAll();
        p = productBLL.findAll();
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(5, 2, 10, 10));
        panel1.add(new JLabel("ID ="));
        panel1.add(t1);
        panel1.add(new JLabel("Client ="));
        panel1.add(cb1);
        for (Client cl : c) {
            cb1.addItem(cl.getClientName());
        }
        panel1.add(new JLabel("Produs ="));
        panel1.add(cb2);
        for (Product pr : p) {
            cb2.addItem(pr.getProductName());
        }
        panel1.add(new JLabel("Cantitate ="));
        panel1.add(t4);
        panel1.add(b2);
        panel1.add(b);
        JPanel content = new JPanel(new BorderLayout());
        content.add(panel1, BorderLayout.CENTER);
        this.setContentPane(content);
        this.pack();

        this.setTitle("Comanda Add");
        this.setSize(300, 300);
        this.setLocation(430, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Displays an error message dialog box.
     *
     * @param errMessage the error message to display
     */
    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    /**
     * Adds an ActionListener to the "Add" button.
     *
     * @param mal the ActionListener to add
     */
    void addbListener(ActionListener mal) {
        b.addActionListener(mal);
    }

    /**
     * Adds an ActionListener to the "Back" button.
     *
     * @param mal the ActionListener to add
     */
    void addb2Listener(ActionListener mal) {
        b2.addActionListener(mal);
    }

    /**
     * Retrieves the value entered in the "ID" field.
     *
     * @return the value of the ID field as an integer
     */
    int gett1() {
        return Integer.parseInt(t1.getText());
    }

    /**
     * Retrieves the selected client name from the drop-down menu.
     *
     * @return the selected client name as a string
     */
    String gett2() {
        return (String) cb1.getSelectedItem();
    }

    /**
     * Retrieves the selected product name from the drop-down menu.
     *
     * @return the selected product name as a string
     */
    String gett3() {
        return (String) cb2.getSelectedItem();
    }

    /**
     * Retrieves the value entered in the "Cantitate" field.
     *
     * @return the value of the "Cantitate" field as an integer
     */
    int gett4() {
        return Integer.parseInt(t4.getText());
    }

    /**
     * Closes the current window.
     */
    public void close() {
        this.dispose();
    }
}
