package presentation;

import bll.ProductBLL;
import model.Product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Pb3Listener class is an ActionListener for handling events related to option Pb3 (Delete Product) in the ViewProductOp class.
 */
class Pb3Listener implements ActionListener {
    private ViewProductOp viewP;
    private DeleteProduct viewDeleteProduct;

    /**
     * Constructs a Pb3Listener object with the specified ViewProductOp instance.
     *
     * @param viewP the ViewProductOp instance
     */
    public Pb3Listener(ViewProductOp viewP) {
        this.viewP = viewP;
    }

    /**
     * Handles the actionPerformed event triggered by the Pb3 option (Delete Product) in the ViewProductOp class.
     *
     * @param e the ActionEvent
     */
    public void actionPerformed(ActionEvent e) {
        viewP.close();
        viewDeleteProduct = new DeleteProduct();
        viewDeleteProduct.setVisible(true);
        viewDeleteProduct.addbListener(new B6Listener());
        viewDeleteProduct.addb2Listener(new Back5Listener());
    }

    /**
     * ActionListener for handling the delete button event in the DeleteProduct class.
     */
    class B6Listener implements ActionListener {

        /**
         * Handles the actionPerformed event triggered by the delete button in the DeleteProduct class.
         *
         * @param e the ActionEvent
         */
        public void actionPerformed(ActionEvent e) {
            int id = 0;
            id = viewDeleteProduct.gett1();
            ProductBLL productBll = new ProductBLL();
            Product c = productBll.findProductById(id);
            try {
                productBll.deleteProduct(c);
                viewDeleteProduct.showError("Produs sters cu succes");
            } catch (Exception ex) {
                viewDeleteProduct.showError("Produsul nu a putut fi sters");
            }
        }
    }

    /**
     * ActionListener for handling the back button event in the DeleteProduct class.
     */
    class Back5Listener implements ActionListener {
        /**
         * Handles the actionPerformed event triggered by the back button in the DeleteProduct class.
         *
         * @param e the ActionEvent
         */
        public void actionPerformed(ActionEvent e) {
            viewDeleteProduct.close();
            viewP.setVisible(true);
        }
    }
}
