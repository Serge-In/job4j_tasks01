package collections.arrayList.methods;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 2024-04-05
 * 0.1. Интерфейс List [#4953]
 */
public class ListRead {
    /**
     * Прочитать элементы из списка можно двумя способами:
     * 2.1. Использование метода get():
     */
    @Test
    public static void main() {
        List<Integer> list = List.of(1,2,3,4);
        System.out.println(list.get(2)); //3
        //System.out.println(list.get(4)); //java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
        for (int el: list) {
            System.out.println(el); //1,2,3,4
        }
    }

    /**
     * 2.2. использовать итератор для доступа к элементам.
     * Для того чтобы получить экземпляр итератора в интерфейсе List<E> определены 3 метода:
     * 1
     * Iterator<E> iterator() – метод возвращает объект Iterator, который содержит в себе все элементы исходной коллекции.
     * Iterator перебирается только в цикле while (iterator.hasNext()) {}
     * (fore each с ним не работает)
     */
    @Test
    public static void main1() {
        List<Integer> list = List.of(1,2,3,4);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next()); //1 2 3 4
        }
    }

    /**
     * 2
     * ListIterator<E> listIterator() – возвращает итератор списка для элементов в этом списке.
     */
    @Test
    public static void main2() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4 ; i++) {
            list.add(i+1);
        }
        ListIterator<Integer> iterator = list.listIterator();
        System.out.println(iterator.hasPrevious()); //false

        while (iterator.hasNext()) {
            System.out.println(iterator.next()); //1 2 3 4
        }

        //если итератор iterator.next() отдал все позиции, следующий вызов приведет к ошибке
        //System.out.println(iterator.next());//java.util.NoSuchElementException

        list.add(10);
        //если список изменился, вызов итератора, созданного до изменения вызовет ошибку.
        //System.out.println(iterator.next()); //java.util.ConcurrentModificationException

        iterator = list.listIterator(); //после изменения списка нужно создать новый итератор
        while (iterator.hasNext()) {
            System.out.println(iterator.next()); //1 2 3 4 10
        }
    }

    /**
     * 3
     * ListIterator<E> listIterator(int index) – возвращает итератор списка для элементов в этом списке,
     * начиная с элемента индекс которого равен index.
     */
    @Test
    public static void main3() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4 ; i++) {
            list.add(i+1);
        }
        ListIterator<Integer> iterator = list.listIterator(2);
        System.out.println(iterator.hasPrevious()); //true

        while (iterator.hasNext()) {
            System.out.println(iterator.next()); //3 4
        }
        System.out.println(iterator.hasNext()); //false
    }

    /**
     * Необходимо отметить, что ListIterator имеет несколько отличий от Iterator:
     * 1. ListIterator может использоваться только со списками, т.е. реализациями интерфейса List<E>,
     * тогда как Iterator<E> применим к любым наследникам и реализациям интерфейса Collection<E>.
     * 2. ListIterator позволяет перебирать список в обоих направлениях, Iterator<E> только в прямом порядке.
     * 3. ListIterator допускает модификацию списка, за счет его дополнительного метода add. Iterator<E> такой возможности не имеет.
     */
    @Test
    public static void main4() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i + 1);
        }
        //[1, 2, 3, 4]

        ListIterator<Integer> iterator = list.listIterator(2); //3 4
        iterator.add(10); //void
        System.out.println(list);//[1, 2, 10, 3, 4]

        /**
         * если добавить новый эл в коллекцию не через iterator.add, вызов ранее созданного итератора приведет к ошибке
         */
        iterator = list.listIterator(2); //10 3 4
        list.add(10);
        System.out.println(list);//[1, 2, 10, 3, 4, 10]// добавили новый эл. в список, но итератор сломался
        while (iterator.hasNext()) {
//            System.out.println(iterator.next()); //java.util.ConcurrentModificationException
        }
    }

    /**
     * даже если добавить новый эл. в начало списка, list.add(0,10);
     * до начала итератора list.listIterator(2)
     * итератор все равно сломается
     */
    @Test
    public static void main5() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4 ; i++) {
            list.add(i+1);
        }
        //[1, 2, 3, 4]
        ListIterator<Integer>  iterator = list.listIterator(2); // 3 4
        list.add(0,10);
        System.out.println(list);//[10, 1, 2, 3, 4]// добавили новый эл. в начало списка, но итератор все равно сломался
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next()); //java.util.ConcurrentModificationException
//        }
    }

    /**
     * 2. ListIterator позволяет перебирать список в обоих направлениях, Iterator<E> только в прямом порядке.
     */
    @Test
    public static void main6() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4 ; i++) {
            list.add(i+1);
        }
        System.out.println(list);//[1, 2, 3, 4]
        ListIterator<Integer>  iterator = list.listIterator(); //[1, 2, 3, 4]
        System.out.println(iterator.next()); //1
        System.out.println(iterator.next()); //2
        System.out.println(iterator.previous());//2
        System.out.println(iterator.next()); //2

        // если создать итератор с индекса, можно получить предыдущий элемент коллекции
        iterator = list.listIterator(2); //[3, 4]
        System.out.println(iterator.previous());//2
        System.out.println(iterator.next()); //2

    }
}
