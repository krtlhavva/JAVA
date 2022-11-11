import java.util.ArrayList;
import java.util.Random;

public class Main {
    static Random random = new Random();
        public static String teams(ArrayList team1, ArrayList team2){

            String spieler1= (String) team1.get(random.nextInt(team1.size()));
            String spieler2= (String) team2.get(random.nextInt(team2.size()));

            System.out.println("Es treffen aufeinander: ");
            System.out.println("Spieler 1: "+spieler1+ "\nSpieler 2: "+spieler2);

            Match m= new Match();
            String spieler =m.match(spieler1, spieler2);

            return spieler;

        }


    public static void main(String[] args) {

        ArrayList team1= new ArrayList();
        ArrayList team2= new ArrayList();

        team1.add("Susi");
        team1.add("Hugo");
        team1.add("Fred");
        team1.add("Louisa");

        team2.add("Fritz");
        team2.add("Annemarie");
        team2.add("Carla");
        team2.add("Mira");

        String spieler;

        do {
            spieler=teams(team1, team2);

            if(team1.contains(spieler)) {
                team1.remove(spieler);
            }else {
                team2.remove(spieler);
            }
            System.out.println("Verbliebene spieler von Team-1: "+ team1);
            System.out.println("Verbliebene spieler von Team-2: "+ team2);
            System.out.println("------------------------------------------------------------------------");

        }while (team1.size() > 0 && team2.size() > 0);

        if(team1.size()==0) {

            System.out.println("Team 2 hat das Match gewonnen");
        }else if(team2.size()==0){
            System.out.println("Team 1 hat das Match gewonnen");
        }

        System.out.println("ENDE!");
    }
}