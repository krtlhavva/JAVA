import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    private static Drivable_Factory fabrik;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean validInput=false;

        do{
            System.out.print("Bitte wählen Sie eine Fortbewegungsmittel \n<A> für Airplane \n<C> für Car \nIhr Auswahl: ");
            String auswahl = sc.nextLine();
            String tmp = String.valueOf(auswahl.toUpperCase().trim().charAt(0));
            try {
                switch (tmp) {
                    case "A":
                        fabrik = new FertigungsstrasseAirplane();
                        validInput=true;
                        break;
                    case "C":
                        fabrik = new FertigungsstrasseCar();
                        validInput=true;
                        break;
                    default:
                        throw new NullPointerException();
                }
            } catch (NullPointerException ex) {
                System.out.println("Ihr Eingabe ist ungültig! Bitte erneut eingeben\n");
            }
        }while (!validInput);



        validInput=false;
        double reichweite = 0;
        do {
            System.out.print("Bitte geben Sie die Reichweite in Format ddd.dd: ");
            String input = sc.nextLine();
           try{

               if(input.matches("\\d{3}.\\d{2}")){
                   System.out.println("Eingegebene Zahl: " + input );
                   reichweite= Double.parseDouble(input);
                   validInput=true;
               }else{
                   throw new NullPointerException();
               }

           }catch (NullPointerException e){
               System.out.println("Die eingegebene Zahl ist ungültig! Bitte erneut eingeben");
           }

        } while (!validInput);

        Drivable drivable= fabrik.erzeugeFortbewegungsmittel();
        drivable.reichweiteAnpassen(reichweite);
        System.out.println(drivable);
    }
}

abstract class Drivable {
    public double reichweite;
    public abstract void reichweiteAnpassen(double reichweite);

    @Override
    public String toString() {
        return "Ihr Fortbewegungsmittel ist erzeugt --> Name: " + this.getClass().getSimpleName() + "\tReichweite: " + this.reichweite;
    }
}

class Airplane extends Drivable {

    @Override
    public void reichweiteAnpassen(double reichweite) {
        super.reichweite=reichweite;
    }

}
class Car extends Drivable {

    @Override
    public void reichweiteAnpassen(double reichweite) {
        super.reichweite=reichweite;
    }

}

abstract class Drivable_Factory{
    public abstract Drivable erzeugeFortbewegungsmittel();
}

class FertigungsstrasseAirplane extends Drivable_Factory{

    @Override
    public Drivable erzeugeFortbewegungsmittel() {
        return new Airplane();
    }
}

class FertigungsstrasseCar extends Drivable_Factory{

    @Override
    public Drivable erzeugeFortbewegungsmittel() {
        return new Car();
    }
}