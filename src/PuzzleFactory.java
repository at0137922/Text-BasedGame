public class PuzzleFactory {
    public static PuzzleStrategy creat_puzzel(String locationName) {
        return switch (locationName) {
            case "Forest" -> new ForestPuzzle();
            case "Cave" -> new CavePuzzle();
            case "Beach" -> new BeachPuzzle();
            case "Shipwreck" -> new ShipwreckPuzzle();
            default -> throw new IllegalArgumentException("Unknown location: " + locationName);
        };
    }
}
