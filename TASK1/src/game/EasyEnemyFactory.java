package game;

public class EasyEnemyFactory extends EnemyFactory {
    public Enemy createEnemy() {
        return new Goblin();
    }
}
