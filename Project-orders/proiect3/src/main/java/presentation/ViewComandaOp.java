package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The ViewComandaOp class represents an order operations view in the presentation layer.
 * It extends JFrame and provides buttons for adding, editing, deleting orders, viewing all orders, and going back.
 */
public class ViewComandaOp extends JFrame {
    private JButton b1 = new JButton("Add new order");
    private JButton b2 = new JButton("Edit order");
    private JButton b3 = new JButton("Delete order");
    private JButton b4 = new JButton("View all orders in a table");
    private JButton b5 = new JButton("Back");

    /**
     * Constructs a ViewComandaOp object.
     */
    public ViewComandaOp() {
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(5, 1, 10, 10));
        panel1.add(b1);
        panel1.add(b2);
        panel1.add(b3);
        panel1.add(b4);
        panel1.add(b5);

        JPanel content = new JPanel(new BorderLayout());
        content.add(panel1, BorderLayout.CENTER);
        this.setContentPane(content);
        this.pack();

        this.setTitle("Order Operations");
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
     * Adds an ActionListener to the "Add new order" button.
     *
     * @param mal the ActionListener to add
     */
    void addb1Listener(ActionListener mal) {
        b1.addActionListener(mal);
    }

    /**
     * Adds an ActionListener to the "Edit order" button.
     *
     * @param mal the ActionListener to add
     */
    void addb2Listener(ActionListener mal) {
        b2.addActionListener(mal);
    }

    /**
     * Adds an ActionListener to the "Delete order" button.
     *
     * @param mal the ActionListener to add
     */
    void addb3Listener(ActionListener mal) {
        b3.addActionListener(mal);
    }

    /**
     * Adds an ActionListener to the "View all orders in a table" button.
     *
     * @param mal the ActionListener to add
     */
    void addb4Listener(ActionListener mal) {
        b4.addActionListener(mal);
    }

    /**
     * Adds an ActionListener to the "Back" button.
     *
     * @param mal the ActionListener to add
     */
    void addb5Listener(ActionListener mal) {
        b5.addActionListener(mal);
    }

    /**
     * Closes the view.
     */
    public void close() {
        this.dispose();
    }
}
