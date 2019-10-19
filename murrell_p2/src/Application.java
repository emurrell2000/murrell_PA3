import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Application {
    @Test
    void testMonthlyInterest() {
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();

        SavingsAccount.modifyInterestRate(0.04);

        saver1.setSavingsBalance(2000);
        saver2.setSavingsBalance(3000);

        for (int i=0; i<12; i++) {
            assertEquals(saver1.getSavingsBalance() + saver1.calculateMonthlyInterest(saver1.getSavingsBalance()), saver1.getSavingsBalance() + (saver1.getSavingsBalance() * (0.04 / 12)));
            assertEquals(saver2.getSavingsBalance() + saver2.calculateMonthlyInterest(saver2.getSavingsBalance()), saver2.getSavingsBalance() + (saver2.getSavingsBalance() * (0.04 / 12)));

            System.out.println("Month " + (i+1));

            saver1.setSavingsBalance(saver1.getSavingsBalance() + saver1.calculateMonthlyInterest(saver1.getSavingsBalance()));
            saver2.setSavingsBalance(saver2.getSavingsBalance() + saver2.calculateMonthlyInterest(saver2.getSavingsBalance()));

            System.out.printf("saver1 bal: %.2f%n", saver1.getSavingsBalance());
            System.out.printf("saver2 bal: %.2f%n%n", saver2.getSavingsBalance());
        }

        SavingsAccount.modifyInterestRate(0.05);

        assertEquals(saver1.getSavingsBalance() + saver1.calculateMonthlyInterest(saver1.getSavingsBalance()), saver1.getSavingsBalance() + (saver1.getSavingsBalance() * (0.05 / 12)));
        assertEquals(saver2.getSavingsBalance() + saver2.calculateMonthlyInterest(saver2.getSavingsBalance()), saver2.getSavingsBalance() + (saver2.getSavingsBalance() * (0.05 / 12)));

        saver1.setSavingsBalance(saver1.getSavingsBalance() + saver1.calculateMonthlyInterest(saver1.getSavingsBalance()));
        saver2.setSavingsBalance(saver2.getSavingsBalance() + saver2.calculateMonthlyInterest(saver2.getSavingsBalance()));

        System.out.printf("saver1 bal: %.2f%n", saver1.getSavingsBalance());
        System.out.printf("saver2 bal: %.2f%n", saver2.getSavingsBalance());
    }
}
