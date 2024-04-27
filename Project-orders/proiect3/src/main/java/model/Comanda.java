package model;

import bll.ProductBLL;

/**
 * Represents a Comanda (order) in the system.
 */
public class Comanda {
    private int id;
    private int idClient;
    private int idProduct;
    private int cantitate;
    private int pretComanda;

    /**
     * Default constructor for Comanda class.
     */
    public Comanda() {
    }

    /**
     * Constructor for Comanda class with specified parameters.
     *
     * @param id     The ID of the order.
     * @param idC    The ID of the client.
     * @param idP    The ID of the product.
     * @param c      The quantity of the product.
     * @param price  The price of the order.
     */
    public Comanda(int id, int idC, int idP, int c, int price) {
        super();
        ProductBLL product = new ProductBLL();
        Product p;
        this.id = id;
        this.idClient = idC;
        this.idProduct = idP;
        this.cantitate = c;
        this.pretComanda = price;
        p = product.findProductById(idP);
        this.pretComanda = p.getProductPrice() * c;
        int s = p.getProductStock() - c;
        Product product1 = new Product(p.getProductName(), p.getProductPrice(), s);
        product.editProduct(idP, product1);
    }

    /**
     * Constructor for Comanda class with specified parameters.
     * This constructor also updates the product stock and price of the order.
     *
     * @param id     The ID of the order.
     * @param idC    The ID of the client.
     * @param idP    The ID of the product.
     * @param c      The quantity of the product.
     */
    public Comanda(int id, int idC, int idP, int c) {
        super();
        ProductBLL product = new ProductBLL();
        Product p;
        this.id = id;
        this.idClient = idC;
        this.idProduct = idP;
        this.cantitate = c;
        p = product.findProductById(idP);
        this.pretComanda = p.getProductPrice() * c;
        int s = p.getProductStock() - c;
        Product product1 = new Product(p.getProductName(), p.getProductPrice(), s);
        product.editProduct(idP, product1);
    }

    /**
     * Constructor for Comanda class with specified parameters.
     * This constructor also updates the product stock and price of the order.
     * The ID of the order is not provided.
     *
     * @param idC    The ID of the client.
     * @param idP    The ID of the product.
     * @param c      The quantity of the product.
     */
    public Comanda(int idC, int idP, int c) {
        super();
        ProductBLL product = new ProductBLL();
        Product p;
        this.idClient = idC;
        this.idProduct = idP;
        this.cantitate = c;
        p = product.findProductById(idP);
        this.pretComanda = p.getProductPrice() * c;
        int s = p.getProductStock() - c;
        Product product1 = new Product(p.getProductName(), p.getProductPrice(), s);
        product.editProduct(idP, product1);
    }

    /**
     * Retrieves the ID of the order.
     *
     * @return The ID of the order.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the order.
     *
     * @param id The ID of the order.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the ID of the client.
     *
     * @return The ID of the client.
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * Sets the ID of the client.
     *
     * @param idC The ID of the client.
     */
    public void setIdClient(int idC) {
        this.idClient = idC;
    }

    /**
     * Retrieves the ID of the product.
     *
     * @return The ID of the product.
     */
    public int getIdProduct() {
        return idProduct;
    }

    /**
     * Sets the ID of the product.
     *
     * @param idP The ID of the product.
     */
    public void setIdProduct(int idP) {
        this.idProduct = idP;
    }

    /**
     * Retrieves the quantity of the product in the order.
     *
     * @return The quantity of the product.
     */
    public int getCantitate() {
        return cantitate;
    }

    /**
     * Sets the quantity of the product in the order.
     *
     * @param c The quantity of the product.
     */
    public void setCantitate(int c) {
        this.cantitate = c;
    }

    /**
     * Retrieves the price of the order.
     *
     * @return The price of the order.
     */
    public int getPretComanda() {
        return pretComanda;
    }

    /**
     * Sets the price of the order.
     *
     * @param price The price of the order.
     */
    public void setPretComanda(int price) {
        this.pretComanda = price;
    }

    /**
     * Returns a string representation of the Comanda object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Order [id=" + id + ", idClient=" + idClient + ", idProduct=" + idProduct + ", cantitate=" + cantitate + ", pret=" + pretComanda
                + "]";
    }
}
