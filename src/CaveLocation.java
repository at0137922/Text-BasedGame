public class CaveLocation extends Location {

    public CaveLocation() {
        super("Cave");
    }

    @Override
    public void search_into_location(Player player) {
        boolean solved = puzzle.puzzel_solver();
        String reward = puzzle.getReward();

        if (solved) {
            if (Math.random() < 0.7) {
                player.get_Inventory().add_item(reward);
                System.out.println(reward + " added to your inventory!");
            } else {
                System.out.println("But the Cave gives you no reward...");
            }
        } else {
            System.out.println("You failed the puzzle. No reward.");
        }
    }

    @Override
    public Enemy generateEnemy() {
        return EnemyFactory.createEnemy("Cave");
    }
}
