package collections;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * 2024-04-10
 * эксперименты с многомерными массивами
 */
public class ArrayJagged {
    @Test
    void main0() {
        int[][][] input = {
                {{1}},
                {{1, 1}, {1}, {1, 2, 3, 4}},
        };
        System.out.println(input.length);
        System.out.println(input[input.length - 1].length);
        System.out.println(Arrays.deepToString(input)); // [[[1]], [[1, 1], [1], [1, 2, 3, 4]]]

        System.out.println(Arrays.toString(input[input.length - 1][input[input.length - 1].length - 1])); //[1, 2, 3, 4]

        // Printing the result using method reference ::println
        // Arrays.stream(input).forEach(Arrays::deepToString);  // пусто
        // String res = Arrays.stream(input).forEach(Arrays::deepToString); //ошибка

    }

    /**
     * Arrays.toString(row)
     */
    @Test
    void main1() {
    int[][] arr = {{0, 1}, {2, 3}};
        Arrays.stream(arr)
            .forEach(row -> System.out.println(Arrays.toString(row)));
        //[0, 1]
        //[2, 3]
    }

    /**
     * Arrays.deepToString(row)
     */
    @Test
    void main2() {
        int[][][] arr = {
                {
                    {0}, {1}
                },
                {
                    {2}, {3}
                }
        };
       Arrays.stream(arr)
                .forEach(row -> System.out.println(Arrays.deepToString(row)));
        // [[0], [1]]
        // [[2], [3]]
    }

    @Test
    void main4() {
        int[][][] input = {
                {{1}},
                {{1, 1}, {1}, {1, 2, 3, 4}},
        };

        // невозможно узнать "размерность" многомерного jagg
        // весь массив
        System.out.println("input.length: " + input.length); //2 // число элементов первой размерности
        System.out.println("input: " + input); //[[I@214b199c //весь массив
        System.out.println("Arrays.toString(input): " + Arrays.toString(input)); //[[[I@20d3d15a, [[I@2893de87] // элементы первой размерности
        System.out.println("Arrays.deepToString(input): " + Arrays.deepToString(input)); // [[[1]], [[1, 1], [1], [1, 2, 3, 4]]]
        System.out.println();

        // переходим на уровень глубже в последний элемент первой размерности
        System.out.println("input[1].length: " + input[1].length); //3 // число элементов внутри элемента №1 первой размерности
        System.out.println("input[input.length - 1].length: " + input[input.length - 1].length); //3 // число элементов внутри элемента №1 первой размерности
        System.out.println("input[1]: " + input[1]); //input[1]: [[I@363ee3a2
        System.out.println("Arrays.toString(input[1]): " + Arrays.toString(input[1])); //Arrays.toString(input[1]): [[I@79b06cab, [I@3eb7fc54, [I@7f552bd3]
        System.out.println("Arrays.deepToString(input[1]): " + Arrays.deepToString(input[1])); //Arrays.deepToString(input[1]): [[1, 1], [1], [1, 2, 3, 4]]
        System.out.println();

        // переходим на уровень глубже в последний элемент второй размерности
        System.out.println("input[1][2]: " + input[1][2]); //[I@55ca8de8 // последний элемент внутри элемента №2 второй размерности
        System.out.println("Arrays.toString(input[1][2]): " + Arrays.toString(input[1][2])); //[1, 2, 3, 4] // он же в виде строки

        //этот же элемент в виде относительного адреса (последний эл. в посл. эл-те)
        System.out.println("input[1][2]: " + Arrays.toString(input[input.length - 1][input[input.length - 1].length - 1])); //[1, 2, 3, 4]

    }

