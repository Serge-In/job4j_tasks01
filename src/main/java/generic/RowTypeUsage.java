package generic;

import org.testng.annotations.Test;

public class RowTypeUsage {
    @Test
    void main() {
        RowType<String, String> first = new RowType<>("First key", "First value");
        System.out.println("Вывод в консоль: " + first);

        RowType<Integer, String> second = new RowType<>(12345, "Second value");
        System.out.println("Вывод в консоль: " + second);
    }
}
