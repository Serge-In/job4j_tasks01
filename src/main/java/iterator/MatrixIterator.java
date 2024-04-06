package iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 2024-03-31
 * 2. Итератор для двухмерного массива int[][] [#9539]
 * Шаблон итератор можно применить для любой структуры.
 * Рассмотрим двухмерный массив
 * Напишем для него итератор, который последовательно вернет элементы.
 * Метод next()  должен вернуть последовательно 1, 2, 3, 4.
 *
 * Цель итератора - переместить указатель на нужную ячейку. Итератор не копирует элементы в новую коллекцию, а переводит указатель.
 * В этом примере указатель имеет две переменные: row и column.
 * В идеале метод hasNext() не должен изменять состояние объекта.
 * Но так как у нас может быть ситуация, когда в массиве есть много пустых массивов,
 * то для оптимизации можно сделать, что бы hasNext() устанавливал указатель на нужный элемент.
 * Решение:
 * Поскольку могут быть пустые массивы внутри data, чтобы определить наличие следующего элемента необходимо найти след. значение не null
 * что означает запомнить индекс этого следующего элемента, те необходимо добавить к классу два поля - индексы след. элемента,
 * по умолчанию и если след эл. не существует, оба индекса = null.
 * определение индексов след. эл. вызывается впервые в конструкторе класса и затем каждый раз после вызова метода next()
 * метод next()
 * 1. проверяет значение индексов след. элемента, если оба индекса не равны null,
 *  1.1 то возвращает элемент с этими индексами,
 *  1.2 флаг goNext = true;
 *  1.2 вызовет hasNext(), который проверить наличие следующего элемента, начиная с текущих индексов
 *   и (goNext = true) поменяет текущие индексы на следующие (если след. эл. есть) или на null, если следующего нет.
 * 2. если хотя бы один индекс == null, вернет NoSuchElementException
 *
 * метод hasNext()
 * перебирает все элементы data в двух вложенных циклах fori начиная с указателя на текущий элемент
 * если текущий элемент в цикле не null перепишет эначения индексов и вернет true
 * если достигнут конец data, присвоит обоим индексам null и вернет false (нет след. элемента)
 *
 */
//public class MatrixIterator implements Iterator<Integer> {
//    private final int[][] data;
//    private int row;
//    private int column;
//
//    public MatrixIterator(int[][] data) {
//        this.data = data;
//        if (data.length != 0) {
//            this.row = 0;
//            if (data[0].length != 0) {
//                this.column = 0;
//            }
//        }
//    }
//
//    @Override
//    public boolean hasNext() {
//        if (data.length == 0 || row >= data.length) {
//            return false;
//        }
//        int colNext = column + 1;
//        for (int i = row; i < data.length; i++) {
//            for (int j = colNext; j < data[i].length; j++) {
//                System.out.print("next el = " + data[i][j] + " in position: i = " + i + ", j = " + j + " "); // пусто
//                return true;
//            }
//            colNext = 0;
//        }
//        return false;
//    }
//
//    @Override
//    public Integer next() {
//        if (!hasNext()) {
//            throw new NoSuchElementException();
//        }
//        if (column == data[row].length) {
//            row++;
//            column = 0;
//        }
//        return data[row][column++];
//    }
//}

/**
 * 3й вариант
 * выполнение метода hasNext определяется состоянием флага isNext
 * таким образом, hasNext  выполняет поиск след. элемента, только при первом вызове из конструктора
 * или из итератора Next, когда требуется найти следующий элемент,
 *
 *  конструктор:
 *      ставится флаг isNext = 0.
 *      вызывается метод hasNext,
 *  hasNext()
 *      проверяет состояние флага isNext.
 *          Если isNext == 1, возвращает true
 *          Если isNext == -1, возвращает false
 *          Если isNext == 0, поиск адреса первого (непустого) элемента в data
 *              если элемент найден
 *                  флаг isNext = 1, возвращает true
 *                  записываются поля [rowNext] [columnNext]
 *              если элемент не найден
 *                  флаг isNext = -1, возвращает false
 *  next()
 *      проверяет флаг isNext
 *          если isNext = -1,
 *              вернет NoSuchElementException
 *          если isNext = 1,
 *              запишет в result элемент data [rowNext] [columnNext]
 *              isNext = 0
 *              вызов hasNext()
 *              вернет result
 */
public class MatrixIterator implements Iterator<Integer> {
    private final int[][] data;
    private int row;
    private int column;
    private int isNext;

    public MatrixIterator(int[][] data) {
        this.data = data;

        if (data.length == 0) {
            isNext = -1;
        } else {

            this.row = 0;
            this.column = -1;
            isNext = 0;
            this.hasNext();
        }
    }

    @Override
    public boolean hasNext() {
        boolean result;
        switch (isNext) {
            case 1:
                result = true;
                break;
            case -1:
                result = false;
                break;
            case 0:
//                if (data.length == 0) {
////                    result = false;
//                    isNext = -1;
//                } else {
                    int colNext = column + 1;
                    for (int i = row; i < data.length; i++) {
                        for (int j = colNext; j < data[i].length; j++) {
                            System.out.print("next el = " + data[i][j] + " in position: i = " + i + ", j = " + j + " "); // пусто
                            isNext = 1;
                            return true;
                        }
                        colNext = 0;
                    }
                    isNext = -1;
                    return false;
//                }
            default:

        }
        throw new IllegalStateException("isNext == " + isNext + ", but valid variable values == -1 or 1 or 0");
    }

    @Override
    public Integer next() {
        switch (isNext) {
            case 1:
                int result = data[row][column];
                isNext = 0;
                hasNext();
                return result;
            case -1:
                throw new NoSuchElementException("Next element in array is absent");
            default:
                throw new IllegalStateException("isNext == " + isNext + ", but valid variable values == -1 or 1");
        }
    }

    /**
     * Первый вариант - метод hasNext выполняет поиск след. элемента при каждом вызове
     *  конструктор:
     *      ставится флаг hasNext = false.
     *      вызывается метод hasNext,
     *  hasNext()
     *      проверяет состояние флага hasNext.
     *          Если hasNext == true, возвращает true
     *          Если hasNext == false, поиск адреса первого (непустого) элемента в data
     *              если элемент найден
     *                  поле hasNext = true
     *                  записываются поля [rowNext] [columnNext]
     *              если элемент не найден, hasNext = false
     *  next()
     *      проверяет флаг hasNext
     *          если hasNext = false,
     *              вернет NoSuchElementException
     *          если hasNext = true,
     *              запишет в result элемент data [rowNext] [columnNext]
     *              hasNext = false
     *              вызов hasNext()
     *              вернет result
     */
}