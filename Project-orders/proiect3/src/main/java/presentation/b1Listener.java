package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener implementation for the "b1" button in the ViewEmployee window.
 */
class b1Listener implements ActionListener {

    private ViewEmployee viewE;
    private ViewClientOp viewCl;

    /**
     * Constructs a b1Listener with the specified ViewEmployee instance.
     *
     * @param viewE the ViewEmployee instance associated with the listener
     */
    public b1Listener(ViewEmployee viewE) {
        this.viewE = viewE;
    }

    /**
     * Handles the actionPerformed event triggered by the "b1" button.
     *
     * @param e the ActionEvent object representing the event
     */
    public void actionPerformed(ActionEvent e) {
        viewE.close();
        viewCl = new ViewClientOp();
        viewCl.setVisible(true);
        viewCl.addb1Listener(new Clb1Listener(viewCl));
        viewCl.addb2Listener(new Clb2Listener(viewCl));
        viewCl.addb3Listener(new Clb3Listener(viewCl));
        viewCl.addb4Listener(new Clb4Listener(viewCl));
        viewCl.addb5Listener(new Clb5Listener(viewCl, viewE));
    }
}
