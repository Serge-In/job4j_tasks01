package collections.list;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 4. Удаление элементов из списка
 * Для выполнения данной операции в интерфейсе List<E> определены 5 методов:
 * 4.1. E remove(int index) – удаляет элемент из списка по индексу index, при этом метод возвращает удаленный элемент.
 *
 * 4.2. boolean remove(E e) – удаляет элемент е типа E из коллекции при его ПЕРВОМ вхождении в список, если он есть в коллекции.
 * Метод remove(E e) реализован с помощью цикла for(), подразумевает под собой первоначальный поиск удаляемого элемента и только потом он удаляется.
 * Соответственно, использование этого метода внутри цикла, который перебирает список, не рекомендуется, поскольку мы будем проходить по списку дважды.
 *
 * 4.3. boolean removeAll(Collection<?> col) – метод удаляет из списка все элементы, которые содержатся в коллекции col,
 * если в результате работы метода исходный список изменился - метод возвращает true.
 *
 * 4.4. boolean retainAll(Collection<?> col) – метод также удаляет элементы из списка, за исключением тех,
 * которые находятся в коллекции col, если в результате работы метода исходный список изменился - метод возвращает true.
 *
 * ВАЖНО! Отмеченные (*) методы реализованы с помощью цикла for(),
 * поэтому применять эти методы внутри циклов, которые перебирают список, нежелательно, поскольку так мы будем проходить по одному и тому же списку дважды.
 */
public class ListDelete {

    @Test
    public static void main1() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4 ; i++) {
            list.add(i+1);
        }
        System.out.println(list); //[1, 2, 10, 4]
        list.remove(1);
        System.out.println(list); //[1, 3, 4]

        List<Integer> list2 = List.of(1, 4);

        System.out.println(list.removeAll(list2));// true
        System.out.println(list);//[3]

        System.out.println(list.retainAll(list2));// true
        System.out.println(list);//[]
    }

    /**
     * 4.5. default boolean removeIf(Predicate<? super E> filter) – метод удаляет все элементы из коллекции,
     * которые удовлетворяют условию определенному в предикате filter(передается в виде лямбда выражения).
     * Если в результате работы метода список изменился - метод возвращает true
     */
    @Test
    public static void main2() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4 ; i++) {
            list.add(i+1);
        }
        System.out.println(list); //[1, 2, 3, 4]
        System.out.println(list.removeIf(i -> i > 2));// true
        System.out.println(list); //[3, 4]
    }

    /**
     * ряд методов, которые определены в интерфейсе List<E>
     * 1. (*) boolean contains(E element) – метод возвращает true, если список содержит переданный в метод элемент element.
     */
    @Test
    public static void main3() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4 ; i++) {
            list.add(i+1);
        }
        System.out.println(list); //[1, 2, 3, 4]
        System.out.println(list.removeIf(i -> i > 2));// true
        System.out.println(list); //[3, 4]
    }

    /**
     * 2. (*) int indexOf(E element) – метод возвращает индекс элемента element при его первом вхождении в список.
     * Если элемент не найден - метод возвращает -1.
     */
    @Test
    public static void main4() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4 ; i++) {
            list.add(i+1);
        }
        System.out.println(list); //[1, 2, 3, 4]
        System.out.println(list.indexOf(5));// -1
    }

    /**
     * 3. (*) int lastIndexOf (E element) - метод возвращает индекс элемента element при его последнем вхождении в список.
     * Если элемент не найден - метод возвращает -1.
     */
    @Test
    public static void main5() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4 ; i++) {
            list.add(i+1);
        }
        System.out.println(list); //[1, 2, 3, 4]
        System.out.println(list.lastIndexOf(2));// 1
        System.out.println(list.lastIndexOf(5));// -1
    }

    /**
     * 4. int size() - метод возвращает целочисленное значение, и говорит нам о том, сколько элементов находится в списке.
     */
    @Test
    public static void main6() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4 ; i++) {
            list.add(i+1);
        }
        System.out.println(list); //[1, 2, 3, 4]
        System.out.println(list.size());// 4
    }

    /**
     *      5. List<E> subList(int fromIndex, int toIndex) - метод возвращает список,
     *      который содержит все элементы исходного списка начиная с индекса fromIndex(включительно)
     *      и до toIndex(значение исключается).
     *      При этом, если выполняется условие fromIndex == toIndex,- метод вернет пустой список.
     */
    @Test
    public static void main7() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4 ; i++) {
            list.add(i+1);
        }
        System.out.println(list); //[1, 2, 3, 4]
        System.out.println(list.subList(0,2));// [1, 2]
        System.out.println(list.subList(0,0));// []
       // System.out.println(list.subList(3,5));// java.lang.IndexOutOfBoundsException: toIndex = 5
    }

    /**
     * 6. default void sort(Comparator<? super E> comp) –
     * метод осуществляет сортировку списка в соответствии с компаратором comp, который мы передаем в метод.
     */
    @Test
    public static void main8() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4 ; i++) {
            list.add(i+1);
        }
        System.out.println(list); //[1, 2, 3, 4]
        list.sort((j, i) -> i.compareTo(j));// void
        System.out.println(list);// [4, 3, 2, 1]
        list.sort(Comparator.naturalOrder());//void
        System.out.println(list); //[1, 2, 3, 4]
    }

}
