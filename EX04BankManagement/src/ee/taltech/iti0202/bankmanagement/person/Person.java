package ee.taltech.iti0202.bankmanagement.person;

import ee.taltech.iti0202.bankmanagement.card.BankCard;
import ee.taltech.iti0202.bankmanagement.exceptions.PersonException;

import java.util.Optional;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private double monthlyIncome;
    private BankCard personBankcard;

    public enum Gender { MALE, FEMALE }

    public Person(String firstName, String lastName, int age, Gender gender, double monthlyIncome) {

        if (age < 1) {
            throw new PersonException(PersonException.Reason.AGE_MUST_BE_OVER_ZERO);
        }
        if (monthlyIncome < 0) {
            throw new PersonException(PersonException.Reason.INCOME_MUST_BE_POSITIVE);
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.monthlyIncome = monthlyIncome;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }
    
    /**
     * Return Optional.empty() if person has no bankcard.
     * @return Optional of BankCard
     */
    public Optional<BankCard> getBankCard() {
        if (personBankcard == null) {
            return Optional.empty();
        }

        return Optional.of(personBankcard);
    }

    public void setBankCard(BankCard bankCard) {
        personBankcard = bankCard;
        
    }
    
    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }
}