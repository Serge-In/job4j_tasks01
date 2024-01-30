package datatypes;

import org.testng.annotations.Test;
import java.time.Duration;
import java.time.Instant;

/**
 * 2024-01-30
 */
public class Template{
@Test
    public void main() {
        Instant start = Instant.now();

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("timeElapsed = " + timeElapsed.getNano() / 1000000.0 + " ms(-3)"); //
    }
}