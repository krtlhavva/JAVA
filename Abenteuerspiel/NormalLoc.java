public abstract class NormalLoc extends Location {

    public NormalLoc(Player player, String name) {
        super(player);
        this.name=name;
    }
    public  boolean getLocation(){
        return true;
    }

}


class safeHaus extends NormalLoc{

    public safeHaus(Player player) {
        super(player, "safe Haus");
    }

    @Override
    public boolean getLocation() {
        player.setHealty(player.getReHealty());
        System.out.println("Sie sind wieder fit! Health ist aktuallisiert: " + player.getHealty());
        System.out.println("Gerade ist Ihr Standort: safe Haus");
        return true;
    }
}

