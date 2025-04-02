package travel;

import javax.swing.*;
import java.awt.*;

public class ReviewTripPanel extends JPanel {
    private JFrame mainFrame;
    private JTextArea reviewArea;
    private JButton endTripButton, backButton, connectButton;
    private String tripKey;
    private String matchedEmail;

    public ReviewTripPanel(JFrame mainFrame, String tripKey) {
        this.mainFrame = mainFrame;
        this.tripKey = tripKey;
        setLayout(new BorderLayout());

        reviewArea = new JTextArea(20, 50);
        reviewArea.setEditable(false);
        reviewArea.setFont(new Font("Serif", Font.PLAIN, 14));
        reviewArea.setBackground(Color.LIGHT_GRAY);
        reviewArea.setBorder(BorderFactory.createTitledBorder("Trip Details"));

        // Fetch trip details
        Trip trip = TripPlannerService.getTripByKeyAsObject(tripKey);
        if (trip != null) {
            String tripDetails = "Name: " + trip.getName() +
                    "\nDestination: " + trip.getDestination() +
                    "\nFrom: " + trip.getFromDate() +
                    "\nTo: " + trip.getToDate() +
                    "\nBudget: " + trip.getBudget() +
                    "\nPersons: " + trip.getPersons() +
                    "\nPlan: " + trip.getTripPlan();
            reviewArea.setText(tripDetails);

            // Check for solo traveler match if the user has opted to connect with solo travelers
            if (trip.isConnectSolo()) {
                matchedEmail = TripPlannerService.findMatchingSoloTraveler(
                    trip.getDestination(),
                    trip.getFromDate(),
                    trip.getToDate(),
                    trip.getEmail()
                );

                // If a match is found, show the connection option
                if (matchedEmail != null) {
                    reviewArea.append("\n\nSolo Traveler Match Found! You can connect at: " + matchedEmail);
                } else {
                    reviewArea.append("\n\nNo solo traveler match found.");
                }
            }
        } else {
            reviewArea.setText("Trip not found!");
        }

        // Buttons
        endTripButton = new JButton("End Trip");
        backButton = new JButton("Back");
        connectButton = new JButton("Connect with Solo Traveler");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(endTripButton);
        buttonPanel.add(backButton);

        // Add connect button only if there is a match
        if (matchedEmail != null) {
            buttonPanel.add(connectButton);
        }

        add(new JScrollPane(reviewArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Event Listeners
        endTripButton.addActionListener(e -> {
            TripPlannerService.deleteTrip(tripKey);
            JOptionPane.showMessageDialog(mainFrame, "Trip ended successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            backToMain();
        });

        backButton.addActionListener(e -> backToMain());

        connectButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(mainFrame, "You can contact your solo traveler at: " + matchedEmail, "Solo Traveler Connection", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    private void backToMain() {
        mainFrame.getContentPane().removeAll();
        mainFrame.setContentPane(new TripPlannerMain(mainFrame));
        mainFrame.revalidate();
        mainFrame.repaint();
    }
}
