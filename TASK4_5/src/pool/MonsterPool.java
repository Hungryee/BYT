package pool;

import java.util.Stack;

public class MonsterPool {
    public Stack<Monster> pool;
    public Stack<Monster> used;
    private final int maxSize;
    public MonsterPool(int size, int maxSize){
        pool = new Stack<>();
        used = new Stack<>();
        for (int i = 0; i < size; i++) {
            pool.push(new Monster());
        }
        this.maxSize = maxSize;
    }

    public Monster acquire(){
        if (!pool.isEmpty()){
            Monster m = pool.pop();
            m.onAcquire();
            used.push(m);
            return m;
        }else{
            if (pool.size()+used.size()<maxSize){
                Monster m = new Monster();
                used.push(m);
                System.out.println("Creating new object");
                m.onAcquire();
                return m;
            }else{
                System.out.println("Cant acquire new objects for now, please wait until one of them is released");
                return null;
            }
        }
    }

    public void release(Monster m){
        if (!pool.contains(m)){
            pool.push(m);
            used.remove(m);
            m.onRelease();
        }
    }
}
