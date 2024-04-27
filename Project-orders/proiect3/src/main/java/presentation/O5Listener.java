package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The O5Listener class is an ActionListener for handling events related to option O5 (View Employee) in the ViewComandaOp class.
 */
class O5Listener implements ActionListener {
    private ViewComandaOp viewO;
    private ViewEmployee viewE;

    /**
     * Constructs an O5Listener object with the specified ViewComandaOp and ViewEmployee instances.
     *
     * @param viewO the ViewComandaOp instance
     * @param viewE the ViewEmployee instance
     */
    public O5Listener(ViewComandaOp viewO, ViewEmployee viewE) {
        this.viewO = viewO;
        this.viewE = viewE;
    }

    /**
     * Handles the actionPerformed event triggered by the O5 option (View Employee) in the ViewComandaOp class.
     *
     * @param e the ActionEvent
     */
    public void actionPerformed(ActionEvent e) {
        viewO.close();
        viewE.setVisible(true);
    }
}
