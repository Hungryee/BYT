import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
    User tmp;

    @Before
    public void setUp() throws Exception {
        tmp = new User("Jora", "s@gmail.com", "123456", new ProfilePicture(), 1, new Faculty(), 1);
    }

    @Test
    public void getSetEmail(){
        assertEquals("Jora", tmp.getName());

        tmp.setName("Ivan");

        assertEquals("Ivan", tmp.getName());
    }
    @Test
    public void getSetPassword(){
        assertEquals("123456", tmp.getPassword());

        tmp.setPassword("qwerty");

        assertEquals("qwerty", tmp.getPassword());
    }

    @Test
    public void getSetSemester(){
        assertEquals(1, tmp.getSemester());

        tmp.setSemester(2);

        assertEquals(2, tmp.getSemester());
    }

    @Test
    public void getSetUUID(){
        assertEquals(1, tmp.getUuid());

        tmp.setUuid(123);

        assertEquals(123, tmp.getUuid());
    }
}
