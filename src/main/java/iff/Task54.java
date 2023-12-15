package iff;

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
