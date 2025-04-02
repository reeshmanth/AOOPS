package p1;

public class Client {
    public static void main(String[] args) {
        // Singleton: Game Level Manager
        GameLevelManager levelManager = GameLevelManager.getInstance();
        System.out.println("Current Game Level: " + levelManager.getLevel());
        levelManager.setLevel("Hard");
        System.out.println("Updated Game Level: " + levelManager.getLevel());

        // Factory Pattern: Requesting a ride
        Vehicle vehicle = VehicleFactory.getVehicle("bike");
        if (vehicle != null) {
            vehicle.requestRide();
        }

        // Abstract Factory Pattern: Creating vehicles
        RideFactory carFactory = new CarFactory();
        Vehicle myCar = carFactory.createVehicle();
        myCar.requestRide();

        RideFactory bikeFactory = new BikeFactory();
        Vehicle myBike = bikeFactory.createVehicle();
        myBike.requestRide();
    }
}
