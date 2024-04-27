package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener implementation for the "b5" button in the ViewClientOp window.
 */
class Clb5Listener implements ActionListener {

    private ViewEmployee viewE;
    private ViewClientOp viewCl;

    /**
     * Constructs a Clb5Listener with the specified ViewClientOp and ViewEmployee instances.
     *
     * @param viewCl the ViewClientOp instance associated with the listener
     * @param viewE  the ViewEmployee instance associated with the listener
     */
    public Clb5Listener(ViewClientOp viewCl, ViewEmployee viewE) {
        this.viewCl = viewCl;
        this.viewE = viewE;
    }

    /**
     * Handles the actionPerformed event triggered by the "b5" button.
     *
     * @param e the ActionEvent object representing the event
     */
    public void actionPerformed(ActionEvent e) {
        viewCl.close();
        viewE.setVisible(true);
    }
}
