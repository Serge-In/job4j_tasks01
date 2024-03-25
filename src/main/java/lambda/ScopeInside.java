package lambda;

import java.util.function.Supplier;

/**
 * 2024-03-13
 * 5. Зона видимости в лямбда-выражениях и исключения [#70609 #485756]
 */
public class ScopeInside {
    public static void main(String[] args) {
       //1
        String name = echo(
                () -> {
                    String ayyyy = "ayyyyy";
                    return ayyyy;
                }
        );
        System.out.println(name);
       // Переменная, объявленная внутри лямбда-выражения, доступна только в самом лямбда-выражении.
       // System.out.println(ayyyy);

        //2
        String ayyyy2 = "ayyyyy2";
        String name2 = echo(
                () -> {
                    // Переменную, объявленную вне лямбда-выражения, изменять внутри лямбда-выражения нельзя.
                    //ayyyy2 += "_мяу";
                    return ayyyy2;
                }
        );
        System.out.println(name2);

        //3
        /**
         * Если в лямбда-выражении используется локальная переменная, объявленная на уровне класса вне этого выражения
         * (то есть локальная переменная метода), то это называется захватом переменной. Захваченную переменную,
         * в нашем случае это переменная ауууу3, изменять нельзя, так как в лямбда-выражении захваченная переменная
         * не может быть изменена после своей инициализации.
         * Можно использовать либо переменные с модификатором final, либо effective final переменные.
         * effective final - это обычные переменные, только которые больше не изменяются после своей инициализации.
         */
        String ayyyy3 = "ayyyyy3";
        //Захваченную переменную ауууу3, изменять нельзя
        //ayyyy3 = "ayyyyy5";

        String name3 = echo(
                () -> {
                    // Переменную, объявленную вне лямбда-выражения, изменять внутри лямбда-выражения нельзя.
                    //java: local variables referenced from a lambda expression must be final or effectively final
                    return ayyyy3;
                }
        );
        System.out.println(name3);
}

    private static String echo(Supplier<String> supplier) {
        String sound = supplier.get();
        return sound + " " + sound + " " + sound;
    }
}