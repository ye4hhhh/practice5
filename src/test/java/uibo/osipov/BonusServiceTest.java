package uibo.osipov;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        long amount = 1000;
        boolean registered = true;
        long expected = 50;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 1000;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndUnderLimit() {
        BonusService service = new BonusService();
        long amount = 500;
        boolean registered = false;
        long expected = 5;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndOverLimit() {
        BonusService service = new BonusService();
        long amount = 200_000;
        boolean registered = false;
        long expected = 1000;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }
}
