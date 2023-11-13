public class Inventory {
    private Weapons weapon;
    private Armors armor;
    private String[] awards;

    public Inventory(){
        this.weapon = new Weapons("Punch",0,0,0);
        this.armor = new Armors(0,"Rag",0,0);
        this.awards = new String[4];
        awards[0] = "";
        awards[1] = "";
        awards[2] = "";
        awards[3] = "";
    }

    public Weapons getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    public Armors getArmor() {
        return armor;
    }

    public void setArmor(Armors armor) {
        this.armor = armor;
    }

    public String[] getAwards() {
        return awards;
    }

    public void setAwards(String award, int idIndex) {
        this.awards[idIndex] = award;
    }
}
