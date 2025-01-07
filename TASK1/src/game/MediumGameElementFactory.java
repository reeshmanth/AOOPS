package game;

public class MediumGameElementFactory implements GameElementFactory {
    public Weapon createWeapon() {
        return new BowAndArrow();
    }

    public PowerUp createPowerUp() {
        return new Shield();
    }
}
