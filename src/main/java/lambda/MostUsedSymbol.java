package lambda;

import java.util.HashMap;
import java.util.Map;

/**
 * 2024-03-16
 * 9. Лямбда выражения и Collection Framework [#505026]
 * пример из урока
 */
public class MostUsedSymbol {

    public static void main(String[] args) {
        String input = "slogan of java language: write once, run everywhere".replaceAll(" ", "");
        Map<Character, Integer> map = new HashMap<>();
/**
 * первый вариант
 */
//        for (char character : input.toCharArray()) {
//            Integer temp = map.get(character);
//            if (temp != null) {
//                map.put(character, temp + 1);
//            } else {
//                map.put(character, 1);
//            }
//        }
        /**
         *      * Сборка Map с использованием двух вставок методом put и проверкой на null выглядит логично.
         *      * Однако попробуем его сократить с использование метода getOrDefault –
         *      * это будет замена get и проверки на null. Цикл со сбором Map примет вид:
         */
//        for (char character : input.toCharArray()) {
//            Integer temp = map.getOrDefault(character, 0);
//            map.put(character, temp + 1);
//        }

        /**
         * Теперь попробуем использовать метод, с которым мы познакомились в этой задаче – computeIfPresent.
         * Как мы помним, метод производит вычисление нового значения в Map, при условии, что по ключу уже пара существует.
         * Т.е. мы будем добавлять новую пару ключ-значение, но будем использовать метод putIfAbsent,
         * поскольку метод put произведет замену значения, и мы потеряем полезные данные.
         * В итоге цикл для сбора Map примет вид:
         */
//        for (char character : input.toCharArray()) {
//            map.computeIfPresent(character, (key, value) -> value + 1);
//            map.putIfAbsent(character, 1);
//        }

        /**
         * Последним вариантом будет использовать метод merge. Код цикла для сбора Map примет вид:
         * Т.е. изначальные 5 строк кода для сборки Map мы сократили до одной строки с использованием метод merge.
         */
        for (char character : input.toCharArray()) {
            map.merge(character, 1, (oldValue, newValue) -> oldValue + 1);
        }

        int max = 0;
        char result = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }

        System.out.println("Most used symbol: " + result);
    }
}

