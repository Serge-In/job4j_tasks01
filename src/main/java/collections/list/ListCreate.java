package collections.list;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024-04-05
 * 0.1. Интерфейс List [#4953]
 */
public class ListCreate {

    /**
     * 0. отличие создания списка через List.of() от list.add()
     * List.of() возвращает неизменяемый список,
     * т.е. вызвать метод add(), remove() и т.п. на такой коллекции не получится, будет сгенерировано исключение UnsupportedOperationException.
     */
    @Test
    public static void main() {
        List<Integer> list = List.of(1,2,3,4); //оператор создает иммутабельный список, в который нельзя добавить новые элементы или удалить
        //list.add(2, 10);//java.lang.UnsupportedOperationException
        //list.clear();//java.lang.UnsupportedOperationException
        System.out.println(list); //[1, 2, 3, 4]
    }

    /**
     * 1
     * boolean add(E e) – добавляет элемент e в конец списка
     */
    @Test
    public static void main1() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4 ; i++) {
           list.add(i+1);
        }
        boolean operation = list.add(5); // этот метод boolean
        System.out.println(operation);//true
        System.out.println(list.add(6)); //true
        System.out.println(list);//[1, 2, 3, 4, 5, 6]
    }

    /**
     * 2
     * void add(int index, E element) – добавляет указанный элемент (element) в указанную позицию(index) в списке.
     * При этом сдвигает элемент, который находится в этой позиции(если есть), и все последующие элементы вправо.
     * добавление по индексу может бросить исключение класса
     * IndexOutOfBoundsException, если будет выполнено условие index < 0 || index > size().
     */
    @Test
    public static void main2() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4 ; i++) {
            list.add(i+1);
        }

        list.add(3,30); //этот метод void, поэтому его нельзя вставить в System.out.println(list.add(3,30))
        System.out.println(list);//[1, 2, 3, 30, 4, 5, 6]
        //list.add(10,10);//java.lang.IndexOutOfBoundsException: Index: 10, Size: 7

    }

    /**
     * 3
     * boolean addAll(Collection<? extends E> c)
     */
    @Test
    public static void main3() {
        List<Integer> list = List.of(1,2,3,4);
        List<Integer> list2 = new ArrayList<>();
        System.out.println(list2.addAll(list)); //true
        System.out.println(list2);//[1, 2, 3, 4]
    }

    /**
     * 4
     * boolean addAll(int index, Collection<? extends E> c)
     * что добавление по индексу может бросить исключение класса
     * IndexOutOfBoundsException, если будет выполнено условие index < 0 || index > size().
     */
    @Test
    public static void main4() {
        List<Integer> list = List.of(1,2,3,4);
        List<Integer> list2 = new ArrayList<>();
        System.out.println(list2.addAll(0,list));//true
        System.out.println(list2.addAll(2,list2));//true
        System.out.println(list2);//[1, 2, 1, 2, 3, 4, 3, 4]
       // System.out.println(list2.addAll(10,list2));//java.lang.IndexOutOfBoundsException: Index: 10, Size: 8
    }
}
