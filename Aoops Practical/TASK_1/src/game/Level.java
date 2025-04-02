package game;

public class Level {
    private final int levelNumber;
    private final String description;

    public Level(int levelNumber, String description) {
        this.levelNumber = levelNumber;
        this.description = description;
    }

    public void startLevel() {
        System.out.println("Starting Level " + levelNumber + ": " + description);
    }
}
