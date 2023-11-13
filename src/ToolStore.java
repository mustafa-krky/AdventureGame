import java.util.Objects;

public class ToolStore extends NormalLocation {
    public ToolStore(Player player) {
        super("Tool Store", player, "Here you might buy a weapon or armor");
    }

    @Override
    public boolean onLocation() {
        String[] tools = {"Weapons", "Armors", "Exit"};

        System.out.println();
        System.out.println("* Welcome to Tool Store, " + this.getPlayer().getName());

        for(int i = 0; i < tools.length; i++){
            System.out.println((i+1)+"-) "+tools[i]);
        }

        System.out.print("Your choose: ");
        int select = input.nextInt();

        while(select < 1 || select > tools.length){
            System.out.print("Invalid selection, select again: ");
            select = input.nextInt();
        }

        switch (select){
            case 1:
                printWeapons();
                buyWeapon();
                break;
            case 2:
                printArmors();
                buyArmor();
                break;
            case 3:
                System.out.println("-> We hope you come again.");
                return true;

        }

        return true;
    }

    public void printWeapons(){
        System.out.println();
        System.out.println("-----------------------* Weapons *----------------------");
        for(Weapons w: Weapons.getWeapons()){
            System.out.println(w.getId()+"-) "+w.getName()+"\t<Price: "+w.getPrice()+" Damage: "+w.getDamage()+" >");
        }
        System.out.println("0-) Quit");
        System.out.println("--------------------------------------------------------");

    }

    public void buyWeapon(){

        System.out.print("Which weapon do you want to buy: ");
        int select = input.nextInt();

        while (select < 0 || select > Weapons.getWeapons().length){
            System.out.print("Invalid selection, select again: ");
            select = input.nextInt();
        }

        if(select == 0){
            onLocation();
        }

        Weapons selectedWeapon = Weapons.getWeaponByID(select);

        if(selectedWeapon != null){
            //We prevented him from getting the same weapon again.
            if(Objects.equals(selectedWeapon.getName(), this.getPlayer().getInventory().getWeapon().getName())){
                System.out.println("!!! You already have this weapon.");
                onLocation();
            }

            if(selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                System.out.println("!!! You don't have enough money.");
            }else {
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("You bought: "+selectedWeapon.getName()+" | Your current money: "+this.getPlayer().getMoney());

                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("--------------------------------------------------------");
            }
        }
    }

    public void printArmors(){
        System.out.println();
        System.out.println("-----------------------* Armors *----------------------");

        for(Armors a: Armors.getArmors()){
            System.out.println(a.getId()+"-) "+a.getName()+"\t<Price: "+a.getPrice()+" Armor Strength: "+a.getBlock()+" >");
        }

        System.out.println("0-) Quit");
        System.out.println("--------------------------------------------------------");

    }

    public void buyArmor(){
        System.out.print("Which armor do you want to buy: ");
        int select = input.nextInt();

        while (select < 0 || select > Weapons.getWeapons().length){
            System.out.print("Invalid selection, select again: ");
            select = input.nextInt();
        }

        if(select == 0){
            onLocation();
        }

        Armors selectedArmor = Armors.getArmorByID(select);

        if(selectedArmor != null){
            if(selectedArmor.getPrice() > this.getPlayer().getMoney()){
                System.out.println("!!! You don't have enough money.");
            }else {
                int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("You bought: "+selectedArmor.getName()+" | Your current money: "+this.getPlayer().getMoney());

                this.getPlayer().getInventory().setArmor(selectedArmor);

            }
        }
    }
}
