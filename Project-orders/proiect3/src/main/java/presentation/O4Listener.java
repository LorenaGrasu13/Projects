package presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The O4Listener class is an ActionListener for handling events related to option O4 (Display All Comanda) in the ViewComandaOp class.
 */
class O4Listener implements ActionListener {
    private ViewComandaOp viewO;
    private DisplayAllComanda viewAllComanda;

    /**
     * Constructs an O4Listener object with the specified ViewComandaOp instance.
     *
     * @param viewO the ViewComandaOp instance
     */
    public O4Listener(ViewComandaOp viewO) {
        this.viewO = viewO;
    }

    /**
     * Handles the actionPerformed event triggered by the O4 option (Display All Comanda) in the ViewComandaOp class.
     *
     * @param e the ActionEvent
     */
    public void actionPerformed(ActionEvent e) {
        viewO.close();
        SwingUtilities.invokeLater(() -> {
            try {
                viewAllComanda = new DisplayAllComanda();
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
            viewAllComanda.setVisible(true);
        });
    }
}
