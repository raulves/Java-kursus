package ee.taltech.iti0202.bankmanagement.bank;
import ee.taltech.iti0202.bankmanagement.card.BankCard;
import ee.taltech.iti0202.bankmanagement.card.CreditCard;
import ee.taltech.iti0202.bankmanagement.person.Person;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Bank {

    private String name;
    private static Set<Person> customers = new HashSet<>();

    public Bank(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Person> getCustomers() {
        return customers;
    }

    public Boolean addCustomer(Person person) {
        if (!customers.contains(person)) {
            customers.add(person);
            return true;
        }
        return false;
    }
    
    public Boolean removeCustomer(Person person){
        if (customers.contains(person)) {
            customers.remove(person);
            person.setBankCard(null);
            return true;
        }
        return false;
    }

    public double getAverageCustomerMonthlyIncome() {
        if (customers.isEmpty()) {
            return 0.0;
        } else {
            return customers.stream()
                    .collect(Collectors.averagingDouble(Person::getMonthlyIncome));
        }
    }

    public double getAverageCustomerMonthlyIncome(int maxAge) {
        if (customers.isEmpty()) {
            return 0.0;
        } else {
            return customers.stream()
                    .filter(person -> person.getAge() <= maxAge)
                    .collect(Collectors.averagingDouble(Person::getMonthlyIncome));
        }
    }

    public double getAverageCustomerMonthlyIncome(int minAge, int maxAge) {
        if (customers.isEmpty()) {
            return 0.0;
        } else {
            return customers.stream()
                    .filter(person -> person.getAge() >= minAge)
                    .filter(person -> person.getAge() <= maxAge)
                    .collect(Collectors.averagingDouble(Person::getMonthlyIncome));
        }

    }

    public double getAverageCustomerMonthlyIncome(Person.Gender gender) {
        if (customers.isEmpty()) {
            return 0.0;
        } else {
            return customers.stream()
                    .filter(person -> person.getGender() == Person.Gender.FEMALE)
                    .collect(Collectors.averagingDouble(Person::getMonthlyIncome));
        }
    }

    public Set<Person> getAllCustomersWithCreditCards() {

        return customers.stream().filter(person -> person.getBankCard().isPresent())
                .filter(person -> person.getBankCard().get().getCardType().equals(BankCard.CardType.CREDIT))
                .collect(Collectors.toSet());
    }

    public Set<Person> getAllCustomersWithDebitCards() {
        return customers.stream().filter(person -> person.getBankCard().isPresent())
                .filter(person -> person.getBankCard().get().getCardType().equals(BankCard.CardType.DEBIT))
                .collect(Collectors.toSet());
    }

    public Optional<Person> getRichestCustomerByGender(Person.Gender gender) {
        return null;
    }
    
    @Override
    public String toString() {
        return getName();
    }
}
