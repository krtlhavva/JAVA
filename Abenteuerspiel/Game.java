import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scanner= new Scanner(System.in);
    public void login(){

        System.out.println("Herzlichen Wilkommen zu unserem Abenteuerspeiel!!! ");
        System.out.print("Bitte geben Sie Ihren Namen ein, bevor Sie das Speil starten:  ");
        String playerName= scanner.nextLine();

        player=new Player("playerName");

        player.selectCharacter();
        start();
    }
    public void start(){

        while(true){
            System.out.println();
            System.out.println("========================================");
            System.out.println();
            System.out.println("Bitte wählen Sie den angegebenen Ort aus: ");
            System.out.println("1- Safe Haus: Ein sicherer Ort für Sie, es gibt keine Feinde");
            System.out.println("2- Höhle: Sie können auf Zombies stoßen");
            System.out.println("3- Wald: Sie können auf Vampir stoßen");
            System.out.println("4- Fluss: Sie können auf Bär stoßen");
            System.out.println("5- Geschäft: Sie können Waffen oder Rüstungen kaufen");
            System.out.print("Ihre Auswahl: ");
            int selectLoc = 0;
            boolean valid = false;

            do {
                try {
                    selectLoc = Integer.parseInt(scanner.nextLine());
                    if (selectLoc >= 1 && selectLoc <= 5) {
                        valid = true;
                    } else {
                        throw new InputMismatchException();
                    }
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.print("Bitte geben Sie eine gültige Zahl zwischen 1 und 5 ein: ");
                    valid = false;
                }
            } while (!valid);

            switch (selectLoc) {
                case 1 -> location = new safeHaus(player);
                case 2 -> location = new Cave(player);
                case 3 -> location = new Forest(player);
                case 4 -> location = new River(player);
                case 5 -> location = new Toolstore(player);
                default -> location = new safeHaus(player);
            }

            if(location.getClass().getSimpleName().equalsIgnoreCase("safeHaus")){
                if(player.getInventory().isWater() && player.getInventory().isFirewood() && player.getInventory().isFood()){
                    System.out.println("Glückwunsch, Sie haben es geschafft! Sie haben alle Herausforderungen gemeistert und das Spiel gewonnen ");
                    break;
                }
            }
            if (!location.getLocation()) {
                System.out.print("Das Spiel hat beendet !");
                break;
            }
        }
    }
}
