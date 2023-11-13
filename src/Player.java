import characters.Archer;
import characters.GameCharacter;
import characters.Knight;
import characters.Samurai;
import java.util.Scanner;

public class Player {
    private String name;
    private String charName;
    private int damage;
    private int health;
    private int originalHealth;
    private int money;
    private Inventory inventory;
    private Scanner input = new Scanner(System.in);

    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
    }

    public void definePlayer(){
        System.out.print("Select a character: ");
        int selectNumber = input.nextInt();

        switch (selectNumber){
            case 1:
                equalPlayer(new Samurai());
                break;
            case 2:
                equalPlayer(new Knight());
                break;
            case 3:
                equalPlayer(new Archer());
                break;
            default:
                equalPlayer(new Samurai());
                System.out.println("Default character selected: "+this.getName());
        }

        System.out.println("The character selected: "+this.getName());
    }

    public void equalPlayer(GameCharacter gameCharacter){
        this.setName(gameCharacter.getName());
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setOriginalHealth(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
    }

    public void printInfo(){
        System.out.println(
                "< Weapon: "+this.getInventory().getWeapon().getName()
                +" | Armor: "+this.getInventory().getArmor().getName()
                +" | Damage: "+this.getTotalDamage()
                +" | Health: "+this.getHealth()
                +" | Money: "+this.getMoney()
                +" >"
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
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
        if(health < 0){
            health = 0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
