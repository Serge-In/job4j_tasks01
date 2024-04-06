package generic;

import org.testng.annotations.Test;

/**
 * 2024-04-03
 * 1. Что такое обобщенные типы (generics) [#4952]
 * Существует такое понятие, связанное с generics, как необработанные типы
 * (в литературе, интернете еще можно встретить такое название как "сырые типы").
 * Обозначаются они также как и generics в скобках <>,
 * в которых проставляются заглавные латинские символы, зарезервированные специально для этих целей символы
 * The most commonly used type parameter names are:
 *
 * E - Element (used extensively by the Java Collections Framework)
 * K - Key
 * N - Number
 * T - Type
 * V - Value
 * S,U,V etc. - 2nd, 3rd, 4th types
 * @param <K>
 * @param <V>
 */
public class RowType<K, V> {
    private K key;

    private V value;

    public RowType(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "GenericsClass{"
                + "key=" + key
                + ", value=" + value
                + '}';
    }

    @Test
    void main() {
        RowType<String, String> first = new RowType<>("First key", "First value");
        System.out.println("Вывод в консоль: " + first);

        RowType<Integer, String> second = new RowType<>(12345, "Second value");
        System.out.println("Вывод в консоль: " + second);
    }
}
