package travel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TripPlannerMain extends JPanel {
    private JFrame mainFrame;

    public TripPlannerMain(JFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton planTripButton = new JButton("Plan Trip");
        JButton reviewTripButton = new JButton("Review Trip");

        planTripButton.addActionListener((ActionEvent e) -> {
            mainFrame.getContentPane().removeAll();
            mainFrame.setContentPane(new GeminiTripPlanner(mainFrame));
            mainFrame.revalidate();
            mainFrame.repaint();
        });

        reviewTripButton.addActionListener((ActionEvent e) -> {
            String tripKey = JOptionPane.showInputDialog(mainFrame, "Enter Trip Key:", "Review Trip", JOptionPane.QUESTION_MESSAGE);
            if (tripKey != null && !tripKey.trim().isEmpty()) {
                mainFrame.getContentPane().removeAll();
                mainFrame.setContentPane(new ReviewTripPanel(mainFrame, tripKey));
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });

        buttonPanel.add(planTripButton);
        buttonPanel.add(reviewTripButton);

        add(buttonPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame mainFrame = new JFrame("Trip Planner");
            mainFrame.setSize(400, 200);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setContentPane(new TripPlannerMain(mainFrame));
            mainFrame.setVisible(true);
        });
    }
}
