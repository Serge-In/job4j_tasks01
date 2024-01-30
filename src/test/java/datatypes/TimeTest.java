package datatypes;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;

/**
 * 2024-01-30
 * таймер для отсчета времени выполнения
 */
public class TimeTest {
    @Test
    public void main() {
        Instant start = Instant.now();
        var res = 0;
        for (int i = 0; i < 100000; i++) {
            res += i;
        }
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("res = " + res + " ; timeElapsed = " + timeElapsed.getNano() + " ns(-9), " + timeElapsed.toMillis() + " ms(-3)");
        //res = 704982704 ; timeElapsed = 1998900 ns(-9), 1 ms(-3)

        //to copy
//        Instant start = Instant.now();
//        Instant end = Instant.now();
//        Duration timeElapsed = Duration.between(start, end);
//        System.out.println("timeElapsed = " + timeElapsed.getNano() + " ns(-9), " + timeElapsed.toMillis() + " ms(-3)");
    }
}
