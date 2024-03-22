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

    /**
     * 2024-03-22
     * 12. Выборка элементов из потока [#504925]
     * В потоке нет индексов
     * но существуют методы, которыми можно вручную ограничить диапазон перебираемых элементов - skip() и limit().
     * - skip(n) - промежуточная операция, пропускает первые n элементов с начала потока.
     * Числа, передающиеся в параметрах методов потоков, начинают отсчет с 1,
     * так как исчисляется количество элементов. (не путать с нумерацией в массиве!)
     * Параметром нельзя задать отрицательное число,
     * а если заданное значение параметра равно или превышает число элементов в исходной структуре данных, то будет возвращен пустой поток.
     */
    @Test
    public static void main8() {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        List<String> result = strings
                .stream()
                .skip(2)
                .toList();
        System.out.println(result); //[Три, Четыре, Пять]

    /**
     *  .limit(n) Этот метод перебирает элементы,
     * пока не накопит указанное количество элементов,
     * после чего завершает перебор исходной структуры данных и возвращает новый поток из собранных элементов.
     */
        result = strings
                .stream()
                .limit(1)
                .toList();
        System.out.println(result); //[Один]

    /**
     * Методы skip() и limit() можно комбинировать, чтобы выбрать определенный диапазон элементов:
     * Данный способ определения диапазона элементов часто применяется для нарезки страниц при постраничной навигации,
     * чтобы выводить только определенное их количество на сайте.
     */
        result = strings
                .stream()
                .skip(3)
                .limit(1)
                .toList();
        System.out.println(result); //[Четыре]

        result = strings
                .stream()
                .skip(strings.size() - 3) //третий элемент с конца стима
                .limit(1)
                .toList();
        System.out.println(result); //[Три]
    /**
     *  терминальной операцией в нем является метод findFirst(),
     *  который получает первое значение из получившегося после исполнения методов skip() и limit() потока.
     *  Метод findFirst() возвращает значение, обернутое в тип Optional.
     *  Optional - это просто обертка для значения, чтобы не возвращать null при отсутствии значения.
     *  метод Optional.orElse() проверяет возвращенное методом findFirst() значение типа Optional на его наличие,
     *  и если оно есть, то возвращает его, а если его нет, то возвращает значение, указанное по умолчанию.
     */
        String str = strings //тип String, но не List!
                .stream()
                .skip(2)
                .findFirst()
                .orElse("По умолчанию");
        System.out.println(str); //Три

        str = strings //тип String, но не List!
                .stream()
                .skip(5)
                .findFirst()
                .orElse("По умолчанию");
        System.out.println(str); //По умолчанию

        /**
        * получить последний элемент потока
        */
        str = strings //тип String, но не List!
                .stream()
                .skip(strings.size() - 1)
                .findFirst()
                .orElse("По умолчанию");
        System.out.println(str); //Пять
    }
}
