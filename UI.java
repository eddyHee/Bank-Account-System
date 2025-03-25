
import java.io.IOException;
import java.util.Scanner;

public final class UI {

    private static final String MENU_TEXT = """
        Please Choose from the options below:
            1. Print all current users.
            2. Print all users with bank balance.
            3. enter user Id to start transaction.
            q. Quit program.
        Enter:\s""";

    private static final String BANK_INTERACTION_MENU_TEXT = """
        Please Choose from the options below:
            1. Deposit.
            2. withdraw.
            3. check Balance.
            q. Quit program.
        Enter:\s""";

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

            if (isValidInput(choice)) {
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

            if (isValidInput(choice)) {
                return choice;
            }
            display(INVALID_INPUT_MESSAGE);
        }
    }

    private static boolean isValidInput(char choice) {
        return choice >= '1' & choice <= '3' || choice == 'q';
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
}
