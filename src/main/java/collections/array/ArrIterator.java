package collections.array;

import org.testng.annotations.Test;

import java.util.*;

/**
 * 2024-04-05
 * Why is there no iterator for an array of primitive types in Java?
 *
 * Get an iterator over a primitive array in Java
 * Even though arrays in Java implements java.lang.Cloneable and java.io.Serializable interfaces,
 * and we can even use them in for-each loops, they don’t implement the Iterable interface.
 * But we can easily get an iterator over a primitive array
 * in Java using any of the following-discussed methods:
 * 1. Writing our own iterator
 * 2. Using Arrays.stream() method
 * 3. Using IntStream.of(), DoubleStream.of(), or LongStream.of() method
 * 4. Using Guava Library
 * 5. Using Apache Commons Collections
 */
public class ArrIterator {
    @Test
    public static void main() {
        int [] arr = {1,2,3};
        System.out.println(arr);//[1, 2, 3]
    }

    @Test
    public static void main1() {
        List<Integer> templist = List.of(1, 2, 3, 4);
        List<Integer> list = new ArrayList<>(templist);

        System.out.println(list);//[1, 2, 3, 4]
        Iterator<Integer> iterator = list.iterator();
        System.out.println(iterator.next());//1

        /**
         * set не влияет на поведение итератора (итератор не выдает исключения)
         */
        System.out.println(list.set(0, 10)); //1 // set не влияет на поведение итератора (итератор не выдает исключения)
        System.out.println(list);//[10, 2, 3, 4]
        System.out.println(iterator.hasNext());//true
        System.out.println(iterator.next());//2

        /**
         * remove неоднозначно влияет на поведение итератора
         * (hasNext не выдает исключение, но если remove 1 ячейка, а в итераторе оставалась более 1 не отданой, то hasNext вернет true)
         * а next вернет исключение!!! те это косяк!
         */
        System.out.println(list.remove(0));//10
        System.out.println(list); //[2, 3, 4]
        System.out.println(iterator.hasNext());//true
        //System.out.println(iterator.next());//java.util.ConcurrentModificationException
    }
}
