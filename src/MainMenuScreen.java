public class MainMenuScreen implements Screen {

    private InputHandler input;
    private Game game;

    public MainMenuScreen(Game game) {
        this.game = game;
        this.input = new InputHandler();
    }

    @Override
    public void show_screen() {

        while (true) {
            System.out.println("\n===== ESCAPE THE ISLAND =====");

            String[] menu = {
                    "1. Start New Game",
                    "2. Load Game",
                    "3. Help",
                    "4. Exit"
            };
            BoxDrawing.printBox(menu);
            System.out.print("Choose option: ");

            int choice = input.getInt();

            switch (choice) {
                case 1 -> game.change_screen(new GameScreen(game));
                case 2 -> {
                    System.out.print("Choose slot (1-3): ");
                    int slot = input.getInt();
                    LoadedGame loaded = SaveManger.loadedGame(slot);
                    if (loaded != null)
                        game.change_screen(new GameScreen(game, loaded.getPlayer(), loaded.getEnemy()));
                    else
                        System.out.println("No save in that slot.");
                }
                case 3 -> game.change_screen(new HelpScreen(game));
                case 4 -> game.exit_game();
                default -> System.out.println("Invalid option.");
            }
        }
    }
}