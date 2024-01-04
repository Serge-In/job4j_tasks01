package collections.arrayList.test3;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Pole", 10);
        Person person2 = new Person("Bob", 12);
        Person person3 = new Person("Mike", 11);

        Map<Integer, Person> mapPersons = new HashMap<>();
        mapPersons.put(1, person2);
        mapPersons.put(0, person3);
        mapPersons.put(0, person1);
        mapPersons.put(2, person3);
        System.out.println(mapPersons); //--> {0=Person{name='Pole', age=10}, 1=Person{name='Bob', age=12}, 2=Person{name='Mike', age=11}}

        Map<Person, Integer> mapPersonsID = new HashMap<>();
        mapPersonsID.put(person2, 1);
        mapPersonsID.put(person3, 0);
        mapPersonsID.put(person1, 0);
        mapPersonsID.put(person3, 2);

        System.out.println(mapPersonsID.size()); // --> 3

        System.out.println(mapPersonsID);               // --> {Person{name='Bob', age=12}=1, Person{name='Mike', age=11}=2, Person{name='Pole', age=10}=0}
        System.out.println(mapPersonsID.entrySet());    // --> [Person{name='Bob', age=12}=1, Person{name='Mike', age=11}=2, Person{name='Pole', age=10}=0]

        System.out.println(mapPersonsID.values()); // --> [1, 2, 0]

        System.out.println(mapPersonsID.getOrDefault(person3, 1)); // --> 2

        System.out.println(mapPersonsID.hashCode()); // --> -800188985

        System.out.println(mapPersonsID.keySet()); // -->[Person{name='Bob', age=12}, Person{name='Mike', age=11}, Person{name='Pole', age=10}]

        System.out.println(mapPersonsID.get(person1)); // --> 0

        System.out.println(mapPersonsID.containsKey(1)); // --> false
        System.out.println(mapPersonsID.containsKey(person3)); // --> true

        System.out.println(mapPersonsID.containsValue(2)); // --> true
    }
}
