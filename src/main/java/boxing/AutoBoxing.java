package boxing;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.list;

/**
 * 2023-12-22
 * 3. Автоупаковка / автораспаковка [#504971]
 * Примитивные типы не являются ссылочными типами (объектами), поэтому если нам требуется объект примитивного типа, 
 * его значение должно быть упаковано в соответствующий класс-обёртку. Например, int в Integer или long в Long. 
 * Начиная с Java 5 такие преобразования выполняются компилятором автоматически и называются автоупаковкой и распаковкой.
 *
 * Распаковка и упаковка касается только единичных элементов.
 * Например, нельзя упаковать/распаковать таким образом массив int в лист Integer или распаковать лист в массив.
 *
 * Появление классов-обёрток обусловлено тем, что Java - это объектно-ориентированный язык,
 * и все сущности в идеале должны быть объектами. Но отказавшись от примитивных типов, упала бы производительность,
 * поэтому к существующим примитивным типам добавили соответствующие классы-обертки,
 * тем самым обеспечив гибкость работы с примитивными значениями.
 */

public class AutoBoxing {
    public static void main(String[] args) {
        autoBoxing1();
        System.out.println();

        //компилятор сделает автобоксинг, если есть метод c типом аргумента, к которому можно сделать автобоксинг
        //если есть перегруженные методы для разных типов аргумента, компилятор выберет наиболее подходящий метод без автобоксинга
        Integer x = 2;
        autoBoxing2(x); // Integer x = 2
        System.out.println();

        autoBoxing2(2); // int x = 2

        autoBoxing3();

        autoUnBoxing1();

        Integer y = 3;
        autoUnBoxing2(y); // Integer y = 2

        autoUnBoxing3();
        autoUnBoxing4();
     }

    //Авто Распаковка происходит в следующих случаях:
    private static void autoUnBoxing1() {
        //1) Если объект класса-обёртки присваивается переменной !соответствующего! примитивного типа. Например:
        System.out.println();
        System.out.println("*** autoUnBoxing1()");
        Integer s = 2;
        int p = s; // происходит автоматическая распаковка значения из ссылочного типа Integer (обёртки) в примитивный тип.
        System.out.println("Integer s = 2;  int p = s; int p = " + p);

        // Под капотом эта строка выглядит так: Метод intValue() класса Integer возвращает значение типа int.
        int p1 = s.intValue();
    }

    private static void autoUnBoxing2(int y) {
        //2) Если объект класса-обёртки передаётся в параметр метода, который предусматривает примитивный тип
        System.out.println();
        System.out.println("*** autoUnBoxing2(int y)");
        System.out.println("Integer y = 3; autoUnBoxing1(int y); int y = " + y);
    }

    private static void autoUnBoxing3() {
        // 3) В выражениях с использованием различных операторов типа +, -, *, /, % и т.д.,
        // если один или оба операнда являются объектами классов-обёрток
        System.out.println();
        System.out.println("*** autoUnBoxing3()");
        Integer k = 2;
        Integer n = 5;

        //В методе println() перемножаться будут уже распакованные значения.
        System.out.println("Integer k = 2; Integer n = 5;  println(k * n) : " + k * n);
    }

    private static void autoUnBoxing4() {
        // 4) В операциях == и != распаковка не применяется,
        // так как эти операторы выполняют сравнение объектов по ссылкам, а не по значениям.
        System.out.println();
        System.out.println("*** autoUnBoxing4() В операциях == и != распаковка не применяется");
        Integer k = 128;
        Integer n = 128;

        //Вывод будет false, так как сравнение будет по ссылкам,
        // а они будут вести на разные объекты типа Integer в памяти, хоть и значение в них будет одинаковое
        System.out.println("Integer k = 128; Integer n = 128;  println(k == n) : " + (k == n)); //--> false

        //Исключением являются только кэшированные значения из пула Integer
        //от -128 до 127 включительно (пул Integer мы будем проходить позже на уровне Джуниор).
        // В этом диапазоне разные ссылки всегда будут вести на элемент из кэша:

        Integer p = 127;
        Integer t = 127;
        System.out.println("Integer p = 127; Integer t = 127;  println(p == t) : " + (p == t)); //--> true
    }

    //Автоупаковка происходит в следующих случаях:
    private static void autoBoxing1() {
        System.out.println();
        System.out.println("*** autoBoxing1()");
        // 1. Если значение примитивного типа присваивается типу соответствующего класса-обёртки. Например:
        Integer b = 1; //под капотом вызывается метод valueOf() для упаковки значения 1 в тип Integer.
        System.out.println("Integer b = 1; b.getClass() : " + b.getClass());
        System.out.println("b.hashCode() : " + b.hashCode());

        int a = 1;
        System.out.println("int a = 1; a.getClass() : not possible for compilation (a isn't an object!)");

        //В следующей строке значение примитивного типа int присваивается типу Integer:
        Integer c = a;

        //Фактически типы int и Integer - разные, то есть должна была быть ошибка компиляции, но этого не произошло,
        // так как компилятор автоматически преобразовывает примитивные типы в их соответствующие обёртки
        //Под капотом эта строка выглядит так:
        c = Integer.valueOf(a);
        //Integer.valueOf() возвращает new Integer()
        //Integer.parseInt() возвращает примитивный int

        System.out.println("Integer c = a; c.getClass()  : " + c.getClass());
        System.out.println("Integer c = a; c.getClass().getName()  : " + c.getClass().getName());
        System.out.println("Integer c = a; c.getClass().getSimpleName()  : " + c.getClass().getSimpleName());

        boolean inst = c instanceof Integer;
        System.out.println("Integer c; c instanceof Integer : " + inst);
    }

    private static void autoBoxing2(Integer x) {
        System.out.println();
        System.out.println("*** autoBoxing2(Integer x)");
        //2. Если значение примитивного типа передаётся в параметр метода, который предусматривает соответствующий класс-обёртку.
        //НО! sample2(Long x) - будет ошибка, тк примитивный тип int нельзя автоматически перенести (автоупаковка) в Long

        System.out.println("x.getClass() : " + x.getClass());
    }

    //Но если в классе имеется подходящий перегруженный метод с параметром того же типа, то компилятор выберет его.
    // Добавим перегруженную версию метода num() в класс Box:

    private static void autoBoxing2(int x) {
        System.out.println();
        System.out.println("*** autoBoxing2(int x)");
        System.out.println("int x : " + x);
    }

    private static void autoBoxing3() {
        //Автоупаковка и распаковка очень часто происходит при работе с коллекциями,
        // так как они не могут хранить примитивные типы данных.
        System.out.println();
        System.out.println("*** autoBoxing3()");

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println("list: " + list);
        System.out.println("list.get(0): " + list.get(0));
        System.out.println("list.get(0).getClass(): " + list.get(0).getClass());
    }
}
