package datatypes;

import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2024-01-29
 * интерфейс List две реализации ArrayList & LinkedList
 * List можно с дубликатами
 */
public class ListTest {
    @Test
    public void main1() {
        List<String> arrayList = new ArrayList<>();
        //нельзя добавить в массив если пропущен индекс
        //arrayList.add(1,"first"); //java.lang.IndexOutOfBoundsException: Index: 1, Size: 0

        //так тоже не получится, пропущен индекс 1
//        arrayList.add(0,null);
//        arrayList.add(2,"sec"); //java.lang.IndexOutOfBoundsException: Index: 2, Size: 1

        //только без пропусков индексов
        arrayList.add(0, null);
        arrayList.add(1, "first");
        System.out.println(arrayList);//[null, first]

        // add всегда сдвигает элементы даже если они были = null
        // вызывается скрытый метод System.arraycopy
        arrayList.add(0, "zero");
        arrayList.add(1, "first");
        System.out.println(arrayList);// [zero, first, null, first]
    }
    @Test
    public void main2() {
        /**
         * System.arraycopy
         * В Java есть еще один способ скопировать массив — с помощью нативного (native) метода arraycopy(), расположенного в классе System.
         * Его работа имеет принципиальное отличие от копирования элементов массива в цикле:
         * он копирует не поэлементно, а целыми блоками памяти, что влияет положительно на производительность.
         * Данный класс находится в пакете java.lang, и его не нужно импортировать — это делается автоматически.
         * Нативными называются методы, реализация которых написана на каком-то другом языке,
         * отличном от Java (например, С/C++), под конкретную ОС, что делает их код платформозависимым, т. е. «родным» для конкретной системы.
         * Методы, помеченные как native, не могут иметь тела и должны заканчиваться точкой с запятой.
         *Получается, что сигнатуру метода arraycopy() с ключевым словом native мы можем наблюдать в классе System, а вот реализация,
         * написанная на языках C/C++, находится совсем в другом месте.
         * Она является частью скомпилированной в виде машинного (бинарного) кода библиотеки внутри JVM.
         */
        List<String> arrayList = new ArrayList<>();
        arrayList.add(0, "zero");
        arrayList.add(1, "first");
        System.out.println("arrayList : " + arrayList); //arrayList : [zero, first]
        List<String> arrayListNew = new ArrayList<>(arrayList.size() + 1);

        //для типа arrayList этот метод не работает
        //java.lang.ArrayStoreException: arraycopy: source type java.util.ArrayList is not an array
        //System.arraycopy(arrayList, 0, arrayListNew, 0, arrayList.size());

        // пробую через массив
        //String[] arr = arrayList.toArray(); //так не работает!  arrayList.toArray() вернет только Object[]
        Object[] arr = arrayList.toArray();
        System.out.println("arr : " + arr); //arr : [Ljava.lang.Object;@50a7bc6e
        for (Object o : arr ) {
            System.out.println(o); // zero first
        }

        String[] arrNew = new String[arrayList.size()+1];
        System.out.println("arrNew : " + arrNew); // arrNew : [Ljava.lang.String;@161b062a
        for (String str : arrNew ) {
            System.out.println(str); // null null null
        }

        // с массивами работает
        System.arraycopy(arr, 0, arrNew, 0, arr.length);
        System.out.println("arrNew : " + arrNew); //arrNew : [Ljava.lang.String;@161b062a

        /**
         * как вывести содержимое массива в консоль:
         */
        //1 способ
        for (String str : arrNew ) {
            System.out.println(str); // zero first null
        }

        // 2 способ
        System.out.println("arrNew : " + Arrays.toString(arrNew)); //arrNew : [zero, first, null]

        // так не работает
        System.out.println("arrNew : " + arrNew.toString()); //arrNew : [Ljava.lang.String;@161b062a

        //java.lang.ArrayStoreException: arraycopy: source type java.util.ArrayList is not an array
        //System.arraycopy(arrayList.stream().toArray(), 0, arrayListNew.stream().toArray(), 0, 1);

        //java.lang.ArrayIndexOutOfBoundsException: arraycopy: last destination index 1 out of bounds for object array[0]
        //System.arraycopy(arrayList.stream().toArray(), 0, arrayListNew.stream().toArray(), 0, 1);



    }
}