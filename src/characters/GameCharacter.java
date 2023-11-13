package characters;

public abstract class GameCharacter {
    private String name;
    private int damage;
    private int health;
    private int money;

    public GameCharacter(String name, int damage, int health, int money) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    public static void printCharInfo() {
        GameCharacter[] gameCharacters = {new Samurai(), new Knight(), new Archer()};

        System.out.println();
        System.out.println("---------------------> Characters <---------------------");

        for (int i = 0; i < gameCharacters.length; i++) {
            System.out.println((i + 1) + "-) " + gameCharacters[i].getName() + " -->\tDamage: " + gameCharacters[i].getDamage()
                    + "\tHealth: " + gameCharacters[i].getHealth() + "\tMoney: " + gameCharacters[i].getMoney());
        }
        System.out.println("--------------------------------------------------------");
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
