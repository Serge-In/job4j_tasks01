package aston;

import org.hamcrest.core.IsInstanceOf;
import org.junit.jupiter.api.Test;

/**
 * 2024-01-25
 * тестовые задания см. тестовый класс
 */
public class TestAston {

    // Какой результат работы данного кода?
    //System.out.println(arr[2]);
    @Test
    void test2() {
        int[] arr = new int[3]; // создать массив {0, 0, 0}
        System.out.println(arr[2]);// 0

        //***
        System.out.println(arr); //[I@3c87521
        for (int i : arr ) {
            System.out.println(i); // 0 0 0
        }

    }

    // Какой результат работы данного кода?
    @Test
    void test3() {
        String test = new String("Hello!");
        String test2 = new String("Hello!");
        System.out.println(test==test2); //false
        System.out.println("test==test2 : " + test==test2); //false
        System.out.println("test2.getClass() : " + test2.getClass());

        String test3 = "Hello!";
        String test4 = "Hello!";
        System.out.println(test3==test4); //true
        System.out.println("test3==test4 : " + test3==test4); //false
        System.out.println("test4.getClass() : " + test4.getClass());

    }
}
