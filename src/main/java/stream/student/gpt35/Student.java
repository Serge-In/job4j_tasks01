package stream.student.gpt35;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 2024-03-19
 * Prompt for GPT35:
 *
 * This is the List which contains 5 objects.
 * Each object in List have two fields: Score and Surname:
 * List<Student> list = Arrays.asList(
 *                 new Student(30, "Ivanov"),
 *                 new Student(40, "Petrov"),
 *                 new Student(50, "Ivanov"),
 *                 new Student(60, "Sidorov"),
 *                 new Student(70, "Petrov")
 * 1) Write the java code, which return Map<String, Student>, where Key=Surname and value = Student
 * 2) use Stream.Api
 */
class Student {
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

        //первый вариант от GPT35
//        Map<String, Student> studentMap = list.stream()
//                .collect(Collectors.toMap(Student::getSurname, student -> student));
//        // Print the map
//        studentMap.forEach((surname, student) ->
//                System.out.println("Surname: " + surname + ", Student: " + student));

        //Prompt:
        //this code return
        //Exception in thread "main" java.lang.IllegalStateException:
        // Duplicate key Ivanov (attempted merging values Student{score=30, surname='Ivanov'} and Student{score=50, surname='Ivanov'})


        //второй вариант от GPT35
        Map<String, Student> studentMap2 = list.stream()
                .collect(Collectors.toMap(
                        Student::getSurname, // Key mapper
                        student -> student, // Value mapper
                        (existingValue, newValue) -> existingValue // Merge function
                ));
        // Print the map
        studentMap2.forEach((surname, student) ->
                System.out.println("Surname: " + surname + ", Student: " + student));
        //СРАБОТАЛО!!!

        //3 вариант от GPT35
        Map<String, Student> studentMap3 = list.stream()
                .collect(Collectors.groupingBy(
                        Student::getSurname, // Key mapper
                        Collectors.collectingAndThen(Collectors.toList(),
                                students -> students.get(0)) // Value mapper: Select the first element from the list
                ));
        // Print the map
        studentMap3.forEach((surname, student) ->
                System.out.println("Surname: " + surname + ", Student: " + student));
        //СРАБОТАЛО!!!
    }
}
