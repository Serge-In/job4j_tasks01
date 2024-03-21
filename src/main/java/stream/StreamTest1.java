package stream;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        //Однако для работы с потоком вовсе не обязательно создавать коллекцию:
        //Просто используйте Stream.of() для создания потока из нескольких объектных ссылок.

        Stream.of("a1", "a2", "a3")
                .findFirst()
                .ifPresent(System.out::println);  // a1
    }

    @Test
    public static void main3() {
        //{1=1, 2=4}
        System.out.println(
                List.of(1, 1, 2, 2).stream().collect(
                        Collectors.toMap(
                                element -> element,
                                element -> element * element,
                                (existing, replacement) -> existing
                        ))
        );

        //{1=1, 2=4}
        System.out.println(
                List.of(1, 1, 2, 2).stream().collect(
                        Collectors.toMap(
                                element -> element,
                                element -> element * element,
                                (existing, replacement) -> replacement
                        ))
        );
    }

    /**
     * 2024-03-21
     * 2 метода Stream API - forEach() и peek() применяют действие ко всем элементам потока
     * peek() - это промежуточная операция. Выполняет действие для каждого элемента потока, возвращая поток, состоящий из измененных элементов
     * forEach() - это конечная операция. Выполняет действие для каждого элемента потока, завершая поток
     */
    @Test
    public static void main4() {
                List.of(1, 1, 2, 2).stream().forEach(System.out::println);
                List.of(1, 1, 2, 2).forEach(System.out::println);
                Stream.of(1, 1, 2, 2).forEach(System.out::println);
                Stream.of(1, 1, 2, 2).map(i -> i * 2).forEach(System.out::println);

        /**
         * chatGPT3.5
         * The issue with the provided Java code is that the peek operation is being used incorrectly.
         * The peek method in Java Stream API is used for performing a side-effect action on each element of the stream
         * without modifying the elements themselves. In the given code, peek is being used to perform multiplication (i * 2),
         * but since peek doesn't modify the elements of the stream, this operation won't have any effect.
         *
         * If you want to perform multiplication and print the modified values, you should use map instead of peek. Here's the corrected code:
         */
        //Stream.of(1, 1, 2, 2).peek(i -> i * 2).forEach(System.out::println);
   }

    /**
     * java отличие stream().map() от stream().peek()
     * In both cases, objects are not cloned.
     * So you could modify an object that is mutable inside of a peek function, but that is just the wrong way to do it:)
     */
    @Test
    public static void main5() {
        List<String> strings = Arrays.asList("ОДИН", "ДВА", "ТРИ");

        /**
         * When you use map, then you expect to pass a Function or UnaryOperator,
         * that receives single object and returns single object.
         * So new String that is lower-cased is returned.
         */
        strings.stream()
                .map(String::toLowerCase)
                .forEach(System.out::println); // один, два, три
        System.out.println(strings); //[ОДИН, ДВА, ТРИ] - объект не изменяется!

        /**
         * Peek expects a Consumer, so if you are using toLowerCase()
         * you are creating a new String, which is put into void.
         * You may modify this object inside of a consumer, but String is immutable, so peek has no effect.
         */
        strings.stream()
                .peek(String::toLowerCase)
                .forEach(System.out::println); //ОДИН, ДВА, ТРИ - нет эффекта!
        System.out.println(strings); //[ОДИН, ДВА, ТРИ]  - объект не изменяется!
}

    @Test
    public static void main6() {
        List<StringBuilder> names = Arrays.asList(
                new StringBuilder("Михаил"), new StringBuilder("Иван"), new StringBuilder("Елена"));
        List<StringBuilder> editedNames = names
                .stream()
                .peek((element) -> element.append(" (Ученик Job4j)"))
                .sorted()
                .toList();
        System.out.println(editedNames);
        //[Елена (Ученик Job4j), Иван (Ученик Job4j), Михаил (Ученик Job4j)]
    }

    @Test
    public static void main7() {
        List<StringBuilder> names = Arrays.asList(
                new StringBuilder("Михаил"), new StringBuilder("Иван"), new StringBuilder("Елена"));
        List<StringBuilder> editedNames = names
                .stream()
                .map((element) -> element.append(" (Ученик Job4j)"))
                .sorted()
                .toList();
        System.out.println(editedNames);
        //[Елена (Ученик Job4j), Иван (Ученик Job4j), Михаил (Ученик Job4j)]
    }
}
