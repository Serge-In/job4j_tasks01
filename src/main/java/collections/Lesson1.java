package collections;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 2023-12-21
 * Урок 1
 * 1. Интерфейс Collection [#504820]
 * CollectionUsage
 */
public class Lesson1 {
        public static void main(String[] args) {
            System.out.println();
            System.out.println("collection1");

            Collection<String> collection1 = new ArrayList<>();
            collection1.add("one");
            collection1.add("two");
            collection1.add("three");

            for (String string : collection1) {
                System.out.println(string);
            }

            System.out.println();
            System.out.println("collection2");

            Collection<String> collection2 = new ArrayList<>();
            collection2.add("one");
            collection2.add("two");
            collection2.add("three");

            Collection<String> list2 = new ArrayList<>();
            list2.addAll(collection2);

            for (String string : list2) {
                System.out.println(string);
            }

//boolean remove(Object o) – метод удаляет объект, который мы передали в метод, и возвращает true
            System.out.println();
            System.out.println("collection3");

            Collection<String> collection3 = new ArrayList<>();
            collection3.add("one");
            collection3.add("two");
            collection3.add("three");
            for (String string : collection3) {
                System.out.println(string);
            }
            collection3.remove("two");
            System.out.println("Вывод содержимого коллекции после удаления");
            for (String string : collection3) {
                System.out.println(string);
            }

//boolean removeAll(Collection<?> c) – метод удаляет все элементы из коллекции, у которой был вызван этот метод, и которые также содержатся в переданной в метод коллекции.
// Таким образом после вызова этого метода в коллекции не будет тех элементов, которые содержатся в переданной в метод коллекции.
            System.out.println();
            System.out.println("collection4");

            Collection<String> collection4 = new ArrayList<>();
            collection4.add("one");
            collection4.add("two");
            collection4.add("three");
            Collection<String> list4 = new ArrayList<>();
            list4.add("two");
            for (String string : collection4) {
                System.out.println(string);
            }
            collection4.retainAll(list4);
            System.out.println("Вывод содержимого коллекции после вызова retainAll");
            for (String string : collection4) {
                System.out.println(string);
            }

            // boolean retainAll(Collection<?> c) – метод, который позволяет сохранить в коллекции только те элементы,
            // которые содержатся в коллекции, которая была передана в метод.
            // Таким образом в результате в коллекции останутся только те элементы, которые представлены в обоих коллекциях.
            
        }
}

