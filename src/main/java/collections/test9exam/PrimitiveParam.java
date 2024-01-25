package collections.test9exam;

/**
 * 2024-01-25
 * 31 из 32. Что будет выведено на консоль? Передача примитивного типа.
 * Ответ  -> 12
 */
public class PrimitiveParam {
    public static void main(String[] args) {
        int value = 1;
        PrimitiveParam.change(value);
        System.out.print(value);
        ++value;
        System.out.println(value);
    }

    public static void change(Integer value) {
        ++value;
    }
}
