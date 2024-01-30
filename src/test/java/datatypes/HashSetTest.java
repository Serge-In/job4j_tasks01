package datatypes;

import org.testng.annotations.Test;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

/**
 * 2024-01-30
 */
public class HashSetTest {
        @Test
    public void main() {
            System.out.println(new Date()); //Tue Jan 30 19:32:49 MSK 2024
            // создать коллекцию
            int size = 100;// размер коллекции

            System.out.println("создать hashSet" + " из " + size + " случайных int элементов от 1 до 10000");
            Instant start = Instant.now();

            Set<Integer> hashSet = new HashSet();

            for (int i = 0; i < size; i++) {
                // порядок позиции в hashMap != порядку вставки в hashmap
//                int x = (int)(Math.ceil(Math.random()*10000));
//                System.out.println(x);
                hashSet.add((int) (Math.ceil(Math.random() * 10000)));
            }

            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            System.out.println("hashSet : " + hashSet);
            System.out.println("hashSet.toString() : " + hashSet.toString());
            System.out.println("timeElapsed = " + timeElapsed.getNano() / 1000000.0 + " ms(-3) \n"); //

            //минимальное значение коллекции hashSet
            System.out.println("минимальное значение коллекции" + " из " + size + " элементов");
            start = Instant.now();

            System.out.println("Collections.min(hashSet) :" + Collections.min(hashSet));
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            System.out.println("timeElapsed = " + timeElapsed.getNano() / 1000000.0 + " ms(-3) \n"); //

            //макс значение коллекции hashSet
            System.out.println("максимальное значение коллекции" + " из " + size + " элементов");
            start = Instant.now();

            System.out.println("Collections.max(hashSet) :" + Collections.max(hashSet));
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            System.out.println("timeElapsed = " + timeElapsed.getNano() / 1000000.0 + " ms(-3) \n"); //

            // java HashSet get last 10 elements
            // In Java, a HashSet is an unordered collection that does not maintain the order of elements,
            // so there's no direct way to retrieve the "first" or "last" element as you would in a data structure like a list.
            // However, you can achieve something similar by converting the HashSet to a List or another ordered data structure.
            System.out.println("HashSet get last 10 elements" + " из " + size + " элементов");
            start = Instant.now();

            System.out.println("hashSet.stream().toList().subList(hashSet.size()-10, hashSet.size()" + " :\n"
                    + hashSet.stream().toList().subList(hashSet.size() - 10, hashSet.size()));
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            System.out.println("timeElapsed = " + timeElapsed.getNano() / 1000000.0 + " ms(-3) \n"); //
        }

        /**
         * HashSet extends AbstractSet and implements the Set interface. It creates a collection that uses a hash table for storage.
         * The class does not guarantee the constant order of elements over time but permits the null element.
         * The underlying data structure for HashSet is Hashtable. HashSet also implements Serializable and Cloneable interfaces.
         *
         *  The three different ways we can get elements by index in a HashSet is by:
         * Using an array
         * Using a for loop
         * Using ArrayList
         */
        @Test
        void main2(){
            System.out.println(new Date()); //Tue Jan 30 20:08:53 MSK 2024
            // создать коллекцию
            int size = 100;// размер коллекции
            int indexOfElement = 9; // номер элемента который нужно получить

            System.out.println("создать hashSet" + " из " + size + " случайных int элементов от 1 до 10000");
            Set<Integer> hashSet = new HashSet();
            for (int i = 0; i < size; i++) {
                // порядок позиции в hashMap != порядку вставки в hashmap
                hashSet.add((int) (Math.ceil(Math.random() * 10000)));
            }

            System.out.println("получить элемент № " + indexOfElement + " из " + size + " элементов \n");

            // 1 Using an array
            System.out.println("1 method: Using an array");
            System.out.println("Integer[] arr = hashSet.toArray(new Integer[hashSet.size()]);");
            Instant start = Instant.now();

            //int [] arr = hashSet.toArray(new Integer[hashSet.size()]); // с примитивным типом не работает
            //int [] arr = (int) hashSet.toArray(new int[hashSet.size()]); // с примитивным типом не работает
            Integer[] arr = hashSet.toArray(new Integer[hashSet.size()]);

            System.out.println("arr[ " + indexOfElement + " ] : " + arr[indexOfElement]);
            Instant end = Instant.now();
            Duration timeElapsed  = Duration.between(start, end);
            System.out.println("timeElapsed = " + timeElapsed.getNano() / 1000000.0 + " ms(-3) \n"); //

            // 2 Using a for loop
                System.out.println("2 method: Using a for each loop");
                start = Instant.now();
                int i = 0;
                Integer res = null;
                for (int el: hashSet) {
                    if (indexOfElement == i) {
                        res = el;
                        break;
                    }
                    i++;
                }

            System.out.println("hashSet element # " + indexOfElement + " = " + res);
            end = Instant.now();
            timeElapsed  = Duration.between(start, end);
            System.out.println("timeElapsed = " + timeElapsed.getNano() / 1000000.0 + " ms(-3) \n"); //
        }
}