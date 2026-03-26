
import java.util.Random;

public class ShipwreckPuzzle implements PuzzleStrategy {
    private InputHandler input;
    private Random random;

    public ShipwreckPuzzle() {
        this.input = new InputHandler();
        this.random = new Random();
    }

    @Override
    public boolean puzzel_solver() {
        // Store messages in an array
        String[] puzzleMessages = {
                "You explore the shipwreck and find scattered materials from old cargo.",
                "You can try to craft a sword using the right combination of items.",
                "Choose 2 items to combine to forge a sword:"
        };
        BoxDrawing.printBox3(puzzleMessages);
        int maxAttempt = 2;
        for (int i = 0; i < maxAttempt; i++) {
            System.out.println("Options: 1) Rusty Blade  2) Leather Strap  3) Cloth");
            System.out.print("Enter first item number: ");
            int first = input.getInt();
            System.out.print("Enter second item number: ");
            int second = input.getInt();
            // Correct combination: Rusty Blade + Leather Strap → Makeshift Sword
            if ((first == 1 && second == 2) || (first == 2 && second == 1)) {
                return true;
            } else {
                System.out.println("These items cannot be combined to make a sword");
            }

        }
        return false;

    }

    public String getReward() {
        return "Makeshift Sword";
    }

}
