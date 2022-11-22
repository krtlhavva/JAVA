package ponyhof;

import java.util.Arrays;
import java.util.Set;

public class Statistik {
    private static int[] eintrittBesucherArr = new int[Enum_Hash.Eintritt.values().length];
    private static int[] anzahlBesucherArr = new int[Enum_Hash.Eintritt.values().length];
    private static int[] kostenAttraktionArr = new int[Attraktion.attraktionsListe.size()];
    private static int[] anzahlAttraktionArr = new int[Attraktion.attraktionsListe.size()];
    private static int[] kostenVerzehrArr = new int[Verzehr.verzehrListe.size()];
    private static int[] anzahlVerzehrArr = new int[Verzehr.verzehrListe.size()];
    static void statistik() {
        Object[] essenTrinkenSchluessel = Enum_Hash.essenTrinken.keySet().toArray();
        Object[] essenTrinkenWerte = Enum_Hash.essenTrinken.values().toArray();
        Enum_Hash.Eintritt[] eintrittArr = Enum_Hash.Eintritt.values();
        Enum_Hash.Attraktionen[] attraktionenArr = Enum_Hash.Attraktionen.values();
        for (Besucher b : Besucher.dieBesucher) {
            for (Attraktion a : b.attraktionen) {
                String name = a.getBezeichnung();
                for(int index = 0; index < 5; index++){
                    if (name.equals(attraktionenArr[index].getBezeichnung())) {
                        kostenAttraktionArr[index] = kostenAttraktionArr[index] + a.getPreis();
                        anzahlAttraktionArr[index]++;
                    }
                }
            }

            for (Verzehr v : b.verzehr) {
                String name = v.getBezeichnung();
                for (int index = 0; index < 8; index++) {
                    if (name.equals(essenTrinkenSchluessel[index].toString())) {
                        kostenVerzehrArr[index] = kostenVerzehrArr[index] + Integer.parseInt(essenTrinkenWerte[index].toString());
                        anzahlVerzehrArr[index]++;
                        break;
                    }
                }
            }

            switch (b.getClass().getSimpleName()) {
                case "Erwachsen":
                    eintrittBesucherArr[0] += b.getPreis();
                    anzahlBesucherArr[0]++;
                    break;
                case "Kind1":
                    eintrittBesucherArr[1] += b.getPreis();
                    anzahlBesucherArr[1]++;
                    break;
                case "Kind2":
                    eintrittBesucherArr[2] += b.getPreis();
                    anzahlBesucherArr[2]++;
                    break;
                case "Rentner":
                    eintrittBesucherArr[3] += b.getPreis();
                    anzahlBesucherArr[3]++;
                    break;
                case "Student":
                    eintrittBesucherArr[4] += b.getPreis();
                    anzahlBesucherArr[4]++;
                    break;
            }
        }
        System.out.println("Tagesbilanz");
        System.out.println("===========\n");
        System.out.println("Heute besuchten " + Besucher.dieBesucher.size() + " Gäste den Ponyhof\n");

        for(int index = 0; index < 5; index++){
            System.out.println(anzahlBesucherArr[index] + " " + eintrittArr[index].getBezeichnung()
                    + " haben " + eintrittBesucherArr[index] + " Euro Eintritt bezahlt");
        }
        System.out.println("\nEintritt gesamt: " + Arrays.stream(eintrittBesucherArr).sum() + " Euro\n");
        System.out.println("---------------------------------------------------------\n");

        for(int index = 0; index < 5; index++){
            System.out.println(anzahlAttraktionArr[index] + " X " + attraktionenArr[index].getBezeichnung()
                    + " haben " + kostenAttraktionArr[index] + " Euro eingebracht");
        }
        System.out.println("\nAttraktionen gesamt: " + Arrays.stream(kostenAttraktionArr).sum() + " Euro\n");
        System.out.println("---------------------------------------------------------\n");

        for (int index = 0; index < 8; index++){
            System.out.println(anzahlVerzehrArr[index] + " X " + essenTrinkenSchluessel[index].toString()
                    + " haben " + kostenVerzehrArr[index] + " Euro eingebracht");
        }
        System.out.println("\nVerzehr gesamt: " + Arrays.stream(kostenVerzehrArr).sum() + " Euro\n");
        System.out.println("---------------------------------------------------------\n");

        System.out.println("Gesamteinnahmen: " + (Arrays.stream(eintrittBesucherArr).sum() +
                                                 Arrays.stream(kostenAttraktionArr).sum() +
                                                 Arrays.stream(kostenVerzehrArr).sum()) + " Euro");
    }
}
