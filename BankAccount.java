
import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private float balance;
    private String accountName;

    private List<Transaction> transactions;

    public BankAccount() {
        this.balance = 0;
    }

    public BankAccount(float balance, String accountName) {
        this.balance = balance;
        this.accountName = accountName;
        this.transactions = new ArrayList<>();
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
        this.transactions.add(new Transaction("WITHDRAW", this.balance, this));

        if (this.balance < 0) {
            UI.display("Error happen when withdraw!", true, true);
        }

    }

    public void deposit(float value) {
        if (value > 0) {
            this.balance += value;

            this.transactions.add(new Transaction("DEPOSIT", this.balance, this));
        } else {
            UI.display("Error happen when deposit", true, true);
        }
    }

    public void printInformation() {
        UI.display("    " + this.accountName + ": $" + this.getBalance(), false, true);
    }

    public void printTransaction() {
        UI.display("Following are the transaction information for account: " + this.accountName, true, true);
        for (Transaction transaction : transactions) {
            transaction.printInformation();
        }
    }
}
