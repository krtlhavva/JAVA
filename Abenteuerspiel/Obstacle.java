import java.util.Random;

public class Obstacle {
    private String name;
    private int damage;
    private int award;
    private int health;
    private int maxQuantity;


    public Obstacle(String name, int damage, int award, int health, int maxQuantity) {
        this.name = name;
        this.damage = damage;
        this.award = award;
        this.health = health;
        this.maxQuantity = maxQuantity;
    }
    public int count(){
        Random random=new Random();
        return random.nextInt(maxQuantity)+1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }
}

class Vampir extends Obstacle{

    public Vampir() {
        super("Vampir", 4, 7, 14, 3);
    }
}

class Zombie extends Obstacle{

    public Zombie() {
        super("Zombie", 3, 4, 10, 3);
    }
}
class Bear extends Obstacle{

    public Bear() {
        super("Bär", 7, 12, 20, 2);
    }
}