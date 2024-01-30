package math;

import org.testng.annotations.Test;
import java.time.Duration;
import java.time.Instant;

/**
 * 2024-01-30
 */
public class RandomTest {
@Test
    public void main() {
        Instant start = Instant.now();
        //
        int size = 10;
        for (int i = 0; i < size; i++) {
            double x = Math.random();
            System.out.println(x);
        }

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("timeElapsed = " + timeElapsed.getNano() / 1000000.0 + " ms(-3)"); //timeElapsed = 1.0008 ms(-3)

        //для сравнения варианты формата
        double duration1 = timeElapsed.getNano() / 1000000.0f; //timeElapsed = 1.997499942779541 ms(-3)
        double duration2 = timeElapsed.getNano() / 1000000.0; //timeElapsed = 1.9982 ms(-3)
        double duration3 = timeElapsed.getNano() / 1000000.00; //timeElapsed = 2.0001 ms(-3)
        double duration4 = timeElapsed.getNano() / 1000000; //timeElapsed = 2.0001 ms(-3)

        System.out.println("timeElapsed = " + duration1 + " ms(-3)");
        System.out.println("timeElapsed = " + duration2 + " ms(-3)");
        System.out.println("timeElapsed = " + duration3 + " ms(-3)");
        System.out.println("timeElapsed = " + duration4 + " ms(-3)");
        //    timeElapsed = 1.9989999532699585 ms(-3)
        //    timeElapsed = 1.999 ms(-3)
        //    timeElapsed = 1.999 ms(-3)
        //    timeElapsed = 1.0 ms(-3)
    }
}

