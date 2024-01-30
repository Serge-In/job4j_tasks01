package datatypes;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ListOfANDArraysAsList {
    static void pr() {System.out.println();}
    static void pr(Object o) {System.out.println(o);}
    static void pr(String str) {System.out.println(str);}

    @Test
    void test1() {
        /**
         * 2024-01-26
         * List.of()
         * List.of это фабричный метод, впервые представленный в Java 9, который создает неизменяемый список, содержащий указанные элементы.
         * Неизменяемость: полученный список неизменен, то есть его размер и элементы не могут быть изменены после создания.
         * Фиксированный размер: список, созданный List.of(), имеет фиксированный размер и не поддерживает добавление или удаление элементов.
         * Нулевые значени: List.of() не допускает нулевых элементов. Если вы попытаетесь добавить null, появится исключение NullPointerException.
         */
        List nums2 = List.of(1, "2", 3); // без указания типа мб любые типы в списке
        pr(nums2.getClass()); // class java.util.ImmutableCollections$ListN
        pr(nums2); //[1, 2, 3]
        pr(nums2.get(0).getClass()); //class java.lang.Integer
        pr(nums2.get(1).getClass()); //class java.lang.String
        //nums2.add(4);//error Immutable object is modified
        //nums2.set(0, 3); //java.lang.UnsupportedOperationException

        //можно определить тип элементов списка List<String>
        List<String> nums3 = List.of("1", "2", "3");
        pr(nums3.get(0).getClass()); //class java.lang.String
    }

    @Test
    void test2() {
        //int[] nums = List.of(1, 2, 3); // нельзя создать массив из списка
        //ArrayList nums = List.of(1, 2, 3); // нельзя создать массив из списка
        //List nums = List.of(1, 2, 3); // так можно
        Collection nums = List.of(1, 2, 3); // так можно
        pr(nums.getClass()); //class java.util.ImmutableCollections$ListN
        Collection nums2 = List.of(1, "2", 3); // так можно
        //у коллекции нет метода nums.get(index) или nums(index) чтобы получить элемент коллекции нужно ее преобразовать в массив


    }

    @Test
    void test3() {
        /**
         * 2024-01-26
         * Arrays.asList() — это метод, доступный еще в ранних версиях Java,
         * и он предоставляет удобный способ создания изменяемого списка, поддерживаемого массивом
         * Модифицируемость: полученный из Arrays.asList() список можно модифицировать,
         * что позволяет добавлять, удалять или изменять элементы.
         * Поддерживается массивом: список поддерживается исходным массивом,
         * поэтому любые изменения в списке влияют на базовый массив и наоборот.
         * Ограничение фиксированного размера: несмотря на возможность изменения,
         * размер списка, возвращаемого Arrays.asList(), является фиксированным,
         * что предотвращает структурные модификации, такие как добавление или удаление элементов.
         * Нулевые значения: в отличие от List.of(), Arrays.asList() допускает нулевые элементы.
         */

        List nums = Arrays.asList(1, 2, 3); // так можно
        pr("nums.getClass() : " + nums.getClass()); //nums.getClass() : class java.util.Arrays$ArrayList


        Integer [] arr = {1, 2, 3};
        pr("arr[0].getClass() : " + arr[0].getClass()); //arr[0].getClass() : class java.lang.Integer
        List arrList = Arrays.asList(arr);
        pr(" arrList.get(0).getClass() : " +  arrList.get(0).getClass()); // arrList.get(0).getClass() : class java.lang.Integer

        arrList.set(0, 5);
        pr(" arrList.get(0) : " +  arrList.get(0));// 5

        //нельзя добавить или изменить новый элемент в списке:
        //arrList.set(3, 10); //java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 3
        //arrList.add(3,10); // java.lang.UnsupportedOperationException нельзя добавить новый элемент
        pr("arrList :" + arrList);

    }

        @Test
        void test4() {

        int[] nums1 = {1,2,3};
        pr(nums1.getClass()); //class [I
        pr(nums1); //[I@548a102f
        pr(nums1[0]); // 1




        Collection nums3 = new ArrayList<>(); // REDUNDED: new ArrayList<>()
        nums3 = List.of(1, 2, 3);
        pr(nums3.getClass()); // class java.util.ImmutableCollections$ListN
        pr(nums3.toString()); // [1, 2, 3]
        pr(((List<?>) nums3).get(0));

        Collection nums4 = List.of(1, 2, 3);
        pr(nums4.getClass()); // class java.util.ImmutableCollections$ListN
        pr(nums4); // [1, 2, 3]

    }
}
