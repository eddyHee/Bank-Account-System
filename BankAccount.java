
public class BankAccount {

    private float balance;

    public BankAccount() {
        this.balance = 0;
    }

    public BankAccount(float balance) {
        this.balance = balance;
    }

    // test comment for git 
    public float getBalance() {
        return this.balance;
    }

    public boolean setBalance(float balance) {
        if (balance >= 0) {
            this.balance = balance;
            return true;
        }

        return false;
    }

    public boolean canWithDraw(float withDrawAmount) {
        return withDrawAmount <= balance;
    }

    public void printInformation() {
        UI.display("    " + this.getBalance(), false, true);
        System.out.flush();
    }

    public void deposit(float value) {
        if (value > 0) {
            this.balance += value;
        } else {
            UI.display("Error happen when deposit", true, true);
        }
    }

    public void withdraw(float amount) {
        this.balance -= amount;

        if (this.balance < 0) {
            UI.display("Error happen when withdraw!", true, true);
        }

    }

}
