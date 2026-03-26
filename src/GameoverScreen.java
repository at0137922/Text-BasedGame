public class GameoverScreen implements Screen {
    private Game game;
    private InputHandler input;
    private Player player;

    public GameoverScreen(Game game, Player player) {
        this.game = game;
        this.player = player;
        this.input = new InputHandler();
    }

    @Override
    public void show_screen() {
        String[] deathMessage = {
                "GAME OVER",
                "The island has claimed another soul.",
                "Location of Death: " + (player.getPlayerLocation() != null ? player.getPlayerLocation() : "Unknown"),
                "Health: 0"
        };
        BoxDrawing.printBox2(deathMessage);

        boolean staying_in_game = true;
        while (staying_in_game) {
            String[] options = {
                    "1. Try Again (New Game)",
                    "2. Exit to Main Menu"
            };
            BoxDrawing.printBox(options);
            System.out.print("What is your choice? ");

            int choice = input.getInt();
            switch (choice) {
                case 1 -> {
                    game.change_screen(new GameScreen(game));
                    staying_in_game = false;
                }
                case 2 -> {
                    game.change_screen(new MainMenuScreen(game));
                    staying_in_game = false;
                }
                default -> System.out.println("Invalid choice.");
            }

        }
    }

}