package collections.test9exam;
/**
 * 2024-01-22
 * эксперименты с коллекциями для удобства запуска отдельных методов перенес сюда - в пакет тестов
 */
import org.junit.jupiter.api.Test;
import java.util.*;

class ExamCollectionTest {
    static void pr() {System.out.println();} //для сокращения кода
    static void pr(Object o) {System.out.println(o);} //для сокращения кода
    static void pr(String str) {System.out.println(str);} //для сокращения кода

    static void collectionName(Collection c) {
        pr("");
        pr("getClass()" + " : " + c.getClass());
        pr("size()" + " : " + c.size());
        pr("hashCode()" + " : " + c.hashCode());
    }

    static void collectionAdd(Collection c) {
        c.add("d"); c.add("4f"); c.add("1"); c.add("!"); //сортировка возможна только коллекции из однотипных значений
    }

    static void collectionSort(Collection c) {
        pr("c.stream().sorted().toList() : " + c.stream().sorted().toList());
        pr("c.stream().toList().get(0) : " + c.stream().toList().get(0));
    }
    @Test
    void main() {
        ExamCollection.main(); //строка добавлена для удобства перехода на класс и метод, к которому относится данный класс тестов
        pr("hello");
    }

    //далее для каждого эксперимента запускается отдельный метод с тегом @Test
    @Test
    void main1() {
        //Collection c1 = Set.of("d", "4f", 1, "!");
        // сортировка возможна только коллекции из однотипных значений
        Collection c = Set.of("d", "4f", "1", "!");
        //нельзя добавить в сет через add
        // c.add("d"); c.add("4f"); c.add("1"); c.add("!"); //сортировка возможна только коллекции из однотипных значений
        pr("getClass()" + " : " + c.getClass());
        pr("size()" + " : " + c.size());
        pr("hashCode()" + " : " + c.hashCode());
        for (Object el : c ) {
            pr(el);
        }
        pr("c.contains(\"d\") : " + c.contains("d"));
    }
    @Test
    void main2() {
        Collection c = new HashSet();
        c.add("d"); c.add("4f"); c.add("1"); c.add("!"); //сортировка возможна только коллекции из однотипных значений
        pr("getClass()" + " : " + c.getClass());
        pr("size()" + " : " + c.size());
        pr("hashCode()" + " : " + c.hashCode());
        for (Object el : c ) {
            pr(el);
        }
     pr("c.contains(\"d\") : " + c.contains("d"));
    }

    @Test
    void main3() {
        //3 из 32. В чём отличие ArrayList от LinkedList?
        //ArrayList - динамический массив
        // When more and more elements are added into an ArrayList, the capacity of the underlying array grows 50% of its size each time.
        // Internally, a new array which is 1.5 times the size the original array is allocated, and the old array is copied to the new one.
        Collection c = new ArrayList<>(2);
        c.add("d"); c.add("4f"); c.add("1"); c.add("!"); //сортировка возможна только коллекции из однотипных значений
        pr("getClass()" + " : " + c.getClass());
        pr("size()" + " : " + c.size());
        pr("hashCode()" + " : " + c.hashCode());
        for (Object el : c ) {
            pr(el);
        }
        pr("c.contains(\"d\") : " + c.contains("d"));
        pr(c.iterator());
        pr(c.iterator().next());
        pr(c.iterator().next());
        // для сортировки ICollection нужно привести к I List
        List list = c.stream().toList();
        pr(list);
        list.sort(Comparator.naturalOrder());
        pr(list);
    }

    @Test
    void main4() {
        ArrayList c = new ArrayList<>(2);
        c.add("d"); c.add("4f"); c.add("1"); c.add("!"); //сортировка возможна только коллекции из однотипных значений
        pr("getClass()" + " : " + c.getClass());
        pr("size()" + " : " + c.size());
        pr("hashCode()" + " : " + c.hashCode());
        for (Object el : c ) {
            pr(el);
        }
        pr("c.get(0) : " + c.get(0));
        Collections.sort(c);
        pr(c);
    }

    @Test
    void main5() {
        // — LinkedList реализован в виде связного списка: набора отдельных элементов,
        // каждый из которых хранит ссылку на следующий и предыдущий элементы.
        // Чтобы вставить элемент в середину такого списка, достаточно поменять ссылки его будущих соседей.
        // чтобы получить элемент с номером 130, нужно пройтись последовательно по всем объектам от 0 до 130.
        // операции set и get тут реализованы очень медленно
        Collection c5 = new LinkedList();
        collectionName(c5);
        collectionAdd(c5);
        collectionSort(c5); //сортировка возможна только коллекции из однотипных значений

    }

    @Test
    void main6() {
        LinkedList c6 = new LinkedList();
        collectionName(c6);
        collectionAdd(c6);
        collectionSort(c6); //сортировка возможна только коллекции из однотипных значений
        pr("c6.get(0) : " + c6.get(0));

    }

    /**
     * 2024-01-24
     *     4 из 32. Выберите коллекции, которые могут хранить дубликаты.
     *     Выберите один или несколько вариантов ответа.
     *     java.util.Set - нет
     *     java.util.Queue - да
     *     java.util.Vector - да
     *     java.util.List -да
     */

