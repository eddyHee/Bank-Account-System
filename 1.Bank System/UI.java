
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public final class UI {

    private static final String MENU_TEXT = """
    =====================================================
    |    Please Choose from the options below:          |
    |     1. Print all current users.                   |
    |     2. Print all users with bank balance.         |
    |     3. enter user Id to start transaction.        |
    |                                                   |
    |     q. Quit program.                              |
    |                                                   |
    =====================================================
    
    Enter your choice:\s""";

    private static final String BANK_INTERACTION_MENU_TEXT = """
    =====================================================
    |    Please Choose from the options below:          |
    |     1. Deposit.                                   |
    |     2. withdraw.                                  |
    |     3. check Balance.                             |
    |     4. print transactions.                        |
    |                                                   |
    |     q. Quit program.                              |
    |                                                   |
    =====================================================

    Enter your choice:\s""";

    public static final String CUSTOMER_INFO_START = """
    =====================================================
           Following are all customers information       
    =====================================================
    """;

    public static final String CUSTOMER_INFO_END = """
    -----------------------------------------------------
           All Customers information printed       
    =====================================================

    """;

    public static final String CUSTOMER_INFO_WITH_BANK_START = """
    =================================================================
        Following are all customers information with Bank Account      
    =================================================================
    """;

    public static final String CUSTOMER_INFO_WITH_BANK_END = """
    -----------------------------------------------------------------
        All customers information with Bank Account printed     
    =================================================================

    """;

    private static final String INVALID_INPUT_MESSAGE = "Invalid Input...\n";
    private static final String IO_ERROR_MESSAGE = "IO Error";
    private static final String BUFFER_CLEAR_ERROR = "Error clearing input buffer";

    private UI() {
    } // Prevent instantiation

    public static char showOptionPanel() {
        while (true) {
            display(MENU_TEXT, true, false);

            char choice = readChar();
            clearInputBuffer();

            if (isValidInput(choice, '1', '3')) {
                return choice;
            }
            display(INVALID_INPUT_MESSAGE);
        }
    }

    public static char showBankInteractionPanel() {
        while (true) {
            display(BANK_INTERACTION_MENU_TEXT, true, false);

            char choice = readChar();
            clearInputBuffer();

            if (isValidInput(choice, '1', '4')) {
                return choice;
            }
            display(INVALID_INPUT_MESSAGE);
        }
    }

    public static void printCustomerInformation(Customer customer) {
        UI.display("\t" + customer.getCustomerInfo(), false, true);
        System.out.flush();
    }

    public static void printInformationWithBankInfo(Customer customer) {
        UI.display("    " + customer.getCustomerInfo(), false, true);
        List<BankAccount> bankAccounts = customer.getBankAccounts();
        if (!bankAccounts.isEmpty()) {
            for (BankAccount bankAccount : bankAccounts) {
                UI.display("    ");
                bankAccount.printInformation();
            }
        } else {
            UI.display("    This user dont have any bank account.");
        }

        System.out.flush();

    }

    private static boolean isValidInput(char choice, int min, int max) {
        return choice >= min & choice <= max || choice == 'q';
    }

    public static void display(String text) {
        System.out.print(text);
        System.out.flush();
    }

    public static void display(String text, boolean prependNewLine, boolean appendNewLine) {
        if (prependNewLine) {
            System.out.println();
        }
        display(text);
        if (appendNewLine) {
            System.out.println();
        }
        System.out.flush();
    }

    private static char readChar() {
        try {
            return (char) System.in.read();
        } catch (IOException e) {
            display(IO_ERROR_MESSAGE);
            return '\0';
        }
    }

    private static void clearInputBuffer() {
        try {
            while (System.in.available() > 0) {
                System.in.read();
            }
        } catch (IOException e) {
            display(BUFFER_CLEAR_ERROR);
        }
    }

    public static String readFromConsole(String msg) {
        Scanner scanner = new Scanner(System.in);
        display(msg);
        String line = scanner.nextLine();

        return line;
    }

    public static Customer getCustomerFromUserInput(Customer[] customers) {
        String userId;
        Customer customer;
        do {
            userId = UI.readFromConsole("Please enter UserId: ");
            customer = getCustomerFromId(userId, customers);
            if (customer == null) {
                display("Please enter a valid user id.", true, true);
            }
        } while (customer == null);

        UI.display("you entered: " + userId, true, true);
        printInformationWithBankInfo(customer);
        return customer;
    }

    private static Customer getCustomerFromId(String userId, Customer[] customers) {
        Customer target = null;
        for (Customer c : customers) {
            if (c.getId().equals(userId)) {
                target = c;
                break;
            }
        }

        return target;
    }

    public static BankAccount getBankAccountFromUserInput(Customer customer) {
        String bankName;
        BankAccount bankAccount;
        do {
            bankName = UI.readFromConsole("Please enter bank Name: ");
            bankAccount = customer.getBankAccountByName(bankName);
            if (bankAccount == null) {
                display("Please enter a valid bank name.", true, true);
            }
        } while (bankAccount == null);

        return bankAccount;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
