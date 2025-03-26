
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String firstName;
    private String lastName;
    private final String id;

    private List<BankAccount> bankAccounts;

    public Customer() {
        this.id = "Invalid";
    }

    public Customer(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;

        this.bankAccounts = new ArrayList<>();
        this.bankAccounts.add(new BankAccount(10, "ABC"));
    }

    public String getCustomerInfo() {
        return firstName + " " + this.lastName + " (ID: " + this.id + ")";
    }

    public String getId() {
        return this.id;
    }

    public boolean createBankAccount(String accountName, int amount) {
        try {
            BankAccount bankAccount = new BankAccount(amount, accountName);
            this.bankAccounts.add(bankAccount);
            return true;
        } catch (Exception e) {
            UI.display("Error when creating account.", true, true);
            return false;
        }
    }

    public BankAccount getBankAccountByName(String accountName) {
        for (BankAccount account : this.bankAccounts) {
            if (account.getAccountName().equals(accountName)) {
                return account;
            }
        }
        return null;
    }

    public void printInformationWithBankInfo() {
        UI.display("    " + this.getCustomerInfo(), false, true);
        if (!this.bankAccounts.isEmpty()) {
            for (BankAccount bankAccount : bankAccounts) {
                UI.display("    ");
                bankAccount.printInformation();
            }
        } else {
            UI.display("    This user dont have any bank account.");
        }

        System.out.flush();

    }

}
