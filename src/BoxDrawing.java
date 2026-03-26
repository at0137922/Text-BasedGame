public class BoxDrawing {
    // Method to print a box around an array of strings based on AI --> chatgpt
    public static void printBox(String[] lines) {
        int maxLength = 0;
        for (String line : lines) {
            if (line.length() > maxLength) {
                maxLength = line.length();
            }
        }

        String border = "+" + "-".repeat(maxLength + 2) + "+";
        System.out.println(border);
        for (String line : lines) {
            System.out.printf("| %-" + maxLength + "s |\n", line);
        }
        System.out.println(border);
    }

    public static void printBox2(String[] lines) {
        int maxLength = 0;
        for (String line : lines) {
            if (line.length() > maxLength) {
                maxLength = line.length();
            }
        }

        String border = "*" + "*".repeat(maxLength + 2) + "*";
        System.out.println(border);
        for (String line : lines) {
            System.out.printf("* %-" + maxLength + "s *\n", line);
        }
        System.out.println(border);
    }

    // draw a box for showing current location.
    public static void printBox3(String[] lines) {
        int maxLength = 0;
        for (String line : lines) {
            if (line.length() > maxLength) {
                maxLength = line.length();
            }
        }

        String border = "*" + "*".repeat(maxLength + 2) + "*";
        System.out.println(border);
        for (String line : lines) {
            System.out.printf("+ %-" + maxLength + "s +\n", line);
        }
        System.out.println(border);

    }
}
