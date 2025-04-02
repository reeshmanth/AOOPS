package p1;

public class BikeFactory implements RideFactory {
    public Vehicle createVehicle() {
        return new Bike();
    }
}
