public class SavingsAccount {

    private static double annualInterestRate;

    public static void modifyInterestRate(double value) {
        annualInterestRate = value;
    }

    private double savingsBalance;

    public double calculateMonthlyInterest(double savingsBalance) {
        return savingsBalance * annualInterestRate / 12;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }
}
