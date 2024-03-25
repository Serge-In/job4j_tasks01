package search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 2024-03-14
 * 7. Функции высшего порядка [#24255]
 */
public class PhoneDictionaryFunc2Test {
    @Test
    public void whenFindByName() {
        PhoneDictionaryFunc2 phones = new PhoneDictionaryFunc2();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenFindBySurname() {
        PhoneDictionaryFunc2 phones = new PhoneDictionaryFunc2();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Arsentev");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenFindByAddress() {
        PhoneDictionaryFunc2 phones = new PhoneDictionaryFunc2();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Bryansk");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenFindByAddressAbsent() {
        PhoneDictionaryFunc2 phones = new PhoneDictionaryFunc2();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Moscow");
        assertThat(persons.size() == 0);
    }
}