    @Test
    void main7() {
        //Collection c = Set.of("d", "d", "1", "!");//java.lang.IllegalArgumentException: duplicate element: d
        Collection c = Set.of("d", "0", "1", "!");
        //c.add("1"); //at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:142)
        collectionName(c);
        pr(c);

    }
    @Test
    void main80() {
        Queue c = new PriorityQueue();
        c.add("5"); c.add("1"); c.add("2"); c.add("3");
        pr("getClass()" + " : " + c.getClass()); //class java.util.PriorityQueue
        pr("size()" + " : " + c.size());
        pr("hashCode()" + " : " + c.hashCode());
        for (Object el : c ) {
            pr(el);
        }
        pr("c.peek() : " + c.peek());
        pr(c);
        pr("c.element() : " + c.element());
        pr(c);
        pr("c.poll() : " + c.poll());
        pr(c);
        pr("c.remove() : " + c.remove());
        pr(c);
    }

    @Test
    void main81() {
        Queue c = new LinkedList();
        c.add("5"); c.add("1"); c.add("2"); c.add("3");
        pr("getClass()" + " : " + c.getClass()); //class java.util.LinkedList
        pr("size()" + " : " + c.size());
        pr("hashCode()" + " : " + c.hashCode());
        for (Object el : c ) {
            pr(el);
        }
        pr("c.peek() : " + c.peek());
        pr(c);
        pr("c.element() : " + c.element());
        pr(c);
        pr("c.poll() : " + c.poll());
        pr(c);
        pr("c.remove() : " + c.remove());
        pr(c);
        c.clear();
        pr("c.poll() : " + c.poll()); //null
        pr("c.peek() : " + c.peek()); //null
//        pr("c.remove() : " + c.remove()); //java.util.NoSuchElementException
//        pr("c.element() : " + c.element()); //java.util.NoSuchElementException
    }

    @Test
    void main82() {
        Deque c = new ArrayDeque();
        c.add("5"); c.add("1"); c.add("2"); c.add("3");
        pr("getClass()" + " : " + c.getClass()); //class java.util.PriorityQueue
        pr("size()" + " : " + c.size());
        pr("hashCode()" + " : " + c.hashCode());
        for (Object el : c ) {
            pr(el);
        }
        pr("c.peek() : " + c.peek());
        pr(c);
        pr("c.element() : " + c.element());
        pr(c);
        pr("c.poll() : " + c.poll());
        pr(c);
        pr("c.remove() : " + c.remove());
        pr(c);
        pr("c.peekFirst(): " + c.peekFirst());
        pr(c);
        pr("c.peekLast(): " + c.peekLast());
        pr(c);
    }
    @Test
    void main83() {
        Deque c = new LinkedList();
        c.add("5"); c.add("1"); c.add("2"); c.add("3");
        pr("getClass()" + " : " + c.getClass()); //class java.util.PriorityQueue
        pr("size()" + " : " + c.size());
        pr("hashCode()" + " : " + c.hashCode());
        for (Object el : c ) {
            pr(el);
        }
        pr("c.peek() : " + c.peek()); pr(c);
        pr("c.element() : " + c.element()); pr(c);
        pr("c.poll() : " + c.poll()); pr(c);
        pr("c.remove() : " + c.remove()); pr(c);
        pr("c.peekFirst(): " + c.peekFirst()); pr(c);
        pr("c.peekLast(): " + c.peekLast()); pr(c);
        c.addLast("asd"); pr("c.addLast(\"asd\")"); pr(c);
        c.addFirst(23); pr("c.addFirst(23)"); pr(c);
    }

    @Test
    void main9() {
        Vector c = new Vector<>();
        c.add("1"); c.add(1);
        collectionName(c);
        pr(c);
//        getClass() : class java.util.Vector
//        size() : 2
//        hashCode() : 2481
//        [1, 1]
    }

    @Test
    void main10() {
        List c = new LinkedList();
        c.add("1"); c.add("1");
        collectionName(c);
        pr(c);
//        getClass() : class java.util.LinkedList
//        size() : 2
//        hashCode() : 2529
//        [1, 1]
    }

    @Test
    void main11() {
        Map map = new HashMap();
        map.put(0, "null");
        map.put(1 , "first");
        pr("getClass()" + " : " + map.getClass());
        pr("size()" + " : " + map.size());
        pr("hashCode()" + " : " + map.hashCode());
        pr(map);
        pr("map.isEmpty() : " + map.isEmpty());
        pr("map.get(1) : " + map.get(1));
    }

    /**
     * 21 из 32. В каких строках происходит анбоксинг (распаковка)?
     */
    @Test
    void main12() {
        Integer a = 3;
        a++;
                pr(a.getClass());
        int b = a;
        Integer c = b;
                pr(c.getClass().getSimpleName());
    }

    /**
     * 30 из 32. Что будет выведено на консоли? Передача параметра ссылочного типа.
     */
    @Test
        public static void main(String[] args) {
            Integer value = 1;
            change(value);
            pr("value : " + value);
        }
        public static void change(Integer value) {
            pr("value : " + value);
            ++value; pr("++value : " + value);
            value++; pr("value++ : " + value);
        }

}