    @Test
    void main5() {
        int[][][] input = {
                {{1}},
                {{1, 1}, {1}, {}, {1, 2, 3, 4}},
        };

        // невозможно узнать "размерность" многомерного jagg
        // весь массив
        System.out.println("input.length: " + input.length); //2
        System.out.println("input: " + input); //
        System.out.println("Arrays.toString(input): " + Arrays.toString(input)); // элементы первой размерности
        System.out.println("Arrays.deepToString(input): " + Arrays.deepToString(input)); // [[[1]], [[1, 1], [1], [], [1, 2, 0, 4]]]
        System.out.println();

        // переходим на уровень глубже в последний элемент первой размерности
        System.out.println("input[1].length: " + input[1].length); //4 // число элементов внутри элемента №1 первой размерности
        System.out.println("input[input.length - 1].length: " + input[input.length - 1].length); //4 // число элементов внутри элемента №1 первой размерности
        System.out.println("input[1]: " + input[1]); //input[1]: [[I@363ee3a2
        System.out.println("Arrays.toString(input[1]): " + Arrays.toString(input[1])); //Arrays.toString(input[1]): [[I@36c88a32, [I@7880cdf3, [I@5be6e01c, [I@1c93084c]
        System.out.println("Arrays.deepToString(input[1]): " + Arrays.deepToString(input[1])); //Arrays.deepToString(input[1]):  [[1, 1], [1], [], [1, 2, 0, 4]]
        System.out.println();

        // переходим на уровень глубже в последний элемент второй размерности
        System.out.println("input[1][2]: " + input[1][3]); //[I@55ca8de8 // третий элемент внутри элемента №2 второй размерности
        System.out.println("Arrays.toString(input[1][3]): " + Arrays.toString(input[1][3])); //[1, 2, 3, 4] // он же в виде строки

        //этот же элемент в виде относительного адреса (последний эл. в посл. эл-те)
        System.out.println("input[1][2]: " + Arrays.toString(input[input.length - 1][input[input.length - 1].length - 1])); //[1, 2, 3, 4]

        System.out.println("Arrays.toString(input[1][2]): " + Arrays.toString(input[1][2])); //[] // пустой элемент
        System.out.println("input[1][2].length: " + input[1][2].length); //0 // его размерность

        //print the last element of jagged array
       // System.out.println(input[input.length - 1][input[input.length - 1].length - 1][input[input.length - 1].length - 1].length - 1));

    }

    /**
     * 2024-04-01
     * ChatGPT 3.5
     * How to get the last nested element of this jagged array:
     */
    @Test
    void main6() {
        int[][][] input = {
                {{1}},
                {{1, 1}, {1}, {}, {1, 2, 3, 4}},
        };

        int lastElement = input[input.length - 1][input[input.length - 1].length - 1][input[input.length - 1][input[input.length - 1].length - 1].length - 1];
        System.out.println("Last element: " + lastElement);

        // в три строки:
        int[] lastNestedArray = input[input.length - 1][input[input.length - 1].length - 1];
        lastElement = lastNestedArray[lastNestedArray.length - 1];
        System.out.println("Last element of the last nested array: " + lastElement); //4

        // в одну строку:
       System.out.println(input[input.length - 1][input[input.length - 1].length - 1][input[input.length - 1][input[input.length - 1].length - 1].length - 1]);

        // с разбивкой:
        System.out.println(
                input[input.length - 1]
                        [input[input.length - 1].length - 1]
                        [input[input.length - 1][input[input.length - 1].length - 1].length - 1]);
    }

    /**
     * int[][] input = {{0}, {1}, {2}} такой массив считается одномерным, те при вызове элементов первый индекс указывает не на строку, а на столбец
     */
    @Test
    void main7() {
        int[][] input = {{0}, {1}, {2}};
        //System.out.println("{} element: " + input[0][1]); //java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1
        System.out.println(input[1][0]); // 1
        System.out.println(Arrays.deepToString(input)); // [[0], [1], [2]]
        System.out.println(Arrays.toString(input[0])); // [0]
        System.out.println(Arrays.toString(input[1])); // [1]
        System.out.println(Arrays.toString(input[2])); // [2]
        System.out.println(input[0][0]); // 0
        System.out.println(input[1][0]); // 1
        System.out.println(input[2][0]); // 2
        System.out.println(input[0][1]); // java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1
        System.out.println(input[0][2]); // java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 1
    }

    /**
     *int[][] input = {{0, 1}, {}, {30}}
     * здесь второй элемент {} это массив (объект) с длиной = 0, те это не 0 и не null
     */
    @Test
    void main8() {
        int[][] input = {{0, 1}, {}, {30}};
        System.out.println(input[0][1]); // 1
        //System.out.println(input[1][0]); // Index 0 out of bounds for length 0
        System.out.println(input[1]); // [I@363ee3a2
        System.out.println(input[1].length == 0); // true
        System.out.println(Arrays.toString(input[1])); // []

        System.out.println(Arrays.deepToString(input)); // [[0, 1], [], [30]]
        System.out.println(Arrays.toString(input[0])); // [0, 1]
        System.out.println(Arrays.toString(input[2])); // [30]
        System.out.println(input[0][0]); // 0
        System.out.println(input[2][0]); // 30
    }
}