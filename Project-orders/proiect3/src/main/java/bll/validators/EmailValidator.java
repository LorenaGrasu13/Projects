package bll.validators;
import java.util.regex.Pattern;
import model.Client;
/**
 * Validator class to validate the email of a Client.
 */
public class EmailValidator implements Validator<Client>{

    private static final String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    /**
     * Validates the email of a Client.
     *
     * @param c the Client to be validated
     * @throws IllegalArgumentException if the email of the Client is not a valid email format
     */
    public void validate(Client c) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        if (!pattern.matcher(c.getClientEmail()).matches()) {
            throw new IllegalArgumentException("Email is not a valid email!");
        }
    }
}
