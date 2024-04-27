package bll.validators;
import model.Client;
/**
 * Validator class to validate the age of a Client.
 */
public class AgeValidator implements Validator<Client>{
    private static final int MIN_AGE = 18;

    /**
     * Validates the age of a Client.
     *
     * @param c the Client to be validated
     * @throws IllegalArgumentException if the age of the Client is below the minimum age limit
     */

    public void validate(Client c) {

        if (c.getClientAge() < MIN_AGE) {
            throw new IllegalArgumentException("The customer Age limit is not respected!");
        }

    }
}
