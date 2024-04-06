package collections.linkedlist;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 2024-04-06
 * 0.3. Внутри LinkedList [#504815 #490083]
 */
public class Test1 {
    /**
     * Для создания экземпляра LinkedList в классе определено 2 конструктора:
     * LinkedList () - создается пустой список.
     * LinkedList (Collection<? extends E> col) - создается список, в который помещается коллекция col.
     */
    @Test
    public static void main1() {
        List<Integer> list = new LinkedList<>();
        System.out.println(list);// []
        if (list.size() < 10) System.out.println("число элементов " + list.size());//0
        System.out.println(list.add(100)); //true
        list.add(200);
        list.add(0,90);//void
        System.out.println(list); //[90, 100, 200]

        List<Integer> list2 = new LinkedList<>(list);
        System.out.println(list2.add(300));//true
        System.out.println(list2);//[90, 100, 200, 300]

        System.out.println(list2.get(0));//90
        //System.out.println(list2.get(5));//java.lang.IndexOutOfBoundsException: Index: 5, Size: 4
        list2.clear();//void

    }
}
