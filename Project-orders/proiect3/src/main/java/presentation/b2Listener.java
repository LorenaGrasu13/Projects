package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener implementation for the "b2" button in the ViewEmployee window.
 */
class b2Listener implements ActionListener {

    private ViewEmployee viewE;
    private ViewProductOp viewP;

    /**
     * Constructs a b2Listener with the specified ViewEmployee instance.
     *
     * @param viewE the ViewEmployee instance associated with the listener
     */
    public b2Listener(ViewEmployee viewE) {
        this.viewE = viewE;
    }

    /**
     * Handles the actionPerformed event triggered by the "b2" button.
     *
     * @param e the ActionEvent object representing the event
     */
    public void actionPerformed(ActionEvent e) {
        viewE.close();
        viewP = new ViewProductOp();
        viewP.setVisible(true);
        viewP.addb1Listener(new Pb1Listener(viewP));
        viewP.addb2Listener(new Pb2Listener(viewP));
        viewP.addb3Listener(new Pb3Listener(viewP));
        viewP.addb4Listener(new Pb4Listener(viewP));
        viewP.addb5Listener(new Pb5Listener(viewP, viewE));
    }
}
