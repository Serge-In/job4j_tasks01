package generic;

/**
 * 2024-04-02
 * 1. Что такое обобщенные типы (generics) [#4952]
 */
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Collection;

public class GenericUsage {
    public static void main(String[] args) {

        List list = new ArrayList();
        list.add("first");
        list.add("second");
        list.add("third");
        //если при объявлении коллекции не указать тип элементов <> то они будут являться типов Object
        //поэтому если мы хотим извлечь такой элемент в String, то требуется даункастинг к типу String
        String o = (String) list.get(1);
        System.out.println("second == " + o);

        for (int i = 0; i < list.size(); i++) {
            String line = (String) list.get(i);
            System.out.println("Текущий элемент: " + line);
        }

        // до версии 1.5 это было бы невозможно привести тип Person к типу String.
        // в версии 1.5 были добавлены средства обобщенного программирования.
        // добавим в наш список экземпляр класса Person и выведем в консоль размер нашего списка:
        list.add(new Person("name", 21, new Date(913716000000L)));
        System.out.println("Количество элементов в списке: " + list.size());
    }

    /**
     * WildCard
     * мы хотим добавить универсальный метод, который будет выводить в консоль наш список. Выполним его следующим образом
     * Collection<Object> collection
     */
    public void printResult(Collection<Object> collection) {
        for (Iterator<Object> iterator = collection.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }

    /**
     * и попробуем его использовать в методе main() для типа данных в списке Integer:
     * new GenericUsage().printResult(list);
     * однако в данном случае мы получим ошибку компиляции, поскольку типы <Integer> и <Object> не совместимы.
     * Метод ожидает коллекцию с одним типом, а получает с другим. Collection<Object> не является выходом из проблемы.
     */
    @Test
    void main2() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        //new GenericUsage().printResult(list);
        //java: incompatible types: java.util.List<java.lang.Integer> cannot be converted to java.util.Collection<java.lang.Object>
    }

    /**
     * Для того чтобы решить эту проблему используется WildCard (обозначает <?>).
     * В этом случае ограничений в использовании не будет (т.е. он имеет соответствие с любым типом).
     */
    public void printResult2(Collection<?> collection) {
        for (Iterator<?> iterator = collection.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    void main3() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        new GenericUsage().printResult2(list); //ок
    }

    /**
     * 2. Bounded Wildcard
     * Вернемся к нашему классу Person и добавим ему наследника Programmer:
     * Теперь создадим метод который позволит вывести в консоль все элементы коллекции,
     * которая может содержать объекты Person или объекты класса Programmer:
     * если указать тип для Collection<Person> collection, то при вызове этого метода на другом типе (Programmer)
     * будет ошибка, поэтому применяется так называемое "Ограничение сверху".
     * В этом случае вместо <Person> записывается конструкция <? extends Person>
     */
//    public void printInfo(Collection<Person> collection) {
//        for (Iterator<Person> iterator = collection.iterator(); iterator.hasNext();) {
//            Person next = iterator.next();
//            System.out.println(next);
//        }
//    }

    public void printInfo(Collection<? extends Person> collection) {
        for (Iterator<? extends Person> iterator = collection.iterator(); iterator.hasNext();) {
            Person next = iterator.next();
            System.out.println(next.toString());
        }
    }

    @Test
    void main4() {
        List<Person> per = List.of(new Person("name", 21, new Date(913716000000L)));
        new GenericUsage().printInfo(per);

        List<Programmer> pro = List.of(new Programmer("name123", 23, new Date(913716000000L)));
        new GenericUsage().printInfo(pro);
    }

    /**
     * Lower bounded Wildcard
     * Аналогичным образом ограниченный снизу wildcard ограничивает неизвестный тип определенным типом или супертипом этого типа
     * Ограниченный снизу wildcard выражается с помощью wildcard символа ("?"),
     * за которым следует ключевое слово super после которого указывается нижняя граница - <? super A>.
     * Представим себе ситуацию, что мы хотим написать метод, который помещает объекты Integer в список и выводит этот список в консоль.
     * При этом наш метод должен быть более гибким и работал не только с типом Integer, но и с его суперклассами (т.е. Number и Object).
     * Чтобы реализовать такой метод, то в его объявлении должна фигурировать такая строка - List<? super Integer>.
     * >. Важно понимать, что запись List<Integer> является более строгой, чем List<? super Integer>,
     * потому что первый соответствует списку только типа Integer, тогда как второй соответствует списку любого типа,
     * который является супертипом Integer.
     */
    public void addAll(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        for (Object line : list) {
            System.out.println("Текущий элемент: " + line + "  .getClass() = " + line.getClass());
        }
    }

    @Test
    void main5() {
        List<? super Integer> list = new ArrayList<>();
        new GenericUsage().addAll(list); //Текущий элемент: 1  .getClass() = class java.lang.Integer
    }

    @Test
    void main6() {
        List<Number> list = new ArrayList<>();
        new GenericUsage().addAll(list); //Текущий элемент: 1  .getClass() = class java.lang.Integer
    }

    @Test
    void main7() {
        List<Object> list = new ArrayList<>();
        new GenericUsage().addAll(list); //Текущий элемент: 1  .getClass() = class java.lang.Integer
    }

    @Test
    void main8() {
        List<Byte> list = new ArrayList<>();
        //new GenericUsage().addAll(list);
        //java: incompatible types: java.util.List<java.lang.Byte> cannot be converted to java.util.List<? super java.lang.Integer>
    }
}
