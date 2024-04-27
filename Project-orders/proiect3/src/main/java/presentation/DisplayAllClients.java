package presentation;

import bll.ClientBLL;
import model.Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The DisplayAllClients class represents a JFrame for displaying all clients.
 */
public class DisplayAllClients extends JFrame {
    private JTable table;
    private JButton b2 = new JButton("Back");

    /**
     * Constructs a DisplayAllClients object.
     *
     * @throws IllegalAccessException if access to the specified field, method, or constructor is not allowed
     */
    public DisplayAllClients() throws IllegalAccessException {
        ClientBLL clientBLL = new ClientBLL();
        List<Client> c = new ArrayList<Client>();
        c = clientBLL.findAll();
        JScrollPane p = new JScrollPane();
        p.setBounds(371, 28, 386, 197);
        table = clientBLL.table(p, c);

        this.setContentPane(p);
        this.pack();

        this.setTitle("Client All");
        this.setSize(500, 300);
        this.setLocation(430, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
