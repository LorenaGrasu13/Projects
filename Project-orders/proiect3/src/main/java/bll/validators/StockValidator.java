package bll.validators;
import model.Product;
/**
 * Validator class to validate the stock of a Product.
 */
public class StockValidator implements Validator<Product>{
    private static final int MIN_STOCK = 0;
    /**
     * Validates the stock of a Product.
     *
     * @param p the Product to be validated
     * @throws IllegalArgumentException if the stock of the Product is below the minimum stock limit
     */
    public void validate(Product p) {

        if (p.getProductStock() < MIN_STOCK) {
            throw new IllegalArgumentException("The Product Stock limit is not respected!");
        }
    }
}
