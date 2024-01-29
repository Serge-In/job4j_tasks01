package service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.PrintStream;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 2024-01-26
 * печать в консоль
 */
public class Print {

    static void pr() {System.out.println();}
    static void pr(Object o) {System.out.println(o);}
    static void pr(String str) {System.out.println(str);}


    @Test
    void test1() {
        //Supplier pr = () -> System.out.println(); //не работает
    }

    @Test
    void test2() {
//    pr("test");
//    print.accept("str");
//        Executable <> pr = () -> System.out.println(str);
    }

    @Test
    void test3() {
        //ссылка на метод
        Consumer<Object> pr = System.out::println;
        pr.accept("str");
    }





    @Test
    void test6() {
        PrintStream p = Objects.requireNonNull(System.out);
        //numbers.toString(o -> p.println(o));
        //() = str -> System.out.println(str);
    }
}
