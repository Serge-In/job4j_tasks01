package search;

import java.util.function.Predicate;

/**
 * 2024-03-13
 * Question:
 * I have the class with these String fieldes: name, age, telephone
 * And the String key, that can be any of  field's type (key may be name or age or telephone)
 *
 * Could U help to write 3 predicates for chek Equals value of key to any fields ?
 *
 * The Answer:
 * The isEqualToField() method returns a predicate based on the key provided.
 * We use a switch expression to determine which field to compare with the key.
 * Each case returns a method reference to the equals() method of the respective field.
 * We then test these predicates with sample values to verify their correctness.
 *
 * .apply method is cannot resolve in Predicate
 *
 * You're correct; my apologies for the confusion. The apply method is not directly available in the Predicate interface.
 * Instead, you can use the test method directly. Let me correct that:
 */
public class MyClassGPT35 {
    private String name;
    private String age;
    private String telephone;

    public MyClassGPT35(String name, String age, String telephone) {
        this.name = name;
        this.age = age;
        this.telephone = telephone;
    }

    public Predicate<String> isEqualToField(String key) {
        return switch (key) {
            case "name" -> value -> value.equals(name);
            case "age" -> value -> value.equals(age);
            case "telephone" -> value -> value.equals(telephone);
            default -> throw new IllegalArgumentException("Invalid key: " + key);
        };
    }

    public static void main(String[] args) {
        MyClassGPT35 obj = new MyClassGPT35("John", "30", "123456789");

        // Testing the predicates
        Predicate<String> namePredicate = obj.isEqualToField("name");
        System.out.println("Name is equal: " + namePredicate.test("John")); // Output: true

        Predicate<String> agePredicate = obj.isEqualToField("age");
        System.out.println("Age is equal: " + agePredicate.test("30")); // Output: true

        Predicate<String> telephonePredicate = obj.isEqualToField("telephone");
        System.out.println("Telephone is equal: " + telephonePredicate.test("123456789")); // Output: true
    }
}