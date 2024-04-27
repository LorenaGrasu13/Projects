package presentation;

import bll.ClientBLL;
import model.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener implementation for the "b2" button in the ViewClientOp window.
 */
class Clb2Listener implements ActionListener {

    private ViewClientOp viewCl;
    private EditClient viewEditClient;

    /**
     * Constructs a Clb2Listener with the specified ViewClientOp instance.
     *
     * @param viewCl the ViewClientOp instance associated with the listener
     */
    public Clb2Listener(ViewClientOp viewCl) {
        this.viewCl = viewCl;
    }

    /**
     * Handles the actionPerformed event triggered by the "b2" button.
     *
     * @param e the ActionEvent object representing the event
     */
    public void actionPerformed(ActionEvent e) {
        viewCl.close();
        viewEditClient = new EditClient();
        viewEditClient.setVisible(true);
        viewEditClient.addbListener(new B1Listener());
        viewEditClient.addb2Listener(new Back1Listener());
    }

    /**
     * ActionListener implementation for the "Edit" button in the EditClient window.
     */
    class B1Listener implements ActionListener {

        /**
         * Handles the actionPerformed event triggered by the "Edit" button.
         *
         * @param e the ActionEvent object representing the event
         */
        public void actionPerformed(ActionEvent e) {
            int id = 0;
            String name = "";
            String address = "";
            String email = "";
            int age = 0;
            id = viewEditClient.gett1();
            name = viewEditClient.gett2();
            address = viewEditClient.gett3();
            email = viewEditClient.gett4();
            age = viewEditClient.gett5();
            ClientBLL clientBll = new ClientBLL();
            Client c = new Client(name, address, email, age);
            try {
                clientBll.editClient(id, c);
                viewEditClient.showError("Client editat cu succes");
            } catch (Exception ex) {
                viewEditClient.showError("Clientul nu a putut fi editat");
            }
        }
    }

    /**
     * ActionListener implementation for the "Back" button in the EditClient window.
     */
    class Back1Listener implements ActionListener {
        /**
         * Handles the actionPerformed event triggered by the "Back" button.
         *
         * @param e the ActionEvent object representing the event
         */
        public void actionPerformed(ActionEvent e) {
            viewEditClient.close();
            viewCl.setVisible(true);
        }
    }
}
