package datatypes.string;

/**
 * 2024-01-10
 */
public class Split {
    public static void main(String[] args) {
        String str = "K2/SK1/SSK2";
        char separator = '/';
        System.out.println(str.indexOf('/')); //2
        System.out.println(str.split("/")); //[Ljava.lang.String;@b4c966a
        System.out.println(str.split("/", 2)); //[Ljava.lang.String;@2f4d3709
        System.out.println(str.substring(0, 2)); //K2
        System.out.println(str.substring(2 + 1, str.length())); //SK1/SSK2
        System.out.println(str.substring(0, str.indexOf(separator))); //K2
        System.out.println(str.substring(str.indexOf(separator) + 1, str.length())); //SK1/SSK2
    }
}
