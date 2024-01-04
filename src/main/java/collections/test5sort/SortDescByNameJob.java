package collections.test5sort;

import java.util.Comparator;

/**
 * Теперь сделаем отдельный компаратор по убыванию.
 * Метод compare должен вернуть -1, 0, 1. Чтобы сделать обратный порядок мы сравниваем правую сторону с левой.
 * То есть просто переворачиваем результат.
 * Сравните с компаратором по возрастанию.
 * return left.getName().compareTo(right.getName());
 */
public class SortDescByNameJob implements Comparator<Job> {
    @Override
    public int compare(Job left, Job right) {
        return right.getName().compareTo(left.getName());
    }
}