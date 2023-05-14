package auth.uiForms;

import auth.AuthData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Menu {
    private final JMenu menu;
    private final JMenuItem signIn;
    private final JMenuItem signup;
    private final JMenuItem logs;
    private final JMenuItem exit;
    private final JMenuItem userInfo;
    private final Container container;

    public void updateMenu() {
        if (AuthData.getIsAuth()) {
            menu.add(userInfo);
            menu.add(exit);
            userInfo.setVisible(true);
            exit.setVisible(true);
        } else {
            menu.remove(userInfo);
            menu.remove(exit);
        }
    }

    public Menu(List<JPanel> panelsList, Container containerPs) {
        menu = new JMenu("Menu");
        container = containerPs;

        signIn = new JMenuItem("SignIn");
        signup = new JMenuItem("Signup");
        logs = new JMenuItem("Logs");
        userInfo = new JMenuItem("User info");
        exit = new JMenuItem("logout");

        menu.add(signup);
        menu.add(signIn);
        menu.add(logs);


        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuGoTo(0);
            }
        });

        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuGoTo(1);
            }
        });

        logs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               menuGoTo(2);
            }
        });

        userInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuGoTo(3);
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuGoTo(0);
                AuthData.logout();
                updateMenu();
            }
        });
    }

    public void menuGoTo(int index) {
        App.getPanelsList().forEach(jPanel -> {
            jPanel.setVisible(false);
            container.remove(jPanel);
        });
        container.add(App.getPanelsList().get(index));
        App.getPanelsList().get(index).setVisible(true);
        updateMenu();
    }
    public JMenu getMenu() {
        return menu;
    }

    public JMenuItem getSignIn() {
        return signIn;
    }

    public JMenuItem getSignup() {
        return signup;
    }

    public JMenuItem getLogs() {
        return logs;
    }

    public JMenuItem getExit() {
        return exit;
    }

    public JMenuItem getUserInfo() {
        return userInfo;
    }
}
