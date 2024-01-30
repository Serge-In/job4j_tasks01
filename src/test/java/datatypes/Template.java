package datatypes;

import org.junit.Test;
import java.time.Duration;
import java.time.Instant;

/**
 * 2024-01-30
 */
public class Template{
    @Test
    public void main() {
        Instant start = Instant.now();
        //
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("timeElapsed = " + timeElapsed.getNano() + " ns(-9), " + timeElapsed.toMillis() + " ms(-3)");
    }
}