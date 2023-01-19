import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    private int damage, healty,reHealty, money;
    private String name, cName;
    private Inventory inventory;
    Scanner scanner= new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectCharacter(){
        switch (charMenü()){
            case 1:
                initPlayer("Samurai",5,21,15);
                break;
            case 2:
                initPlayer("Archer",7,18,20);
                break;
            case 3:
                initPlayer("Knight",8,21,5);
                break;
            default:
                initPlayer("Samurai",5,21,15);
                break;
        }
        System.out.println("Ihr Spieler wurde erzeugt");
        System.out.println("Spieler: " + getcName() + "\tDamage: " + getDamage()+ "\tHealty: " + getHealty() +"\tMoney: " + getMoney());

    }
    public void initPlayer(String name, int dmg, int hlty, int mny){
        setcName(name);
        setDamage(dmg);
        setHealty(hlty);
        setMoney(mny);
        setReHealty(hlty);
    }

    public int charMenü(){
        System.out.println("Bitte wählen Sie ein Spieler aus: ");
        System.out.println("1- Samurai \tDamage: 5 \tHealty: 21 \tMoney: 15 ");
        System.out.println("2- Archer \tDamage: 7 \tHealty: 18 \tMoney: 20 ");
        System.out.println("3- Knight \tDamage: 8 \tHealty: 21 \tMoney: 5 ");
        System.out.print("Ihre Auswahl: ");
        int charID = 0;
        boolean valid = false;
        do {
            try {
                charID = Integer.parseInt(scanner.nextLine());
                if (charID >= 1 && charID <= 3) {
                    valid = true;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Bitte geben Sie eine gültige Zahl zwischen 1 und 3 ein: ");
                valid = false;
            }
        } while (!valid);
        System.out.println();

        return charID;
    }

    public int getTotalDamage(){
        return this.getDamage() + this.getInventory().getDamage();
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealty() {
        return healty;
    }

    public void setHealty(int healty) {
        this.healty = healty;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }


    public int getReHealty() {
        return reHealty;
    }

    public void setReHealty(int reHealty) {
        this.reHealty = reHealty;
    }
}
