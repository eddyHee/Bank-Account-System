
public class Main {

    private static final int MAX_SIZE = 5;

    static Customer[] customers = new Customer[MAX_SIZE];

    // create some customer data
    static {
        for (int i = 0; i < MAX_SIZE; i++) {
            customers[i] = new Customer("Smith" + i, "C", String.valueOf(i));
        }
        MenuInteraction.customers = customers;
    }

    /**
     * features: 1. deposit / withdraw 2. balance check 3. transaction history
     */
    public static void main(String args[]) {

        UI.display("Program Started", false, true);

        boolean finished = false;
        while (!finished) {
            finished = MenuInteraction.mainMenu();
        }
        UI.display("Program finished", true, true);
    }

}
