package model;

/**
 * Represents a Product in the system.
 */
public class Product {
    private int id;
    private String ProductName;
    private int ProductPrice;
    private int ProductStock;

    /**
     * Default constructor for Product class.
     */
    public Product() {
    }

    /**
     * Constructor for Product class with specified parameters.
     *
     * @param id   The ID of the product.
     * @param name The name of the product.
     * @param p    The price of the product.
     * @param s    The stock of the product.
     */
    public Product(int id, String name, int p, int s) {
        super();
        this.id = id;
        this.ProductName = name;
        this.ProductPrice = p;
        this.ProductStock = s;
    }

    /**
     * Constructor for Product class with specified parameters.
     * The ID of the product is not provided.
     *
     * @param name The name of the product.
     * @param p    The price of the product.
     * @param s    The stock of the product.
     */
    public Product(String name, int p, int s) {
        super();
        this.ProductName = name;
        this.ProductPrice = p;
        this.ProductStock = s;
    }

    /**
     * Retrieves the ID of the product.
     *
     * @return The ID of the product.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the product.
     *
     * @param id The ID of the product.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the product.
     *
     * @return The name of the product.
     */
    public String getProductName() {
        return ProductName;
    }

    /**
     * Sets the name of the product.
     *
     * @param name The name of the product.
     */
    public void setProductName(String name) {
        this.ProductName = name;
    }

    /**
     * Retrieves the price of the product.
     *
     * @return The price of the product.
     */
    public int getProductPrice() {
        return ProductPrice;
    }

    /**
     * Sets the price of the product.
     *
     * @param p The price of the product.
     */
    public void setProductPrice(int p) {
        this.ProductPrice = p;
    }

    /**
     * Retrieves the stock of the product.
     *
     * @return The stock of the product.
     */
    public int getProductStock() {
        return ProductStock;
    }

    /**
     * Sets the stock of the product.
     *
     * @param s The stock of the product.
     */
    public void setProductStock(int s) {
        this.ProductStock = s;
    }

    /**
     * Returns a string representation of the Product object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + ProductName + ", pret=" + ProductPrice + ", stock=" + ProductStock
                + "]";
    }
}
