package lab7;

public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100.0, "Alice");

        // Test 1: Get methods
        System.out.println("Test 1 - Get methods:");
        System.out.println(account.getAccountHolder().equals("Alice") ? "PASS" : "FAIL");
        System.out.println(account.getBalance() == 100.0 ? "PASS" : "FAIL");

        // Test 2: Deposit positive amount
        System.out.println("\nTest 2 - Deposit positive amount:");
        account.deposit(50.0);
        System.out.println(account.getBalance() == 150.0 ? "PASS" : "FAIL");

        // Test 3: Deposit negative amount
        System.out.println("\nTest 3 - Deposit negative amount:");
        account.deposit(-20.0);
        System.out.println(account.getBalance() == 150.0 ? "PASS" : "FAIL");

        // Test 4: Withdraw valid amount
        System.out.println("\nTest 4 - Withdraw valid amount:");
        boolean result1 = account.withdraw(40.0);
        System.out.println(result1 ? "PASS" : "FAIL");
        System.out.println(account.getBalance() == 110.0 ? "PASS" : "FAIL");

        // Test 5: Withdraw negative amount
        System.out.println("\nTest 5 - Withdraw negative amount:");
        boolean result2 = account.withdraw(-10.0);
        System.out.println(!result2 ? "PASS" : "FAIL");
        System.out.println(account.getBalance() == 110.0 ? "PASS" : "FAIL");

        // Test 6: Withdraw too much
        System.out.println("\nTest 6 - Withdraw too much:");
        boolean result3 = account.withdraw(200.0);
        System.out.println(!result3 ? "PASS" : "FAIL");
        System.out.println(account.getBalance() == 110.0 ? "PASS" : "FAIL");
    }
}

