package lab7TestCases;

import lab7.SavingsAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SavingsTester {

    private SavingsAccount account;

    @BeforeEach
    void setUp() {
        account = new SavingsAccount(100.0, "John Doe", 5.0, 0.01);
    }

    @Test
    void testGetMethods() {
        assertEquals("John Doe", account.getAccountHolder());
        assertEquals(100.0, account.getBalance(), 0.001);
        assertEquals(5.0, account.getWithdrawalFee(), 0.001);
        assertEquals(0.01, account.getInterestRate(), 0.001);
    }

    @Test
    void testDepositPositiveAmount() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.001);
    }

    @Test
    void testWithdrawValidAmountWithFee() {
        boolean success = account.withdraw(40.0);
        assertTrue(success);
        assertEquals(55.0, account.getBalance(), 0.001);
    }

    @Test
    void testWithdrawTooMuchWithFee() {
        boolean success = account.withdraw(200.0);
        assertFalse(success);
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    @Test
    void testApplyInterest() {
        account.applyInterest();
        assertEquals(101.0, account.getBalance(), 0.001);
    }
}
