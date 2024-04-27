package presentation;

import bll.ClientBLL;
import model.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * The EditClient class represents a JFrame for editing client information.
 */
public class EditClient extends JFrame {
    private JComboBox<Integer> cb = new JComboBox<Integer>();
    private JTextField t2 = new JTextField(45);
    private JTextField t3 = new JTextField(45);
    private JTextField t4 = new JTextField(45);
    private JTextField t5 = new JTextField(5);
    private JButton b = new JButton("Edit");
    private JButton b2 = new JButton("Back");
    private List<Client> c = new ArrayList<Client>();
    private ClientBLL clientBLL = new ClientBLL();

    /**
     * Constructs an EditClient object.
     */
    public EditClient() {
        c = clientBLL.findAll();
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(6, 2, 10, 10));
        panel1.add(new JLabel("ID ="));
        panel1.add(cb);
        for (Client cl : c) {
            cb.addItem(cl.getId());
        }
        panel1.add(new JLabel("Name ="));
        panel1.add(t2);
        panel1.add(new JLabel("Address ="));
        panel1.add(t3);
        panel1.add(new JLabel("Email ="));
        panel1.add(t4);
        panel1.add(new JLabel("Age ="));
        panel1.add(t5);
        panel1.add(b2);
        panel1.add(b);
        JPanel content = new JPanel(new BorderLayout());
        content.add(panel1, BorderLayout.CENTER);
        this.setContentPane(content);
        this.pack();

        this.setTitle("Client Edit");
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
     * Retrieves the selected client ID from the combo box.
     *
     * @return the selected client ID
     */
    int gett1() {
        return (int) cb.getSelectedItem();
    }

    /**
     * Retrieves the value entered in the Name text field.
     *
     * @return the value entered in the Name text field
     */
    String gett2() {
        return t2.getText();
    }

    /**
     * Retrieves the value entered in the Address text field.
     *
     * @return the value entered in the Address text field
     */
    String gett3() {
        return t3.getText();
    }

    /**
     * Retrieves the value entered in the Email text field.
     *
     * @return the value entered in the Email text field
     */
    String gett4() {
        return t4.getText();
    }

    /**
     * Retrieves the value entered in the Age text field.
     *
     * @return the value entered in the Age text field
     */
    int gett5() {
        return Integer.parseInt(t5.getText());
    }

    /**
     * Closes the JFrame.
     */
    public void close() {
        this.dispose();
    }
}
