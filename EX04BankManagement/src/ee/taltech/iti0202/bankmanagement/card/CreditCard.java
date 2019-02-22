package ee.taltech.iti0202.bankmanagement.card;


import ee.taltech.iti0202.bankmanagement.exceptions.TransactionException;


import java.math.BigDecimal;

public final class CreditCard extends BankCard {
    final private int maxDebt = -5000;

    CreditCard() {



    }

    @Override
    public BigDecimal withdraw(BigDecimal value) throws TransactionException {
        if (!((balance.intValue() - value.intValue()) <= maxDebt)) {
            return balance = balance.subtract(value);
        } else {
            throw new TransactionException(TransactionException.Reason.NOT_ENOUGH_MONEY);
        }
    }

    @Override
    public BigDecimal getBalance() {
        if (balance.intValue() < 0) {
            return BigDecimal.ZERO;
        }
        return balance;
    }

    public BigDecimal getDebt() {
        if (balance.intValue() < 0) {

            return balance.abs();
        }
        return BigDecimal.ZERO;
    }
}
