package collections.arrayList.test1;
import java.util.ArrayList;
import java.util.List;
/**
 * 2023-12-21
 * Коллекции
 * Урок 2
 * 2. Коллекции, ArrayList, List, Обобщения [#10094]
 */

public class ArrList {
    public static void main(String[] args) {
        //ArrayList arrList = new ArrayList();
        //при таком объявлении idea показывает предупреждение Unchecked call to add(E)
        //поэтому в коллекции нужно после имени класса в угловых скобках указать тип данных
        //ArrayList<String> arrList = new ArrayList<String>();
        //это новый элемент языка - "обобщения".
        // Этот механизм позволяет в процессе компиляции проверить, что в коллекцию добавляют элементы только указанного типа.
        ArrayList<String> arrList = new ArrayList<String>();
        arrList.add("a");
        System.out.println("arrList.add(\"a\")");

        arrList.add(0, "b");
        System.out.println("arrList.add(0, \"b\")");
        System.out.println("arrList = " + arrList);
        System.out.println("arrList.size(): " + arrList.size());

        for (int i = 0; i < arrList.size(); i++) {
            System.out.println("arrList.get(" + i + "): " + arrList.get(i));
        }
    }
}
