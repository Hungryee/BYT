import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

import static org.junit.Assert.*;

public class SubscriptionTest {
    Subscription tmp;
    User u;
    User u2;
    @Before
    public void setUp() throws Exception {
        u = new User("Jora", "s@gmail.com", "123456", new ProfilePicture(), 1, new Faculty(), 1);
        u2 = new User("Ivan", "s2@gmail.com", "qwerty", new ProfilePicture(), 2, new Faculty(), 2);
        tmp = new Subscription(666, u, 1, Date.from(Instant.now()));
    }

    @Test
    public void getSetUser(){
        assertEquals(u, tmp.getUser());

        tmp.setUser(u2);

        assertEquals(u2, tmp.getUser());
    }

//    @Test
//    public void getSetSemester(){
//        assertEquals(1, tmp.getSemester());
//
//        tmp.setSemester(2);
//
//        assertEquals(2, tmp.getSemester());
//    }

    @Test
    public void getSetUUID(){
        assertEquals(666, tmp.getUuid());

        tmp.setUuid(123);

        assertEquals(123, tmp.getUuid());
    }
}
