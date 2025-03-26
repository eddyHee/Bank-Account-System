
public class MenuInteraction {

    public static Customer[] customers;

    private MenuInteraction() {
    }

    public static boolean mainMenu() {
        switch (UI.showOptionPanel()) {
            case '1' ->
                printAllUser();
            case '2' ->
                printAllUserWithBankInfo();
            case '3' ->
                interactWithUser();
            case 'q' -> {
                return true;
            }
        }
        return false;
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

        String bankName;
        BankAccount bankAccount;
        do {
            bankName = UI.readFromConsole("Please enter bank Name: ");
            bankAccount = customer.getBankAccountByName(bankName);
        } while (bankAccount == null);

        BankServicesInteraction.customerBankInteraction(bankAccount);

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

}
