package stream;

import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Stream;

/**
 * 2024-03-25
 * 0. Stream API улучшения [#58167]
 * В этом задании мы познакомимся с новыми методами, которые добавили в новых версиях JDK
 */
public class NewMethods {

    /**
     * Stream.takeWhile - этот метод позволяет получать поток данных до тех пор, пока условие истина
     * Результат: 1
     * Результат: 2
     * Когда поток обрабатывает число 3 условие принимает значение "ложь" и поток данных завершается.
     * Эту конструкцию удобно использовать с отсортированными данными
     */
    @Test
    public static void main1() {
        List.of(1, 2, 3, 4, 1).stream()
                .takeWhile(value -> value < 3)
                .map(value -> "Результат: " + value)
                .forEach(System.out::println);

    }

    /**
     * Stream.dropWhile - пропускает все элементы потока, пока они удовлетворяют условию.
     * При обработке первого элемента, который не удовлетворяет условию,
     * этот и все остальные элементы независимо от условия будут проходить дальше
     * Результат: 3
     * Результат: 4
     * Результат: 1
     */
    @Test
    public static void main2() {
        List.of(1, 2, 3, 4, 1).stream()
                .dropWhile(value -> value < 3)
                .map(value -> "Результат: " + value)
                .forEach(System.out::println);

    }

    /**
     * Stream.of().flatMap(Stream::ofNullable) - сделает из элемента поток, если элемент равен null, то элемент пропускается.
     * Этот метод позволяет фильтровать поток с null элементами.
     Результат: 1
     Результат: 2
     Результат: 4
     */
    @Test
    public static void main3() {
        //List.of(1, 2, null, 4, null) // не пройдет, тк лист нельзя создать с null

        Stream.of(null, 1, 2, null, 4, null)
                .flatMap(Stream::ofNullable)
                .map(value -> "Результат: " + value)
                .forEach(System.out::println);
    }

}
