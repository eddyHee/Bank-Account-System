
public class BankAccount {

    private float balance;
    private String accountName;

    public BankAccount() {
        this.balance = 0;
    }

    public BankAccount(float balance, String accountName) {
        this.balance = balance;
        this.accountName = accountName;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

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

    public void withdraw(float amount) {
        this.balance -= amount;

        if (this.balance < 0) {
            UI.display("Error happen when withdraw!", true, true);
        }

    }

    public void deposit(float value) {
        if (value > 0) {
            this.balance += value;
        } else {
            UI.display("Error happen when deposit", true, true);
        }
    }

    public void printInformation() {
        UI.display("    " + this.getBalance(), false, true);
        System.out.flush();
    }

}
