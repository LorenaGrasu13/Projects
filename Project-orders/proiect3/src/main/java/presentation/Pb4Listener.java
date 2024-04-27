package presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Pb4Listener class is an ActionListener for handling events related to option Pb4 (Display All Products) in the ViewProductOp class.
 */
public class Pb4Listener implements ActionListener {
    private ViewProductOp viewP;
    private DisplayAllProducts viewAllProducts;

    /**
     * Constructs a Pb4Listener object with the specified ViewProductOp instance.
     *
     * @param viewP the ViewProductOp instance
     */
    public Pb4Listener(ViewProductOp viewP) {
        this.viewP = viewP;
    }

    /**
     * Handles the actionPerformed event triggered by the Pb4 option (Display All Products) in the ViewProductOp class.
     *
     * @param e the ActionEvent
     */
    public void actionPerformed(ActionEvent e) {
        viewP.close();
        SwingUtilities.invokeLater(() -> {
            try {
                viewAllProducts = new DisplayAllProducts();
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
            viewAllProducts.setVisible(true);
        });
    }
}
