package ee.taltech.iti0202.bankmanagement.card;

import ee.taltech.iti0202.bankmanagement.bank.Bank;
import ee.taltech.iti0202.bankmanagement.exceptions.TransactionException;
import ee.taltech.iti0202.bankmanagement.person.Person;

import java.math.BigDecimal;



public final class DebitCard extends BankCard {

    DebitCard(CardType cardType, Bank bank, Person person) {
        this.cardType = cardType;
        this.bank = bank;
        this.person = person;
        this.balance = new BigDecimal(0);
        person.setBankCard(this);
        bank.addCustomer(person);


    }

    @Override
    public BigDecimal withdraw(BigDecimal value) throws TransactionException {
        if (balance.intValue() < value.intValue()) {
            throw new TransactionException();
        }
        return balance = balance.subtract(value);
    }

}