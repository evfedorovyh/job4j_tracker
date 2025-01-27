package ru.job4j.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Ivan", "Petrov", "265984", "Moscow")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenDontFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Ivan", "Petrov", "265984", "Moscow")
        );
        ArrayList<Person> persons = phones.find("lex");
        assertThat(persons.isEmpty()).isTrue();
    }

    @Test
    public void whenFindBySurname() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Ivan", "Petrov", "265984", "Moscow")
        );
        ArrayList<Person> persons = phones.find("tro");
        assertThat(persons.get(0).getSurname()).isEqualTo("Petrov");
    }

    @Test
    public void whenDontFindBySurname() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Ivan", "Petrov", "265984", "Moscow")
        );
        ArrayList<Person> persons = phones.find("dor");
        assertThat(persons.isEmpty()).isTrue();
    }

    @Test
    public void whenFindByPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Ivan", "Petrov", "265984", "Moscow")
        );
        ArrayList<Person> persons = phones.find("65");
        assertThat(persons.get(0).getSurname()).isEqualTo("Petrov");
    }

    @Test
    public void whenDontFindByPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Ivan", "Petrov", "265984", "Moscow")
        );
        ArrayList<Person> persons = phones.find("111");
        assertThat(persons.isEmpty()).isTrue();
    }

    @Test
    public void whenFindByAddress() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Ivan", "Petrov", "265984", "Moscow")
        );
        ArrayList<Person> persons = phones.find("yan");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenDontFindByAddress() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Ivan", "Petrov", "265984", "Moscow")
        );
        ArrayList<Person> persons = phones.find("burg");
        assertThat(persons.isEmpty()).isTrue();
    }
}