package stream.student.mytest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 2024-03-21
 * 8. Преобразование List в Map. [#110226]
 * опыты
 */
class Student2 {
    private int score;
    private String surname;

    public Student2(int score, String surname) {
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
        List<Student2> list = Arrays.asList(
                new Student2(30, "Ivanov"),
                new Student2(40, "Petrov"),
                new Student2(50, "Ivanov"),
                new Student2(60, "Sidorov"),
                new Student2(70, "Petrov")
        );

        //первый вариант - не работает
//        Map<String, Student2> studentMap = list.stream()
//                .collect(Collectors.toMap(Student2::getSurname, student -> student));
//        // Duplicate key Ivanov (attempted merging values Student{score=30, surname='Ivanov'} and Student{score=50, surname='Ivanov'})
//        System.out.println("\nstudentMap :" + studentMap);
//        studentMap.forEach((surname, student) ->
//                System.out.println("Surname: " + surname + ", Student: " + student));

        //второй вариант от GPT35
        Map<String, Student2> studentMap2 = list.stream()
                .collect(Collectors.toMap(
                        Student2::getSurname, // Key mapper
                        student -> student, // Value mapper
                        (existingValue, newValue) -> existingValue // Merge function
                ));
        // Print the map
        System.out.println("\nstudentMap :" + studentMap2);
        studentMap2.forEach((surname, student) ->
                System.out.println("Surname: " + surname + ", Student: " + student));

//        studentMap :{Petrov=Student{score=40, surname='Petrov'}, Sidorov=Student{score=60, surname='Sidorov'}, Ivanov=Student{score=30, surname='Ivanov'}}
//        Surname: Petrov, Student: Student{score=40, surname='Petrov'}
//        Surname: Sidorov, Student: Student{score=60, surname='Sidorov'}
//        Surname: Ivanov, Student: Student{score=30, surname='Ivanov'}
//

        //3 вариант от GPT35
        Map<String, Student2> studentMap3 = list.stream()
                .collect(Collectors.groupingBy(
                        Student2::getSurname, // Key mapper
                        Collectors.collectingAndThen(Collectors.toList(),
                                students -> students.get(0)) // Value mapper: Select the first element from the list
                ));
        // Print the map
        System.out.println("\nstudentMap3 :" + studentMap3);
        studentMap3.forEach((surname, student) ->
                System.out.println("Surname: " + surname + ", Student: " + student));
//        studentMap3 :{Petrov=Student{score=40, surname='Petrov'}, Sidorov=Student{score=60, surname='Sidorov'}, Ivanov=Student{score=30, surname='Ivanov'}}
//        Surname: Petrov, Student: Student{score=40, surname='Petrov'}
//        Surname: Sidorov, Student: Student{score=60, surname='Sidorov'}
//        Surname: Ivanov, Student: Student{score=30, surname='Ivanov'}

        //4
        Map<String, Student2> studentMap4 = list.stream()
                .collect(Collectors.toMap(
                        Student2::getSurname, // Key mapper
                        student -> student, // Value mapper
                        (existingValue, newValue) -> newValue // Merge function в мапу добавляется последнее значение с этим ключом
                ));
        // Print the map
        System.out.println("\nstudentMap4 :" + studentMap4);
        studentMap4.forEach((surname, student) ->
                System.out.println("Surname: " + surname + ", Student: " + student));
//        studentMap4 :{Petrov=Student{score=70, surname='Petrov'}, Sidorov=Student{score=60, surname='Sidorov'}, Ivanov=Student{score=50, surname='Ivanov'}}
//        Surname: Petrov, Student: Student{score=70, surname='Petrov'}
//        Surname: Sidorov, Student: Student{score=60, surname='Sidorov'}
//        Surname: Ivanov, Student: Student{score=50, surname='Ivanov'}
    }
}