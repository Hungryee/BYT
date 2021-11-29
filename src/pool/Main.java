package pool;

public class Main {
    public static void main(String[] args) {
        MonsterPool m = new MonsterPool(3, 5);
        Monster m1 = m.acquire();

        System.out.println("On creation: "+m1);
        m1.health-=15;
        System.out.println("After damage: "+m1);
        m.release(m1);
        System.out.println("After release: "+m1);

        m.acquire();

        Monster m2 = m.acquire();
        Monster m3 = m.acquire();
        Monster m4 = m.acquire();
        Monster m5 = m.acquire();
        m.acquire();
        m.release(m2);
        m.release(m3);
        m.release(m4);

        System.out.println("Used: " + m.used.size());
        System.out.println("Available: " + m.pool.size());
    }
}
