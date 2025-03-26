
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
    }

    public String getCustomerInfo() {
        return firstName + " " + this.lastName + " (ID: " + this.id + ")";
    }

    public String getId() {
        return this.id;
    }

    public BankAccount getBankAccountByName(String accountName) {
        for (BankAccount account : this.bankAccounts) {
            if (account.getAccountName().equals(accountName)) {
                return account;
            }
        }
        return null;
    }

    public void printInformation() {
        UI.display("    " + this.getCustomerInfo(), false, true);
        System.out.flush();
    }

    public void printInformationWithBankInfo() {
        UI.display("    " + this.getCustomerInfo(), false, true);
        for (BankAccount bankAccount : bankAccounts) {
            UI.display("    ");
            bankAccount.printInformation();
        }

        System.out.flush();
    }

}
