package collections.test5sort;

import java.util.Comparator;

/**
 * Теперь давайте создадим класс ru.job4j.collection.SortByNameJob, который будет реализовывать интерфейс java.util.Comparator.
 * для сравнения в классе Job для сортировки по приоритету имеем:
 * return Integer.compare(priority, another.priority);
 * а здесь сравниваются строки
 * return left.getName().compareTo(right.getName());
 */

public class SortByNameJob implements Comparator<Job> {
    @Override
    public int compare(Job left, Job right) {
        return left.getName().compareTo(right.getName());
    }
}