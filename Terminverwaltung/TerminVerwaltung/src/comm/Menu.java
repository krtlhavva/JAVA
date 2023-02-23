package comm;

import Controller.TerminController;
import Model.Termin;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private static String datum;
    private static String uhrzeit;
    private static String termin;
    private static String beschreibung;
    public static Scanner scanner = new Scanner(System.in);
    public static void showMenu() {
        int antwort = 0;
        boolean valid = false;
        String eingabe;

        do {
            System.out.println("Menu:");
            System.out.println("1. Einen Termin erstellen\n" +
                    "2. Termine anzeigen \n" +
                    "3. Das Programm beenden ");
            System.out.print("Bitte geben Sie die Nummer ihrer Auswahl ein: ");


            do {
                try {
                    antwort = Integer.parseInt(scanner.nextLine());
                    if (antwort >= 1 && antwort <= 3) {
                        valid = true;
                    } else {
                        throw new InputMismatchException();
                    }
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.print("Bitte geben Sie eine gültige Zahl zwischen 1 und 3 ein: ");
                    valid = false;
                }
            } while (!valid);

            switch (antwort) {
                case 1:
                    TerminController.insertTermin(datum, uhrzeit, termin, beschreibung);
                    break;
                case 2:
                    TerminController.selectTermin();
                    for (Termin t : Termin.liste) {
                        System.out.println(t);
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
            }

            System.out.print("Möchten Sie noch etwas tun? (j/n): ");
            eingabe = scanner.nextLine();

        } while (eingabe.equalsIgnoreCase("j"));
    }
}
