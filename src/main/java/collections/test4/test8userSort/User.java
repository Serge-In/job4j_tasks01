package collections.test4.test8userSort;

import java.util.Objects;

/**
 * 2024-01-07
 * 1. Организовать сортировку User [#10034]
 * 1. В этом задании нужно осуществить сортировку для модели данных ru.job4j.collection.User. В этой модели должны быть поля:
 * - name с типом String;
 * - age с типом int.
 * Класс User должен реализовать интерфейс Comparable
 *
 * В классе User нужно реализовать метод compareTo:
 *
 *Очень Важно!!! Метод должен сравнивать имена и в случае их равенства,
 * метод должен вернуть результат сравнения возраста. Для реализации вам понадобятся
 * - метод compareTo(), который определен в классе String для сравнения имен;
 * - метод Integer.compare(), который будет необходим для сравнения возрастов.
 * В модели User также реализованы методы equals и hashCode.
 * Они нужны для тестов, где мы используем методы сравнения моделей user.equals.
 *
 * 07.01.2024 1:08:14
 * Возникли вопросы по этому заданию:
 * 1.	Нужны в этом задании геттеры полей name, age?
 * 2.	Почему без геттеров методы
 * this.name.compareTo(anotherUser.name)
 * Integer.compare(this.age, anotherUser.age)
 * все равно работают даже с приватными полями name, age
 *
 * 3.	Почему
 * this.name.compareTo(anotherUser.name);
 * - Работает на приватных полях, но
 *
 * this.getAge().compareTo(anotherUser.age);
 * - требует вызыва на геттере, а на поле не вызывается
 *
 */

public class User implements Comparable<User> {
    private String name;

    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

//    @Override
//    public int compareTo(User left, User right) {
//        if (left.name != right.name) {
//            return left.getName().compareTo(right.getName());
//        } else {
//            //return Integer.compare(left.age, right.age);
//            return left.getAge().compareTo(right.getAge());
//        }
//    }

//    @Override
//    public int compareTo(User anotherUser) {
//        if (this.name != anotherUser.name) {
//            return this.getName().compareTo(anotherUser.getName());
//        } else {
//            return this.getAge().compareTo(anotherUser.getAge());
//        }
//    }

//    @Override //ok
//    public int compareTo(User anotherUser) {
//        if (this.name != anotherUser.name) {
//            return this.name.compareTo(anotherUser.name);
//        } else {
//            return this.getAge().compareTo(anotherUser.age);
//        }
//    }

    @Override //тоже работает
    public int compareTo(User anotherUser) {
        if (this.name != anotherUser.name) {
            return this.name.compareTo(anotherUser.name);
        } else {
            return Integer.compare(this.age, anotherUser.age);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age
                && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

}
