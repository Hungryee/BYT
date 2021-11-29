package pool;

import java.util.Random;

public class Monster implements Reusable{
    double x;
    double y;
    int health;
    int maxHealth;

    public Monster(int x, int y){
        //some heavy operation here
        this.x = x;
        this.y = y;
        this.maxHealth=100;
        this.health=maxHealth;
    }
    public Monster(){
        //some heavy operation here
        this(-999,-999);
    }
    @Override
    public void onRelease() {
        //assume this operation moves monster out of the player reach/out of the map
        this.x = -999;
        this.y = -999;
        this.health = maxHealth;
        System.out.println("Object has been returned to pool");
    }

    @Override
    public void onAcquire() {
        this.x = new Random().nextInt(1000);
        this.y = new Random().nextInt(1000);;
        System.out.println("Object has been acquired from pool");
    }

    @Override
    public String toString() {
        return "Monster("+x+","+y+") with health "+health+"/"+maxHealth;
    }
}
