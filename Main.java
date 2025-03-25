
import java.util.Optional;

public class Main {

    private static final int MAX_SIZE = 5;

    static Customer[] customers = new Customer[MAX_SIZE];

    // create some customer data
    static {
        for (int i = 0; i < MAX_SIZE; i++) {
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
                case '1' ->
                    printAllUser();
                case '2' ->
                    printAllUserWithBankInfo();
                case '3' ->
                    interactWithUser();
                case 'q' -> {
                    break stop;
                }
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
                case '1' ->
                    deposit(bAccount);
                case '2' ->
                    withdraw(bAccount);
                case '3' ->
                    checkBalance(bAccount);
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
            String amount = UI.readFromConsole("Please enter amount: ");

            Optional<Integer> optionalValue = Convert.convertStringToInt(amount);

            if (optionalValue.isPresent()) {
                int value = optionalValue.get();
                if (isValidDepositAmount(value)) {
                    account.deposit(value);
                    System.out.println("Deposited: " + value);
                    validInput = true;
                } else {
                    System.out.println("Please enter a positive amount.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

    }

    private static void withdraw(BankAccount account) {
        UI.display("withdraw...", true, true);
    }

    private static void checkBalance(BankAccount account) {
        account.printInformation();
    }

    private static boolean isValidDepositAmount(int amount) {

        return amount > 0;

    }

}
