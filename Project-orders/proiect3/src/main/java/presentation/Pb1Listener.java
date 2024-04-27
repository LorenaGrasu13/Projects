package presentation;

import bll.ClientBLL;
import bll.ProductBLL;
import model.Client;
import model.Product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Pb1Listener class is an ActionListener for handling events related to option Pb1 (Add Product) in the ViewProductOp class.
 */
class Pb1Listener implements ActionListener {
    private ViewProductOp viewP;
    private AddProduct viewAddProduct;

    /**
     * Constructs a Pb1Listener object with the specified ViewProductOp instance.
     *
     * @param viewP the ViewProductOp instance
     */
    public Pb1Listener(ViewProductOp viewP) {
        this.viewP = viewP;
    }

    /**
     * Handles the actionPerformed event triggered by the Pb1 option (Add Product) in the ViewProductOp class.
     *
     * @param e the ActionEvent
     */
    public void actionPerformed(ActionEvent e) {
        viewP.close();
        viewAddProduct = new AddProduct();
        viewAddProduct.setVisible(true);
        viewAddProduct.addbListener(new B4Listener());
        viewAddProduct.addb2Listener(new Back3Listener());
    }

    /**
     * ActionListener for handling the add button event in the AddProduct class.
     */
    class B4Listener implements ActionListener {

        /**
         * Handles the actionPerformed event triggered by the add button in the AddProduct class.
         *
         * @param e the ActionEvent
         */
        public void actionPerformed(ActionEvent e) {
            int id = 0;
            String name = "";
            int price = 0;
            int stock = 0;
            id = viewAddProduct.gett1();
            name = viewAddProduct.gett2();
            price = viewAddProduct.gett3();
            stock = viewAddProduct.gett4();
            ProductBLL productBll = new ProductBLL();
            Product c = new Product(id, name, price, stock);
            try {
                productBll.addProduct(c);
                viewAddProduct.showError("Produs adaugat cu succes");
            } catch (Exception ex) {
                viewAddProduct.showError("Produsul nu a putut fi adaugat");
            }
        }
    }

    /**
     * ActionListener for handling the back button event in the AddProduct class.
     */
    class Back3Listener implements ActionListener {
        /**
         * Handles the actionPerformed event triggered by the back button in the AddProduct class.
         *
         * @param e the ActionEvent
         */
        public void actionPerformed(ActionEvent e) {
            viewAddProduct.close();
            viewP.setVisible(true);
        }
    }
}
