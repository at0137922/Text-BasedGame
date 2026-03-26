public class EnemyRepository {
// we make an object with our enmy data blue print instead of actual enmey 
    public static final EnemyData[] FOREST_ENEMIES = {
        new EnemyData("Wild Boar", 30, 6, "Tusks", 2),
        new EnemyData("Venomous Snake", 25, 5, "Poison Fang", 3),
        new EnemyData("Forest Bandit", 35, 7, "Dagger", 4),
        new EnemyData("Giant Wolf", 45, 9, "Fangs", 5)
    };

    public static final EnemyData[] CAVE_ENEMIES = {
        new EnemyData("Cave Bat", 20, 4, "Wings", 2),
        new EnemyData("Goblin", 40, 6, "Club", 4),
        new EnemyData("Cave Spider", 35, 7, "Venom Bite", 5),
        new EnemyData("Cave Troll", 70, 12, "Fists", 7)
    };

    public static final EnemyData[] BEACH_ENEMIES = {
        new EnemyData("Sand Crab", 25, 5, "Claws", 2),
        new EnemyData("Pirate", 40, 8, "Cutlass", 4),
        new EnemyData("Smuggler", 45, 9, "Pistol", 5),
        new EnemyData("Sea Serpent", 90, 15, "Bite & Tail", 8)
    };
}