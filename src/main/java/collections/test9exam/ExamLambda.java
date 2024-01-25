package collections.test9exam;

/**
 * 2024-01-24
 * повтор темы коллекции, подготовка к тестированию
 * эксперименты с коллекциями для удобства запуска отдельных методов перенес в пакет тестов
 */
public class ExamLambda {
    public static void main(String... args) {
        System.out.println("plug");

        //23 из 32. Что произойдёт в следующем примере?
        Integer a = null;
        int b = a; //Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.lang.Integer.intValue()" because "a" is null

        System.out.println(b);
    }
}
