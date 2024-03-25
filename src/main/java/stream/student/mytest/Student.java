package stream.student.mytest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 2024-03-18
 * 8. Преобразование List в Map. [#110226]
 * реализовать метод, который на вход принимает список студентов List<Student>
 * и вернет результат его преобразования в Map<String, Student>, где:
 * ключ - это фамилия студента;
 * значение - объект Student (ученик).
 * Предусмотреть в реализации исключение дубликатов,
 * поскольку ключ - это фамилия, то дубликатами будут те пары, у которых совпадают фамилии студентов.
 */
public class Student {
    private int score;
    private String surname;

    public Student(int score, String surname) {
        this.score = score;
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{"
                + "score=" + score
                + ", surname='" + surname + '\''
                + '}';
    }

    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student(30, "Ivanov"),
                new Student(40, "Petrov"),
                new Student(50, "Ivanov"),
                new Student(60, "Sidorov"),
                new Student(70, "Petrov")
        );

       // public static Map<String, Student> convert (List<Student> list)

        //Comparator<Student> compSurname = (left, right) ->  Student.getSurname().compareTo(Student.getSurname());
        //Comparator<Student> compSurname = Comparator.comparing(left -> Student.getSurname());
        //BiFunction<Student, Student, Boolean> equalsSurname = (first, second) ->  Student.getSurname().equals(Student.getSurname());
        //BiPredicate<Student, Student> equalsSurname = (first, second) ->  first.getSurname().equals(second.getSurname());
        //Predicate<Student> predicate = student -> student.getScore() >= 70;

//        School school = new School();
//        BiPredicate<Student, Student> equalsSurname = (first, second) ->  first.getSurname().equals(second.getSurname());
//        List<Student> result = school.collect(list, equalsSurname);

//        return list.stream()
//                .collect(Collectors.toMap(Student::getSurname, Student -> Student));

//        return list.stream().collect(Collectors.toSet())
//                .stream()
//                .collect(Collectors.toMap(Student::getSurname, Student -> Student));
//    }

        Map<String, Student> studentMap2 = list.stream()
                .collect(Collectors.toMap(
                        Student::getSurname, // Key mapper
                        student -> student, // Value mapper
                        (existingValue, newValue) -> existingValue // Merge function
                ));
        System.out.println(studentMap2);

//    public static void main(String[] args) {
//        List<Student> list = Arrays.asList(
//                new Student(30, "Ivanov"),
//                new Student(40, "Petrov"),
//                new Student(50, "Ivanov"),
//                new Student(60, "Sidorov"),
//                new Student(70, "Petrov")
//        );
        //Map<String, Student> result = ListToMap.convert(list);
//        System.out.println(list.stream().collect(Collectors.toSet()));//дубликаты с одинаковыми фио или очками не удаляются.
//        System.out.println(list.stream().collect(Collectors.toSet()).stream().distinct().toList());//дубликаты не удаляются.
        //System.out.println(list.stream().filter());//дубликаты не удаляются.

        //System.out.println(list.stream().collect(Collectors.toMap(Student::getSurname, Student -> Student)));//не может создать карту , тк повторяются ключи (фио).
//        Map<String, Student> expected = {
//                {"Ivanov", new Student(30, "Ivanov")},
//                {"Petrov", new Student(40, "Petrov")},
//                {"Sidorov", new Student(60, "Sidorov")}
//        }
//        System.out.println(expected);
    }
}
