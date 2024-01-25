package collections.test9exam;

/**
 * 2024-01-25
 * 30 из 32. Что будет выведено на консоли? Передача параметра ссылочного типа.
 */
public class RefTask {
    static void pr() { System.out.println(); } //для сокращения кода
    static void pr(Object o) { System.out.println(o); } //для сокращения кода
    static void pr(String str) { System.out.println(str); } //для сокращения кода
    public static void main(String[] args) {
        Integer value = 1;
        RefTask.change(value);
        pr("value : " + value);
    }

    public static void change(Integer value) {
        pr("value : " + value);
        ++value; pr("++value : " + value);
        value++; pr("value++ : " + value);
    }
}