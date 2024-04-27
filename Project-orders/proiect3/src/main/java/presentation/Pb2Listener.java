package presentation;

import bll.ProductBLL;
import model.Product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Pb2Listener class is an ActionListener for handling events related to option Pb2 (Edit Product) in the ViewProductOp class.
 */
class Pb2Listener implements ActionListener {

    private ViewProductOp viewP;
    private EditProduct viewEditProduct;

    /**
     * Constructs a Pb2Listener object with the specified ViewProductOp instance.
     *
     * @param viewP the ViewProductOp instance
     */
    public Pb2Listener(ViewProductOp viewP) {
        this.viewP = viewP;
    }

    /**
     * Handles the actionPerformed event triggered by the Pb2 option (Edit Product) in the ViewProductOp class.
     *
     * @param e the ActionEvent
     */
    public void actionPerformed(ActionEvent e) {
        viewP.close();
        viewEditProduct = new EditProduct();
        viewEditProduct.setVisible(true);
        viewEditProduct.addbListener(new B5Listener());
        viewEditProduct.addb2Listener(new Back4Listener());
    }

    /**
     * ActionListener for handling the edit button event in the EditProduct class.
     */
    class B5Listener implements ActionListener {

        /**
         * Handles the actionPerformed event triggered by the edit button in the EditProduct class.
         *
         * @param e the ActionEvent
         */
        public void actionPerformed(ActionEvent e) {
            int id = 0;
            String name = "";
            int price = 0;
            int stock = 0;
            id = viewEditProduct.gett1();
            name = viewEditProduct.gett2();
            price = viewEditProduct.gett3();
            stock = viewEditProduct.gett4();
            ProductBLL productBll = new ProductBLL();
            Product c = new Product(name, price, stock);
            try {
                productBll.editProduct(id, c);
                viewEditProduct.showError("Produs editat cu succes");
            } catch (Exception ex) {
                viewEditProduct.showError("Produsul nu a putut fi editat");
            }
        }
    }

    /**
     * ActionListener for handling the back button event in the EditProduct class.
     */
    class Back4Listener implements ActionListener {
        /**
         * Handles the actionPerformed event triggered by the back button in the EditProduct class.
         *
         * @param e the ActionEvent
         */
        public void actionPerformed(ActionEvent e) {
            viewEditProduct.close();
            viewP.setVisible(true);
        }
    }
}
