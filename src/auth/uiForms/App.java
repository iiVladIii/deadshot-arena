package auth.uiForms;

import auth.uiForms.pages.AuthPage;
import auth.uiForms.pages.LogsPage;
import auth.uiForms.pages.SignupPage;
import auth.uiForms.pages.UserPage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class App extends JFrame {
    private Container container;
    private static ArrayList<JPanel> panelsList = new ArrayList<>();
    private static Menu menu;

    public App() {
        super("App");
        super.setBounds(400, 200, 650, 450);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container = super.getContentPane();
        container.setLayout(new GridLayout(1, 1));

        AuthPage authPage = new AuthPage();
        JPanel authPanel = authPage.getPanel();
        panelsList.add(authPanel);

        SignupPage signupPage = new SignupPage();
        JPanel signupPanel = signupPage.getPanel();
        panelsList.add(signupPanel);


        LogsPage logsPage = new LogsPage();
        JPanel logsPanel = logsPage.getPanel();
        panelsList.add(logsPanel);


        menu = new Menu(panelsList, container);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu.getMenu());
        setJMenuBar(menuBar);


        container.add(signupPanel);

    }
    public static ArrayList<JPanel> getPanelsList() {
        return panelsList;
    }

    public static Menu getMenu() {
        return menu;
    }
}
