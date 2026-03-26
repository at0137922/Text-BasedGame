
import java.util.Random;

public class CombatingSystem {
    private static InputHandler input = new InputHandler();
    private static Random random = new Random();
    boolean fightOngoing = true;

    // public CombatingSystem() {
    // this.input = new InputHandler();
    // this.random = new Random();
    // }

    // there is fight function which is between player and enemy
    public static void fight(Player player, Enemy enemy) {
        Random random = new Random();
        boolean fightOngoing = true;

        String[] combatOptions = { "1. Attack", "2. Defend", "3. Run" };

        while (player.is_Alive() && enemy.isAlive() && fightOngoing) {
            System.out.println(
                    "\nYour Health: " + player.get_health() +
                            " | " + enemy.getEnemyName() + " Health: " + enemy.getEnemyHealth());

            BoxDrawing.printBox3(combatOptions);
            System.out.print("Choose an action: ");
            int action = input.getInt();

            // **pass random object to fix escape chance**
            fightOngoing = actionHandler(action, player, enemy, random);
        }

        if (!enemy.isAlive()) {
            System.out.println("You defeated the " + enemy.getEnemyName() + "!");
        }

        if (!player.is_Alive()) {
            System.out.println("You were defeated...");
        }
    }

    public static boolean actionHandler(int action, Player player, Enemy enemy, Random random) {
        switch (action) {
            // Attack
            case 1:
                int player_attack_value = player.getAttackPower();// get attack value and store in a varaible
                enemy.takeEnemyDamage(player_attack_value);// enemy loses health when palyer damages him

                if (player.get_Inventory().hasItem("Makeshift Sword")) {
                    System.out.println("You attack the " + enemy.getEnemyName() + " with your sword!");
                } else {
                    String[] noWeaponMessages = {
                            "You try to fight with your bare hands...",
                            "But without a weapon, your attacks are weak.",
                            "Maybe you should find a sword first."
                    };
                    BoxDrawing.printBox2(noWeaponMessages);
                    System.out.println(
                            "You deal " + player_attack_value + " damage to the " + enemy.getEnemyName() + "!");

                }

                if (enemy.isAlive()) {
                    player.takePlayerDamage(enemy.getEnemyAttackPower());
                    System.out.println(enemy.getEnemyName() + " attacks you!");
                }
                return true;

            // Defend
            case 2:
                System.out.println("You brace yourself to defend!");
                int reducedDamage = enemy.getEnemyAttackPower() / 2;
                player.takePlayerDamage(reducedDamage);
                System.out.println(enemy.getEnemyName() + " attacks! You take only " + reducedDamage + " damage.");
                return true;

            // Run / Escape
            case 3:
                System.out.println("You try to escape the battle...");
                int escapeChance = random.nextInt(100); // 0-99
                if (escapeChance < 70) { // 70% chance to escape
                    System.out.println("You successfully ran away!");
                    return false; // **this will stop the loop**
                } else {
                    System.out.println("You failed to escape!");
                    player.takePlayerDamage(enemy.getEnemyAttackPower());
                    System.out.println(enemy.getEnemyName() + " attacks you while you try to escape!");
                    return true;
                }

            default:
                System.out.println("Invalid action.");
                return true;
        }
    }

}
