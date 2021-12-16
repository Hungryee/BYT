package b_Money;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));

		SweBank.deposit("Alice", new Money(1000000, SEK));
	}
	
	@Test
	public void testAddRemoveTimedPayment() {
		testAccount.addTimedPayment("123", 5,3,new Money(100000, SEK), SweBank, "Alice");
		assertTrue(testAccount.timedPaymentExists("123"));

		testAccount.removeTimedPayment("123");
		assertFalse(testAccount.timedPaymentExists("123"));
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		testAccount.addTimedPayment("123", 5,3,new Money(100000, SEK), SweBank, "Alice");
		for (int i = 0; i < 3+1; i++) {
			testAccount.tick();
		}

		//transaction completed on 4th tick
		assertEquals(new Money(10000000-100000, SEK).getAmount(), testAccount.getBalance().getAmount(),1);
	}

	@Test
	public void testAddWithdraw() {
		assertEquals(new Money(10000000, SEK).getAmount(), testAccount.getBalance().getAmount(),1);
		testAccount.withdraw(new Money(5000000, SEK));
		assertEquals(new Money(5000000, SEK).getAmount(), testAccount.getBalance().getAmount(),1);
	}
	
	@Test
	public void testGetBalance() {
		assertEquals(new Money(10000000, SEK).getAmount(), testAccount.getBalance().getAmount(),1);
	}
}
