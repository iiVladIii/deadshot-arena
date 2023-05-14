package auth.uiForms.pages;

import auth.logs.Log;
import auth.logs.LogsList;
import auth.uiForms.panels.PasswordPanel;
import auth.uiForms.panels.UsernamePanel;

import javax.swing.*;
import java.awt.*;

public class LogsPage {
    private JPanel logsPanel = new JPanel();
    private static JTextArea textArea;

    public LogsPage() {
        Label pageTitle = new Label("Logs");
        pageTitle.setMaximumSize(new Dimension(50, 60));

        logsPanel.setLayout(new BoxLayout(logsPanel, BoxLayout.Y_AXIS));
        logsPanel.add(pageTitle);
        textArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        fillArea();
        logsPanel.add(scroll);
//        logsPanel.add(scroll);
    }

    public static void fillArea() {
        textArea.setText("");
        for (Log log : LogsList.getLogsList()) {
            textArea.setText(textArea.getText() + "\n" + log.toString());
        }
    }

    public JPanel getPanel() {
        return logsPanel;
    }
}
