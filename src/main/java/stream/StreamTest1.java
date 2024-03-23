package stream;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

    /**
     * 2024-03-22
     * 13. Методы преобразования потоков объектов в потоки примитивы и наоборот [#504927]
     * В этом уроке будут рассмотрены методы mapToInt(), flatMapToInt() и mapToObj().
     */
    @Test
    public static void main9() {
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        /**
         * mapToInt() - преобразовывает поток объектов в поток примитивных чисел типа int.
         * Является промежуточной операцией.
         * Применяется, если исходящий поток состоит из элементов-объектов,
         * а в результате их обработки будет получен примитивный тип int.
         * Метод mapToInt возвращает объект интерфейса IntStream (числовой поток),
         * который в дальнейшем обрабатывается как поток примитивных чисел.
         */
        List<Integer> res = strings.stream()
                .mapToInt(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .boxed()
                .toList();
        System.out.println(res); //[2, 4]

        /**
         * Since Java 16 we can use the method mapMulti(BiConsumer) of the Stream API.
         * This method allows us to map each element of the stream to multiple elements.
         * We can also do that with the flatMap(Function) method, but if we want to map a limited set of elements, mapMulti is more convenient.
         * Internally a shared stream is used and we don’t have the cost of creating a new stream for each element.
         * Another use case is if the logic to map an element to multiple elements is complex and is hard to implement by returning a stream.
         * Then mapMulti allows us to write that logic in a BiConsumer instead of a Function.
         * https://blog.jdriven.com/2023/07/java-joy-using-mapmulti-method-of-the-stream-api/
         */
        assert Stream.of("Java", "Groovy", "Clojure")
                .mapMulti((language, downstream) -> {
                    if (language.contains("o")) {
                        downstream.accept(language);
                        downstream.accept(language.toUpperCase());
                        downstream.accept(language.length());
                    }
                })
                .toList()
                .equals(List.of("Groovy", "GROOVY", 6, "Clojure", "CLOJURE", 7)); //test passed

        // Same logic implemented with flatMap.
        assert Stream.of("Java", "Groovy", "Clojure")
                .filter(language -> language.contains("o"))
                .flatMap(language -> Stream.of(language, language.toUpperCase()))
                .toList()
                .equals(List.of("Groovy", "GROOVY", "Clojure", "CLOJURE")); //test passed

        // We want to expand each number to itself and its square root value
        // and we muse mapMultiToInt here.
        var summaryStatistics = Stream.of(1, 2, 3)
                .mapMultiToInt((number, downstream) -> {
                    downstream.accept(number);
                    downstream.accept(number * number);
                })
                .summaryStatistics();
        System.out.println(summaryStatistics);
        //IntSummaryStatistics{count=6, sum=20, min=1, average=3,333333, max=9}

        assert summaryStatistics.getCount() == 6;
        assert summaryStatistics.getSum() == 20;
        assert summaryStatistics.getMin() == 1;
        assert (int) summaryStatistics.getAverage() == 3;
        assert summaryStatistics.getMax() == 9;

    }

    /**
     * В строке ниже метод mapToInt() преобразует поток Person в поток int:
     * Класс Stream помимо метода mapToInt() также имеет аналогичные ему методы
     * mapToDouble() и mapToLong(), работающие с Double и Long типами соответственно.
     */
    @Test
    public static void main10() {
        record Person(String name, Integer age) {
        }

        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );

        int sum = people.stream()
                .filter(element -> element.age() > 25)
                .mapToInt(Person::age)
                .peek(System.out::println) // 35 26 29
                .sum();
        System.out.println("Сумма: " + sum); //Сумма: 90

    }

    /**
     * - flatMapToInt() - трансформирует поток массивов в поток примитивных чисел int.
     * Работает как mapToInt(), но возвращает не одно преобразованное в int значение, а поток примитивов int.
     * Является промежуточной операцией.
     */
    @Test
    public static void main11() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        int[] array3 = {7, 8, 9};

        /**
         * запускаем поток, состоящий из 3 массивов
         * Далее метод flatMapToInt() преобразует каждый элемент потока (массив) в поток примитивных чисел int
         * в результате чего все элементы этих массивов объединяются в один общий поток примитивных чисел int
         * примитивные числа не являются объектами, поэтому для того,
         * чтобы собрать в List наш поток элементов типа int, нужно обернуть их в тип Integer.
         * Это можно сделать с помощью метода boxed()
         * Класс Stream помимо метода flatMapToInt()
         * также имеет аналогичные ему методы flatMapToDouble() и flatMapToLong(),
         * работающие с Double и Long типами соответственно.
         */
        List<Integer> list = Stream.of(array1, array2, array3)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(list); //[1, 2, 3, 4, 5, 6, 7, 8, 9]
    }

    /**
     * - mapToObj() - преобразует поток примитивных чисел в поток объектов. Является промежуточной операцией.
     * IntStream.rangeClosed(1, 5) создается поток из примитивных чисел int от 1 до 5 включительно
     * метод mapToObj() преобразует все элементы потока примитивного тип int в строки типа String.
     */
    @Test
    public static void main12() {
        List<String> list = IntStream.rangeClosed(1, 5)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());
        System.out.println(list); //[1, 2, 3, 4, 5]
    }

    /**
     * 14. Агрегатные методы min(), max(), count(), average(), sum() [#504928]
     * в этом уроке мы познакомимся с агрегатными методами потоков - min(), max(), count(), average() и sum().
     * Агрегация - это вычисления, строящиеся на всех элементах исходной структуры данных,
     * в результате которых получается единое значение.
     * Например, среднее арифметическое, сумма чисел и т.д. Агрегацию еще называют сведением.
     * В строке ниже метод min() вычисляет минимальное значение с помощью переданного нами компаратора сравнения объектов по возрастанию.
     */
    @Test
    public static void main13() {
        List<Integer> list = Arrays.asList(4, 5, 1, 3, 2);
        Optional<Integer> minEl = list.stream()
                .min(Comparator.naturalOrder());
        System.out.println(minEl.get()); //1
    }

    /**
     * Компаратор нужно передавать, чтобы метод понимал по какому принципу сравнивать объекты.
     * Если метод min() применяется к потоку примитивных чисел, то можно использовать его без компаратора:
     * В данном примере мы запустили поток примитивных чисел типа int с помощью метода rangeClosed()
     * Обратите внимание, что метод min() здесь возвращает тип OptionalInt.
     * Optional - это обертка для значения, чтобы в случае его отсутствия вернулся не null,
     * а пустая обертка Optional. В нашем случае OptionalInt - это обертка для примитивного типа int,
     * из этой обертки мы получаем само значение с помощью метода getAsInt().
     * Optional - это просто обертка для значения, чтобы не возвращать null при отсутствии значения.
     * метод Optional.orElse() проверяет возвращенное методом findFirst() значение типа Optional на его наличие,
     * и если оно есть, то возвращает его, а если его нет, то возвращает значение, указанное по умолчанию.
     */
    @Test
    public static void main14() {
        OptionalInt min = IntStream
                .rangeClosed(3, 5)
                .min();

        System.out.println(min); //OptionalInt[3]
        System.out.println(min.getAsInt()); //3
        System.out.println(min.isPresent()); //true
    }

    /**
     * В строке ниже мы передаем в метод min() компаратор, который задает принцип поиска по значению поля age.
     * Метод min() возвращает значение типа Optional, поэтому в следующей строке мы получаем объект Person из обертки Optional и далее получаем его возраст:
     */
    @Test
    public static void main15() {
        record Person(String name, int Age) { }

        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        Optional<Person> youngestPerson = people.stream()
                .min(Comparator.comparing(Person::Age)); //Метод min() возвращает значение типа Optional
        int age = youngestPerson.get().Age(); //получаем объект Person из обертки Optional и далее получаем его возраст

        System.out.println(age); //16

        var statisticsPerson = people.stream()
                //.flatMapToInt(person -> person.Age) // не работает
                .mapToInt(person -> person.Age) //
                .summaryStatistics();
        System.out.println(statisticsPerson); //IntSummaryStatistics{count=5, sum=126, min=16, average=25,200000, max=35}
        System.out.println(statisticsPerson.getClass()); //class java.util.IntSummaryStatistics
        System.out.println(statisticsPerson.getClass().getSimpleName()); //IntSummaryStatistics
        System.out.println(statisticsPerson.getAverage()); //25.2

        OptionalDouble average = people.stream()
                .mapToInt(Person::Age)
                .average(); //Метод average() возвращает OptionalDouble
        double result = average.getAsDouble(); //25.2
        System.out.println(result);

        int sum = people.stream()
                .mapToInt(Person::Age)
                .sum();
        System.out.println(sum); //126
    }

    @Test
    public static void main16() {
        record Person(String name, int Age) { }
            List<Person> people = Arrays.asList(
                    new Person("Михаил", 35),
                    new Person("Ольга", 26),
                    new Person("Антон", 20),
                    new Person("Виктор", 16),
                    new Person("Анна", 29)
            );
            IntSummaryStatistics statisticsPerson = people.stream()
                    .mapToInt(Person::Age)
                    .summaryStatistics();

            System.out.println("Statistics for Age:");
            System.out.println("Max: " + statisticsPerson.getMax());
            System.out.println("Min: " + statisticsPerson.getMin());
            System.out.println("Sum: " + statisticsPerson.getSum());
            System.out.println("Average: " + statisticsPerson.getAverage());
            System.out.println("Count: " + statisticsPerson.getCount());
    }

    /**
     * 2024-03-23
     * 15. Агрегатный метод reduce() [#504929]
     * Метод reduce() применяет операцию ко всем элементам потока.
     * В этом методе понятие агрегации обобщается, так как в нем можно самостоятельно задать критерий для получения значения.
     * Метод является терминальным
     * Метод reduce() имеет 3 формы
     * - reduce(BinaryOperator<T> accumulator) -  стандартный вариант метода reduce().
     * В строке ниже мы передаем BinaryOperator в метод reduce().
     * .reduce((left, right) -> left + right);
     * (left, right) - это первые 2 элемента потока, left + right - это действие, которое нужно применить к этим элементам
     *
     */
    @Test
    public static void main17() {
        record Person(String name, int Age) { }
        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        OptionalInt sumOfAges = people.stream()
                .mapToInt(Person::Age)
                .reduce(Integer::sum);
        System.out.println("sum of ages: " + sumOfAges.getAsInt()); //sum for Ages: 126

        Optional<String> text = people.stream()
                .map(Person::name)
                .reduce(String::concat);
        System.out.println("Concat of names: " + text.get()); //Concat od names: МихаилОльгаАнтонВикторАнна

        Optional<String> text2 = people.stream()
                .map(Person::name)
                .reduce((name1, name2) -> new StringBuilder().append(name1).append(" ").append(name2).toString());
        System.out.println("Concat of names: " + text2.get()); //Concat of names: Михаил Ольга Антон Виктор Анна

        Optional<String> text3 = people.stream()
                .map(Person::name)
                .reduce((name1, name2) -> name1 + " " + name2);
        System.out.println("Concat of names: " + text3.get()); //Concat of names: Михаил Ольга Антон Виктор Анна
    }

    /**
     * - reduce(T identity, BinaryOperator<T> accumulator) -
     * эта версия метода похожа на предыдущую,
     * только в BinaryOperator первым параметром будет identity - значение,
     * к которому будет применяться второй элемент в функции.
     * Если поток будет пуст, то identity останется значением по умолчанию.
     * Данная форма метода возвращает само значение (T).
     * На этот раз первым параметром будем выступать указанный identity,
     * который складывается с первым элементом (left + right) -> identity + right,
     * на следующем шаге первым параметром в BinaryOperator
     * будет сумма этих элементов, которая будет складываться уже со вторым элементом потока,
     */
    @Test
    public static void main18() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        int sum = nums.stream()
                .reduce(10, (left, right) -> left + right); // 10 + 1 + 2 + 3 + 4
        System.out.println(sum); // 20

        List<String> names = Arrays.asList("Михаил", "Ольга", "Антон", "Виктор", "Анна");
        String concat = names.stream()
                .reduce("Names:", (left, right) -> left + " " + right);
        System.out.println(concat); // Names: Михаил Ольга Антон Виктор Анна
    }

    /**
     * - reduce (U identity, BiFunction<U, ? super T,U> accumulator, BinaryOperator<U> combiner)
     * если нам нужно вернуть тип данных, отличный от входящего, то нужно использовать эту версию метода reduce()
     * accumulator здесь позволяет выполнить промежуточное действие над элементами потока
     * после чего к ним будет применена агрегатная операция combiner
     * комбинации методов map() и второй формы reduce()
     * Если в потоке не будет элементов, заданный identity будет выведен как значение по умолчанию
     * Важно! Полноценная работа этой версии метода reduce(),
     * а точнее работа combiner раскрывается только при выполнении вычислений потока (stream) в многопоточной среде.
     * каждое вычисление accumulator будет выполняться отдельно, после чего combiner сведёт полученные результаты указанным способом
     */
    @Test
    public static void main19() {
        record Person(String name, int Age) { }
        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        int sum = people.stream()
                .reduce(
                        0,
                        (left, right) -> {
                            if (right.Age() > 25) {
                                return left + right.Age();
                            } else {
                                return left;
                            }
                        },
                        (left, right) -> left + right
                );
        System.out.println(sum); // 35 + 26 + 29 = 90

        //При использовании просто stream combiner вообще никак не используется.
        // Можно возвращать хоть 0. Результат будет корректный. Пример:
        int sum2 = people.stream()
                .reduce(
                        0,
                        (left, right) -> {
                            int res = left;
                            if (right.Age() > 25) {
                                res += right.Age();
                            }
                            System.out.println("left: " + left + ", right: " + right + ", result: " + res); //эта строка выполняется
                            return res;
                        },
//                        (left, right) -> left + right
// строку заменим на следующую, результат не меняется
                        (left, right) -> {
                            int res = left + right;
                            System.out.println("left: " + left + ", right: " + right + ", result: " + res); //эта строка НЕ выполняется
                            return 0;
                        }
                );
        System.out.println(sum2); // 35 + 26 + 29 = 90
//        left: 0, right: Person[name=Михаил, Age=35], result: 35
//        left: 35, right: Person[name=Ольга, Age=26], result: 61
//        left: 61, right: Person[name=Антон, Age=20], result: 61
//        left: 61, right: Person[name=Виктор, Age=16], result: 61
//        left: 61, right: Person[name=Анна, Age=29], result: 90
//        90
    }

