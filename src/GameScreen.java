public class GameScreen implements Screen, HealthObserver {
    private InputHandler input;
    private boolean is_running;
    private Player player;
    private Game game;
    private Enemy currentEnemy;
    private GameoverScreen gameOver;

    public GameScreen(Game game, Player player, Enemy enemy) {
        this.game = game;
        this.player = player; // use loaded player
        this.currentEnemy = enemy;
        this.input = new InputHandler();
        this.is_running = true;
        player.addHealthObserver(this);
        this.gameOver = gameOver;
        this.gameOver = new GameoverScreen(game, player);
    }

    public GameScreen(Game game) {
        this(game, new Player(), null);
    }

    @Override
    public void healthUpdate(int playerNewHealth) {
        System.out.println("Player Health Updated: " + playerNewHealth);
    }

    @Override
    public void show_screen() {
        String[] gameDescription = {
                "Game Started!",
                "You wake up stranded on an island....",
                "Goal: Collect 3 Wood, 2 Rope, 2 Metal to craft a boat and escape!",
                "The island is dangerous. You may need a weapon to survive."
        };
        BoxDrawing.printBox2(gameDescription);
        // used Ai gemeni to develop rendering system.
        // 1. Initial Welcome
        System.out.println("\n--- GAME START ---");

        // 2. Render Location immediately if loaded
        if (player.getPlayerLocation() != null) {
            System.out.println("\n[RESTORING SESSION]");
            Location savedLocation = LocationFactory.getLocationByName(player.getPlayerLocation());
            System.out.println("You are at the " + savedLocation.get_location_name());

            // This triggers the search/puzzle logic of that location immediately
            savedLocation.search_into_location(player);
        }

        // 3. Render Enemy Fight immediately if loaded
        if (currentEnemy != null && currentEnemy.getEnemyHealth() > 0) {
            System.out.println("\n WARNING: The " + currentEnemy.getEnemyName() + " is still here!");
            CombatingSystem.fight(player, currentEnemy);

            if (!player.is_Alive())
                return;

            if (currentEnemy.getEnemyHealth() <= 0) {
                currentEnemy = null; // Clear enemy after victory
            }
        }
        while (player.is_Alive() && is_running) {
            System.out.println("Current Health: " + player.get_health());
            game_Main_Menu();
            System.out.print("Choose option: ");
            int choice = input.getInt();
            choice_handler_game_menu(choice);
        }

        if (!player.is_Alive()) {
            gameOver.show_screen();
        }
    }

    private void game_Main_Menu() {
        String[] game_menu = {
                "1. Explore",
                "2. Rest",
                "3. View Inventory",
                "4. Craft Boat",
                "5. Save Game",
                "6. Return to Main Menu"
        };
        BoxDrawing.printBox(game_menu);
    }

    private void choice_handler_game_menu(int choice) {
        switch (choice) {
            case 1 -> explore();
            case 2 -> recover();
            case 3 -> player.get_Inventory().display_inventory();
            case 4 -> craft_boat();
            case 5 -> {
                System.out.print("Choose slot (1-3): ");
                int slotChoice = input.getInt();
                SaveManger.save_Game(player, slotChoice, currentEnemy);

            }
            case 6 -> is_running = false;
            default -> System.out.println("Invalid choice.");
        }
        System.out.println();
    }

    private void explore() {
        Location location = LocationFactory.getRandomLocation();
        System.out.println("\nYou travel to the " + location.get_location_name() + "...");
        // FIX: Save the player's new location// I used the co-piolt to fix the
        // problem and now location is saved in txtx file,
        player.setPlayerLocation(location.get_location_name());

        if (Math.random() < 0.6) {
            Enemy enemy = EnemyFactory.createEnemy(location.get_location_name());
            if (enemy != null) {
                // Store the enemy so the SaveManager can see it
                this.currentEnemy = enemy;
                System.out.println("An enemy appears! It's a " + enemy.getEnemyName() +
                        " (Level " + enemy.getEnemyLevel() + ")");
                CombatingSystem.fight(player, enemy);
                if (!player.is_Alive())
                    return;
                // If the enemy is defeated, clear it so we don't save a dead enemy
                if (enemy.getEnemyHealth() <= 0) {
                    this.currentEnemy = null;
                }
            } else {
                System.out.println("No enemies appear here.");
            }
        } else {
            System.out.println("No enemies appear here.");
        }

        location.search_into_location(player);
    }

    private void recover() {
        player.recover(10);
        System.out.println("You rest and recover 10 health.");
    }

    private void craft_boat() {
        if (player.get_Inventory().canCraftBoat()) {
            player.get_Inventory().craftBoat();
            System.out.println("You sail away and escape the island!");
            System.out.println("YOU WIN!");
            is_running = false;
        } else {
            System.out.println("You do not have enough materials.");
            System.out.println("Required: 3 Wood, 2 Rope, 2 Metal.");
        }
    }
}