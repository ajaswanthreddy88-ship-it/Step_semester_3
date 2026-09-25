class PiggyBank {
    private int savings;
    private final String id;

    // Constructor
    PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    // Deposit money
    void deposit(int amount) {
        savings = savings + amount;
    }

    // Withdraw money
    void withdraw(int amount) {
        if (amount <= savings) {
            savings = savings - amount;
        } else {
            System.out.println("Withdrawal rejected");
        }
    }

    // Check savings
    int getSavings() {
        return savings;
    }
}

public class Main {
    public static void main(String[] args) {

        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        System.out.println("Savings = " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("Savings = " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("Savings = " + pb.getSavings());
    }
}
