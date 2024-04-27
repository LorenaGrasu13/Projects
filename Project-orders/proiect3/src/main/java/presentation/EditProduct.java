package presentation;

import bll.ProductBLL;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * The EditProduct class represents a JFrame for editing product information.
 */
public class EditProduct extends JFrame {
    private JComboBox<Integer> cb = new JComboBox<Integer>();
    private JTextField t2 = new JTextField(45);
    private JTextField t3 = new JTextField(5);
    private JTextField t4 = new JTextField(5);
    private JButton b = new JButton("Edit");
    private JButton b2 = new JButton("Back");
    private List<Product> c = new ArrayList<Product>();
    private ProductBLL productBLL = new ProductBLL();

    /**
     * Constructs an EditProduct object.
     */
    public EditProduct() {
        c = productBLL.findAll();
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(6, 2, 10, 10));
        panel1.add(new JLabel("ID ="));
        panel1.add(cb);
        for (Product p : c) {
            cb.addItem(p.getId());
        }
        panel1.add(new JLabel("Name ="));
        panel1.add(t2);
        panel1.add(new JLabel("Price ="));
        panel1.add(t3);
        panel1.add(new JLabel("Stock ="));
        panel1.add(t4);
        panel1.add(b2);
        panel1.add(b);
        JPanel content = new JPanel(new BorderLayout());
        content.add(panel1, BorderLayout.CENTER);
        this.setContentPane(content);
        this.pack();

        this.setTitle("Product Edit");
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
     * Retrieves the selected product ID from the combo box.
     *
     * @return the selected product ID
     */
    int gett1() {
        return (int) cb.getSelectedItem();
    }

    /**
     * Retrieves the edited product name from the text field.
     *
     * @return the edited product name
     */
    String gett2() {
        return t2.getText();
    }

    /**
     * Retrieves the edited product price from the text field.
     *
     * @return the edited product price
     */
    int gett3() {
        return Integer.parseInt(t3.getText());
    }

    /**
     * Retrieves the edited product stock from the text field.
     *
     * @return the edited product stock
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
