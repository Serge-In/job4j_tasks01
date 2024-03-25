package search;

import java.util.ArrayList;
import java.util.function.BiPredicate;

/**
 * 2024-03-13
 * 7. Функции высшего порядка [#24255]
 * Есть список абонентов. Нужно их отфильтровать по ключу
 * Метод поиска должен фильтровать все поля модели. Если изменится модель, то нам нужно будет дописать условия.
 * Допишите метод find с использованием функции высшего порядка
 */
public class PhoneDictionaryFunc {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {

        BiPredicate<String, String> combine = (x, y) -> x.equals(y);

        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person.getName(), key)
                    || combine.test(person.getSurname(), key)
                    || combine.test(person.getPhone(), key)
                    || combine.test(person.getAddress(), key)) {
                result.add(person);
            }
        }
        return result;
    }
}