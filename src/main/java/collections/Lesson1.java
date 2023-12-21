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
        colAdd1();
        colAddAll();
        colRemove();
        colRemoveAll();
        colRetainAll();
    }

    public static void colAdd1() {
        System.out.println();
        System.out.println("***");
        System.out.println("collection1");

        Collection<String> collection1 = new ArrayList<>();
        collection1.add("one");
        collection1.add("two");
        collection1.add("three");

        for (String string : collection1) {
            System.out.println(string);
        }
    }

    public static void colAddAll() {
        Collection<String> collection = new ArrayList<>();
        System.out.println();
        System.out.println("***");
            System.out.println("new empty collection");
            for (String string : collection) {
                System.out.println(string);
            }

        Collection<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
            System.out.println("list to add");
            for (String string : list) {
                System.out.println(string);
            }

            //Добавить коллекцию в другую коллекцию
        collection.addAll(list);

        System.out.println("collection after adding");
        for (String string : collection) {
            System.out.println(string);
        }
    }

    public static void colRemove() {
        Collection<String> collection = new ArrayList<>();
        collection.add("one");
        collection.add("two");
        collection.add("three");

        System.out.println();
        System.out.println("***");
        System.out.println("collection");
        for (String string : collection) {
            System.out.println(string);
        }
        //boolean remove(Object o) – метод удаляет объект, который мы передали в метод, и возвращает true
        collection.remove("two");
        System.out.println("Вывод содержимого коллекции после удаления");
        for (String string : collection) {
            System.out.println(string);
        }
    }

    public static void colRemoveAll() {
        //boolean removeAll(Collection<?> c) – метод удаляет все элементы из коллекции, у которой был вызван этот метод, и которые также содержатся в переданной в метод коллекции.
        // Таким образом после вызова этого метода в коллекции не будет тех элементов, которые содержатся в переданной в метод коллекции.

        Collection<String> collection = new ArrayList<>();
        collection.add("one");
        collection.add("two");
        collection.add("three");

            System.out.println();
            System.out.println("***");
            System.out.println("collection");

            for (String string : collection) {
                System.out.println(string);
            }

        Collection<String> removeList = new ArrayList<>();
        removeList.add("two");
        removeList.add("o");
        removeList.add("one");

            System.out.println();
            System.out.println("removeList");
            for (String string : removeList) {
                System.out.println(string);
            }

        collection.removeAll(removeList);
        System.out.println("Вывод содержимого коллекции после вызова removeAll");
        for (String string : collection) {
            System.out.println(string);
        }
    }

    public static void colRetainAll() {

        // boolean retainAll(Collection<?> c) – метод, который позволяет сохранить в коллекции только те элементы,
        // которые содержатся в коллекции, которая была передана в метод.
        // Таким образом в результате в коллекции останутся только те элементы, которые представлены в обоих коллекциях.
        Collection<String> collection = new ArrayList<>();
        collection.add("one");
        collection.add("two");
        collection.add("three");

            System.out.println();
            System.out.println("***");
            System.out.println("collection");

            for (String string : collection) {
                System.out.println(string);
            }

        Collection<String> retainList = new ArrayList<>();
        retainList.add("two");
        retainList.add("o");
        retainList.add("one");

            System.out.println();
            System.out.println("retainList");
            for (String string : retainList) {
                System.out.println(string);
            }

        collection.retainAll(retainList);
        System.out.println("Вывод содержимого коллекции после вызова retainAll");
        for (String string : collection) {
            System.out.println(string);
        }
    }
}


