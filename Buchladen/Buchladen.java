import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Buchladen{

     List<UpdateBuecher> buecher;

    public Buchladen(int anzahlBueher){
        buecher= new ArrayList<UpdateBuecher>();
        speichereBueher(anzahlBueher);
    }
    public void speichereBueher(int anzahlBueher){
        FunctionSummary fs= new FunctionSummary();

        for (int i=0; i< anzahlBueher; i++){
            buecher.add(fs.erstelleBuch(i)) ;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
       for (UpdateBuecher b: buecher){
           if(b instanceof Buch){
               Buch tmpBuch =(Buch) b;
               sb.append("\nId: \t").append(tmpBuch.id).
                       append("\nTitel: \t").append(tmpBuch.titel).
                       append("\nAutor: \t").append(tmpBuch.autor).
                       append("\nVerlag:\t").append(tmpBuch.verlag).
                       append("\nPreis: \t").append(tmpBuch.preis).
                       append("\n=====================================\n");
           }
       }
        return sb.toString();
    }

    class FunctionSummary {
        //In diesem Schritt der Funktionalität soll der Buchladen die Möglichkeit erhalten eine beliebige Anzahl an Bücher zu erstellen
       public final List<String> titel = Arrays.asList("Mimik", "Eine Frage der Chemie", "Zur See", "Einsame Nacht", "Nachmittage");
       public List<String> autoren = Arrays.asList("Sebastian Fitzek", "Bonnie Garmus", "Dörte Hansen", "Charlotte Link", "Ferdinand Schirach");
       public List<String> verlaege = Arrays.asList("Droemer", "Piper", "Zur See", "Penguin", "Luchterhand");
       public List<Double> preise = Arrays.asList(24.99, 22.98, 24.25, 25.19, 22.99);

       private int getRandom(){
           Random random=new Random();
           int max=5;
           int min=1;
           return random.nextInt(min,max);
       }

       // Hier werden zufällige Bücher generiert
       public Buch erstelleBuch(int id){
          return new Buch(id+1,
                  titel.get(getRandom()),
                  autoren.get(getRandom()),
                  verlaege.get(getRandom()),
                  preise.get(getRandom()));
       }
   }
   public void updateBuch(int welche, String name, Object wert){
        welche=welche-1;

       if( welche < buecher.size() && buecher.get(welche) instanceof Buch){
           Buch b= (Buch) buecher.get(welche);
           System.out.println("\t" + name + " wurde aktualisiert!\n***************************************");
           b.update(name, wert);
       }else{
           System.out.println("Fehler beim Update!");
       }
   }

    class Buch implements UpdateBuecher {
        int id;
        String titel;
        String autor;
        String verlag;
        double preis;

        public Buch (int id, String titel, String autor, String verlag, double preis) {
            this.id = id;
            this.titel = titel;
            this.autor = autor;
            this.verlag = verlag;
            this.preis = preis;
        }

        public double getPreis() {
            return preis;
        }

        public void setPreis(double preis) {
            this.preis = preis;
        }

        public int getId() {
            return id;
        }

        public String getTitel() {
            return titel;
        }

        public String getAutor() {
            return autor;
        }

        public String getVerlag() {
            return verlag;
        }

        @Override
        public void update(String name, Object wert) {
          switch (name.toLowerCase()){
              case "titel":
                  this.titel= (String) wert;
                  break;
              case "autor":
                  this.autor= (String) wert;
                  break;
              case "verlag":
                  this.verlag= (String) wert;
                  break;
              case "preis":
                  this.preis= (Double) wert;
                  break;
          }

        }

    }

}
