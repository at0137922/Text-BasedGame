public class HelpScreen implements Screen {
    private InputHandler input;
    // InputHandler input
    private Game game;

    public HelpScreen(Game game) {
        this.input = new InputHandler(); // creating an object form Input Handler class to avoid being null
        this.game = game;
    }

    public void show_screen() {
        System.out.println("\n=== HELP ===");
        String[] help_description = {
                "You are stranded on a mysterious island.",
                "Explore locations such as Forest, Cave, Beach, and Shipwreck.",
                "Solve puzzles to collect resources like Wood, Rope, and Metal.",
                "Goal: Collect 3 Wood, 2 Rope, and 2 Metal to craft a boat and escape.",
                "Dangerous enemies may appear while exploring.",
                "You may need to find and craft a weapon to defeat them.",
                "Makeshift Sword:",
                " - Collected at the Shipwreck.",
                " - Increases your attack power significantly.",
                " - Without it, your attacks are weak.",
                "Combat Tips:",
                " - Attack: Deal damage to enemies.",
                " - Defend: Reduce damage from enemy attacks.",
                " - Run: Escape from combat if necessary.",
                "Tip: Explore the Shipwreck early to get the sword.",
                "Tip: Use Defend strategically to survive tough enemies."
        };
        BoxDrawing.printBox2(help_description);
        System.out.println("\nPress Enter to return to main menu...");
        input.getString();
        game.change_screen(new MainMenuScreen(game)); // when user enter it directs to the main menu
    }
}
