package ee.taltech.iti0202.bankmanagement.exceptions;
public class TransactionException extends Exception {
    public enum Reason {
        NOT_ENOUGH_MONEY,
        DEPOSIT_MUST_BE_POSITIVE
    }

    private Reason reason;

    public TransactionException(Reason reason) {
        this.reason = reason;
    }

    public Reason getReason() {
        return reason;
    }

    @Override
    public String getMessage() {
        return toString();
    }

    @Override
    public String toString() {
        return getReason().toString();
    }
}
