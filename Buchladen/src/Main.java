public class Main {
    public static void main(String[] args) {

       Buchladen b= new Buchladen(2);

       System.out.println(b.toString());

       b.updateBuch(2,"Titel","Nacht!");
       System.out.println(b.toString());

       b.updateBuch(1,"Preis",20.99);
       System.out.println(b.toString());

    }
}