package generic;

import java.util.Date;

/**
 * 2024-04-02
 * Вернемся к нашему классу Person и добавим ему наследника Programmer:
 */
public class Programmer extends Person {
    public Programmer(String name, int age, Date birthday) {
        super(name, age, birthday);
    }
}
