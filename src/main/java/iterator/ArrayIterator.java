package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 2024-03-31
 * 1. Что такое итератор. [#4951]
 * Шаблон итератор используется в коллекциях, базах данных, чтении файлов.
 * Метод next возвращает первый элемент ячейки.
 * Второй вызов метода next вернет второй элемент и так далее.
 * Метод next сдвигает указатель итератора.
 * Указатель - это ссылка на элемент, который нужно вернуть.
 *
 * Пример. Сделаем итератор для одномерного массива чисел.
 * Что будет, если в итераторе нет элементов и мы вызовем метод next?
 * В этом случае итератор должен сгенерировать исключение NoSuchElementException.
 */
public class ArrayIterator implements Iterator<Integer> {
    private final int[] data;
    private int point;

    public ArrayIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return point < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }
}
