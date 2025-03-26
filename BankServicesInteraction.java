
import java.util.Optional;

public class BankServicesInteraction {

    private BankServicesInteraction() {

    }

    public static void interactWithUser(Customer[] customers) {
        Customer customer = UI.getCustomerFromUserInput(customers);
        BankAccount bankAccount = UI.getBankAccountFromUserInput(customer);

        customerBankInteraction(bankAccount);

    }

    private static void customerBankInteraction(BankAccount bAccount) {

        UI.display("Customer bank interaction started", false, true);

        stop:
        for (;;) {
            char choice = UI.showBankInteractionPanel();
            UI.clearScreen();
            switch (choice) {
                case '1' -> {
                    // UI.clearScreen();
                    deposit(bAccount);
                }
                case '2' -> {
                    // UI.clearScreen();
                    withdraw(bAccount);
                }
                case '3' -> {
                    // UI.clearScreen();
                    checkBalance(bAccount);
                }
                case '4' -> {
                    // UI.clearScreen();
                    bAccount.printTransaction();
                }
                case 'q' -> {
                    break stop;
                }
            }
        }
        UI.display("Customer bank interaction finished", true, true);
    }

    private static void deposit(BankAccount account) {
        boolean validInput = false;

        while (!validInput) {
            String amount = UI.readFromConsole("Please enter amount want to deposit: ");

            Optional<Integer> optionalValue = Convert.convertStringToInt(amount);

            if (optionalValue.isPresent()) {
                int value = optionalValue.get();
                if (isValidDepositAmount(value)) {
                    account.deposit(value);
                    System.out.println("Deposited: " + value);
                    validInput = true;
                    checkBalance(account);
                } else {
                    System.out.println("Please enter a positive amount.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

    }

    private static void withdraw(BankAccount account) {
        boolean validInput = false;

        while (!validInput) {
            String amount = UI.readFromConsole("Please enter amount want to withdraw: ");

            Optional<Integer> optionalValue = Convert.convertStringToInt(amount);

            if (optionalValue.isPresent()) {
                int value = optionalValue.get();
                if (isValidWithdrawAmount(value, account)) {
                    account.withdraw(value);
                    System.out.println("Withdraw: " + value);
                    validInput = true;
                    checkBalance(account);
                } else {
                    System.out.println("Please enter a positive amount.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static void checkBalance(BankAccount account) {
        account.printInformation();
    }

    private static boolean isValidDepositAmount(int amount) {

        return amount > 0;

    }

    private static boolean isValidWithdrawAmount(int amount, BankAccount account) {

        return (amount > 0 & account.canWithDraw(amount));

    }

}
