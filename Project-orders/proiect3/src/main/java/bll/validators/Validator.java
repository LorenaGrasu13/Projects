package bll.validators;
/**
 * Interface for implementing validation logic.
 *
 * @param <T> the type of object to be validated
 */
public interface Validator<T> {
    /**
     * Validates an object of type T.
     *
     * @param t the object to be validated
     * @throws IllegalArgumentException if the object does not pass the validation criteria
     */
    public void validate(T t);
}
