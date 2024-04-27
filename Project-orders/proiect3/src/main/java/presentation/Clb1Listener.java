package presentation;

import bll.ClientBLL;
import bll.validators.AgeValidator;
import bll.validators.EmailValidator;
import model.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener implementation for the "b1" button in the ViewClientOp window.
 */
class Clb1Listener implements ActionListener {
    private ViewClientOp viewCl;
    private AddClient viewAddClient;

    /**
     * Constructs a Clb1Listener with the specified ViewClientOp instance.
     *
     * @param viewCl the ViewClientOp instance associated with the listener
     */
    public Clb1Listener(ViewClientOp viewCl) {
        this.viewCl = viewCl;
    }

    /**
     * Handles the actionPerformed event triggered by the "b1" button.
     *
     * @param e the ActionEvent object representing the event
     */
    public void actionPerformed(ActionEvent e) {
        viewCl.close();
        viewAddClient = new AddClient();
        viewAddClient.setVisible(true);
        viewAddClient.addbListener(new BListener());
        viewAddClient.addb2Listener(new BackListener());
    }

    /**
     * ActionListener implementation for the "Add" button in the AddClient window.
     */
    class BListener implements ActionListener {
        /**
         * Handles the actionPerformed event triggered by the "Add" button.
         *
         * @param e the ActionEvent object representing the event
         */
        public void actionPerformed(ActionEvent e) {
            int id = 0;
            String name = "";
            String address = "";
            String email = "";
            int age = 0;
            id = viewAddClient.gett1();
            name = viewAddClient.gett2();
            address = viewAddClient.gett3();
            email = viewAddClient.gett4();
            age = viewAddClient.gett5();
            ClientBLL clientBll = new ClientBLL();
            Client c = new Client(id, name, address, email, age);
            try {
                AgeValidator av = new AgeValidator();
                EmailValidator ev = new EmailValidator();
                av.validate(c);
                ev.validate(c);
                clientBll.addClient(c);
                viewAddClient.showError("Client adaugat cu succes");
            } catch (Exception ex) {
                viewAddClient.showError("Clientul nu a putut fi adaugat");
            }
        }
    }

    /**
     * ActionListener implementation for the "Back" button in the AddClient window.
     */
    class BackListener implements ActionListener {
        /**
         * Handles the actionPerformed event triggered by the "Back" button.
         *
         * @param e the ActionEvent object representing the event
         */
        public void actionPerformed(ActionEvent e) {
            viewAddClient.close();
            viewCl.setVisible(true);
        }
    }
}
