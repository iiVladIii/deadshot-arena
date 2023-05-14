package auth.uiForms.pages;

import auth.signIn.SignInUI;
import auth.uiForms.App;
import auth.uiForms.panels.EmailPanel;
import auth.uiForms.panels.PasswordPanel;
import auth.uiForms.panels.UsernamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AuthPage {
    private JPanel authPanel = new JPanel();

    public AuthPage() {
        PasswordPanel passwordPanel = new PasswordPanel();
        EmailPanel emailPanel = new EmailPanel();

        Label pageTitle = new Label("Sign in");
        pageTitle.setMaximumSize(new Dimension(50, 60));

        JButton submitButton = new JButton("Войти");
        submitButton.setMaximumSize(new Dimension(280, 40));
        JPanel buttonPanel = new JPanel();

        buttonPanel.add(submitButton);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        authPanel.setLayout(new BoxLayout(authPanel, BoxLayout.Y_AXIS));
        authPanel.add(pageTitle);
        authPanel.add(emailPanel.getPanel());
        authPanel.add(passwordPanel.getPanel());
        authPanel.add(buttonPanel);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean loginIsSuccess = SignInUI.signIn(emailPanel.getText(), passwordPanel.getText());
                if (loginIsSuccess) {
                    emailPanel.setText("");
                    UserPage userPage = new UserPage();
                    JPanel userPanel = userPage.getPanel();
                    App.getPanelsList().add(userPanel);
                    App.getMenu().updateMenu();
                    LogsPage.fillArea();
                }
                passwordPanel.setText("");
            }
        });
    }

    public JPanel getPanel() {
        return authPanel;
    }
}
