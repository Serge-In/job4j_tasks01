package stream.match;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 2024-03-23
 * 16. Методы проверки элементов потока на соответствие условию [#504926]
 * методами проверки элементов на соответствие заданному условию - noneMatch(), anyMatch() и allMatch()
 * Все эти методы принимают Predicate в качестве параметра (условия для проверки).
 * все 3 метода являются конечными (терминальными).
 */
public class Match {

    @Test
    public static void main() {
        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        boolean isMatch = myList.stream()
                .noneMatch("2"::contains); //возвращает true, если ни один из элементов потока не удовлетворяет условию
        System.out.println(isMatch); //true

        boolean isMatch2 = myList.stream()
                .anyMatch("2"::contains); // anyMatch() возвращает true, если как минимум один из элементов потока удовлетворяет условию.
        System.out.println(isMatch2); //false

        boolean isMatch3 = myList.stream()
                .anyMatch("a2"::contains); //anyMatch() возвращает true, если как минимум один из элементов потока удовлетворяет условию.
        System.out.println(isMatch3); //true

        boolean isMatch4 = myList.stream()
                .anyMatch(element -> element.endsWith("1")); // anyMatch() возвращает true, если как минимум один из элементов потока удовлетворяет условию.
        System.out.println(isMatch4); //true

        boolean isMatch5 = myList.stream()
                .allMatch("2"::contains); //allMatch() - возвращает true, если все элементы потока удовлетворяют условию
        System.out.println(isMatch5); //false
    }
}
