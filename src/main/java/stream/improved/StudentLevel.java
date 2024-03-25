package stream.improved;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 2024-03-25
 * 0. Stream API улучшения [#58167]
 * Необходимо реализовать метод List<Student> levelOf(List<Student> students, int bound);
 * Метод должен вернуть список студентов, у которых балл аттестата не меньше bound, отсортированных в обратном порядке, от большего балла к меньшему.
 * Во входящем списке могут быть null элементы.
 * Порядок действий.
 * - Используя метод filter убрать null;
 * - Отсортировать список;
 * - Используя метод takeWhile, получить нужный поток;
 * - Сохранить поток в List.
 */
public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        System.out.println("students: " + students + " bound = " + bound);
        List<Student> res = students.stream()
                .flatMap(Stream::ofNullable)
                .peek(System.out::println)
                .sorted((left, right) -> Integer.compare(right.getScore(), left.getScore()))
                .peek(System.out::println)
                .takeWhile(student -> student.getScore() >= bound)
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println("result: " + res);

        return res;
    }
}