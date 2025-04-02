package travel;

public class Trip {
    private String name;
    private String email;
    private String destination;
    private String fromDate;
    private String toDate;
    private double budget;
    private int persons;
    private String tripPlan;
    private boolean connectSolo;

    // Constructor with all required fields
    public Trip(String name, String email, String destination, String fromDate, String toDate, double budget, int persons, String tripPlan, boolean connectSolo) {
        this.name = name;
        this.email = email;
        this.destination = destination;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.budget = budget;
        this.persons = persons;
        this.tripPlan = tripPlan;
        this.connectSolo = connectSolo;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDestination() {
        return destination;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public double getBudget() {
        return budget;
    }

    public int getPersons() {
        return persons;
    }

    public String getTripPlan() {
        return tripPlan;
    }

    public boolean isConnectSolo() {
        return connectSolo;
    }
}
