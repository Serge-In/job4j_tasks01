package base;

public class IfElse {
    public static void main(String[] args) {
        //можно без {}
        if (1 > 0) System.out.println("ok 1");

        //можно без {}
        if (1 > 4) System.out.println("ok 2"); else System.out.println("ok 3");

        //то же самое с {}
        if (1 > 4) {
            System.out.println("ok 2");
        } else {
            System.out.println("ok 3");
        }

    }
}
