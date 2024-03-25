package search;

import java.util.ArrayList;

/**
 * 2023-12-22
 * 4. Телефонный справочник на базе ArrayList [#41598]
 * Вернуть список всех пользователей, который содержат key в любых полях.
 * param key Ключ поиска.
 * return Список пользователей, которые прошли проверку.
 */

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getName().contains(key)
                    || person.getSurname().contains(key)
                    || person.getPhone().contains(key)
                    || person.getAddress().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}