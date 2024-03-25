package stream.gpt35;

import org.testng.annotations.Test;

import java.util.stream.Stream;

/**
 * 2024-03-25
 * ответы чатбота на мои вопросы ( в яндексе не нашел ответ)
 */
public class Test1 {

    /**
     * remember me methods of java STREAM API
     * which can print each member of stream and adds prefix before fist member only
     *
     * GPT35 Answer:
     */
    @Test
    public static void main1() {
        Stream<String> stream = Stream.of("a", "b", "c", "d", "e");

        stream.peek(item -> System.out.print("Prefix: ")) // Adds prefix before the first member only
                .findFirst() // Find the first element
                .ifPresent(System.out::println); // Print the first element with prefix
        //Prefix: a

        // Print the remaining elements without prefix
        //stream.stream().forEach(System.out::println); //java.lang.IllegalStateException: stream has already been operated upon or closed
    }

    /**
     * No, this code isn't correct. The result must be like following:
     * "prefix: a b c d e"
     * GPT35 Answer:
     * In this corrected code:
     *
     * We create a Stream of strings containing elements "a", "b", "c", "d", "e".
     * We use the map() method to add a prefix "Prefix: " only before the first member of the stream.
     * We use a boolean array isFirst to track whether we are processing the first element.
     * Inside the forEach() method, we print each item with a space separator.
     */
    @Test
    public static void main2() {
        Stream<String> stream = Stream.of("a", "b", "c", "d", "e");

        // Add prefix only before the first member
        boolean[] isFirst = {true};
        stream.map(item -> isFirst[0] ? "Prefix: " + item : item)
                .forEach(item -> {
                    isFirst[0] = false;
                    System.out.print(item + " ");
                });
        //Prefix: a b c d e
    }

    /**
     * еще нашел более простое решение (среди своих опытов)
     */
    @Test
    public static void main3() {
        Stream<String> stream = Stream.of("a", "b", "c", "d", "e");
        String res = stream
                .reduce("Names:", (left, right) -> left + " " + right);

        System.out.println(res);
    }
}
