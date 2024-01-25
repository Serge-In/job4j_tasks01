package collections.test9exam;
/**
 * 2024-01-24
 * эксперименты для удобства запуска отдельных методов перенес сюда - в пакет тестов
 */
import org.junit.jupiter.api.Test;

class ExamLambdaTest {
    static void pr() {System.out.println();} //для сокращения кода
    static void pr(Object o) {System.out.println(o);} //для сокращения кода
    static void pr(String str) {System.out.println(str);} //для сокращения кода

    @FunctionalInterface
    interface Operationable {
        int calculate(int x, int y);
    }
    @Test
    void main() {
        //int n = 3;
        //n -> n * n;
        //(x, y) -> x * y;
        //operation = (int x, int y) -> x + y;
        Operationable operation = (x, y) -> x + y;
        pr(operation.calculate(2, 4));
        pr();

    }
}