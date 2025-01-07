package game;

public class HardEnemyFactory extends EnemyFactory {
    public Enemy createEnemy() {
        return new Dragon();
    }
}
