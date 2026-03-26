public class ShipwreckLocation extends Location {

    public ShipwreckLocation() {
        super("Shipwreck");
    }

    @Override
    public void search_into_location(Player player) {
        String swordName = "Makeshift Sword";

        if (player.get_Inventory().hasItem(swordName)) {
            System.out.println("You already have the " + swordName +
                    ". You don't need to go back to the shipwreck.");
            return;
        }

        boolean solved = puzzle.puzzel_solver();
        String reward = puzzle.getReward();

        if (solved && reward != null) {
            player.get_Inventory().add_item(reward);
            System.out.println(reward + " added to your inventory!");
        } else {
            System.out.println("You failed the puzzle.");
        }

    }

    @Override
    public Enemy generateEnemy() {
        return null; // Shipwreck never has enemies
    }
}
