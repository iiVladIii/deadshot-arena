package auth.uiForms.pages;

import auth.registration.RegistrationUi;
import auth.uiForms.App;
import auth.uiForms.Menu;
import auth.uiForms.panels.EmailPanel;
import auth.uiForms.panels.PasswordPanel;
import auth.uiForms.panels.UsernamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupPage {
    private JPanel signupPanel = new JPanel();

    public SignupPage() {
        PasswordPanel passwordPanel = new PasswordPanel();
        UsernamePanel usernamePanel = new UsernamePanel();
        EmailPanel emailPanel = new EmailPanel();

        Label pageTitle = new Label("Signup");
        pageTitle.setMaximumSize(new Dimension(50, 60));

        JButton submitButton = new JButton("Зарегестрироваться");
        submitButton.setMaximumSize(new Dimension(280, 40));
        JPanel buttonPanel = new JPanel();

        buttonPanel.add(submitButton);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        signupPanel.setLayout(new BoxLayout(signupPanel, BoxLayout.Y_AXIS));
        signupPanel.add(pageTitle);
        signupPanel.add(emailPanel.getPanel());
        signupPanel.add(passwordPanel.getPanel());
        signupPanel.add(usernamePanel.getPanel());
        signupPanel.add(buttonPanel);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean regResult = RegistrationUi.signupUI(
                        emailPanel.getText(),
                        passwordPanel.getText(),
                        usernamePanel.getText()
                );
                if (regResult) {
                    emailPanel.setText("");
                    passwordPanel.setText("");
                    usernamePanel.setText("");
                    UserPage userPage = new UserPage();
                    JPanel userPanel = userPage.getPanel();
                    App.getPanelsList().add(userPanel);
                    App.getMenu().updateMenu();
                    LogsPage.fillArea();
                }
            }
        });
    }

    public JPanel getPanel() {
        return signupPanel;
    }

}
