package ee.taltech.iti0202.bankmanagement.card;

import ee.taltech.iti0202.bankmanagement.bank.Bank;
import ee.taltech.iti0202.bankmanagement.exceptions.TransactionException;
import ee.taltech.iti0202.bankmanagement.person.Person;

import java.math.BigDecimal;



public final class DebitCard extends BankCard {

    DebitCard() {

    }

    @Override
    public BigDecimal withdraw(BigDecimal value) throws TransactionException {
        if (balance.intValue() < value.intValue()) {
            throw new TransactionException(TransactionException.Reason.NOT_ENOUGH_MONEY);
        }
        return balance = balance.subtract(value);
    }

}
