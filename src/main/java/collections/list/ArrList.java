package collections.list;

import org.testng.annotations.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 2024-04-05
 * 0.2. Внутри ArrayList [#504814]
 */
public class ArrList {

    @Test
    public static void main() {
        int[] list = {1,2,3,4};
        System.out.println(Arrays.toString(list)); //[1, 2, 3, 4]
        int[] newlist = Arrays.copyOf(list, 10);
        System.out.println(Arrays.toString(newlist)); //[1, 2, 3, 4, 0, 0, 0, 0, 0, 0]
    }

    /**
     * Arrays.copyOf(list, 10); внутри реализован через
     * System.arraycopy(list, 0, listCopy, 6, Math.min(list.length,  listCopy.length));
     * т.е. происходит "тяжелая" операция по перекопированию значений из старого массива в новый.
     * Именно с этим связана рекомендация о использовании конструктора со значением int initialCapacity,
     * если нам конечно заранее известно сколько элементов будет храниться в нашем списке.
     * вот так:
     */
    @Test
    public static void main1() {
        int[] list = {1,2,3,4};
        System.out.println(Arrays.toString(list));

        if (list.length < 10) System.out.println("число элементов " + list.length);

      int[] listCopy = {10,20,30,40,50,60,70,80,90,100};
      System.arraycopy(list, 0, listCopy, 6, Math.min(list.length,  listCopy.length));
      System.out.println(Arrays.toString(listCopy)); //[10, 20, 30, 40, 50, 60, 1, 2, 3, 4]
    }

    @Test
    public static void main2() {
        /**
         * Важно! Число элементов или размер ArrayList (то, что возвращает list.size()) это количество элементов в нем, а не размер массива.
         * В английской терминологии можно встретить термины capacity и size,
         * первый описывает длину массива (array.length) или вместимость контейнера (а не списка, список динамический!),
         * второй количество элементов в списке
         */
        List<Integer> list = new ArrayList<>(10);
        System.out.println(list.size());//0
        // нельзя в цикле перебрать емкость списка (capacity = 10), но только число элементов
        for (int i = 0; i < 10; i++) {
            //System.out.println(list.get(i)); // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        }

        /**
         * Важно! Это замечание следует из предыдущего и из свойства списков хранить null.
         * В контексте ArrayList, есть null элементы (это null элементы которые мы добавляем в список)
         * и пустые ячейки контейнера, которые в конечном счете, тоже null.
         * Не путайте null элементы и пустые ячейки контейнера!
         * Пример, вы создали ArrayList начальной вместимостью 10, добавили в него 5 null элементов,
         * несмотря на то, что внутри ArraList массив пуст (все ячейки null),
         * у нас есть 5 null элементов, и в этой ситуации размер списка 5.
         * Все это идет из того, что при вызове метода добавления происходит увеличение счетчика, отвечающего за количество элементов.
         */
        list.add(null);
        list.add(null);
        System.out.println(list.size());//2
        for (Integer el: list) {
            System.out.println(el);
            //null
            //null
        }
    }
}
