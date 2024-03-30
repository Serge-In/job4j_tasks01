package exeption;

/**
 * 2024-03-30
 * 4. Утверждения с исключениями [#504886]
 * Метод getName() выбросит исключение IllegalArgumentException, если поле name не заполнено,
 * а метод setName(String word, int number) - если введены несогласованные данные (длина переменной word не совпадает со значением переменной number).
 */
public class SimpleModel {
    private String name = "";

    public String getName() {
        if (name.length() == 0) {
            throw new IllegalArgumentException();
        }
        return name;
    }

    public void setName(String word, int number) {
        if (word.length() != number) {
            throw new IllegalArgumentException(
                    String.format("this word: %s has length not equal to : %s", word, number)
            );
        }
        this.name = word;
    }

//    @Test
//    public static void main() {
//        void checkGetName () {
//            SimpleModel simpleModel = new SimpleModel();
//            assertThatThrownBy(simpleModel::getName)
//                    .isInstanceOf(IllegalArgumentException.class);
//        }
//    }

}
