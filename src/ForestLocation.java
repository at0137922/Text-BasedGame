public class ForestLocation extends Location {
    public ForestLocation() {
        super("Forest"); // Call the parent Location constructor to set the name of this location
    }

    public void search_into_location(Player player) {
        boolean solved = puzzle.puzzel_solver();
        String reward = puzzle.getReward();

        if (solved) {
            if (Math.random() < 0.8) {
                player.get_Inventory().add_item(reward);
                System.out.println(reward + " added to your inventory!");
            } else {
                System.out.println("But the forest gives you no reward...");
            }
        } else {
            System.out.println("You failed the puzzle. No reward.");
        }
    }

    public Enemy generateEnemy() {
        return EnemyFactory.createEnemy("Forest");
    }
}