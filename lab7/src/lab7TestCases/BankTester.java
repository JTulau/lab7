package lab7TestCases;

import lab7.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTester {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(100.0, "John Doe");
    }

    @Test
    void testGetMethods() {
        assertEquals("John Doe", account.getAccountHolder());
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    @Test
    void testDepositPositiveAmount() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.001);
    }

    @Test
    void testDepositNegativeAmount() {
        account.deposit(-20.0);
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    @Test
    void testWithdrawValidAmount() {
        boolean success = account.withdraw(40.0);
        assertTrue(success);
        assertEquals(60.0, account.getBalance(), 0.001);
    }

    @Test
    void testWithdrawNegativeAmount() {
        boolean success = account.withdraw(-10.0);
        assertFalse(success);
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    @Test
    void testWithdrawTooMuch() {
        boolean success = account.withdraw(200.0);
        assertFalse(success);
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    @Test
    void testConstructorRejectsNegativeBalance() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount(-50.0, "Jane Doe");
        });
    }
}
