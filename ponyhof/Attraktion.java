package ponyhof;

import java.util.ArrayList;

public class Attraktion {
    static ArrayList<Attraktion> attraktionsListe = new ArrayList<>();
    private int preis;
    private String bezeichnung;
    public Attraktion(int preis, String bezeichnung){
        this.preis = preis;
        this.bezeichnung = bezeichnung;
    }
    static void fuelleListe(){
        Enum_Hash.Attraktionen[] attraktionenArr = Enum_Hash.Attraktionen.values();
        for(int index = 0; index < 5; index++){
            attraktionsListe.add(new Attraktion(attraktionenArr[index].getKosten(),
                    attraktionenArr[index].getBezeichnung()));
        }
    }

    public int getPreis() {
        return preis;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }
}
