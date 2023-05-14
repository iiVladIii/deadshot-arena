package auth.uiForms.panels;

import javax.swing.*;
import java.awt.*;

public class UsernamePanel {
    private JPanel usernamePanel = new JPanel();
    private Label username_label = new Label("Username:");
    private JTextField username_text_filed = new JTextField();

    public UsernamePanel() {
        usernamePanel.setLayout(new BoxLayout(usernamePanel, BoxLayout.X_AXIS));
        username_label.setMaximumSize(new Dimension(80, 40));
        username_text_filed.setMaximumSize(new Dimension(200, 40));
        usernamePanel.add(username_label);
        usernamePanel.add(username_text_filed);
    }

    public JPanel getPanel() {
        return usernamePanel;
    }

    public String getText () {
        return username_text_filed.getText();
    }
    public void setText (String str) {
        username_text_filed.setText(str);
    }
}
