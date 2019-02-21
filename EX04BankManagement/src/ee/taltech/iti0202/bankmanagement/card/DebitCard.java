package ee.taltech.iti0202.bankmanagement.card;
import ee.taltech.iti0202.bankmanagement.bank.Bank;
import ee.taltech.iti0202.bankmanagement.exceptions.TransactionException;
import ee.taltech.iti0202.bankmanagement.person.Person;

import java.math.BigDecimal;

public final class DebitCard extends BankCard {




    DebitCard() {
        person.setBankCard(this);
        bank.addCustomer(person);

    }

    @Override
    public BigDecimal withdraw(BigDecimal value) throws TransactionException {
        return null;
    }

}