import java.util.Random;

public  class Match {

    static Random rand1 =new Random();
    public static  String match(String spieler1, String spieler2){

        int a1,b1;
        int xa=0,xb=0, zaehler=0;


        do {
            int a=0, b=0;
            do {
                a1 = rand1.nextInt(50 );
                b1 = rand1.nextInt(50 );

                if (a1 > b1) {
                    a++;
                }
                else if (b1>a1) {
                    b++;
                }
            } while (a < 6 && b < 6);

            if(a==6) {
                xa++;
            }
            else if(b==6) {
                xb++;
            }
            zaehler++;
            System.out.println("Match " +zaehler+ ": " +a+ "-" +b+ "\t" +xa+ "-" +xb  );


        }while (xa<3 && xb<3);

        System.out.println();

        if(xa>xb) {
            System.out.println( spieler1 +" hat dieses Match gewonnen.\n");
            return spieler2;    // verlorene wird gelöscht
        }
        else{
            System.out.println( spieler2 +" hat dieses Match gewonnen.\n");
            return spieler1;    // verlorene wird gelöscht
        }
    }

}