/**
 * Отличие выполнения .stream() от .parallelStream()
 */
@Test
public static void main20() {
    record Person(String name, int Age) { }
    List<Person> people = Arrays.asList(
            new Person("Михаил", 35),
            new Person("Ольга", 26),
            new Person("Антон", 20),
            new Person("Виктор", 16),
            new Person("Анна", 29)
    );
    int sum2 = people.parallelStream()
            .reduce(
                    0,
                    (left, right) -> {
                        int res = left;
                        if (right.Age() > 25) {
                            res += right.Age();
                        }
                        System.out.println("left: " + left + ", right: " + right + ", result: " + res); //эта строка выполняется
                        return res;
                    },
//                     (left, right) -> left + right
// строку заменим на следующее, итог тот же (90)
                    (left, right) -> {
                        int res = left + right;
                        System.out.println("left: " + left + ", right: " + right + ", result: " + res); //эта строка выполняется
                        return res;
                    }
            );
    System.out.println(sum2); //
    //порядок выполнения потоков любой!
//    left: 0, right: Person[name=Виктор, Age=16], result: 0
//    left: 0, right: Person[name=Ольга, Age=26], result: 26
//    left: 0, right: Person[name=Антон, Age=20], result: 0
//    left: 0, right: Person[name=Михаил, Age=35], result: 35
//    left: 0, right: Person[name=Анна, Age=29], result: 29
//    left: 0, right: 29, result: 29
//    left: 0, right: 29, result: 29
//    left: 35, right: 26, result: 61
//    left: 61, right: 29, result: 90
//    90

    /**
     * Текст задания: identity, равный 0, так как суммировать будем с нуля. Но это нечто другое.
     * Если использовать просто stream а не parallelStream c identity=1 то результат будет 91, а тоже самое  parrallelStream - 95).
     * Из документации:
     * Значение identity должно быть тождеством для функции accumulator. Это означает, что для всех t значение accumulator.apply(identity, t) равно t.
     */
    int sum3 = people.parallelStream()
            .reduce(
                    1,
                    (left, right) -> {
                        int res = left;
                        if (right.Age() > 25) {
                            res += right.Age();
                        }
                        System.out.println("left: " + left + ", right: " + right + ", result: " + res); //эта строка выполняется
                        return res;
                    },
//                     (left, right) -> left + right
// строку заменим на следующее, итог тот же (90)
                    (left, right) -> {
                        int res = left + right;
                        System.out.println("left: " + left + ", right: " + right + ", result: " + res); //эта строка выполняется
                        return res;
                    }
            );
    System.out.println(sum3); //
    //порядок выполнения потоков любой!
//    left: 1, right: Person[name=Ольга, Age=26], result: 27
//    left: 1, right: Person[name=Михаил, Age=35], result: 36
//    left: 1, right: Person[name=Анна, Age=29], result: 30
//    left: 1, right: Person[name=Антон, Age=20], result: 1
//    left: 36, right: 27, result: 63
//    left: 1, right: Person[name=Виктор, Age=16], result: 1
//    left: 1, right: 30, result: 31
//    left: 1, right: 31, result: 32
//    left: 63, right: 32, result: 95
//    95
    }
}