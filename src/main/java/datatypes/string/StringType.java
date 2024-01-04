package datatypes.string;

public class StringType {

    public static void main(String[] args) {
        String first = new String("one");
        String one = new String("one");
        if (first == one) {
            System.out.println("first equals one");
        } else {
            System.out.println("first does not equal one");
        }
        /*Метод equals для String сравнивает значения, записанные в Heap.
        Если области памяти заполнены одинаково, то метод вернет значение true.*/
        if (first.equals(one)) {
            System.out.println("first equals one");
        } else {
            System.out.println("first does not equal one");
        }
    }
}
