package lab7;

public class SavingsAccount extends BankAccount {
    private double withdrawalFee;
    private double interestRate;

    public SavingsAccount(double initialBalance, String accountHolder, double withdrawalFee, double interestRate) {
        super(initialBalance, accountHolder);
        this.withdrawalFee = withdrawalFee;
        this.interestRate = interestRate;
    }

    public double getWithdrawalFee() {
        return withdrawalFee;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public boolean withdraw(double amount) {
        double totalAmount = amount + withdrawalFee;
        if (totalAmount <= getBalance() && amount > 0) {
            super.withdraw(totalAmount);
            return true;
        }
        return false;
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);  // Adds interest to the balance
    }
}
