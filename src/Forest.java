import monsters.Vampire;

public class Forest extends BattleLocation {
    public Forest(Player player) {
        super(player, "Forest", "Here there are vampires. You may gain in there <firewood>"
                , new Vampire(), "Firewood",3,1);
    }
}
