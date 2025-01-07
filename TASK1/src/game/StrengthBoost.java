package game;

public class StrengthBoost implements PowerUp {
    public void activate() {
        System.out.println("Strength increased! Attack power doubled!");
    }

    public void display() {
        System.out.println("A Strength Boost has been picked up!");
    }
}
