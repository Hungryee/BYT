package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	@Test
	public void testGetAmount() {
		assertEquals(SEK100.getAmount(), 10000,0);
	}

	@Test
	public void testGetCurrency() {
		assertEquals(EUR, EUR10.getCurrency());
	}

	@Test
	public void testToString() {
		assertEquals(SEK100.toString(), "100.0 SEK");
	}

	@Test
	public void testGlobalValue() {
		int amount = (int) (SEK100.getAmount()/SEK100.getCurrency().getRate());
		assertEquals(SEK100.universalValue(), amount, 0);
	}

	@Test
	public void testEqualsMoney() {
		assertEquals(EUR20, EUR20);
	}

	@Test
	public void testAdd() {
		int universal1 = EUR20.add(SEK100).universalValue();
		int universal2 = SEK100.add(EUR20).universalValue();
		assertEquals(universal1,universal2,10);
	}

	@Test
	public void testSub() {
		int universal1 = EUR10.add(SEK200).universalValue();
		int universal2 = SEK200.add(EUR10).universalValue();
		assertEquals(universal1,universal2,10);
	}

	@Test
	public void testIsZero() {
		assertTrue(EUR0.isZero());
	}

	@Test
	public void testNegate() {
		Money m1 = SEKn100;
		Money m2 = SEK100.negate();
		assertTrue(m1.equals(m2));
	}

	@Test
	public void testCompareTo() {
		assertEquals(EUR10.compareTo(EUR0), 1);
	}
}
