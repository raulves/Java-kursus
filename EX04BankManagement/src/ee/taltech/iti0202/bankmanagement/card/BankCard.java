package ee.taltech.iti0202.bankmanagement.card;
import ee.taltech.iti0202.bankmanagement.bank.Bank;
import ee.taltech.iti0202.bankmanagement.exceptions.TransactionException;
import ee.taltech.iti0202.bankmanagement.person.Person;

import java.math.BigDecimal;


public abstract class BankCard {

    protected CardType cardType;
    protected Bank bank;
    protected Person person;
    protected BigDecimal balance;
    private static final BigDecimal creditCardStartingBalance = new BigDecimal(10000);


    public enum CardType {CREDIT, DEBIT
    }

    /**
     * Constructor factory. Return a CreditCard or DebitCard object according to parameter cardType.
     *
     * @param cardType Specifies objected type to be returned.
     * @param bank     Specifies the bank of the created card.
     * @param person   Specifies the card owner.
     * @return
     */
    public static BankCard createCard(CardType cardType, Bank bank, Person person) {

        if (cardType.equals(CardType.DEBIT)) {
            BankCard card = new DebitCard();
            card.bank = bank;
            card.cardType = cardType;
            card.person = person;
            card.balance = BigDecimal.ZERO;
            person.setBankCard(card);
            bank.addCustomer(person);
            return card;
        } else if (cardType.equals(CardType.CREDIT)) {
            BankCard card = new CreditCard();
            card.bank = bank;
            card.cardType = cardType;
            card.person = person;
            card.balance = creditCardStartingBalance;
            person.setBankCard(card);
            bank.addCustomer(person);
            return card;
        } else {
            return null;
        }

    }

    /**
     * Deposit given amount to the card.
     *
     * @param value Value to be deposited.
     * @throws TransactionException Thrown if given value is zero or less.
     */
    public void deposit(BigDecimal value) throws TransactionException {
        if (value.intValue() <= 0) {
            throw new TransactionException(TransactionException.Reason.DEPOSIT_MUST_BE_POSITIVE);
        }
        balance = balance.add(value);
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


    public CardType getCardType() {
        return cardType;
    }

    public Bank getBank() {
        return bank;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return cardType.toString();
    }
}
