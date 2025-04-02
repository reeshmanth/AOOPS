package p1;

public class GameLevelManager {
    private static GameLevelManager instance;
    private String level;

    private GameLevelManager() {
        this.level = "Easy"; // Default level
    }

    public static GameLevelManager getInstance() {
        if (instance == null) {
            instance = new GameLevelManager();
        }
        return instance;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
