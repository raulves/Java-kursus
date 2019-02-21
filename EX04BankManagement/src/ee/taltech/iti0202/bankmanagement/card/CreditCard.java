package ee.taltech.iti0202.bankmanagement.card;
import ee.taltech.iti0202.bankmanagement.bank.Bank;
import ee.taltech.iti0202.bankmanagement.exceptions.TransactionException;
import ee.taltech.iti0202.bankmanagement.person.Person;

import java.math.BigDecimal;

public final class CreditCard extends BankCard {


    CreditCard() {
        person.setBankCard(this);
        bank.addCustomer(person);
    }

    @Override
    public BigDecimal withdraw(BigDecimal value) throws TransactionException {
        return null;
    }

    @Override
    public BigDecimal getBalance() {
        return null;
    }

    public BigDecimal getDebt() {
        return null;
    }
}