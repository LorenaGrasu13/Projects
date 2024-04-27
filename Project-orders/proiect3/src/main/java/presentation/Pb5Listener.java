package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Pb5Listener class is an ActionListener for handling events related to option Pb5 (Go to Employee Management) in the ViewProductOp class.
 */
public class Pb5Listener implements ActionListener {
    private ViewProductOp viewP;
    private ViewEmployee viewE;

    /**
     * Constructs a Pb5Listener object with the specified ViewProductOp and ViewEmployee instances.
     *
     * @param viewP the ViewProductOp instance
     * @param viewE the ViewEmployee instance
     */
    public Pb5Listener(ViewProductOp viewP, ViewEmployee viewE) {
        this.viewP = viewP;
        this.viewE = viewE;
    }

    /**
     * Handles the actionPerformed event triggered by the Pb5 option (Go to Employee Management) in the ViewProductOp class.
     *
     * @param e the ActionEvent
     */
    public void actionPerformed(ActionEvent e) {
        viewP.close();
        viewE.setVisible(true);
    }
}
