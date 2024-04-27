package start;

import java.lang.reflect.Field;

/**
 * The ReflectionExample class provides a static method for retrieving properties of an object using reflection.
 */
public class ReflectionExample {

    /**
     * Retrieves the properties of an object using reflection and prints them to the console.
     *
     * @param object the object whose properties to retrieve
     */
    public static void retrieveProperties(Object object) {
        // Iterate over the fields of the object
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true); // Enable access to private fields
            Object value;
            try {
                // Get the value of the field from the object
                value = field.get(object);
                System.out.println(field.getName() + "=" + value);

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
