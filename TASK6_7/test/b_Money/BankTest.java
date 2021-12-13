package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {
		assertEquals("Nordea", Nordea.getName());
	}

	@Test
	public void testGetCurrency() {
		assertEquals(SEK, Nordea.getCurrency());
	}

	@Test
	public void testOpenAccount() throws AccountExistsException {
		// since it exists
		assertThrows(AccountExistsException.class, () -> SweBank.openAccount("Ulrika"));
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		assertThrows(AccountDoesNotExistException.class,()->SweBank.deposit("NONAME", new Money(123, SEK)));
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		assertThrows(AccountDoesNotExistException.class,()->SweBank.withdraw("NONAME", new Money(123, SEK)));
	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		assertEquals(0,SweBank.getBalance("Ulrika"),0);
		SweBank.deposit("Ulrika", new Money(123, SEK));
		assertEquals(123,SweBank.getBalance("Ulrika"),0);
	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		assertEquals(0,SweBank.getBalance("Ulrika"),0);
		assertEquals(0,SweBank.getBalance("Bob"),0);
		SweBank.deposit("Ulrika", new Money(123, SEK));
		SweBank.transfer("Ulrika", "Bob", new Money(23, SEK));

		assertEquals(100,SweBank.getBalance("Ulrika"),1);
		assertEquals(23,SweBank.getBalance("Bob"),1);
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		SweBank.addTimedPayment("Ulrika", "412", 4, 4, new Money(100, SEK), Nordea, "Bob");
		SweBank.tick();
		SweBank.tick();
		SweBank.tick();
		SweBank.tick();
		SweBank.tick();
		assertEquals(100, Nordea.getBalance("Bob"),1);
	}
}
