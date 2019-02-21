package ee.taltech.iti0202.bankmanagement.card;

import ee.taltech.iti0202.bankmanagement.exceptions.TransactionException;
import java.math.BigDecimal;

public final class CreditCard extends BankCard {


    CreditCard() {
        person.setBankCard(this);
        bank.addCustomer(person);
        balance = balance.add(new BigDecimal(10000));
    }

    @Override
    public BigDecimal withdraw(BigDecimal value) throws TransactionException {
        if (!((balance.intValue() - value.intValue()) < -5000)) {
            return balance = balance.subtract(value);
        } else {
            throw new TransactionException();
        }
    }

    @Override
    public BigDecimal getBalance() {
        return null;
    }

    public BigDecimal getDebt() {
        if (balance.intValue() < 0) {
            return balance;
        }
        return null;
    }
}