package presentation;

import bll.ClientBLL;
import bll.ComandaBLL;
import bll.ProductBLL;
import bll.validators.StockValidator;
import model.Client;
import model.Comanda;
import model.Product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The O2Listener class is an ActionListener for handling events related to option O2 (Edit Comanda) in the ViewComandaOp class.
 */
class O2Listener implements ActionListener {
    private ViewComandaOp viewO;
    private EditComanda viewEditComanda;

    /**
     * Constructs an O2Listener object with the specified ViewComandaOp instance.
     *
     * @param viewO the ViewComandaOp instance
     */
    public O2Listener(ViewComandaOp viewO) {
        this.viewO = viewO;
    }

    /**
     * Handles the actionPerformed event triggered by the O2 option (Edit Comanda) in the ViewComandaOp class.
     *
     * @param e the ActionEvent
     */
    public void actionPerformed(ActionEvent e) {
        viewO.close();
        viewEditComanda = new EditComanda();
        viewEditComanda.setVisible(true);
        viewEditComanda.addbListener(new O2Listener.BO2Listener());
        viewEditComanda.addb2Listener(new O2Listener.Back2Listener());
    }

    /**
     * The BO2Listener class is an ActionListener for handling events related to the "Edit" button in the EditComanda class.
     */
    class BO2Listener implements ActionListener {

        /**
         * Handles the actionPerformed event triggered by the "Edit" button in the EditComanda class.
         *
         * @param e the ActionEvent
         */
        public void actionPerformed(ActionEvent e) {
            int id = 0;
            String ClientName = "";
            String ProductName = "";
            int cantitate = 0;
            id = viewEditComanda.gett1();
            ClientName = viewEditComanda.gett2();
            ProductName = viewEditComanda.gett3();
            cantitate = viewEditComanda.gett4();
            ClientBLL clientBll = new ClientBLL();
            Client cl = new Client();
            cl = clientBll.findClientByName(ClientName);
            ProductBLL productBll = new ProductBLL();
            Product p = new Product();
            p = productBll.findProductByName(ProductName);
            ComandaBLL comandaBll = new ComandaBLL();
            Comanda ctest = new Comanda();
            ctest = comandaBll.findOrderById(id);
            Product p1 = new Product(p.getId(), p.getProductName(), p.getProductPrice(), p.getProductStock() + ctest.getCantitate());
            productBll.editProduct(p.getId(), p1);
            try {
                StockValidator sv = new StockValidator();
                sv.validate(p);
                if(p.getProductStock()-cantitate>=0){
                    Comanda c = new Comanda(id, cl.getId(), p.getId(), cantitate);
                    Comanda c1 = new Comanda(id, cl.getId(), p.getId(), cantitate, c.getPretComanda());
                    comandaBll.editComanda(id,c1);
                    viewEditComanda.showError("Comanda adaugata cu succes");}
                else throw new Exception("Stock insuficient2");
            } catch (Exception ex) {
                viewEditComanda.showError("Comanda nu a putut fi editata");
            }
        }
    }

    /**
     * The Back2Listener class is an ActionListener for handling events related to the "Back" button in the EditComanda class.
     */
    class Back2Listener implements ActionListener {
        /**
         * Handles the actionPerformed event triggered by the "Back" button in the EditComanda class.
         *
         * @param e the ActionEvent
         */
        public void actionPerformed(ActionEvent e) {
            viewEditComanda.close();
            viewO.setVisible(true);
        }
    }
}
