package collections.test8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

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

public class LexSortTest {
    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task."
        };
        String[] output = {
                "1. Task.",
                "2. Task.",
                "10. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input).containsExactly(output);
    }
}