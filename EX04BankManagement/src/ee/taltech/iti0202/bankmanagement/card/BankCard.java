package ee.taltech.iti0202.bankmanagement.card;
import ee.taltech.iti0202.bankmanagement.bank.Bank;
import ee.taltech.iti0202.bankmanagement.exceptions.TransactionException;
import ee.taltech.iti0202.bankmanagement.person.Person;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public abstract class BankCard {


    protected static Bank bank;
    protected static Person person;
    protected static BigDecimal balance;


    public enum CardType {CREDIT, DEBIT}

    /**
     * Constructor factory. Return a CreditCard or DebitCard object according to parameter cardType.
     *
     * @param cardType Specifies objected type to be returned.
     * @param bank     Specifies the bank of the created card.
     * @param person   Specifies the card owner.
     * @return
     */
    public static BankCard createCard(CardType cardType, Bank bank, Person person) {

        BankCard.bank = bank;
        BankCard.person = person;

        if (cardType.equals(CardType.DEBIT)) {
            return new DebitCard();
        } else {
            return new CreditCard();
        }
    }

    /**
     * Deposit given amount to the card.
     *
     * @param value Value to be deposited.
     * @throws TransactionException Thrown if given value is zero or less.
     */
    public void deposit(BigDecimal value) throws TransactionException {
        balance.add(value);
    }

    /**
     * Withdraw the given amount from the card. Abstract function - implemented in subclasses CreditCard and DebitCard.
     *
     * @param value Value to be withdrawn.
     * @return Amount withdrawn.
     * @throws TransactionException Thrown if given value cannot be withdrawn for
     *                              various reasons - specified in subclasses.
     */
    public abstract BigDecimal withdraw(BigDecimal value) throws TransactionException;


    public Bank getBank() {
        return bank;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Person getPerson() {
        return person;
    }
}
