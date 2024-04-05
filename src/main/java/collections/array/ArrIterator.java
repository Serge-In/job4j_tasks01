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
}
