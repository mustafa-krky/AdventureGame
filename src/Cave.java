import monsters.Zombie;

public class Cave extends BattleLocation{
    public Cave(Player player){
        super(player,"Cave","Here there are zombies. You may gain in there <food>"
                ,new Zombie(),"Food",3,0);

    }
}
