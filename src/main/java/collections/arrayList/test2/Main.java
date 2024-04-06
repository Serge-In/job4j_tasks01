package collections.arrayList.test2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Pole", 10);
        Person person2 = new Person("Bob", 12);
        Person person3 = new Person("Mike", 11);


//        // 1 добавить в список методом add
        List<Person> personList = new ArrayList<>(3);
        personList.add(person1);
        personList.add(0, person2);
        personList.add(0, person3);
        System.out.println(personList);
        //[Person{name='Mike', age=11}, Person{name='Bob', age=12}, Person{name='Pole', age=10}]
//*******************
        // 2 нельзя добавить / заменить (add / set) в список по индексу, если пред. ячейка списка пустая
        personList = new ArrayList<>();
        personList.add(1, person1);
        //Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 1, Size: 0

        personList.set(1, person1);
        //Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 1, Size: 0

        personList.set(0, person1);
        //Index 0 out of bounds for length 0
//*******************

    }
}
