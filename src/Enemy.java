public class Enemy {

    private String name;
    private int health;
    private int attackPower;
    private String weapon;
    private int level;

    public Enemy(String name, int health, int attackPower, String weapon, int level) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.weapon = weapon;
        this.level = level;
    }

    public String getEnemyName() {
        return name;
    }

    public int getEnemyHealth() {
        return health;
    }

    public int getEnemyAttackPower() {
        return attackPower;
    }

    public String getEnemyWeapon() {
        return weapon;
    }

    public int getEnemyLevel() {
        return level;
    }

    // a boolean method to check enemy is alive or not
    public boolean isAlive() {
        return health > 0;
    }

    public void takeEnemyDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }
}