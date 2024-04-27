package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Represents the GUI window for adding a new product.
 */
public class AddProduct extends JFrame {
    private JTextField t1 = new JTextField(5);
    private JTextField t2 = new JTextField(45);
    private JTextField t3 = new JTextField(5);
    private JTextField t4 = new JTextField(5);
    private JButton b = new JButton("Add");
    private JButton b2 = new JButton("Back");

    /**
     * Creates an instance of AddProduct window.
     */
    public AddProduct() {
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(6, 2, 10, 10));
        panel1.add(new JLabel("ID ="));
        panel1.add(t1);
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

        this.setTitle("Product Add");
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
     * Retrieves the value entered in the "Name" field.
     *
     * @return the value of the Name field as a string
     */
    String gett2() {
        return t2.getText();
    }

    /**
     * Retrieves the value entered in the "Price" field.
     *
     * @return the value of the Price field as an integer
     */
    int gett3() {
        return Integer.parseInt(t3.getText());
    }

    /**
     * Retrieves the value entered in the "Stock" field.
     *
     * @return the value of the Stock field as an integer
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
