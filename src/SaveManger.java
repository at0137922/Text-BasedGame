import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Formatter;
import java.util.Map;

public class SaveManger {

    public static final int maxSaveSlot = 3;

    private static String getFileName(int slot) {
        File dir = new File("resources/Gamesaves");
        if (!dir.exists())
            dir.mkdirs();
        return "resources/Gamesaves/save" + slot + ".txt";
    }

    public static void save_Game(Player player, int slot, Enemy enemy) {
        try {
            Formatter output = new Formatter(getFileName(slot));

            // Save player data
            output.format("health=%d\n", player.get_health());
            output.format("location=%s\n", player.getPlayerLocation());

            // Save inventory items
            for (Map.Entry<String, Integer> entry : player.get_Inventory().getItems().entrySet()) {
                output.format("%s=%d\n", entry.getKey(), entry.getValue());
            }

            // 3. Save Enemy (Only if one exists and is alive)
            if (enemy != null && enemy.getEnemyHealth() > 0) {
                output.format("enemy=%s,%d,%d,%s,%d\n",
                        enemy.getEnemyName(),
                        enemy.getEnemyHealth(),
                        enemy.getEnemyAttackPower(),
                        enemy.getEnemyWeapon(),
                        enemy.getEnemyLevel());
            }

            System.out.println("Game saved successfully in slot " + slot);
            output.close();

        } catch (Exception e) {
            System.out.println("Save failed: " + e.getMessage());
        }
    }

    public static boolean saveExists(int slot) {
        return new File(getFileName(slot)).exists();
    }

    public static String getSavedLocation(int slot) {
        try (BufferedReader reader = new BufferedReader(new FileReader(getFileName(slot)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("location=")) {
                    return line.split("=")[1];
                }
            }
        } catch (IOException ignored) {
        }
        return "Unknown";
    }

    public static LoadedGame loadedGame(int slot) {
        File file = new File(getFileName(slot));
        if (!file.exists())
            return null; // Added check to prevent "No save" error

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Player player = new Player();
            Enemy enemy = null;
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.contains("="))
                    continue;

                String[] parts = line.split("=", 2);
                String key = parts[0].trim();
                String value = parts[1].trim();

                switch (key) {
                    case "health" -> {
                        int savedHealth = Integer.parseInt(value);
                        player.takePlayerDamage(player.get_health() - savedHealth);
                    }
                    case "location" -> player.setPlayerLocation(value);
                    case "enemy" -> {
                        String[] e = value.split(",");
                        // We expect exactly 5 pieces of data
                        if (e.length == 5) {
                            enemy = new Enemy(e[0], Integer.parseInt(e[1]),
                                    Integer.parseInt(e[2]), e[3],
                                    Integer.parseInt(e[4]));
                        }
                    }
                    default -> {
                        // This handles inventory items: Wood=4, Metal=2, etc.
                        try {
                            int amount = Integer.parseInt(value);
                            for (int i = 0; i < amount; i++) {
                                player.get_Inventory().add_item(key);
                            }
                        } catch (NumberFormatException nfe) {
                            // Not an inventory item, ignore
                        }
                    }
                }
            }
            return new LoadedGame(player, enemy);
        } catch (Exception e) {
            e.printStackTrace(); //  see errors in the console
            return null;
        }
    }
}