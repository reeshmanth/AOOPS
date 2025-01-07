package game;

public class HealthPotion implements PowerUp {
    public void activate() {
        System.out.println("Health restored!");
    }

    public void display() {
        System.out.println("A Health Potion has been picked up!");
    }
}
