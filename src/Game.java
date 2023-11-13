import characters.GameCharacter;
import java.util.Scanner;

public class Game {
    Scanner input = new Scanner(System.in);
    private Player player;
    private boolean gameKey;
    private String playerName;

    public void start() {
        System.out.println("Welcome to Adventure Game !");
        System.out.print("Enter player name: ");
        playerName = input.next();

        player = new Player(playerName);
        System.out.println("Hi! " + this.playerName + ". Welcome to this dark and foggy game ! " +
                "Everything that happens here is real !");

        GameCharacter.printCharInfo();
        player.definePlayer();

        Location location;

        gameKey = true;

        while (gameKey) {

            Location[] locations = {new SafeHouse(player), new ToolStore(player),
                    new Cave(player), new Forest(player), new River(player)};

            if (winController()) {
                gameKey = false;
                continue;
            }

            player.printInfo();

            System.out.println();
            System.out.println("-----------------------* Regions *----------------------");

            for (int i = 0; i < locations.length; i++) {
                System.out.println((i + 1) + "-) " + locations[i].getName() + ": " + locations[i].getInfo());
            }

            System.out.println("0-) Quit");
            System.out.println("--------------------------------------------------------");

            System.out.print("Select the region you want to go to: ");
            int selectLoc = input.nextInt();

            if (controlAward(selectLoc)) {
                continue;
            }

            switch (selectLoc) {

                case 0:
                    System.out.println("--> You left early this dark and foggy island :)");
                    gameKey = false;
                    continue;

                case 1:
                    location = new SafeHouse(player);
                    break;

                case 2:
                    location = new ToolStore(player);
                    break;

                case 3:
                    location = new Cave(player);
                    break;

                case 4:
                    location = new Forest(player);
                    break;

                case 5:
                    location = new River(player);
                    break;

                default:
                    location = new SafeHouse(player);
                    System.out.println("Selected default region: " + location.getName());
            }

            if (!location.onLocation()) {
                gameKey = false;
            }
        }

    }

    public boolean controlAward(int selectLoc) {

        for (String award : this.player.getInventory().getAwards()) {

            if (selectLoc == 3 && (award.equals("Food"))) {
                System.out.println("Already you had won <Food>, you can't go Cave again !");
                gameKey = true;
                return true;
            } else if (selectLoc == 4 && (award.equals("Firewood"))) {
                System.out.println("Already you had won <Firewood>, you can't go Forest again !");
                gameKey = true;
                return true;
            } else if (selectLoc == 5 && (award.equals("Water"))) {
                System.out.println("Already you had won <Water>, you can't go River again !");
                gameKey = true;
                return true;
            }
        }
        return false;
    }

    public boolean winController() {
        String[] award = this.player.getInventory().getAwards();

        if(award[0].equals("Food")
        && award[1].equals("Firewood")
        &&award[2].equals("Water")){
            System.out.println("You took all items and won game ! Congratulations, " + this.playerName);
            return true;
        }

        return false;
    }
}
