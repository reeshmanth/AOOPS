package travel;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;

public class GeminiTripPlanner extends JPanel {
    private JFrame mainFrame;
    private JTextField nameField, placeField, fromDateField, toDateField, budgetField, personsField, emailField;
    private JCheckBox soloTravelerCheck;
    private JTextArea responseArea;
    private JButton generatePlanButton, backButton, copyKeyButton;
    private String lastGeneratedKey;

    public GeminiTripPlanner(JFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(9, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Trip Planner Inputs"));

        nameField = new JTextField();
        placeField = new JTextField();
        fromDateField = new JTextField();
        toDateField = new JTextField();
        budgetField = new JTextField();
        personsField = new JTextField();
        emailField = new JTextField();
        soloTravelerCheck = new JCheckBox("Connect with Solo Travelers?");

        inputPanel.add(new JLabel("Person's Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(emailField);
        inputPanel.add(new JLabel("Place Name:"));
        inputPanel.add(placeField);
        inputPanel.add(new JLabel("From Date (YYYY-MM-DD):"));
        inputPanel.add(fromDateField);
        inputPanel.add(new JLabel("To Date (YYYY-MM-DD):"));
        inputPanel.add(toDateField);
        inputPanel.add(new JLabel("Budget (INR):"));
        inputPanel.add(budgetField);
        inputPanel.add(new JLabel("Number of Persons:"));
        inputPanel.add(personsField);
        inputPanel.add(new JLabel("Solo Traveler:"));
        inputPanel.add(soloTravelerCheck);

        generatePlanButton = new JButton("Plan Trip");
        backButton = new JButton("Back");
        copyKeyButton = new JButton("Copy Key");
        copyKeyButton.setEnabled(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(generatePlanButton);
        buttonPanel.add(copyKeyButton);
        buttonPanel.add(backButton);

        responseArea = new JTextArea(20, 50);
        responseArea.setEditable(false);
        responseArea.setFont(new Font("Serif", Font.PLAIN, 14));
        responseArea.setBackground(Color.LIGHT_GRAY);
        responseArea.setBorder(BorderFactory.createTitledBorder("Trip Plan"));
        JScrollPane scrollPane = new JScrollPane(responseArea);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        generatePlanButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String place = placeField.getText();
            String fromDate = fromDateField.getText();
            String toDate = toDateField.getText();
            String budgetStr = budgetField.getText();
            String personsStr = personsField.getText();
            boolean isSoloTraveler = soloTravelerCheck.isSelected();

            if (name.isEmpty() || email.isEmpty() || place.isEmpty() || fromDate.isEmpty() || toDate.isEmpty() || budgetStr.isEmpty() || personsStr.isEmpty()) {
                JOptionPane.showMessageDialog(mainFrame, "Please fill all fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double budgetINR;
            int persons;
            try {
                budgetINR = Double.parseDouble(budgetStr);
                persons = Integer.parseInt(personsStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mainFrame, "Invalid budget or persons value!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String tripPlan = TripPlannerService.getTripPlan(name, place, fromDate, toDate, budgetINR, persons);
            responseArea.setText(tripPlan);

            lastGeneratedKey = TripPlannerService.saveTrip(name, email, place, fromDate, toDate, budgetINR, persons, tripPlan, isSoloTraveler);
            if (lastGeneratedKey != null) {
                JOptionPane.showMessageDialog(mainFrame, "Trip saved successfully!\nYour Trip Key: " + lastGeneratedKey, "Success", JOptionPane.INFORMATION_MESSAGE);
                copyKeyButton.setEnabled(true);
            }
        });

        copyKeyButton.addActionListener(e -> {
            if (lastGeneratedKey != null) {
                copyToClipboard(lastGeneratedKey);
                JOptionPane.showMessageDialog(mainFrame, "Trip Key copied to clipboard!", "Copied", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        backButton.addActionListener(e -> {
            mainFrame.getContentPane().removeAll();
            mainFrame.setContentPane(new TripPlannerMain(mainFrame));
            mainFrame.revalidate();
            mainFrame.repaint();
        });
    }

    private void copyToClipboard(String text) {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}
