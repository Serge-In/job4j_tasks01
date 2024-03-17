package stream;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 2024-03-17
 * Перевод руководства по Stream API от Benjamin Winterberg
 * <a href="https://habr.com/ru/articles/437038/">...</a>
 * Потоки представляют собой монады, которые играют важную роль в развитии функционального программирования в Java
 */
public class StreamTest1 {
    @Test
    public static void main(String[] args) {
        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    public static void main2() {
        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}
