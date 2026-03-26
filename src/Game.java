public class Game {
    // AI -> Microsoft Copilot has been used to create this softeare pattern in the
    // game called Singleton pattern.It make sure that only one game instance is
    // exisit during game.

    private static Game instance;

    // we need to define Screen manger so that we can use it in our run game.
    private ScreenManger screen_manger;

    // we need to pass screen manger objec.
    public Game() {
        screen_manger = new ScreenManger();
    }

    // Singleton pattern
    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    // to run the game we need to use screen manager and show the mainMenu.
    public void run_game() {
        screen_manger.set_screen(new MainMenuScreen(this)); // Display the main menu when the game starts
        screen_manger.display_current_screen();
    }

    // another method that a game class should have is change screen so that the
    // screen can change.
    public void change_screen(Screen screen) {
        screen_manger.set_screen(screen);
        screen_manger.display_current_screen();
    }

    public void exit_game() {
        System.out.println("Goodbye!");
        System.exit(0);
    }

}