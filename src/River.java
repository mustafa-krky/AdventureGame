import monsters.Bear;

public class River extends BattleLocation{
    public River(Player player){
        super(player,"River","Here there are bears. You may gain in there <water>"
                ,new Bear(),"Water",2,2);
    }
}
