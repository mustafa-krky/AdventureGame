import java.util.Scanner;

public abstract class Location {
    private String name;
    private String info;
    private Player player;
    protected static Scanner input = new Scanner(System.in);

    public Location(String name, Player player, String info) {
        this.name = name;
        this.player = player;
        this.info = info;
    }

    public abstract boolean onLocation();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
