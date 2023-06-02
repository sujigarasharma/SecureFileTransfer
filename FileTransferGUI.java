import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;
import java.util.Arrays;

public class FileTransferGUI extends Frame {
    private Label passwordLabel;
    private JPasswordField passwordField;
    private Button authenticateButton;
    private Button uploadButton;
    private Button encryptButton;
    private Button decryptButton;
    private TextArea logTextArea;

    private String authenticatedUser;
    private File selectedFile;

    public FileTransferGUI() {
        setTitle("Secure File Transfer");
        setSize(500, 400);
        setLayout(new FlowLayout());

        passwordLabel = new Label("Password:");
        add(passwordLabel);

        passwordField = new JPasswordField(20);
        add(passwordField);

        authenticateButton = new Button("Authenticate");
        authenticateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                authenticateUser();
            }
        });
        add(authenticateButton);

        uploadButton = new Button("Upload File");
        uploadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectFile();
            }
        });
        add(uploadButton);

        encryptButton = new Button("Encrypt File");
        encryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                encryptFile();
            }
        });
        add(encryptButton);

        decryptButton = new Button("Decrypt File");
        decryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                decryptFile();
            }
        });
        add(decryptButton);

        logTextArea = new TextArea(15, 40);
        add(logTextArea);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private void authenticateUser() {
        String password = passwordField.getText();
        String hashedPassword = hashPassword(password);

        // Simulate user authentication
        if (hashedPassword.equals(hashPassword("admin123"))) {
            authenticatedUser = "SUJIGARASHARMA";
            log("User authenticated as: " + authenticatedUser);
        }else if (hashedPassword.equals(hashPassword("admin111"))) {
            authenticatedUser = "BAVAN";
            log("User authenticated as: " + authenticatedUser);
        }else {
            log("Authentication failed!");
        }
    }

    private void selectFile() {
        FileDialog fileDialog = new FileDialog(this, "Select File", FileDialog.LOAD);
        fileDialog.setVisible(true);

        String directory = fileDialog.getDirectory();
        String filename = fileDialog.getFile();

        if (directory != null && filename != null) {
            selectedFile = new File(directory, filename);
            log("Selected file: " + selectedFile.getAbsolutePath());
        }
    }

    private void encryptFile() {
        if (authenticatedUser == null) {
            log("Please authenticate first!");
            return;
        }

        if (selectedFile == null) {
            log("Please select a file!");
            return;
        }

        try {
            String encryptedFileName = selectedFile.getName() + ".encrypted";
            File encryptedFile = new File(selectedFile.getParent(), encryptedFileName);

            byte[] fileBytes = Files.readAllBytes(selectedFile.toPath());
            byte[] encryptedBytes = encryptBytes(fileBytes);

            Files.write(encryptedFile.toPath(), encryptedBytes);
            log("File encrypted: " + encryptedFile.getAbsolutePath());
        } catch (IOException e) {
            log("Error encrypting file: " + e.getMessage());
        }
    }

    private void decryptFile() {
        if (authenticatedUser == null) {
            log("Please authenticate first!");
            return;
        }

        if (selectedFile == null) {
            log("Please select a file!");
            return;
        }

        try {
            String decryptedFileName = selectedFile.getName().replaceAll("\\.encrypted$", "");
            File decryptedFile = new File(selectedFile.getParent(), decryptedFileName);

            byte[] fileBytes = Files.readAllBytes(selectedFile.toPath());
            byte[] decryptedBytes = decryptBytes(fileBytes);

            Files.write(decryptedFile.toPath(), decryptedBytes);
            log("File decrypted: " + decryptedFile.getAbsolutePath());
        } catch (IOException e) {
            log("Error decrypting file: " + e.getMessage());
        }
    }

    private byte[] encryptBytes(byte[] input) {
        byte[] passwordBytes = passwordField.getText().getBytes();
        byte[] encryptedBytes = new byte[input.length];

        for (int i = 0; i < input.length; i++) {
            encryptedBytes[i] = (byte) (input[i] ^ passwordBytes[i % passwordBytes.length]);
        }

        return encryptedBytes;
    }

    private byte[] decryptBytes(byte[] input) {
        return encryptBytes(input);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            byte[] hashedBytes = digest.digest(password.getBytes());

            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : hashedBytes) {
                stringBuilder.append(String.format("%02x", b));
            }

            return stringBuilder.toString();
        } catch (Exception e) {
            log("Error hashing password: " + e.getMessage());
        }

        return null;
    }

    private void log(String message) {
        logTextArea.append(message + "\n");
    }

    public static void main(String[] args) {
        FileTransferGUI gui = new FileTransferGUI();
        gui.setVisible(true);
    }
}
