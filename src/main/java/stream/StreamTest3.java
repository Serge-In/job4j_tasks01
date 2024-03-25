package stream;

import org.testng.annotations.Test;

import java.util.stream.Stream;

/**
 * 2024-03-25
 * Pipeline [#505136]
 * разные задачи для демонстрации шаблона Конвейер
 * Подобные задачи могут давать на собеседовании. При решении подобных задач стоит обратить внимание:
 * 1. Есть ли терминальным метод. Если да, то поток будет выполнен.
 * 2. Есть ли аккумуляционные методы, Если да, то поток будет собирать элементы в этом методе, а потом передавать далее.
 */
public class StreamTest3 {

    /**
     * one one ONE two two TWO three
     * Причина в том, что элементы двигаются по одному через цепочку обработчиков до аккумуляционного или терминального действия.
     * методы в Stream API делятся на два типа: энергичные или терминальные и отложенные или конвейерные.
     * oneone
     * ONE
     * twotwo
     * TWO
     * three
     */
    @Test
    public static void main1() {
        Stream.of("one", "two", "three")
                .filter(x -> {
                    System.out.print(x);
                    return x.length() <= 3;
                })
                .map(x -> {
                    System.out.println(x);
                    return x.toUpperCase();
                })
                .forEach(System.out::println);
    }

      /**
      * Есть особенность с методом sorted.
      * Sorted хоть и является отложенным, но для его вычисления ему необходимо собрать все элементы потока и потом выполнить сортировку.
       * oneone
       * twotwo
       * threeONE
       * TWO
      */
    @Test
    public static void main2() {
        Stream.of("one", "two", "three")
                .filter(x -> {
                    System.out.print(x);
                    return x.length() <= 3;
                })
                .map(x -> {
                    System.out.println(x);
                    return x.toUpperCase();
                })
                .sorted()
                .forEach(System.out::println); //Если у потока не вызван терминальным метод, то поток не будет выполнять действия.
    }

    /**
     * Метод peek и sorted является отложенным, то есть он будет выполнен только если для потока применен терминальный метод.
     * То есть код ниже ничего не выведет на консоль.
     */
    @Test
    public static void main3() {
        Stream.of("one", "two", "three")
                .peek(System.out::println)
                .sorted();
                //.forEach(System.out::println); //Если у потока не вызван терминальным метод, то поток не будет выполнять действия.
    }

    /**
     * можно выполнить поток при вызове его с терминальным методом, но отдельно:
     * вызов потока
     * one
     * two
     * three
     * [one, three, two]
     */
    @Test
    public static void main4() {
        var stream = Stream.of("one", "two", "three")
                .peek(System.out::println)
                .sorted();

        System.out.println("вызов потока");
        System.out.println(stream.toList());

    }

    /**
     Метод distinct является отложенным, но не является аккумуляционным, то есть он сразу отдает элемент следующему обработчику.
     Однако внутри он собирает все элементы в Set, чтобы проверить, что далее в потоке будут только уникальные элементы.
     one
     one
     one
     two
     two
     three
     three
     */
    @Test
    public static void main5() {
        Stream.of("one", "one", "two", "three")
                .peek(System.out::println)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     А можно ли конвейер запустить несколько раз?
     Нет. поток выполняется один раз при вызове терминального метода и удаляется.
     one
     one
     one
     two
     two
     three
     three
     */
    @Test
    public static void main6() {
       var stream =  Stream.of("one", "one", "two", "three")
                .peek(System.out::println)
                .distinct();

       stream.forEach(System.out::println);
       //stream.forEach(System.out::println); //java.lang.IllegalStateException: stream has already been operated upon or closed
    }
}
