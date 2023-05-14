package auth.uiForms.panels;

import javax.swing.*;
import java.awt.*;

public class EmailPanel {
    private JPanel emailPanel = new JPanel();
    private Label email_label = new Label("Email:");
    private JTextField email_text_filed = new JTextField();

    public EmailPanel() {
        emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.X_AXIS));
        email_label.setMaximumSize(new Dimension(80, 40));
        email_text_filed.setMaximumSize(new Dimension(200, 40));
        emailPanel.add(email_label);
        emailPanel.add(email_text_filed);
    }

    public JPanel getPanel() {
        return emailPanel;
    }

    public String getText () {
        return email_text_filed.getText();
    }

    public void setText (String str) {
        email_text_filed.setText(str);
    }

}
