import monsters.Monsters;
import java.util.Random;

public abstract class BattleLocation extends Location {
    private int id;
    private Monsters monster;
    private String award;
    private int maxMonsterNumber;
    private final int randomMonsterNum;
    private int randomHitNumber;

    public BattleLocation(Player player, String name, String info, Monsters monster, String award, int maxMonsterNumber, int id) {
        super(name, player, info);
        this.id = id;
        this.monster = monster;
        this.award = award;
        this.maxMonsterNumber = maxMonsterNumber;
        this.randomMonsterNum = this.randomMonsterNumber();
        this.randomHitNumber = this.randomHitNumber();
    }

    @Override
    public boolean onLocation() {

        System.out.println("Now, you in " + this.getName()
                + ", be careful ! Because here "
                + this.randomMonsterNum + " " + this.getMonster().getName() + definePluralSuffix() + " live");

        System.out.print("<F>ight or <E>scape: ");
        String select = input.next().toUpperCase();

        if (select.equals("F") && combat(randomMonsterNum)) {
            System.out.println("You killed the all monsters in here !");
            
            this.getPlayer().getInventory().setAwards(this.getAward(), this.getId());

            System.out.println("-> You won: "+this.getAward()+" <-");
            return true;
        }

        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("YOU DEAD, GAME OVER !");
            return false;
        }

        return true;
    }

    public boolean combat(int monsterNum) {

        printPlayerStats();
        enemyStats();

        for (int i = 1; i <= monsterNum; i++) {

            this.getMonster().setHealth(this.getMonster().getOriginalHealth());

            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {

                System.out.print("<H>it or <E>scape: ");
                String select = input.next().toUpperCase();

                if(!select.equals("H")){
                    return false;
                }
                hit();

            }

            if(this.getMonster().getHealth() <= 0){
                System.out.println("----------------------------------------------");
                System.out.println(i + ". " + this.getMonster().getName() + " died.");

                System.out.println("You gained " + this.getMonster().getReward() + " moneys");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getReward());
                System.out.println("Your current money: " + this.getPlayer().getMoney());
                System.out.println("----------------------------------------------");
            }

            if(this.getPlayer().getHealth() == 0){
                return false;
            }
        }

        return true;
    }

    public void afterHit() {
        System.out.println("Your health: " + this.getPlayer().getHealth());
        System.out.println("Enemy's health: " + this.getMonster().getHealth());
        System.out.println();
    }

    public void printPlayerStats() {
        System.out.println();
        System.out.println("----------* Player Stat *----------");
        System.out.println("Health: " + this.getPlayer().getHealth()
        +"| Weapon: " + this.getPlayer().getInventory().getWeapon().getName()
        +"| Damage: " + this.getPlayer().getTotalDamage()
        +"| Armor: " + this.getPlayer().getInventory().getArmor().getName()
        +"| Armor Strength: " + this.getPlayer().getInventory().getArmor().getBlock()
        +"| Money: " + this.getPlayer().getMoney());
    }

    public void enemyStats() {
        System.out.println("----------* Enemy Stat *----------");
        System.out.println("Health: " + this.getMonster().getHealth()
        +"| Damage: " + this.getMonster().getDamage()
        +"| Reward: " + this.getMonster().getReward());
        System.out.println();
    }

    public int randomMonsterNumber() {
        Random random = new Random();
        return random.nextInt(getMaxMonsterNumber()) + 1;
    }
    public int randomHitNumber(){
        Random random = new Random();
        return random.nextInt(2);
    }

    public void hit(){

        int monsDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();

        if (monsDamage < 0) {
            monsDamage = 0;
        }

        if(this.randomHitNumber == 0){

            System.out.println("!! CRASHH ! You hit to monster.");

            this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());

            if (this.getMonster().getHealth() > 0) {

                this.getPlayer().setHealth(this.getPlayer().getHealth() - monsDamage);
            }
            afterHit();

        }else if(this.randomHitNumber == 1){

            System.out.println("!!! AHHH ! The monster hit you.");

            if (this.getMonster().getHealth() > 0) {
                this.getPlayer().setHealth(this.getPlayer().getHealth() - monsDamage);
            }
            this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
            afterHit();
        }
    }

    public String definePluralSuffix() {
        if (this.randomMonsterNum == 1) {
            return "";
        } else {
            return "s";
        }
    }

    public Monsters getMonster() {
        return monster;
    }

    public void setMonster(Monsters monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonsterNumber() {
        return maxMonsterNumber;
    }

    public void setMaxMonsterNumber(int maxMonsterNumber) {
        this.maxMonsterNumber = maxMonsterNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
