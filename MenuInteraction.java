
public class MenuInteraction {

    public static Customer[] customers;

    private MenuInteraction() {
    }

    public static boolean mainMenu() {
        switch (UI.showOptionPanel()) {
            case '1' -> {
                UI.clearScreen();
                printAllUser();
            }
            case '2' -> {
                UI.clearScreen();
                printAllUserWithBankInfo();
            }
            case '3' -> {
                BankServicesInteraction.interactWithUser(customers);
                UI.clearScreen();
            }
            case 'q' -> {
                return true;
            }
        }
        return false;
    }

    private static void printAllUser() {

        UI.display(UI.CUSTOMER_INFO_START, true, true);

        for (Customer customer : customers) {
            UI.printCustomerInformation(customer);
        }

        UI.display(UI.CUSTOMER_INFO_END, true, true);
    }

    private static void printAllUserWithBankInfo() {

        UI.display("Start printing all customers:", true, true);

        for (Customer customer : customers) {
            customer.printInformationWithBankInfo();
        }

        UI.display("Finish print all customers.\n====", true, true);
    }

}
