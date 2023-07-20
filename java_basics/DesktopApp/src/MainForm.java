import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class MainForm {
    private JPanel MainPanel;
    private JPanel collapsePanel;
    private JPanel expandPanel;
    private JTextField surNameField;
    private JTextField nameField;
    private JTextField patronymicField;
    private JButton collapseButton;

    private JTextField FIO;
    private JButton expandButton;
    private static String surName;
    private static String name;
    private static String patronymic;


    public MainForm() {
        expandPanel.setVisible(false);
        collapseButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!surNameField.getText().equals("") && !nameField.getText().equals("")) {
                    collapsePanel.setVisible(false);
                    FIO.setText(surNameField.getText() + " " + nameField.getText()+ " " + patronymicField.getText());
                    expandPanel.setVisible(true);
                } else if (surNameField.getText().equals("")) {
                    danger("Необходимо ввести фамилию");
                } else if (nameField.getText().equals("")) {
                    danger("Необходимо ввести имя");
                }
            }
        });
        expandButton.addActionListener(new Action() {

            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {
            }

            @Override
            public void setEnabled(boolean b) {
            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {
            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                String fioField = FIO.getText();
                if (!fioField.equals("")) {
                    String[] fio = fioField.split("\\s+");
                    if (fio.length == 3) {
                        surName = (fio[0]);
                        name = (fio[1]);
                        patronymic = (fio[2]);
                        sendMessage();
                    } else if (fio.length == 2) {
                        surName = (fio[0]);
                        name = (fio[1]);
                        patronymic = ("");
                        sendMessage();
                    } else {
                        danger("Введены некорректные данные");
                    }
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }

    private void sendMessage() {
        expandPanel.setVisible(false);
        collapsePanel.setVisible(true);
        surNameField.setText(surName);
        nameField.setText(name);
        patronymicField.setText(patronymic);
    }

    private void danger(String text) {
        JOptionPane.showMessageDialog(
                MainPanel,
                text,
                "Предупреждение!",
                JOptionPane.WARNING_MESSAGE);
    }
}