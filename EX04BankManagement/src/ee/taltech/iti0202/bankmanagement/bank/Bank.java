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
        }
        double sum = 0.0;
        double count = customers.size();
        for (Person customer : customers) {
            sum += customer.getMonthlyIncome();
        }
        return sum / count;
    }

    public double getAverageCustomerMonthlyIncome(int maxAge) {
        double sum = 0;

        if (customers.isEmpty()) {
            return 0.0;
        } else {
            Set<Person> maxAgeSet =  customers.stream()
                    .filter(person -> person.getAge() <= maxAge)
                    .collect(Collectors.toSet());
            if (!maxAgeSet.isEmpty()) {
                for (Person person : maxAgeSet) {
                    sum += person.getMonthlyIncome();
                }
                return sum / maxAgeSet.size();
            } else {
                return 0.0;
            }
        }
    }

    public double getAverageCustomerMonthlyIncome(int minAge, int maxAge) {
        double sum = 0;

        if (customers.isEmpty()) {
            return 0.0;
        } else {
            Set<Person> minMaxAge =  customers.stream()
                    .filter(person -> person.getAge() >= minAge)
                    .filter(person -> person.getAge() <= maxAge)
                    .collect(Collectors.toSet());
            if (!minMaxAge.isEmpty()) {
                for (Person person : minMaxAge) {
                    sum += person.getMonthlyIncome();
                }
                return sum / minMaxAge.size();
            } else {
                return 0.0;
            }
        }

    }

    public double getAverageCustomerMonthlyIncome(Person.Gender gender) {
        double sum = 0;

        if (customers.isEmpty()) {
            return 0.0;
        } else {
            Set<Person> genderSet =  customers.stream()
                    .filter(person -> person.getGender().equals(gender))
                    .collect(Collectors.toSet());
            if (!genderSet.isEmpty()) {
                for (Person person : genderSet) {
                    sum += person.getMonthlyIncome();
                }
                return sum / genderSet.size();
            } else {
                return 0.0;
            }
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
