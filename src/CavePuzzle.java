
import java.util.Random;

public class CavePuzzle implements PuzzleStrategy {
    private InputHandler input;
    private Random random;

    public CavePuzzle() {
        this.input = new InputHandler();
        random = new Random();
    }

    public boolean puzzel_solver() {
        System.out.println("\nCave Puzzle!");
        // Store messages in an array
        String[] messages = {
                "You find an ancient lock inside the cave.",
                "Guess the correct number between 1 and 5.",
                "You have 3 attempts."
        };
        BoxDrawing.printBox2(messages);
        System.out.print("--> ");
        int correct_answeer = random.nextInt(5) + 1;// so the correct answer is between 1 - 5 its randomly
        int attempts = 3;
        for (int i = 0; i < attempts; i++) {
            System.out.print("Enter your guess: ");
            int guess = input.getInt();
            if (guess == correct_answeer) {
                System.out.println("Correct!");
                System.out.println("The lock opens!");

                return true;
            } else {
                System.out.println("Wrong Number");
            }
        }
        System.out.println("The cave lock remains closed.");
        return false;
    }

    @Override
    public String getReward() {
        return "Metal";
    }
}
