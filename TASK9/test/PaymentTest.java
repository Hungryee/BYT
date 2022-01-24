import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PaymentTest {
    Payment tmp;

    @Before
    public void setUp() throws Exception {
        tmp = new Payment(2, "4242424242424242", null);
    }

    @Test
    public void getSetUUID() {
        assertEquals(2, tmp.getUuid());

        tmp.setUuid(123);

        assertEquals(123, tmp.getUuid());
    }

    @Test
    public void getSetAccNum() {
        assertEquals("4242424242424242", tmp.getAccount_num());

        tmp.setAccount_num("4141414141414141");

        assertEquals("4141414141414141", tmp.getAccount_num());
    }

}
