package p1;

public class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        if (type.equalsIgnoreCase("car")) return new Car();
        else if (type.equalsIgnoreCase("bike")) return new Bike();
        else if (type.equalsIgnoreCase("scooter")) return new Scooter();
        return null;
    }
}
