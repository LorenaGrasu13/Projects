package presentation;

import model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The View class represents a login view in the presentation layer.
 * It extends JFrame and provides user interface components for username, password, and login functionality.
 */
public class View extends JFrame {
    private JTextField userInput = new JTextField(30);
    private JTextField password = new JTextField(30);
    private JButton loginBtn = new JButton("Login");
    private JButton clearBtn = new JButton("Clear");
    private Employee e;

    /**
     * Constructs a View object with the specified Employee instance.
     *
     * @param e the Employee instance
     */
    public View(Employee e) {
        this.e = e;

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Username"));
        panel1.add(Box.createHorizontalStrut(10));
        panel1.add(userInput);
        panel1.add(Box.createHorizontalStrut(10));
        panel1.add(new JLabel("Password"));
        panel1.add(Box.createHorizontalStrut(10));
        panel1.add(password);
        panel1.add(Box.createHorizontalStrut(10));
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

        JPanel content = new JPanel();
        content.add(panel1);
        content.add(loginBtn);

        this.setContentPane(content);
        this.pack();

        this.setTitle("Login");
        this.setSize(500, 150);
        this.setLocation(430, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Returns the user input from the username text field.
     *
     * @return the user input
     */
    String getUserInput() {
        return userInput.getText();
    }

    /**
     * Returns the password input from the password text field.
     *
     * @return the password input
     */
    String getPassword() {
        return password.getText();
    }

    /**
     * Displays an error message in a dialog box.
     *
     * @param errMessage the error message to display
     */
    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    /**
     * Adds an ActionListener to the login button.
     *
     * @param mal the ActionListener to add
     */
    void addLoginListener(ActionListener mal) {
        loginBtn.addActionListener(mal);
    }

    /**
     * Closes the view.
     */
    public void close() {
        this.dispose();
    }
}
