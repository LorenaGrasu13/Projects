package presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener implementation for the "b4" button in the ViewClientOp window.
 */
class Clb4Listener implements ActionListener {

    private ViewClientOp viewCl;
    private DisplayAllClients viewAllClient;

    /**
     * Constructs a Clb4Listener with the specified ViewClientOp instance.
     *
     * @param viewCl the ViewClientOp instance associated with the listener
     */
    public Clb4Listener(ViewClientOp viewCl) {
        this.viewCl = viewCl;
    }

    /**
     * Handles the actionPerformed event triggered by the "b4" button.
     *
     * @param e the ActionEvent object representing the event
     */
    public void actionPerformed(ActionEvent e) {
        viewCl.close();
        SwingUtilities.invokeLater(() -> {
            try {
                viewAllClient = new DisplayAllClients();
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
            viewAllClient.setVisible(true);
        });
    }
}
