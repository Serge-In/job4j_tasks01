package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class ListLambdaUsage {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 4, 7, 9, 12);

        // в две строки
//        UnaryOperator<Integer> operator = i -> i * i;
//        list.replaceAll(operator);

        // в одну строку
        list.replaceAll(i -> i * i);

        list.forEach(s -> System.out.println("Current number: " + s));

    }
}
