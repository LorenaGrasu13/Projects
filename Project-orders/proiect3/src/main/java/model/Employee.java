package model;

/**
 * Represents an Employee in the system.
 */
public class Employee {
    private String username;
    private String password;

    /**
     * Default constructor for Employee class.
     */
    public Employee() {

    }

    /**
     * Constructor for Employee class with specified username and password.
     *
     * @param u The username of the employee.
     * @param p The password of the employee.
     */
    public Employee(String u, String p) {
        this.password = p;
        this.username = u;
    }

    /**
     * Checks if the provided username and password match the predefined values.
     *
     * @param u The username to be checked.
     * @param p The password to be checked.
     * @return 1 if the username and password match, 0 otherwise.
     */
    public int test(String u, String p) {
        if (u.equals("Lore") && p.equals("admin")) {
            return 1;
        } else {
            return 0;
        }
    }
}
