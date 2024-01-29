package datatypes;

import org.junit.jupiter.api.Test;

/**
 * 2024-01-26
 * тесты массивов
 */
public class ArraysTest {

    @Test
    void test1() {
        int[] arr = new int[3]; // создать массив {0, 0, 0}
        System.out.println(arr[2]);// 0

        //***
        System.out.println(arr); //[I@3c87521
        for (int i : arr) {
            System.out.println(i); // 0 0 0
        }

    }

    // Какой результат работы данного кода?
    @Test
    void test3() {

    }
}