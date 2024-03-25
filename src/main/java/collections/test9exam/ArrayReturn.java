package collections.test9exam;

import org.testng.annotations.Test;

/**
 * 2024-01-25
 * 32 из 32. Ссылочный тип данных - массив. Изменение значения ячейки на -1.
 */
public class ArrayReturn {
    private int[] values;

    public int[] sort(int[] values) {
        this.values = values;
        return values;
    }

    public void echo() {
        System.out.println(this.values[0]);
    }

    //@Test
    public static void main(String[] args) {
        ArrayReturn ar = new ArrayReturn();
        final int[] immutable = {1};
        final int[] ri = ar.sort(immutable);
        ri[0] = -1;
        ar.echo();
        System.out.println("ar.values[0] : " + ar.values[0]);
        System.out.println("immutable[0] : " + immutable[0]);
        System.out.println("ri[0] : " + ri[0]);
    }

    @Test
    public static void main2() {
        System.out.println("test");
    }
}