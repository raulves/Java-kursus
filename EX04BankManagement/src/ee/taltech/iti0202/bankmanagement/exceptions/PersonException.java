package ee.taltech.iti0202.bankmanagement.exceptions;
public class PersonException extends RuntimeException {
    public enum Reason {
        AGE_MUST_BE_OVER_ZERO,
        INCOME_MUST_BE_POSITIVE
    }

    private Reason reason;

    public PersonException(Reason reason) {
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