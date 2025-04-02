package game;

public class SpeedBoost implements PowerUp {
    public void activate() {
        System.out.println("Speed boosted!");
    }

    public void display() {
        System.out.println("A Speed Boost has been picked up!");
    }
}
