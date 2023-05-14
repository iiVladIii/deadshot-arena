package auth.uiForms.panels;

import javax.swing.*;
import java.awt.*;

public class PasswordPanel {
    private JPanel passwordPanel = new JPanel();
    private Label password_label = new Label("Password:");
    private JTextField password_text_filed = new JPasswordField();


    public PasswordPanel() {
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
        password_label.setMaximumSize(new Dimension(80, 40));
        password_text_filed.setMaximumSize(new Dimension(200, 40));
        passwordPanel.add(password_label);
        passwordPanel.add(password_text_filed);
    }

    public JPanel getPanel() {
        return passwordPanel;
    }

    public String getText() {
        return password_text_filed.getText();
    }

    public void setText(String str) {
        password_text_filed.setText(str);
    }
}
