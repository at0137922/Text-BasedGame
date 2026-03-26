public class EnemyData {
    // Enemy Data is sample and buleprint. all changes will apply to the real enemy
    // which in this case is Enemy class
    private String name;
    private int health;
    private int attackPower;
    private String weapon;
    private int level;

    public EnemyData(String name, int health, int attackPower, String weapon, int level) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.weapon = weapon;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public String getWeapon() {
        return weapon;
    }

    public int getLevel() {
        return level;
    }
}