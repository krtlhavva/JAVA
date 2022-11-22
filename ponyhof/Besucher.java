package ponyhof;

import java.util.ArrayList;

public class Besucher {
    static ArrayList<Besucher> dieBesucher = new ArrayList<>();
    ArrayList<Attraktion> attraktionen = new ArrayList<>();
    ArrayList<Verzehr> verzehr = new ArrayList<>();
    private int preis;
    private String bezeichnung;
    protected Besucher(int preis, String bezeichnung){

        this.preis = preis;
        this.bezeichnung = bezeichnung;

        for(int i = 0; i < 3; i++) {
            int x = StarteMich.zuf.nextInt(5);
            this.attraktionen.add(Attraktion.attraktionsListe.get(x));
            //break;
        }

        int anzSpeisen = StarteMich.zuf.nextInt(3) + 2;
        for(int i = 0; i < anzSpeisen; i++) {
            int x = StarteMich.zuf.nextInt(8);
            this.verzehr.add(Verzehr.verzehrListe.get(x));
            //break;
        }
        dieBesucher.add(this);
    }

    public int getPreis() {
        return preis;
    }
    public String getBezeichnung() {
        return bezeichnung;
    }
}

class Erwachsen extends Besucher{
    public Erwachsen(){
        super(Enum_Hash.Eintritt.ERWACHSEN.getKosten(), Enum_Hash.Eintritt.ERWACHSEN.getBezeichnung());
    }
}

class Kind1 extends Besucher{
    public Kind1(){
        super(Enum_Hash.Eintritt.KIND1.getKosten(), Enum_Hash.Eintritt.KIND1.getBezeichnung());
        int wert = StarteMich.zuf.nextInt(2);
        if(wert == 1){
            new Erwachsen();
        } else{
            new Rentner();
        }
    }
}

class Kind2 extends Besucher{
    public Kind2(){
        super(Enum_Hash.Eintritt.KIND2.getKosten(), Enum_Hash.Eintritt.KIND2.getBezeichnung());
    }
}

class Rentner extends Besucher{
    public Rentner(){
        super(Enum_Hash.Eintritt.RENTNER.getKosten(), Enum_Hash.Eintritt.RENTNER.getBezeichnung());
    }
}

class Student extends Besucher{
    public Student(){
        super(Enum_Hash.Eintritt.STUDENT.getKosten(), Enum_Hash.Eintritt.STUDENT.getBezeichnung());
    }
}
