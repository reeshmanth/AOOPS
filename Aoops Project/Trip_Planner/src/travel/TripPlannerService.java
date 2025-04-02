package travel;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.util.UUID;
import org.json.*;

public class TripPlannerService {

    public static String getTripPlan(String name, String place, String fromDate, String toDate, double budgetINR, int persons) {
        String apiKey = ApiConfig.API_KEY;
        if (apiKey == null || apiKey.isEmpty()) {
            return "Error: API key is missing.";
        }

        try {
            String apiUrl = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-pro:generateContent?key=" + apiKey;
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInputString = "{ \"contents\": [{ \"parts\": [{ \"text\": \"Generate a detailed trip plan for: "
                    + name + " visiting " + place + " from " + fromDate + " to " + toDate
                    + ". Budget: " + budgetINR + " INR, with " + persons + " persons. Provide daily itineraries and estimated costs.\" }] }] }";

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line).append("\n");
                    }

                    System.out.println("Raw API Response:\n" + response.toString());

                    String tripPlan = extractTextFromResponse(response.toString());

                    System.out.println("Extracted Trip Plan:\n" + tripPlan);

                    return tripPlan;
                }
            } else {
                return "Error: HTTP " + responseCode;
            }
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    private static String extractTextFromResponse(String jsonResponse) {
        try {
            JSONObject responseObj = new JSONObject(jsonResponse);
            JSONArray candidates = responseObj.getJSONArray("candidates");

            if (candidates.length() > 0) {
                JSONObject firstCandidate = candidates.getJSONObject(0);
                JSONObject content = firstCandidate.getJSONObject("content");
                JSONArray parts = content.getJSONArray("parts");

                if (parts.length() > 0) {
                    return parts.getJSONObject(0).getString("text").replace("\\n", "\n").replace("**", "");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Error extracting trip plan.";
    }

    public static String saveTrip(String name, String email, String destination, String fromDate, String toDate, double budget, int persons, String tripPlan, boolean connectSolo) {
        String uniqueKey = UUID.randomUUID().toString();
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                 "INSERT INTO trips (name, email, destination, from_date, to_date, budget, persons, trip_plan, unique_key, connect_solo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
             )) {
            
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, destination);
            stmt.setDate(4, java.sql.Date.valueOf(fromDate));
            stmt.setDate(5, java.sql.Date.valueOf(toDate));
            stmt.setDouble(6, budget);
            stmt.setInt(7, persons);
            stmt.setString(8, tripPlan);
            stmt.setString(9, uniqueKey);
            stmt.setBoolean(10, connectSolo);
            
            int rowsAffected = stmt.executeUpdate();
            return (rowsAffected > 0) ? uniqueKey : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String findMatchingSoloTraveler(String destination, String fromDate, String toDate, String currentUserEmail) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                 "SELECT email FROM trips WHERE destination = ? AND from_date = ? AND to_date = ? AND connect_solo = true AND email <> ?"
             )) {
            // Set the parameters for the query
            stmt.setString(1, destination);
            stmt.setDate(2, java.sql.Date.valueOf(fromDate));
            stmt.setDate(3, java.sql.Date.valueOf(toDate));
            stmt.setString(4, currentUserEmail);

            // Execute the query
            ResultSet rs = stmt.executeQuery();

            // If there's a matching traveler, return their email
            if (rs.next()) {
                return rs.getString("email");  // Matching traveler with connect_solo = true
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;  // No match found or the other traveler didn't check the connect_solo box
    }

    
    public static void deleteTrip(String uniqueKey) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM trips WHERE unique_key = ?")) {
            stmt.setString(1, uniqueKey);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to get trip details as a formatted string
    public static String getTripByKey(String uniqueKey) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM trips WHERE unique_key = ?")) {
            stmt.setString(1, uniqueKey);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return "Name: " + rs.getString("name") +
                       "\nDestination: " + rs.getString("destination") +
                       "\nFrom: " + rs.getDate("from_date") +
                       "\nTo: " + rs.getDate("to_date") +
                       "\nBudget: " + rs.getDouble("budget") +
                       "\nPersons: " + rs.getInt("persons") +
                       "\nPlan: " + rs.getString("trip_plan");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Trip not found!";
    }

    // New method to get trip details as an object
    public static Trip getTripByKeyAsObject(String uniqueKey) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM trips WHERE unique_key = ?")) {
            stmt.setString(1, uniqueKey);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Trip(
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("destination"),
                    rs.getDate("from_date").toString(),
                    rs.getDate("to_date").toString(),
                    rs.getDouble("budget"),
                    rs.getInt("persons"),
                    rs.getString("trip_plan"),
                    rs.getBoolean("connect_solo")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
