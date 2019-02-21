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
        return balance = balance.subtract(value);
    }

    @Override
    public BigDecimal getBalance() {
        return null;
    }

    public BigDecimal getDebt() {
        return null;
    }
}