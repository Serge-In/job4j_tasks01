package iff;

/**
 * 2023-12-15
 * 1.1.4 Оператор ветвления
 * 53. Преобразовать трехзначное число в зависимости от условия
 * Ниже представлен метод transform(int number), который принимает целое трехзначное число.
 * Задание: Написать код, который выполняет следующее:
 * - Если число четное - все четные цифры этого числа увеличиваются на 1, а нечетные - уменьшаются на 1.
 *  Если увеличение/уменьшение невозможно (например, увеличить 9), то оставить эту цифру без изменения.
 *
 * - Если число нечетное, то все изменения произвести наоборот - четные цифры уменьшить на 1, нечетные - увеличить на 1.
 * Получившееся число вывести в консоль.
 */
public class Task54 {
    public static void transform(int number) {
        int sign = number >= 0 ? 1 : -1;
        String numStr = Integer.toString(Math.abs(number));
        char[] charArray = numStr.toCharArray();

        int[] intArray = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            intArray[i] = Character.getNumericValue(charArray[i]);
        }

        if (number % 2 == 0) {
            for (int i = 0; i < intArray.length; i++) {
                if (intArray[i] % 2 == 0 && intArray[i] < 9) {
                    intArray[i] = intArray[i] + 1;
                } else if (intArray[i] % 2 != 0 && intArray[i] > 0) {
                    intArray[i] = intArray[i] - 1;
                }
            }
        } else {
            for (int i = 0; i < intArray.length; i++) {
                if (intArray[i] % 2 == 0 && intArray[i] > 0) {
                    intArray[i] = intArray[i] - 1;
                } else if (intArray[i] % 2 != 0 && intArray[i] < 9) {
                    intArray[i] = intArray[i] + 1;
                }
            }
        }
        String resNumStr = "";
        for (int num:intArray) {
            resNumStr = resNumStr + Integer.toString(num);
        }
        System.out.println(Integer.parseInt(resNumStr) * sign);
    }

    public static void main(String[]args) {
        transform(0); //--> 1
        transform(1); //--> 2
        transform(-1); //--> -2
        transform(390); //--> 281
        transform(333); //--> 444
        transform(-900); //--> -811
        transform(999); //--> 999
        transform(109); //--> 209
        transform(100); //--> 11
    }
}
