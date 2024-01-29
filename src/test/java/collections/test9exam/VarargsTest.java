package collections.test9exam;

import org.junit.jupiter.api.Test;
import java.text.MessageFormat;
import java.util.Date;

/**
 * 2024-01-25
 * 1 public static void main(String… args) vs
 * 2 public static void main(String[] args) vs
 * 3 public static void main(String args []) (it's just another valid way to declare an array.)
 * 2 & 3 - is the same
 * 1. String… args - > Varargs
 */
class VarargsTest {
    @Test
    public static void main(String... arg) {
        System.out.println("main1");
        String result = MessageFormat.format(
                "At {1,time} on {1,date}, there was {2} on planet "
                        + "{0,number,integer}.",
                7, new Date(), "a disturbance in the Force");
        System.out.println(result);
    }

    @Test
    void test1() {
        System.out.println("test1");
        //здесь переменные передаются в строку отдельно (а не в массиве) что позволяет обрабатывать каждую отдельно:
        String result = MessageFormat.format(
                "At {1,time} on {1,date}, there was {2} on planet "
                        + "{0,number,integer}.",
                7, new Date(), "a disturbance in the Force");
        System.out.println(result);
        //At 19:13:44 on 25 янв. 2024 г., there was a disturbance in the Force on planet 7.
    }
    @Test
    void test2() {
        //здесь пробуем передать массив переменных строкового типа:
        System.out.println("test2");
        String[] args = {String.valueOf(7), (new Date()).toString(), "a disturbance in the Force"};
        //так не получится передать значения, тк из стринга не выделить дату и
        //java.lang.IllegalArgumentException: Cannot format given Object as a Date
        String result = MessageFormat.format(
                "At {1,time} on {1,date}, there was {2} on planet "
                        + "{0,number,integer}.", args);
        System.out.println(result);
    }

    @Test
    void test3() {
        //здесь пробуем передать массив переменных строкового типа:
        System.out.println("test3");
        String[] args = {String.valueOf(7), (new Date()).toString(), "a disturbance in the Force"};
        String result = MessageFormat.format(
                "At {1,time} on {1,date}, there was {2} on planet "
                        + "{0,number,integer}.", args);
        System.out.println(result);
    }
}