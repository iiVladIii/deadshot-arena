package auth.uiForms.pages;

import auth.AuthData;
import auth.uiForms.panels.EmailPanel;
import auth.uiForms.panels.PasswordPanel;
import auth.uiForms.panels.UsernamePanel;
import auth.user.User;

import javax.swing.*;
import java.awt.*;

public class UserPage {
    private JPanel userPanel = new JPanel();

    public UserPage() {
        Label pageTitle = new Label("Пользователь");
        pageTitle.setMaximumSize(new Dimension(200, 60));

        Label username_label = new Label("Username: " + AuthData.getUser().getUsername());
        username_label.setMaximumSize(new Dimension(200, 40));

        Label password_label = new Label("Password Hash: " + AuthData.getUser().getPassword());
        password_label.setMaximumSize(new Dimension(400, 40));

        Label email_label = new Label("Email: " + AuthData.getUser().getEmail());
        email_label.setMaximumSize(new Dimension(200, 40));

        Label id_label = new Label("Id: " + Long.toString(AuthData.getUser().getId()));
        id_label.setMaximumSize(new Dimension(200, 40));

        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));
        userPanel.add(pageTitle);
        userPanel.add(id_label);
        userPanel.add(username_label);
        userPanel.add(email_label);
        userPanel.add(password_label);
    }

    public JPanel getPanel() {
        return userPanel;
    }
}
