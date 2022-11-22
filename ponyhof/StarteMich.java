package ponyhof;

import java.util.Random;

public class StarteMich {
    static Random zuf = new Random();
    static void parkOeffnen(){
        int anz = zuf.nextInt(101) + 150;
        for(int x = 0; x < anz; x++){
            int welcherbesucher = zuf.nextInt(5);
            switch(welcherbesucher){
                case 0: new Erwachsen(); break;
                case 1: new Kind1(); break;
                case 2: new Kind2(); break;
                case 3: new Rentner(); break;
                case 4: new Student(); break;
            }
        }
//        System.out.println(anz);
//        System.out.println(Besucher.dieBesucher.size());
    }
    public static void main(String[] args) {
        Enum_Hash.fuelleHashmap();
        Verzehr.fuelleListe();
        Attraktion.fuelleListe();
        parkOeffnen();
        Statistik.statistik();
    }
}