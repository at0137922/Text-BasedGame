import java.util.Scanner;

public class InputHandler {

    private Scanner scanner = new Scanner(System.in);

    public int getInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }

    public String getString() {
        return scanner.nextLine();
    }
}
