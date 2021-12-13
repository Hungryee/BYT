package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	@Test
	public void testGetName() {
		assertEquals(SEK.getName(), "SEK");
		assertEquals(DKK.getName(), "DKK");
		assertEquals(EUR.getName(), "EUR");
	}
	
	@Test
	public void testGetRate() {
		assertEquals(SEK.getRate(), 0.15, 0);
		assertEquals(DKK.getRate(), 0.2, 0);
		assertEquals(EUR.getRate(), 1.5, 0);
	}
	
	@Test
	public void testSetRate() {
		SEK.setRate(0.173);
		assertEquals(SEK.getRate(), 0.173, 0);
	}
	
	@Test
	public void testGlobalValue() {
		assertEquals(SEK.universalValue(100), (int) (100/0.15), 0);
	}
	
	@Test
	public void testValueInThisCurrency() {
		//true amount in SEK frmo 100 eur is
		Integer amount = (int) (EUR.universalValue(100)*SEK.getRate());
		assertEquals(SEK.valueInThisCurrency(100, EUR), amount,0);
	}

}
