package collections;

import org.testng.annotations.Test;

import java.util.Arrays;

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
}
