
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {

    private final String type;
    private final String transactionId;
    private final float amount;
    private final BankAccount account;
    private final LocalDateTime timestamp;

    public Transaction(String type, float amount, BankAccount account) {
        this.type = type;
        this.amount = amount;
        this.account = account;

        this.transactionId = generateTransactionId();
        this.timestamp = LocalDateTime.now();
    }

    private static String generateTransactionId() {
        return UUID.randomUUID().toString();
    }

    public void printInformation() {
        UI.display("\tTransactionId: " + this.transactionId, true, true);
        UI.display("\tType: " + this.type, true, true);
        UI.display("\tAmount: " + this.amount, true, true);
        UI.display("\ttimestamp: " + this.timestamp, true, true);
    }

}
