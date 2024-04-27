package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Represents the GUI window for adding a client.
 */
public class AddClient extends JFrame {
    private JTextField t1 = new JTextField(5);
    private JTextField t2 = new JTextField(45);
    private JTextField t3 = new JTextField(45);
    private JTextField t4 = new JTextField(45);
    private JTextField t5 = new JTextField(5);
    private JButton b = new JButton("Add");
    private JButton b2 = new JButton("Back");

    /**
     * Creates an instance of AddClient window.
     */
    public AddClient() {
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(6, 2, 10, 10));
        panel1.add(new JLabel("ID ="));
        panel1.add(t1);
        panel1.add(new JLabel("Name ="));
        panel1.add(t2);
        panel1.add(new JLabel("Address ="));
        panel1.add(t3);
        panel1.add(new JLabel("Email ="));
        panel1.add(t4);
        panel1.add(new JLabel("Age ="));
        panel1.add(t5);
        panel1.add(b2);
        panel1.add(b);
        JPanel content = new JPanel(new BorderLayout());
        content.add(panel1, BorderLayout.CENTER);
        this.setContentPane(content);
        this.pack();

        this.setTitle("Client Add");
        this.setSize(300, 300);
        this.setLocation(430, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * Displays an error message in a dialog box.
     *
     * @param errMessage The error message to be displayed.
     */
    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    /**
     * Adds an ActionListener to the "Add" button.
     *
     * @param mal The ActionListener to be added.
     */
    void addbListener(ActionListener mal) {
        b.addActionListener(mal);
    }

    /**
     * Adds an ActionListener to the "Back" button.
     *
     * @param mal The ActionListener to be added.
     */
    void addb2Listener(ActionListener mal) {
        b2.addActionListener(mal);
    }

    /**
     * Retrieves the value from text field t1 as an integer.
     *
     * @return The value of t1 as an integer.
     */
    int gett1() {
        return Integer.parseInt(t1.getText());
    }

    /**
     * Retrieves the value from text field t2 as a string.
     *
     * @return The value of t2 as a string.
     */
    String gett2() {
        return t2.getText();
    }

    /**
     * Retrieves the value from text field t3 as a string.
     *
     * @return The value of t3 as a string.
     */
    String gett3() {
        return t3.getText();
    }

    /**
     * Retrieves the value from text field t4 as a string.
     *
     * @return The value of t4 as a string.
     */
    String gett4() {
        return t4.getText();
    }

    /**
     * Retrieves the value from text field t5 as an integer.
     *
     * @return The value of t5 as an integer.
     */
    int gett5() {
        return Integer.parseInt(t5.getText());
    }

    /**
     * Closes the AddClient window.
     */
    public void close() {
        this.dispose();
    }
}
