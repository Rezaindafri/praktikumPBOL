import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;

public class Tugas3_B1 extends JFrame {
    private JPanel registerPanel, loginPanel;
    private JTextField nameField, registerUsernameField, loginUsernameField;
    private JPasswordField registerPasswordField, registerRePasswordField, loginPasswordField;
    private JButton createButton, loginButton, switchToLoginButton, switchToRegisterButton;
    
    // Menggunakan HashMap untuk menyimpan data pengguna
    private HashMap<String, String> dataUser = new HashMap<>();

    public Tugas3_B1() {
        setTitle("Sistem Register dan Login");
        setSize(460, 560);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new CardLayout());

        initLoginPanel();
        initRegisterPanel();


        add(loginPanel, "login");
        add(registerPanel, "register");

        switchToLoginPanel();
    }


    private void initLoginPanel() {
        loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        loginPanel.add(titleLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        loginPanel.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        loginUsernameField = new JTextField(20);
        loginPanel.add(loginUsernameField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        loginPanel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        loginPasswordField = new JPasswordField(20);
        loginPanel.add(loginPasswordField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        loginButton = new JButton("Masuk");
        loginButton.addActionListener(new LoginAction());
        loginPanel.add(loginButton, gbc);

        gbc.gridy++;
        switchToRegisterButton = new JButton("Belum Punya Akun? Daftar");
        switchToRegisterButton.addActionListener(e -> switchToRegisterPanel());
        loginPanel.add(switchToRegisterButton, gbc);
    }

    private void initRegisterPanel() {
        registerPanel = new JPanel(new GridBagLayout());
        registerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        JLabel titleLabel = new JLabel("Register");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        registerPanel.add(titleLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        registerPanel.add(new JLabel("Nama:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        nameField = new JTextField(20);
        registerPanel.add(nameField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        registerPanel.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        registerUsernameField = new JTextField(20);
        registerPanel.add(registerUsernameField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        registerPanel.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        registerPasswordField = new JPasswordField(20);
        registerPanel.add(registerPasswordField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        registerPanel.add(new JLabel("Ulangi Password:"), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        registerRePasswordField = new JPasswordField(20);
        registerPanel.add(registerRePasswordField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        createButton = new JButton("Buat Akun");
        createButton.addActionListener(new RegisterAction());
        registerPanel.add(createButton, gbc);

        gbc.gridy++;
        switchToLoginButton = new JButton("Kembali ke Login");
        switchToLoginButton.addActionListener(e -> switchToLoginPanel());
        registerPanel.add(switchToLoginButton, gbc);
    }

    private void switchToLoginPanel() {
        ((CardLayout) getContentPane().getLayout()).show(getContentPane(), "login");
    }

    private void switchToRegisterPanel() {
        ((CardLayout) getContentPane().getLayout()).show(getContentPane(), "register");
    }

    private class LoginAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = loginUsernameField.getText();
            String password = new String(loginPasswordField.getPassword());

            if (dataUser.containsKey(username) && dataUser.get(username).equals(password)) {
                JOptionPane.showMessageDialog(Tugas3_B1.this, "Login Berhasil!");
            } else {
                JOptionPane.showMessageDialog(Tugas3_B1.this, "Username atau Password salah.");
            }
        }
    }

    private class RegisterAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String username = registerUsernameField.getText();
            String password = new String(registerPasswordField.getPassword());
            String rePassword = new String(registerRePasswordField.getPassword());

            if (dataUser.containsKey(username)) {
                JOptionPane.showMessageDialog(Tugas3_B1.this, "Username sudah terdaftar.");
            } else if (!password.equals(rePassword)) {
                JOptionPane.showMessageDialog(Tugas3_B1.this, "Password tidak cocok, silakan periksa kembali.");
            } else {
                dataUser.put(username, password);
                JOptionPane.showMessageDialog(Tugas3_B1.this, "Pendaftaran Berhasil! Silakan Login.");
                switchToLoginPanel();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Tugas3_B1 app = new Tugas3_B1();
            app.setVisible(true);
        });
    }
}
