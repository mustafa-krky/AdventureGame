package monsters;

import java.util.Random;

public class Monsters {
    private int id;
    private String name;
    private int damage;
    private int health;
    private int reward;
    private int originalHealth;

    public Monsters(int id, String name, int damage, int health, int reward) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.reward = reward;
        this.originalHealth = health;
    }

    public int randomDamage(){
        Random random = new Random();
        return random.nextInt(4) + 3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
