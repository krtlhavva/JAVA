package ponyhof;

import java.util.ArrayList;

public class Verzehr {
    static ArrayList<Verzehr> verzehrListe = new ArrayList<>();
    private int preis;
    private String bezeichnung;
    public Verzehr(int preis, String bezeichnung){
        this.preis = preis;
        this.bezeichnung = bezeichnung;
    }
    static void fuelleListe(){
        Object[] schluessel = Enum_Hash.essenTrinken.keySet().toArray();
        Object[] werte = Enum_Hash.essenTrinken.values().toArray();

        for(int index = 0; index < 8; index++){
            verzehrListe.add(new Verzehr(
                    Integer.parseInt(werte[index].toString()), schluessel[index].toString()));
        }
    }

    public int getPreis() {
        return preis;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }
}
