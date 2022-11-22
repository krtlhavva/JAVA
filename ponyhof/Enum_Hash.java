package ponyhof;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Enum_Hash {
     enum Attraktionen{
        PLANWAGEN("Planwagenfahrt", 7),
        PONY("Ponyreiten", 5),
        HUHN("Hühner füttern", 2),
        BROT("Brot backen", 5),
        ZOO("Streichelzoo", 3);
        private String bezeichnung;
        private int kosten;

        Attraktionen(String s, int i) {
            bezeichnung = s;
            kosten = i;
        }
        public int getKosten(){
            return kosten;
        }
        public String getBezeichnung() {
            return bezeichnung;
        }
     }

    enum Eintritt{
        ERWACHSEN("Erwachsene", 15),
        KIND1("Kinder (bis 7 Jahre)", 5),
        KIND2("Kinder (8 bis 13 Jahre)", 7),
        RENTNER("Rentner", 10),
        STUDENT("Studenten", 9);
        private String bezeichnung;
        private int kosten;
        Eintritt(String s, int i) {
            bezeichnung = s;
            kosten = i;
        }
        public int getKosten(){
            return kosten;
        }
        public String getBezeichnung() {
            return bezeichnung;
        }
    }

    static HashMap<String, String> essenTrinken;
    static void fuelleHashmap(){
        essenTrinken = new LinkedHashMap<>();
        essenTrinken.put("Wasser", "2");
        essenTrinken.put("Limo", "3");
        essenTrinken.put("Waffeln", "3");
        essenTrinken.put("Bratwurst", "2");
        essenTrinken.put("Salat", "6");
        essenTrinken.put("Currywurst", "4");
        essenTrinken.put("Pommes", "2");
        essenTrinken.put("Veganer Wrap", "5");
    }
}
