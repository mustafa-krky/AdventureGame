public class SafeHouse extends NormalLocation{
    public SafeHouse(Player player){
        super("Safe House",player,"Here your health renew");
    }

    @Override
    public boolean onLocation(){
        System.out.println("You are in the Safe House and your health renewed");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        return true;
    }
}
