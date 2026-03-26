public class BeachLocation extends Location {

    public BeachLocation() {
        super("Beach");
    }

    @Override
    public void search_into_location(Player player) {
        boolean solved = puzzle.puzzel_solver();
        String reward = puzzle.getReward();

        if (solved) {
            if (Math.random() < 0.65) {
                player.get_Inventory().add_item(reward);
                System.out.println(reward + " added to your inventory!");
            } else {
                System.out.println("But the Beach gives you no reward...");
            }
        } else {
            System.out.println("You failed the puzzle. No reward.");
        }
    }

    @Override
    public Enemy generateEnemy() {
        return EnemyFactory.createEnemy("Beach");
    }
}
