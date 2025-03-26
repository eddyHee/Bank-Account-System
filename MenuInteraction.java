
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
                BankServicesInteraction.interactWithUser(customers);
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

}
