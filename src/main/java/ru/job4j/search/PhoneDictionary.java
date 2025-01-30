package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> filterByName = person -> person.getName().contains(key);
        Predicate<Person> filterBySurname = person -> person.getSurname().contains(key);
        Predicate<Person> filterByPhone = person -> person.getPhone().contains(key);
        Predicate<Person> filterByAddress = person -> person.getAddress().contains(key);
        Predicate<Person> combine = filterByName
                .or(filterBySurname)
                .or(filterByPhone)
                .or(filterByAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
