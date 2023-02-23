package Model;

import java.util.ArrayList;
import java.util.List;

public class Termin {
    public static List<Termin> liste= new ArrayList();
    private final int id;
    private String datum;
    private String uhrzeit;
    private  String termin;
    private  String beschreibung;

    public Termin(int id, String datum, String uhrzeit, String termin, String beschreibung) {
        this.id = id;
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.termin = termin;
        this.beschreibung = beschreibung;
        liste.add(this);
    }

    public String getDatum() {
        return datum;
    }

    public String getUhrzeit() {
        return uhrzeit;
    }

    public String getTermin() {
        return termin;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    @Override
    public String toString() {
        return
                "\n"+ id + ".Termin"+
                "\nDatum= " + datum  +
                "\tUhrzeit= " + uhrzeit +
                "\nTermin= " + termin  +
                "\nBeschreibung= " + beschreibung +
                "\n------------------------------------------";
    }
}
