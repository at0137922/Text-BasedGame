public class LoadedGame {
    private Player player;
    private Enemy enemy;

    public LoadedGame(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public Player getPlayer() { return player; }
    public Enemy getEnemy() { return enemy; }
}