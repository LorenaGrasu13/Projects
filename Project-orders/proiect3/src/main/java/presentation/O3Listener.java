package presentation;

import bll.ClientBLL;
import bll.ComandaBLL;
import model.Client;
import model.Comanda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The O3Listener class is an ActionListener for handling events related to option O3 (Delete Comanda) in the ViewComandaOp class.
 */
class O3Listener implements ActionListener {
    private ViewComandaOp viewO;
    private DeleteComanda viewDeleteComanda;

    /**
     * Constructs an O3Listener object with the specified ViewComandaOp instance.
     *
     * @param viewO the ViewComandaOp instance
     */
    public O3Listener(ViewComandaOp viewO) {
        this.viewO = viewO;
    }

    /**
     * Handles the actionPerformed event triggered by the O3 option (Delete Comanda) in the ViewComandaOp class.
     *
     * @param e the ActionEvent
     */
    public void actionPerformed(ActionEvent e) {
        viewO.close();
        viewDeleteComanda = new DeleteComanda();
        viewDeleteComanda.setVisible(true);
        viewDeleteComanda.addbListener(new BO3Listener());
        viewDeleteComanda.addb2Listener(new Back3Listener());
    }

    /**
     * The BO3Listener class is an ActionListener for handling events related to the "Delete" button in the DeleteComanda class.
     */
    class BO3Listener implements ActionListener{
        /**
         * Handles the actionPerformed event triggered by the "Delete" button in the DeleteComanda class.
         *
         * @param e the ActionEvent
         */
        public void actionPerformed(ActionEvent e) {
            int id = 0;
            id = viewDeleteComanda.gett1();
            ComandaBLL comandaBll = new ComandaBLL();
            Comanda c = comandaBll.findOrderById(id);
            try {
                comandaBll.deleteComanda(c);
                viewDeleteComanda.showError("Comanda stearsa cu succes");
            } catch (Exception ex) {
                viewDeleteComanda.showError("Comanda nu a putut fi stearsa");
            }
        }
    }

    /**
     * The Back3Listener class is an ActionListener for handling events related to the "Back" button in the DeleteComanda class.
     */
    class Back3Listener implements ActionListener {
        /**
         * Handles the actionPerformed event triggered by the "Back" button in the DeleteComanda class.
         *
         * @param e the ActionEvent
         */
        public void actionPerformed(ActionEvent e) {
            viewDeleteComanda.close();
            viewO.setVisible(true);
        }
    }
}
