package game;

public class MediumEnemyFactory extends EnemyFactory {
    public Enemy createEnemy() {
        return new Orc();
    }
}
