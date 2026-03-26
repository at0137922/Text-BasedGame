import java.util.Random;

public class LocationFactory {
    private static Random random = new Random();
    private static boolean first_Explore = true; // tracks the first exploration TO GIVE PRIORITY TO LOCATION OCCUR

    public static Location getRandomLocation() {
        if (first_Explore) {
            first_Explore = false;// mark that first explore has happened
        }
        // 50% chance to return Shipwreck on first explore
        if (Math.random() < 0.5) {
            return new ShipwreckLocation();
        }
        // // Normal random generation after first explore
        int choice = random.nextInt(4); // 0 to 3
        return switch (choice) {
            case 0 -> new ForestLocation();
            case 1 -> new CaveLocation();
            case 2 -> new BeachLocation();
            default -> new ShipwreckLocation();
        };
    }

    // "re-materialize" the location object from the saved string.
    public static Location getLocationByName(String name) {
        if (name == null)
            return new BeachLocation(); // Default fallback

        return switch (name) {
            case "Forest" -> new ForestLocation();
            case "Cave" -> new CaveLocation();
            case "Beach" -> new BeachLocation();
            case "Shipwreck" -> new ShipwreckLocation();
            default -> new BeachLocation();
        };
    }

}
