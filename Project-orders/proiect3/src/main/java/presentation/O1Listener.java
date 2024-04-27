package presentation;

import bll.ClientBLL;
import bll.ComandaBLL;
import bll.ProductBLL;
import bll.validators.AgeValidator;
import bll.validators.EmailValidator;
import bll.validators.StockValidator;
import model.Client;
import model.Comanda;
import model.Product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The O1Listener class is an ActionListener for handling events related to option O1 (Add Comanda) in the ViewComandaOp class.
 */
class O1Listener implements ActionListener {
    private ViewComandaOp viewO;
    private AddComanda viewAddComanda;

    /**
     * Constructs an O1Listener object with the specified ViewComandaOp instance.
     *
     * @param viewO the ViewComandaOp instance
     */
    public O1Listener(ViewComandaOp viewO) {
        this.viewO = viewO;
    }

    /**
     * Handles the actionPerformed event triggered by the O1 option (Add Comanda) in the ViewComandaOp class.
     *
     * @param e the ActionEvent
     */
    public void actionPerformed(ActionEvent e) {
        viewO.close();
        viewAddComanda = new AddComanda();
        viewAddComanda.setVisible(true);
        viewAddComanda.addbListener(new O1Listener.BO1Listener());
        viewAddComanda.addb2Listener(new O1Listener.BackListener());
    }

    /**
     * The BO1Listener class is an ActionListener for handling events related to the "Edit" button in the AddComanda class.
     */
    class BO1Listener implements ActionListener {

        /**
         * Handles the actionPerformed event triggered by the "Edit" button in the AddComanda class.
         *
         * @param e the ActionEvent
         */
        public void actionPerformed(ActionEvent e) {
            int id = 0;
            String ClientName = "";
            String ProductName = "";
            int cantitate = 0;
            id = viewAddComanda.gett1();
            ClientName = viewAddComanda.gett2();
            ProductName = viewAddComanda.gett3();
            cantitate = viewAddComanda.gett4();
            ClientBLL clientBll = new ClientBLL();
            Client cl = clientBll.findClientByName(ClientName);
            ProductBLL productBll = new ProductBLL();
            Product p = productBll.findProductByName(ProductName);
            try {
                if(p.getProductStock()-cantitate>=0){
                    ComandaBLL comandaBll = new ComandaBLL();
                    //Comanda c = new Comanda(id, cl.getId(), p.getId(), cantitate);
                    Comanda c1 = new Comanda(id, cl.getId(), p.getId(), cantitate, cantitate*p.getProductPrice());
                    System.out.println(c1.toString());
                comandaBll.addComanda(c1);
                viewAddComanda.showError("Comanda adaugata cu succes");}
                else throw new Exception("Stock insuficient1");
            } catch (Exception ex) {
                viewAddComanda.showError("Comanda nu a putut fi adaugata");
            }
        }
    }

    /**
     * The BackListener class is an ActionListener for handling events related to the "Back" button in the AddComanda class.
     */
    class BackListener implements ActionListener {
        /**
         * Handles the actionPerformed event triggered by the "Back" button in the AddComanda class.
         *
         * @param e the ActionEvent
         */
        public void actionPerformed(ActionEvent e) {
            viewAddComanda.close();
            viewO.setVisible(true);
        }
    }
}
