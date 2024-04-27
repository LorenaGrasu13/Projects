package presentation;

import model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The ViewEmployee class represents an employee view in the presentation layer.
 * It extends JFrame and provides buttons for client operations, product operations, and order operations.
 */
public class ViewEmployee extends JFrame {
    private JButton b1 = new JButton("Client operations");
    private JButton b2 = new JButton("Product operations");
    private JButton b3 = new JButton("Order operations");

    /**
     * Constructs a ViewEmployee object.
     */
    public ViewEmployee() {
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 1, 10, 10));
        panel1.add(b1);
        panel1.add(b2);
        panel1.add(b3);

        JPanel content = new JPanel(new BorderLayout());
        content.add(panel1, BorderLayout.CENTER);
        this.setContentPane(content);
        this.pack();

        this.setTitle("Employee");
        this.setSize(300, 200);
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
     * Adds an ActionListener to the "Client operations" button.
     *
     * @param mal the ActionListener to add
     */
    void addb1Listener(ActionListener mal) {
        b1.addActionListener(mal);
    }

    /**
     * Adds an ActionListener to the "Product operations" button.
     *
     * @param mal the ActionListener to add
     */
    void addb2Listener(ActionListener mal) {
        b2.addActionListener(mal);
    }

    /**
     * Adds an ActionListener to the "Order operations" button.
     *
     * @param mal the ActionListener to add
     */
    void addb3Listener(ActionListener mal) {
        b3.addActionListener(mal);
    }

    /**
     * Closes the view.
     */
    public void close() {
        this.dispose();
    }
}
