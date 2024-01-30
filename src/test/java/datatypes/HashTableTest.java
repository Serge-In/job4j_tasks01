package datatypes;

import org.testng.annotations.Test;
import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * 2024-01-30
 */
public class HashTableTest {
    @Test
    public void main() {
        Instant start = Instant.now();
        //
        Set<String> hashSet = new HashSet();
        hashSet.add("zero");
        int size = 10;
        for (int i = 0; i < size; i++) {
            double x = Math.random();
            System.out.println(x);
        }

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("timeElapsed = " + timeElapsed.getNano() + " ns(-9), " + timeElapsed.toMillis() + " ms(-3)");
    }
}