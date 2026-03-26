
import java.util.ArrayList;

public class Player {
    // private Random random;
    private int bassAttack;
    // private int attackPower;
    private int health;
    private Inventory inventory;
    private String playerCurrentLocation;

    // healthObservers stores all classes that want to be
    // notified
    // when the player's health changes. Whenever health is updated,
    // these observers are automatically informed so they can react.
    private ArrayList<HealthObserver> healthObservers = new ArrayList<>();

    // here is no object to run therefore we must create a new object from inventory
    // class to avoid null exception,
    public Player() {
        this.bassAttack = 5;// player's base strength
        // this.attackPower = attackPower;
        this.health = 100;
        inventory = new Inventory();
        // random = new Random();
    }

    // this method add the classes that want to be notified when health is changing
    public void addHealthObserver(HealthObserver observer_health) {
        healthObservers.add(observer_health);
    }

    // // Notify all observers
    public void notifyHealthObserver() {
        for (HealthObserver observer_health : healthObservers) {
            observer_health.healthUpdate(health);
        }
    }

    public int getAttackPower() {
        // powerfull attack when it has weapon
        if (inventory.hasItem("Makeshift Sword")) {
            int damageVariation = (int) (Math.random() * 10) + 4; // a random numebr between 4 to 13
            return bassAttack + damageVariation; // RANDOM NUMBER + 5 WHICH IS BASE ATTACK;

        }
        // No weapon → return baseAttack (weak)
        return bassAttack;

    }

    public int get_health() {
        return health;
    }

    public void recover(int heal_amount) {
        health += heal_amount;
        if (health > 100) {
            health = 100;
            notifyHealthObserver();
        }
    }

    public Inventory get_Inventory() {
        return inventory;
    }

    public boolean is_Alive() {
        return health > 0;
    }

    public void takePlayerDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
            notifyHealthObserver();
        }
    }

    // player current location for saving
    public void setPlayerLocation(String location) {
        this.playerCurrentLocation = location;
    }

    public String getPlayerLocation() {
        return playerCurrentLocation;
    }

}