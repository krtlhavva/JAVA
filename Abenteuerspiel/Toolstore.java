import java.util.InputMismatchException;

public class Toolstore extends NormalLoc {


    public Toolstore(Player player) {
        super(player, "Geschäft");
    }

    @Override
    public boolean getLocation() {
        System.out.println("1- Waffen");
        System.out.println("2- Rüstung");
        System.out.println("3- Exit");
        System.out.print("Ihre Auswahl: ");
        int selectTool = 0;
        boolean valid = false;
        do {
            try {
                selectTool = Integer.parseInt(scanner.nextLine());
                if (selectTool >= 1 && selectTool <= 3) {
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

        int itemId;
        switch (selectTool) {
            case 1:
                itemId = weaponMenu();
                buyWeapon(itemId);
                break;
            case 2:
                itemId = armorMenu();
                buyArmor(itemId);
                break;
        }
        return true;
    }


    private int weaponMenu() {
        System.out.println("Ihres aktuelle Guthaben:  " + player.getMoney());
        System.out.println("1- Pistole \t<Preis: 15  Damage: 2>");
        System.out.println("2- Schwert \t<Preis: 35  Damage: 3>");
        System.out.println("3- Gewehr \t<Preis: 45  Damage: 7>");
        System.out.println("4- Exit");
        System.out.print("Ihre Auswahl: ");
        int weaponId = 0;
        boolean valid = false;
        do {
            try {
                weaponId = Integer.parseInt(scanner.nextLine());
                if (weaponId >= 1 && weaponId <= 4) {
                    valid = true;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Bitte geben Sie eine gültige Zahl zwischen 1 und 4 ein: ");
                valid = false;
            }
        } while (!valid);

        System.out.println();

        return weaponId;
    }

    private void buyWeapon(int itemId) {
        int damage = 0;
        int price = 0;
        String wName = null;
        switch (itemId) {
            case 1:
                damage = 2;
                wName = "Pistole";
                price = 15;
                break;
            case 2:
                damage = 3;
                wName = "Schwert";
                price = 35;
                break;
            case 3:
                damage = 7;
                wName = "Gewehr";
                price = 45;
                break;
            case 4:
                System.out.println("Exit wird ausgeführt!");
                break;
            default:
                System.out.println("Ungültige Nummer !");
        }
        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInventory().setDamage(damage);
                player.getInventory().setwName(wName);
                player.setMoney(player.getMoney() - price);
                System.out.println(wName + " haben Sie gekauft!, Damage ist als < " + player.getTotalDamage() + " > aktualisiert!");
                System.out.println("Ihres aktuelle Guthaben: " + player.getMoney());
            } else {
                System.out.println("Ihr Guthaben ist nicht genug !");
            }
        }

    }

    private int armorMenu() {
        System.out.println("Ihres aktuelle Guthaben:  " + player.getMoney());
        System.out.println("1- Leicht \t<Preis: 15  Verteidigung: 1>");
        System.out.println("2- Mittel \t<Preis: 25  Verteidigung: 3>");
        System.out.println("3- Schwer \t<Preis: 40  Verteidigung: 5>");
        System.out.println("4- Exit");
        System.out.print("Ihre Auswahl: ");
        int armorId = 0;
        boolean valid = false;
        do {
            try {
                armorId = Integer.parseInt(scanner.nextLine());
                if (armorId >= 1 && armorId <= 4) {
                    valid = true;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Bitte geben Sie eine gültige Zahl zwischen 1 und 4 ein: ");
                valid = false;
            }
        } while (!valid);
        System.out.println();
        return armorId;
    }
    private void buyArmor(int itemId) {
        String aName=null;
        int price=0;
        int avoid=0;
        switch (itemId){
            case 1:
                aName="Leicht";
                price=15;
                avoid=1;
                break;
            case 2:
                aName="Mittel";
                price=25;
                avoid=3;
                break;
            case 3:
                aName="Schwer";
                price=40;
                avoid=5;
                break;
            case 4:
                System.out.println("Exit wird ausgeführt!");
            default:
                System.out.println("Ungültige Nummer !");
        }
        if(price>0){
            if (player.getMoney()>=price){
                player.setMoney(player.getMoney()-price);
                player.getInventory().setArmor(avoid);
                player.getInventory().setaName(aName);
                System.out.println(aName+"e Rüstung haben Sie gekauft! Verteidigung ist als < " + player.getInventory().getArmor() + " > aktualisiert!" );
                System.out.println("Ihres aktuelle Guthaben: " + player.getMoney());
            } else {
                System.out.println("Ihr Guthaben ist nicht genug !");
            }
            }
        }
    }

