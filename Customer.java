
public class Customer {

    private String firstName;
    private String lastName;
    private final String id;

    private BankAccount bankAccount;

    public Customer() {
        this.id = "Invalid";
    }

    public Customer(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;

        bankAccount = new BankAccount();
    }

    public String getName() {
        return firstName + " " + this.lastName + " (ID: " + this.id + ")";
    }

    public String getId() {
        return this.id;
    }

    public BankAccount getBankAccount() {
        return this.bankAccount;
    }

    public void printInformation() {
        UI.display("    " + this.getName(), false, true);
        System.out.flush();
    }

    public void printInformationWithBankInfo() {
        UI.display("    " + this.getName(), false, true);
        UI.display("    ");
        this.bankAccount.printInformation();
        System.out.flush();
    }

}
