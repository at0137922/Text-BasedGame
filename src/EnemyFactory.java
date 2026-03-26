import java.util.Random;

public class EnemyFactory {
    // a random obejct to make enemy appear randomly
    private static final Random random = new Random();

    // create an object of enemy based on location which returns enemy obbject
    public static Enemy createEnemy(String locationName) {
        EnemyData[] enemies;
        switch (locationName) {
            case "Forest" -> enemies = EnemyRepository.FOREST_ENEMIES;
            case "Cave" -> enemies = EnemyRepository.CAVE_ENEMIES;
            case "Beach" -> enemies = EnemyRepository.BEACH_ENEMIES;
            case "Shipwreck" -> enemies = new EnemyData[0]; // no enemies here

            default -> throw new IllegalArgumentException("null");
        }
        // FIX: if there are no enemies (Shipwreck), return null
        if (enemies.length == 0) {
            return null;
        }
        // picking a random enemy.
        EnemyData random_Enemy = enemies[random.nextInt(enemies.length)];

        // here should return real Enemy objects that has been seted in the builder
        // class by using blue print data

        // It stores the stats an enemy should have: name, health, attack power, weapon,
        // level.
        // It doesn’t change during the game — it’s just a template.
        // When we want a live enemy in the game, you copy the stats from the blueprint
        // into a new Enemy object.
        return new EnemyBuilder()
                .setEnemyName(random_Enemy.getName()).setEnemyHealth(random_Enemy.getHealth())
                .setEnemyAttackPower(random_Enemy.getAttackPower()).setEnemyWeapon(random_Enemy.getWeapon())
                .setEnemyLevel(random_Enemy.getLevel()).build();

    }

}
