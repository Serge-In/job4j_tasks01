package search;


import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 2024-03-14
 * 7. Функции высшего порядка [#24255]
 * Есть список абонентов. Нужно их отфильтровать по ключу
 * Метод поиска должен фильтровать все поля модели. Если изменится модель, то нам нужно будет дописать условия.
 * Допишите метод find с использованием функции высшего порядка
 * UPD 2024-03-14
 * создаем 4 Predicate, каждый проверяет одно поле объекта,
 * потом создаем пятый предикат который объединит 4 предыдущих с помощью метода or()
 */
public class PhoneDictionaryFunc2 {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {

//        BiPredicate<String, Person> name = (x, y) -> x.equals(y.getName());
//        BiPredicate<String, Person> surname = (x, y) -> x.equals(y.getSurname());
//        BiPredicate<String, Person> phone = (x, y) -> x.equals(y.getPhone());
//        BiPredicate<String, Person> address = (x, y) -> x.equals(y.getAddress());

        Predicate<Person> name = (person) -> person.getName().contains(key);
        Predicate<Person> surname = (person) -> person.getSurname().contains(key);
        Predicate<Person> phone = (person) -> person.getPhone().contains(key);
        Predicate<Person> address = (person) -> person.getAddress().contains(key);

        Predicate<Person> combine = name.or(surname).or(phone).or(address);

        //применение предиката через стрим вариант 1
//        List<Person> list = persons.stream().filter(combine).collect(Collectors.toList());
//        ArrayList<Person> result = new ArrayList<>(list);

        //применение предиката через стрим вариант 2
//        List<Person> list = persons.stream().filter(combine).toList();
//        ArrayList<Person> result = new ArrayList<>(list);

        //применение предиката через стрим в одну строку вариант 3
        ArrayList<Person> result = new ArrayList<>(persons.stream().filter(combine).toList());

        //применение предиката через цикл вариант 4
//        ArrayList<Person> result = new ArrayList<>();
//        for (Person person : persons) {
//            if (combine.test(person)) {
//                result.add(person);
//            }
//        }

        return result;
    }
}
