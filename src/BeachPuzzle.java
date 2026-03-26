
import java.util.Random;

public class BeachPuzzle implements PuzzleStrategy {
    private InputHandler input;
    private Random random;

    public BeachPuzzle() {
        this.input = new InputHandler();
        this.random = new Random();
    }

    @Override
    public boolean puzzel_solver() {

        System.out.println("\n Beach Puzzle!");
        String[] puzzleMessages = {
                "You see a treasure chest half-buried near the shore, but the waves are strong.",
                "You need to wait for the tide to go out to safely reach it.",
                "Choose the time to try: (1) Morning (2) Afternoon (3) Evening"
        };

        // Randomly pick the correct time (1-Morning, 2-Afternoon, 3-Evening)
        int correctTime = random.nextInt(3) + 1;
        BoxDrawing.printBox(puzzleMessages);
        int attemps = 3;
        for (int i = 0; i < attemps; i++) {
            System.out.print("Your choice: ");
            int answer = input.getInt();
            if (answer == correctTime) {
                System.out.println("Correct!");
                return true;
            } else {
                System.out.println("Oh no! The waves were too strong and the treasure is lost for now.");
            }

        }
        return false;
    }

    public String getReward() {
        return "Rope";
    }

}
