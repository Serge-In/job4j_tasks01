package stream;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 2024-03-17
 * 2. Типы методов Stream API [#504923]
 */
public class StreamTest2 {
    @Test
    public static void main(String[] args) {
        List<Integer> myList =
                Arrays.asList(1, 2, 4);
        System.out.println(myList);

        myList.stream()
                .mapToDouble(x -> (double) x)
                .forEach(System.out::println);
        System.out.println(myList);
        return;
    }
}
