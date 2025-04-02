package p1;

public class ScooterFactory implements RideFactory {
    public Vehicle createVehicle() {
        return new Scooter();
    }
}
