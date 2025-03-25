
public class Main {

    static Customer[] customers = new Customer[5];

    // create some customer data
    static {
        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Customer("Smith" + i, "C", String.valueOf(i));
        }
    }

    /**
     * features: 1. deposit / withdraw 2. balance check 3. transaction history
     */
    public static void main(String args[]) {

        UI.display("Program Started", false, true);

        stop:
        for (;;) {
            switch (UI.showOptionPanel()) {
                case '1':
                    printAllUser();
                    break;
                case '2':
                    printAllUserWithBankInfo();
                    break;
                case '3':
                    interactWithUser();
                    break;
                case 'q':
                    break stop;
            }
        }
        UI.display("Program finished", true, true);
    }

    private static void printAllUser() {

        UI.display("Start printing all customers:", true, true);

        for (Customer customer : customers) {
            customer.printInformation();
        }

        UI.display("Finish print all customers.\n====", true, true);
    }

    private static void printAllUserWithBankInfo() {

        UI.display("Start printing all customers:", true, true);

        for (Customer customer : customers) {
            customer.printInformationWithBankInfo();
        }

        UI.display("Finish print all customers.\n====", true, true);
    }

    private static void interactWithUser() {
        String userId;
        Customer customer;
        do {
            userId = UI.readFromConsole("Please enter UserId: ");
            customer = getCustomerFromId(userId);
        } while (customer == null);

        UI.display("you entered: " + userId, true, true);
        customer.printInformationWithBankInfo();

        customerBankInteraction(customer.getBankAccount());

    }

    private static Customer getCustomerFromId(String userId) {
        Customer target = null;
        for (Customer c : customers) {
            if (c.getId().equals(userId)) {
                target = c;
                break;
            }
        }

        return target;
    }

    private static void customerBankInteraction(BankAccount bAccount) {

        UI.display("Customer bank interaction started", false, true);

        stop:
        for (;;) {
            switch (UI.showBankInteractionPanel()) {
                case '1':
                    deposit(bAccount);
                    break;
                case '2':
                    withdraw(bAccount);
                    break;
                case '3':
                    checkBalance(bAccount);
                    break;
                case 'q':
                    break stop;
            }
        }
        UI.display("Customer bank interaction finished", true, true);
    }

    private static void deposit(BankAccount account) {
        String amount = UI.readFromConsole("Please enter amount: ");

    }

    private static void withdraw(BankAccount account) {
        UI.display("withdraw...", true, true);
    }

    private static void checkBalance(BankAccount account) {
        account.printInformation();
    }

}
