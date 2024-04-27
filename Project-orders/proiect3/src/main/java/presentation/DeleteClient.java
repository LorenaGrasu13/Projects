package presentation;

import bll.ClientBLL;
import model.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * The DeleteClient class represents a JFrame for deleting a client.
 */
public class DeleteClient extends JFrame {
    private JComboBox<Integer> cb = new JComboBox<Integer>();
    private JButton b = new JButton("Delete");
    private JButton b2 = new JButton("Back");
    private List<Client> c = new ArrayList<Client>();
    private ClientBLL clientBLL = new ClientBLL();

    /**
     * Constructs a DeleteClient object.
     */
    public DeleteClient() {
        c = clientBLL.findAll();
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 1, 10, 10));
        panel1.add(new JLabel("ID ="));
        panel1.add(cb);
        for (Client cl : c) {
            cb.addItem(cl.getId());
        }
        panel1.add(b2);
        panel1.add(b);
        JPanel content = new JPanel(new BorderLayout());
        content.add(panel1, BorderLayout.CENTER);
        this.setContentPane(content);
        this.pack();

        this.setTitle("Client Delete");
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
     * Adds an ActionListener to the delete button.
     *
     * @param mal the ActionListener to add
     */
    void addbListener(ActionListener mal) {
        b.addActionListener(mal);
    }

    /**
     * Adds an ActionListener to the back button.
     *
     * @param mal the ActionListener to add
     */
    void addb2Listener(ActionListener mal) {
        b2.addActionListener(mal);
    }

    /**
     * Retrieves the selected ID from the JComboBox.
     *
     * @return the selected ID as an integer
     */
    int gett1() {
        return (int) cb.getSelectedItem();
    }

    /**
     * Closes the DeleteClient window.
     */
    public void close() {
        this.dispose();
    }
}
