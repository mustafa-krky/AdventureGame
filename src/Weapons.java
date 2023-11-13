public class Weapons {
    private String name;
    private int id;
    private int price;
    private int damage;

    public Weapons(String name, int id, int price, int damage) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.damage = damage;
    }

    public static Weapons[] getWeapons(){
        Weapons[] weaponList = new Weapons[3];
        weaponList[0] = new Weapons("Pistol",1,15,2);
        weaponList[1] = new Weapons("Sword",2,35,3);
        weaponList[2] = new Weapons("Rifle",3,45,7);

        return weaponList;
    }

    public static Weapons getWeaponByID(int id){

        for(Weapons w: Weapons.getWeapons()){

            if(w.getId() == id){
                return w;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
