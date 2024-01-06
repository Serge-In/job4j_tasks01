package collections.test7tree;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * 2024-01-06
 * 1. Организовать сортировку User [#10034]
 * В Java есть интерфейс java.util.Set.
 * Классы этого интерфейса - это java.util.HashSet и java.util.TreeSet.
 * java.util.TreeSet. Эта коллекция сразу сортирует элементы
 * TreeSet требует от входящего типа данных поддержания интерфейса java.util.Comparable.
 * При каждой вставке в TreeSet элемент будет искать нужную ячейку через механизм сравнения элементов.
 * Внутри TreeSet используется бинарное дерево поиска.
 */

public class TreeSort {
    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>();
        numbers.add(6);
        numbers.add(3);
        numbers.add(2);
        numbers.add(6);
        System.out.println(numbers); //[2, 3, 6]

        Set<String> strings = new TreeSet<>();
        strings.add("f");
        strings.add("r");
        strings.add("y");
        strings.add("f");
        System.out.println(strings); //[f, r, y]

        //когда нам нужно расположить элементы по убыванию. Для этого в конструктор коллекции нужно передать компаратор.
        numbers = new TreeSet<>(Collections.reverseOrder());
        numbers.add(6);
        numbers.add(3);
        numbers.add(2);
        numbers.add(6);
        System.out.println(numbers); //[6, 3, 2]
    }
    }

