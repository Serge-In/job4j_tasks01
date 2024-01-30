package datatypes;

import org.testng.annotations.Test;

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
        //res = 704982704 ; timeElapsed = 5002400 ns(-9), 5 ms(-3)

        //сколько времени выполняется отдельный вызов класса Instant?
        start = Instant.now();
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("res = " + res + " ; timeElapsed = " + timeElapsed.getNano() + " ns(-9), " + timeElapsed.toMillis() + " ms(-3)");
        //res = 704982704 ; timeElapsed = 0 ns(-9), 0 ms(-3)


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


        //to copy
//        Instant start = Instant.now();
//        Instant end = Instant.now();
//        Duration timeElapsed = Duration.between(start, end);
//        System.out.println("timeElapsed = " + timeElapsed.getNano() + " ns(-9), " + timeElapsed.toMillis() + " ms(-3)");

        //to copy !! если делать как ниже - в одну строку время выполнения будет разное в ms и ns
//        Instant start = Instant.now();
//        System.out.println("timeElapsed = " + Duration.between(start, Instant.now()).getNano() + " ns(-9), " + Duration.between(start, Instant.now()).toMillis() + " ms(-3)");


        //to copy - лучший вариант
//        Instant start = Instant.now();
//        Instant end = Instant.now();
//        Duration timeElapsed = Duration.between(start, end);
//        System.out.println("timeElapsed = " + timeElapsed.getNano() / 1000000.0 + " ms(-3)"); //

    }
}
