package presentation;

import bll.ClientBLL;
import bll.ComandaBLL;
import bll.ProductBLL;
import model.Client;
import model.Comanda;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * The EditComanda class represents a JFrame for editing order information.
 */
public class EditComanda extends JFrame {
    private JComboBox<Integer> cb = new JComboBox<Integer>();
    private JComboBox<String> cb1 = new JComboBox<String>();
    private JComboBox<String> cb2 = new JComboBox<String>();
    private JTextField t4 = new JTextField(5);
    private JButton b2 = new JButton("Back");
    private JButton b = new JButton("Edit");

    private List<Product> p = new ArrayList<Product>();
    private ProductBLL productBLL = new ProductBLL();
    private List<Client> c = new ArrayList<Client>();
    private ClientBLL clientBLL = new ClientBLL();
    private List<Comanda> co = new ArrayList<Comanda>();
    private ComandaBLL comandaBLL = new ComandaBLL();

    /**
     * Constructs an EditComanda object.
     */
    public EditComanda() {
        c = clientBLL.findAll();
        p = productBLL.findAll();
        co = comandaBLL.findAll();
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(5, 2, 10, 10));
        panel1.add(new JLabel("ID ="));
        panel1.add(cb);
        for (Comanda com : co) {
            cb.addItem(com.getId());
        }
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

        this.setTitle("Comanda Edit");
        this.setSize(300, 300);
        this.setLocation(430, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Displays an error message in a dialog box.
     *
     * @param errMessage the error message to display
     */
    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    /**
     * Adds an ActionListener to the Edit button.
     *
     * @param mal the ActionListener to add
     */
    void addbListener(ActionListener mal) {
        b.addActionListener(mal);
    }

    /**
     * Adds an ActionListener to the Back button.
     *
     * @param mal the ActionListener to add
     */
    void addb2Listener(ActionListener mal) {
        b2.addActionListener(mal);
    }

    /**
     * Retrieves the selected order ID from the combo box.
     *
     * @return the selected order ID
     */
    int gett1() {
        return (int) cb.getSelectedItem();
    }

    /**
     * Retrieves the selected client name from the combo box.
     *
     * @return the selected client name
     */
    String gett2() {
        return (String) cb1.getSelectedItem();
    }

    /**
     * Retrieves the selected product name from the combo box.
     *
     * @return the selected product name
     */
    String gett3() {
        return (String) cb2.getSelectedItem();
    }

    /**
     * Retrieves the quantity entered in the text field.
     *
     * @return the quantity entered
     */
    int gett4() {
        return Integer.parseInt(t4.getText());
    }

    /**
     * Closes the JFrame.
     */
    public void close() {
        this.dispose();
    }
}
