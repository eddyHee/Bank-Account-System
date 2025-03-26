
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {

    private String type;
    private final String transactionId;
    private float amount;
    private BankAccount account;
    private LocalDateTime timestamp;

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

}
