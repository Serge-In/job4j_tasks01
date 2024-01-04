package collections.test4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 2024-01-04
 * 0. Сортировка [#10096]
 * В Java большинство коллекций поддерживает метод Collections.sort, который позволяет отсортировать коллекцию.
 */

public class Sort {
    public static void main(String[] args) {
        /**
         * Java производит сортировку по возрастанию. Внутри метода sort осуществляется сортировка методом слияния.
         * Чтобы использовать алгоритм слияния, сортируемый тип данных должен поддерживать интерфейс java.util.Comparable.
         * Все встроенные типы данных поддерживают этот интерфейс.
         */
        List<Integer> list = Arrays.asList(5, 3, 4, 1, 2);
        System.out.println(list); //[5, 3, 4, 1, 2]
        Collections.sort(list);
        System.out.println(list); //[1, 2, 3, 4, 5]

        /**
         * int first = 1; у примитивных типов нет интерфейса Comparable
         * Интерфейс Comparable имеет всего один метод compareTo(T t). Этот метод возвращает меньше нуля, ноль, больше нуля.
         */
        Integer first = 1;
        Integer second = 2;
        System.out.println(first.compareTo(second)); // -1
        System.out.println(second.compareTo(second)); // 0
        System.out.println(second.compareTo(first)); // 1

        /**
         * При сравнении каждая строка раскладывается на массив символов, которые в свою очередь преобразуются в массив чисел.
         * Дальше Java по очереди сравнивает каждую ячейку массива. Если вычисление дает результат 0,
         * то вычисление повторяется для следующей пары, пока не дойдет до конца или пока результат не станет отличен от 0.
         */
        String petr = "Petr"; //{P, e, t, r} -> {80, 101, 116, 114}
        String ivan = "Ivan"; //{I, v, a, n} -> {73, 118, 100, 110}
        int resultString = petr.compareTo(ivan); // 80 - 73 = 7
        System.out.println(resultString); // 7

        /**
         * Сортировка по убыванию
         *
         * Через интерфейс java.util.Comparable мы можем задать только один порядок сортировки.
         * Чтобы сделать другой порядок, в Java есть интерфейс, который не привязан к модели данных.
         * Это интерфейс java.util.Comparator.
         * В нем есть метод int compare(T first, T second), который принимает сразу два параметра.
         * Для всех встроенных типов Integer, String и т.д. в Java есть готовые классы, реализующие этот интерфейс.
         * В классе java.util.Collections есть класс
         * public static <T> Comparator<T> reverseOrder()
         * Чтобы воспользоваться этим классом, в метод sort с коллекцией передается объект Comparator.
         */
        List<Integer> list1 = Arrays.asList(5, 3, 4, 1, 2);
        System.out.println("list1 :" + list1); // list1 :[5, 3, 4, 1, 2]
        Collections.sort(list1, Collections.reverseOrder());
        System.out.println("Collections.sort(list1, Collections.reverseOrder()) :" + list1); //Collections.sort(list1, Collections.reverseOrder()) :[5, 4, 3, 2, 1]

    }
}
