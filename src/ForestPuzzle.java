public class ForestPuzzle implements PuzzleStrategy {
    private InputHandler input;

    public ForestPuzzle() {
        input = new InputHandler(); // handles player input
    }

    @Override
    public boolean puzzel_solver() {

        System.out.println("\nForest Puzzle!");

        String[] puzzleText = {
                "You need wood to build a boat and escape the island.",
                "In the forest you find three types of wood:",
                "1. Soft Pine",
                "2. Rotten Driftwood",
                "3. Ironwood",
                "",
                "Riddle:",
                "I am strong, heavy, and survive the sea.",
                "Choose the best wood for your boat."
        };

        BoxDrawing.printBox2(puzzleText);
        System.out.print(">");
        String answer = input.getString().toLowerCase();

        if (answer.equalsIgnoreCase("ironwood")) {
            System.out.println("Correct!");
            return true;
        }

        System.out.println("Wrong!");
        return false;
    }

    @Override
    public String getReward() {
        return "Wood";
    }
}