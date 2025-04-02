package p1;

public class CarFactory implements RideFactory {
    public Vehicle createVehicle() {
        return new Car();
    }
}
