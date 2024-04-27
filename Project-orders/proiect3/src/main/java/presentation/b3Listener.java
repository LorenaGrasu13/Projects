package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener implementation for the "b3" button in the ViewEmployee window.
 */
class b3Listener implements ActionListener {
    private ViewEmployee viewE;
    private ViewComandaOp viewO;

    /**
     * Constructs a b3Listener with the specified ViewEmployee instance.
     *
     * @param viewE the ViewEmployee instance associated with the listener
     */
    public b3Listener(ViewEmployee viewE) {
        this.viewE = viewE;
    }

    /**
     * Handles the actionPerformed event triggered by the "b3" button.
     *
     * @param e the ActionEvent object representing the event
     */
    public void actionPerformed(ActionEvent e) {
        viewE.close();
        viewO = new ViewComandaOp();
        viewO.setVisible(true);
        viewO.addb1Listener(new O1Listener(viewO));
        viewO.addb2Listener(new O2Listener(viewO));
        viewO.addb3Listener(new O3Listener(viewO));
        viewO.addb4Listener(new O4Listener(viewO));
        viewO.addb5Listener(new O5Listener(viewO, viewE));
    }
}
