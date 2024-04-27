package model;
/**

 The Client class represents a client entity with various properties such as ID, name, address, email, and age.
 */
public class Client {
    private int id;
    private String clientName;
    private String clientAddress;
    private String clientEmail;
    private int clientAge;
    /**
     Constructs a new Client object with default values for the properties.
     */
    public Client() {

    }
    /**
     Constructs a new Client object with the specified values for the properties.
     @param id The ID of the client.
     @param name The name of the client.
     @param address The address of the client.
     @param email The email of the client.
     @param age The age of the client.
     */
    public Client(int id, String name, String address, String email, int age) {
        super();
        this.id = id;
        this.clientName = name;
        this.clientAddress = address;
        this.clientEmail = email;
        this.clientAge = age;
    }
    /**
     Constructs a new Client object with the specified values for the properties.
     @param name The name of the client.
     @param address The address of the client.
     @param email The email of the client.
     @param age The age of the client.
     */
    public Client(String name, String address, String email, int age) {
        super();
        this.clientName = name;
        this.clientAddress = address;
        this.clientEmail = email;
        this.clientAge = age;
    }
    /**
     Retrieves the ID of the client.
     @return The ID of the client.
     */
    public int getId() {
        return id;
    }
    /**
     Sets the ID of the client.
     @param id The ID to set for the client.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**

     Retrieves the name of the client.
     @return The name of the client.
     */
    public String getClientName() {
        return clientName;
    }
    /**

     Sets the name of the client.
     @param name The name to set for the client.
     */
    public void setClientName(String name) {
        this.clientName = name;
    }
    /**

     Retrieves the address of the client.
     @return The address of the client.
     */
    public String getClientAddress() {
        return clientAddress;
    }
    /**

     Sets the address of the client.
     @param address The address to set for the client.
     */
    public void setClientAddress(String address) {
        this.clientAddress = address;
    }
    /**

     Retrieves the age of the client.
     @return The age of the client.
     */
    public int getClientAge() {
        return clientAge;
    }
    /**

     Sets the age of the client.
     @param age The age to set for the client.
     */
    public void setClientAge(int age) {
        this.clientAge = age;
    }
    /**

     Retrieves the email of the client.
     @return The email of the client.
     */
    public String getClientEmail() {
        return clientEmail;
    }
    /**

     Sets the email of the client.
     @param email The email to set for the client.
     */
    public void setClientEmail(String email) {
        this.clientEmail = email;
    }
    /**

     Returns a string representation of the Client object.
     @return A string representation of the Client object.
     */
    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + clientName + ", address=" + clientAddress + ", email=" + clientEmail + ", age=" + clientAge
                + "]";
    }

}
