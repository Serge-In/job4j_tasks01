package search;

import java.util.function.Predicate;

/**
 * 2024-03-14
 *
 */
public class MyClassGPT4 {

    private String name;
    private String age;
    private String telephone;

    public MyClassGPT4(String name, String age, String telephone) {
        this.name = name;
        this.age = age;
        this.telephone = telephone;
    }

    private Object getTelephone() {
        return this.telephone;
    }

    private Object getAge() {
        return this.age;
    }

    private Object getName() {
        return this.name;
    }

    Predicate<MyClassGPT4> complexPredicate(String key) {
        Predicate<MyClassGPT4> checkNamePredicate = obj -> obj.getName().equals(key);
        Predicate<MyClassGPT4> checkAgePredicate = obj -> obj.getAge().equals(key);
        Predicate<MyClassGPT4> checkTelephonePredicate = obj -> obj.getTelephone().equals(key);

        Predicate<MyClassGPT4> combinedPredicate = checkNamePredicate.or(checkAgePredicate).or(checkTelephonePredicate);

        return combinedPredicate;
    }

    public static void main(String[] args) {
        MyClassGPT4 obj = new MyClassGPT4("John", "30", "123456789");

        // Testing the predicates
        System.out.println(obj.complexPredicate("30")); //java.util.function.Predicate$$Lambda$18/0x0000000800c45ef8@5fd0d5ae

        System.out.println(obj.complexPredicate("name").test(obj)); //false
        System.out.println(obj.complexPredicate("John").test(obj)); //true
        System.out.println(obj.complexPredicate("30").test(obj)); //true
        System.out.println(obj.complexPredicate("123456789").test(obj)); //true
        System.out.println(obj.complexPredicate("12345678").test(obj)); //false
    }
}