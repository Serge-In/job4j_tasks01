package collections;

import java.util.ArrayList;
import java.util.List;

/**
 * 2023-12-23
 * 8. Конвертация листа массивов в один лист Integer [#10037]
 * у нас есть список, содержащий массив чисел. Массив - это объект.
 * В этом задании Вам нужно будет преобразовать список с массивом чисел в список чисел
 * Массивы в списке list могут быть разного размера.
 * Метод convert должен пройтись по всем элементам всех массивов в списке list и добавить их в список rsl.
 */
public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();

        for (int[] arr : list) {
            for (int num : arr) {
                result.add(num);
            }
        }
        return result;
    }
}