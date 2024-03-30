package map;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 2024-03-30
 * how to create map with follow pair of members:
 * "key=value", "key1=value1", "key2=value2"
 * ChatGPT3.5 answers:
 */
public class CreateMap {

    @Test
    public void main() {
        String[] pairs = {"key=value", "key1=value1", "key2=value2"};

        Map<String, String> expected = new HashMap<>();
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            if (keyValue.length == 2) {
                expected.put(keyValue[0], keyValue[1]);
            } else {
                System.out.println("Invalid pair: " + pair);
            }
        }
        System.out.println(expected); //{key1=value1, key2=value2, key=value}
    }

    @Test
    public static void main2() {
        String[] pairs = {"key=value", "key1=value1", "key2=value2"};

        Map<String, String> map = Arrays.stream(pairs)
                .map(pair -> pair.split("="))
                .collect(Collectors.toMap(
                        keyValue -> keyValue[0],
                        keyValue -> keyValue[1]
                ));

        System.out.println(map); //{key1=value1, key2=value2, key=value}
    }

    @Test
    public static void main3() {
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("key1", "value1");
        map.put("key2", "value2");

        System.out.println(map); //{key1=value1, key2=value2, key=value}
    }

    @Test
    public void main4() {
        Map<String, String> expected = Map.of(
                "A", "32",
                "C", "34",
                "T", "53"
        );
        System.out.println(expected); //{T=53, A=32, C=34}
    }
}
