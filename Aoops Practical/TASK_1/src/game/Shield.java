package game;

public class Shield implements PowerUp {
    public void activate() {
        System.out.println("Shield activated! Damage reduced!");
    }

    public void display() {
        System.out.println("A Shield has been picked up!");
    }
}
