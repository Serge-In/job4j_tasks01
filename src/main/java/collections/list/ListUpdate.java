package collections.list;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024-04-05
 * 0.1. Интерфейс List [#4953]
 */
public class ListUpdate {
    /**
     * 3. Изменение элементов в списке
     * E set(int index, E element) - вернет элемент, подлежащий замене
     */
    @Test
    public static void main() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4 ; i++) {
            list.add(i+1);
        }
        System.out.println(list.set(2, 10)); // 3
        System.out.println(list); //[1, 2, 10, 4]
    }

    /**
     * default void replaceAll(UnaryOperator<E> operator)
     * – заменяет каждый элемент в списке результатом применения оператора (operator) к каждому элементу.
     */
    @Test
    public static void main1() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4 ; i++) {
            list.add(i+1);
        }
        System.out.println(list); //[1, 2, 10, 4]
        list.replaceAll(Integer::reverse);
        System.out.println(list); //[-2147483648, 1073741824, -1073741824, 536870912]
        list.replaceAll(Integer::reverse);
        System.out.println(list); //[1, 2, 10, 4]
    }
}