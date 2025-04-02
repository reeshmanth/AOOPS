package game;

import java.util.Scanner;

public class GameApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Game state setup
        GameState gameState = GameState.getInstance();
        System.out.print("Enter game difficulty (Easy, Medium, Hard): ");
        String difficulty = scanner.nextLine();
        gameState.setDifficulty(difficulty);
        gameState.displayState();

        // Enemy and Element factory selection based on difficulty
        EnemyFactory enemyFactory;
        GameElementFactory elementFactory;

        switch (gameState.getDifficulty()) {
            case "Easy" -> {
                enemyFactory = new EasyEnemyFactory();
                elementFactory = new EasyGameElementFactory();
            }
            case "Medium" -> {
                enemyFactory = new MediumEnemyFactory();
                elementFactory = new MediumGameElementFactory();
            }
            case "Hard" -> {
                enemyFactory = new HardEnemyFactory();
                elementFactory = new HardGameElementFactory();
            }
            default -> {
                enemyFactory = new EasyEnemyFactory();
                elementFactory = new EasyGameElementFactory();
            }
        }

        // Create and display the enemy, weapon, and power-up
        Enemy enemy = enemyFactory.createEnemy();
        enemy.display();
        enemy.attack();

        Weapon weapon = elementFactory.createWeapon();
        weapon.display();
        weapon.use();

        PowerUp powerUp = elementFactory.createPowerUp();
        powerUp.display();
        powerUp.activate();

        // Get level number and description from the user
        System.out.print("Enter the current level number: ");
        int levelNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter level description: ");
        String description = scanner.nextLine();

        Level level = new Level(levelNumber, description);
        level.startLevel();

        // Advance to the next level
        gameState.setCurrentLevel(levelNumber + 1);
        System.out.println("Advancing to Level: " + gameState.getCurrentLevel());

        // Exit the game after advancing
        System.out.println("Game Over. Thank you for playing!");
        System.exit(0);
    }
}
