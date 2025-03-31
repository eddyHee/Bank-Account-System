
public class MenuInteraction {

    public static Customer[] customers;

    private MenuInteraction() {
    }

    public static boolean mainMenu() {
        char choice = UI.showOptionPanel();
        UI.clearScreen();
        switch (choice) {
            case '1' -> {
                printAllUser();
            }
            case '2' -> {
                printAllUserWithBankInfo();
            }
            case '3' -> {
                BankServicesInteraction.interactWithUser(customers);
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

        UI.display(UI.CUSTOMER_INFO_WITH_BANK_START, true, true);

        for (Customer customer : customers) {
            UI.printInformationWithBankInfo(customer);
        }

        UI.display(UI.CUSTOMER_INFO_WITH_BANK_END, true, true);
    }

}
