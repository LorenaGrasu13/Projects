package presentation;

import bll.ClientBLL;
import bll.ComandaBLL;
import bll.ProductBLL;
import model.Client;
import model.Comanda;
import model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the GUI window for displaying all products.
 */
public class DisplayAllProducts extends JFrame {
    private JTable table;
    private JButton b2 = new JButton("Back");

    /**
     * Creates an instance of DisplayAllProducts window.
     *
     * @throws IllegalAccessException if the access to the method or field is not allowed.
     */
    public DisplayAllProducts() throws IllegalAccessException {
        ProductBLL productBLL = new ProductBLL();
        List<Product> pr = new ArrayList<Product>();
        pr = productBLL.findAll();
        JScrollPane p = new JScrollPane();
        p.setBounds(371, 28, 386, 197);
        table = productBLL.table(p, pr);

        this.setContentPane(p);
        this.pack();

        this.setTitle("Product All");
        this.setSize(500, 300);
        this.setLocation(430, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
