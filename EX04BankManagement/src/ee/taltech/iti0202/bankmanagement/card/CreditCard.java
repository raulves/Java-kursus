package ee.taltech.iti0202.bankmanagement.card;

import ee.taltech.iti0202.bankmanagement.bank.Bank;
import ee.taltech.iti0202.bankmanagement.exceptions.TransactionException;
import ee.taltech.iti0202.bankmanagement.person.Person;

import java.math.BigDecimal;

public final class CreditCard extends BankCard {


    CreditCard(CardType cardType, Bank bank, Person person) {
        this.cardType = cardType;
        this.bank = bank;
        this.person = person;
        this.balance = new BigDecimal(10000);
        person.setBankCard(this);
        bank.addCustomer(person);

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