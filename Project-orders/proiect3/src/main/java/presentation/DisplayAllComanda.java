package presentation;

import bll.ComandaBLL;
import model.Comanda;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The DisplayAllComanda class represents a JFrame for displaying all orders.
 */
public class DisplayAllComanda extends JFrame {
    private JTable table;
    private JButton b2 = new JButton("Back");

    /**
     * Constructs a DisplayAllComanda object.
     *
     * @throws IllegalAccessException if access to the specified field, method, or constructor is not allowed
     */
    public DisplayAllComanda() throws IllegalAccessException {
        ComandaBLL comandaBLL = new ComandaBLL();
        List<Comanda> c = new ArrayList<Comanda>();
        c = comandaBLL.findAll();
        JScrollPane p = new JScrollPane();
        p.setBounds(371, 28, 386, 197);
        table = comandaBLL.table(p, c);

        this.setContentPane(p);
        this.pack();

        this.setTitle("Comanda All");
        this.setSize(500, 300);
        this.setLocation(430, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
