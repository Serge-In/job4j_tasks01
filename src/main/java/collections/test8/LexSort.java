package collections.test8;

import java.util.Comparator;

/**
 * 2024-01-08
 * 4. Сортировка номера [#221284]
 *  Ваша задача дописать компаратор, чтобы он сравнивал начальный номер.
 *  Expected: is ["1. Task.", "2. Task.", "10. Task."]
 *  В решении нас интересует шаблон номера задачи, который представлен в тесте выше, т.е. без вложенных номеров задач
 * Для реализации Вам понадобятся следующие методы:
 * - метод split() класса String - необходим для того, чтобы отделить часть строки, которая будет содержать номер задачи;
 * - метод Integer.parseInt() - позволит преобразовать строку, содержащее номер задачи в число типа Integer;
 * - метод Integer.compare() - позволит корректно сравнить номера задач.
 */
public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] arrLeft = left.split(". ");
        String[] arrRight = right.split(". ");
        return Integer.compare(Integer.parseInt(arrLeft[0]), Integer.parseInt(arrRight[0]));
    }

    public static void main(String[] args) {
        String left = "10. sdf";
        String right = "1. sff";
        System.out.println(left.indexOf(". "));
        String[] arrLeft = left.split(". ");
        System.out.println(arrLeft[0] + " " + arrLeft[1]);
        String[] arrRight = right.split(". ");

        System.out.println(Integer.parseInt(arrLeft[0]));
        System.out.println(Integer.parseInt(arrRight[0]));
        int comp = Integer.compare(Integer.parseInt(arrLeft[0]), Integer.parseInt(arrRight[0]));
        System.out.println(comp);
    }
}