package recipefinder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    // Simulating a database of users
    private static final HashMap<String, String> usersDatabase = new HashMap<>();

    static {
        usersDatabase.put("user", "password");
        usersDatabase.put("admin", "admin123");
        usersDatabase.put("guest", "guest2024");
    }

    public LoginPage() {
        setTitle("Login");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
         setLocationRelativeTo(null);  // Center the frame

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Username label and field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        panel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        usernameField = new JTextField(15);
        panel.add(usernameField, gbc);

        // Password label and field
        gbc.gridx = 0;
        gbc.gridy = 1;
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        panel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        passwordField = new JPasswordField(15);
        panel.add(passwordField, gbc);

        // Login button
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });
        panel.add(loginButton, gbc);

        add(panel);
        setVisible(true);
    }

    private void performLogin() {
        // Authentication logic using dynamic credentials
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Check if the entered credentials match the ones in the "database"
        if (usersDatabase.containsKey(username) && usersDatabase.get(username).equals(password)) {
            // If login is successful, open the Recipe Finder GUI
            new RecipeFinderGUI();
            dispose(); // Close the login window
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials. Please try again.", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginPage());
    }
}
