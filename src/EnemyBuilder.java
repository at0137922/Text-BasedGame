public class EnemyBuilder {

    private String enemyName;
    private int enemyHealth;
    private int enemyAttackPower;
    private String enemyWeapon;
    private int enemyLevel;

    public EnemyBuilder setEnemyName(String name) {
        this.enemyName = name;
        return this;
    }

    public EnemyBuilder setEnemyHealth(int health) {
        this.enemyHealth = health;
        return this;
    }

    public EnemyBuilder setEnemyAttackPower(int attackPower) {
        this.enemyAttackPower = attackPower;
        return this;
    }

    public EnemyBuilder setEnemyWeapon(String weapon) {
        this.enemyWeapon = weapon;
        return this;
    }

    public EnemyBuilder setEnemyLevel(int level) {
        this.enemyLevel = level;
        return this;
    }

    // build() creates an Enemy with all the fields. the type is Enemy class and we pass this seted fileds to constructor
    public Enemy build() {
        return new Enemy(enemyName, enemyHealth, enemyAttackPower, enemyWeapon, enemyLevel);
    }
}