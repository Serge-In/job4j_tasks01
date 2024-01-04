package collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * 2023-12-21
 * Коллекции
 * Урок 1
 * 1. Интерфейс Collection [#504820]
 * CollectionUsage
 */

public class Collections {
    public static void main(String[] args) {
        colAdd();
        colAddAll();
        colRemove();
        colRemoveAll();
        colRetainAll();
        colMiscMethods();
    }

    private static void colMiscMethods() {
//вспомогательные методы
       //int size() – метод возвращает размер коллекции
        System.out.println();
        System.out.println("***");

        Collection<String> collection = new ArrayList<>();
        System.out.println("collection.isEmpty() -->" + collection.isEmpty()); //->true

        collection.add("one");
        collection.add("two");
        collection.add("three");

        System.out.println("add to collection");
        System.out.println("collection:" + collection);
        System.out.println();

        System.out.println("collection.size() -->" + collection.size()); //->3

        System.out.println("collection.isEmpty() -->" + collection.isEmpty()); //->false

        System.out.println("collection.contains(\"one\") -->" + collection.contains("one")); //->true
        System.out.println("collection.contains(\"\") -->" + collection.contains("")); //->false
        System.out.println("collection.contains(1) -->" + collection.contains(1)); //->false

        //удаляет все элементы из коллекции. После применения этого метода коллекция будет пустой.
        collection.clear();
        System.out.println();
        System.out.println("collection.clear()");
        System.out.println("collection.size() -->" + collection.size()); //->0
        System.out.println();

        //Object[] toArray() – метод возвращает массив, который содержит все элементы, содержащиеся в коллекции
        collection.add("one");
        collection.add("two");
        collection.add("three");

        System.out.println("add to collection");
        System.out.println("collection:" + collection);

        System.out.println();
        Object[] arr = collection.toArray();

        System.out.println("Arrays.toString(collection.toArray()) -->" + Arrays.toString(arr)); //->3
        System.out.println("collection.toString() -->" + collection.toString());
        System.out.println("collection:" + collection);

        // Object.equals() и Object.hashcode()
        Collection<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

            System.out.println();
            System.out.println("collection:" + collection); //collection:[one, two, three]
            System.out.println("list:" + list); //list:[one, two, three]
            System.out.println("collection.hashCode() -->" + collection.hashCode()); //219827735
            System.out.println("list.hashCode() -->" + list.hashCode()); //219827735
            System.out.println("collection.equals(list) -->" + collection.equals(list)); //true
    }

    public static void colAdd() {
        System.out.println();
        System.out.println("***");
        System.out.println("collection");

        Collection<String> collection = new ArrayList<>();
        collection.add("one");
        collection.add("two");
        collection.add("three");

        for (String string : collection) {
            System.out.println(string);
        }

    }

    public static void colAddAll() {
        Collection<String> collection = new ArrayList<>();
            System.out.println();
            System.out.println("***");
            System.out.println("new empty collection:" + collection);

        Collection<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
            System.out.println("list to add:" + list);

            //Добавить коллекцию в другую коллекцию
        collection.addAll(list);
            System.out.println("collection after adding");
            System.out.println("collection:" + collection);
    }

    public static void colRemove() {
        Collection<String> collection = new ArrayList<>();
        collection.add("one");
        collection.add("two");
        collection.add("three");

        System.out.println();
        System.out.println("***");
        System.out.println("collection:" + collection);

        //boolean remove(Object o) – метод удаляет объект, который мы передали в метод, и возвращает true
        collection.remove("two");
        System.out.println("Вывод содержимого коллекции после удаления");
        System.out.println("collection:" + collection);
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
            System.out.println("collection:" + collection);

        Collection<String> removeList = new ArrayList<>();
        removeList.add("two");
        removeList.add("o");
        removeList.add("one");

            System.out.println();
            System.out.println("removeList:" + removeList);

        collection.removeAll(removeList);
        System.out.println("Вывод содержимого коллекции после вызова removeAll");
        System.out.println("collection:" + collection);
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
            System.out.println("collection:" + collection);

        Collection<String> retainList = new ArrayList<>();
        retainList.add("two");
        retainList.add("o");
        retainList.add("one");

            System.out.println();
            System.out.println("retainList:" + retainList);

        collection.retainAll(retainList);
        System.out.println("Вывод содержимого коллекции после вызова retainAll");
        System.out.println("collection:" + collection);
    }
}


