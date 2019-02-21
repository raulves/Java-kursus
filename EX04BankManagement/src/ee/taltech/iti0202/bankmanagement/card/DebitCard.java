package ee.taltech.iti0202.bankmanagement.card;

import ee.taltech.iti0202.bankmanagement.exceptions.TransactionException;
import java.math.BigDecimal;



public final class DebitCard extends BankCard {

    DebitCard() {
        person.setBankCard(this);
        bank.addCustomer(person);
        balance = new BigDecimal(0);

    }

    @Override
    public BigDecimal withdraw(BigDecimal value) throws TransactionException {
        return balance.subtract(value);
    }

}