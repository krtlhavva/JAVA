public abstract class BattleLoc extends Location{
     Obstacle obstacle;
     protected String award;

    public BattleLoc(Player player, String name, Obstacle obstacle,String award) {
        super(player);
        this.name=name;
        this.obstacle=obstacle;
        this.award=award;
    }

    public boolean getLocation(){
        int obsCount= obstacle.count();
        System.out.println("Ihre aktuelle Position: " + this.getName());
        System.out.println("Vorsichtig ! " + obsCount + " " + obstacle.getName() + " leben hier !");
        System.out.print("<K>ampf oder <F>lug: ");
        String selectCase =scanner.nextLine();

        if(selectCase.equalsIgnoreCase("K")){
            if(combat(obsCount)){
                System.out.println("In der Region "+this.getName() + " haben Sie alle Gegner getötet!");
                if(this.award.equals("Essen") && !player.getInventory().isFood()){
                    System.out.println("Sie haben " + this.award + " gewonnen");
                    player.getInventory().setFood(true);
                }else if(this.award.equals("Wasser") && !player.getInventory().isWater()){
                    System.out.println("Sie haben " + this.award + " gewonnen");
                    player.getInventory().setWater(true);
                }else if(this.award.equals("Brennholz") && !player.getInventory().isFirewood()){
                    System.out.println("Sie haben " + this.award + " gewonnen!!!");
                    player.getInventory().setFirewood(true);
                }
                return true;
            }if(player.getHealty()<=0){
                System.out.println("Sie haben leider verloren! Versuchen Sie bitte noch einmal");
                return false;
            }
        }
        return true;
    }

    public boolean combat (int obsCount){
        for(int i=0; i<obsCount; i++){
            int defaultObsHealth = obstacle.getHealth();
            playerStatus();
            enemyStatus();
            while (player.getHealty()>0 && obstacle.getHealth()>0){
                System.out.print("<A>ngreifen oder <F>lüchten: ");
                String selectCase = scanner.nextLine();
                if (selectCase.equalsIgnoreCase("A")){
                    System.out.println("\nSie haben den Gegner attackiert!");
                    obstacle.setHealth(obstacle.getHealth()-player.getTotalDamage());

                    System.out.println("Health von Spieler: " + player.getHealty());
                    System.out.println("Health von "+ (i+1) +". "+ obstacle.getName()+ ": "+ obstacle.getHealth());
                    System.out.println();

                    if(obstacle.getHealth()>0) {
                        System.out.println("\nEin Angriff des Gegners hat Sie getroffen");
                        player.setHealty(player.getHealty() - (obstacle.getDamage() - player.getInventory().getArmor()));
                        afterHit();
                    }
                }else{
                    return false;
                }
            }
            if(obstacle.getHealth()<=0 && player.getHealty() >0){
                System.out.println("Sie haben geschafft!! Ihr Gewinn: " + obstacle.getAward());
                player.setMoney(player.getMoney()+obstacle.getAward());
                System.out.println("Ihr Guthaben ist aktuallisiert: " + player.getMoney());
                obstacle.setHealth(defaultObsHealth);
            }else{
                return false;
            }
            System.out.println("-------------------------------------");
        }
        return true;
    }
    public void afterHit(){

    }

    private void playerStatus() {
        System.out.println("Die Werte von Spieler\n-------------------------------------");
        System.out.println("Health: "+ player.getHealty());
        System.out.println("Money: "+ player.getMoney());
        System.out.println("Damage: "+ player.getTotalDamage());
        if(player.getInventory().getDamage()>0){
            System.out.println("Waffe: "+ player.getInventory().getwName());
        }
        if(player.getInventory().getArmor()>0){
            System.out.println("Rüstung: "+ player.getInventory().getaName());
        }
    }

    private void enemyStatus() {
        System.out.println("\nDie Werte von " + obstacle.getName() + "\n-------------------------------------");
        System.out.println("Health: " + obstacle.getHealth());
        System.out.println("Damage: " + obstacle.getDamage());
        System.out.println("Award: " + obstacle.getAward());
    }
}

class Forest extends BattleLoc{
    public Forest(Player player) {
        super(player, "Wald", new Vampir(), "Brennholz");
    }
}

class River extends BattleLoc{
    public River(Player player) {
        super(player, "Fluss",new Bear(),"Wasser" );
    }
}

class Cave extends BattleLoc{
    public Cave(Player player) {
        super(player, "Höhle",new Zombie(),"Essen");
    }
}