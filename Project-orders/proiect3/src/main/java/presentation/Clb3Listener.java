package presentation;

import bll.ClientBLL;
import model.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener implementation for the "b3" button in the ViewClientOp window.
 */
class Clb3Listener implements ActionListener {
    private ViewClientOp viewCl;
    private DeleteClient viewDeleteClient;

    /**
     * Constructs a Clb3Listener with the specified ViewClientOp instance.
     *
     * @param viewCl the ViewClientOp instance associated with the listener
     */
    public Clb3Listener(ViewClientOp viewCl) {
        this.viewCl = viewCl;
    }

    /**
     * Handles the actionPerformed event triggered by the "b3" button.
     *
     * @param e the ActionEvent object representing the event
     */
    public void actionPerformed(ActionEvent e) {
        viewCl.close();
        viewDeleteClient = new DeleteClient();
        viewDeleteClient.setVisible(true);
        viewDeleteClient.addbListener(new B3Listener());
        viewDeleteClient.addb2Listener(new Back2Listener());
    }

    /**
     * ActionListener implementation for the "Delete" button in the DeleteClient window.
     */
    class B3Listener implements ActionListener {
        /**
         * Handles the actionPerformed event triggered by the "Delete" button.
         *
         * @param e the ActionEvent object representing the event
         */
        public void actionPerformed(ActionEvent e) {
            int id = 0;
            id = viewDeleteClient.gett1();
            ClientBLL clientBll = new ClientBLL();
            Client c = clientBll.findClientById(id);
            try {
                clientBll.deleteClient(c);
                viewDeleteClient.showError("Client sters cu succes");
            } catch (Exception ex) {
                viewDeleteClient.showError("Clientul nu a putut fi sters");
            }
        }
    }

    /**
     * ActionListener implementation for the "Back" button in the DeleteClient window.
     */
    class Back2Listener implements ActionListener {
        /**
         * Handles the actionPerformed event triggered by the "Back" button.
         *
         * @param e the ActionEvent object representing the event
         */
        public void actionPerformed(ActionEvent e) {
            viewDeleteClient.close();
            viewCl.setVisible(true);
        }
    }
}
