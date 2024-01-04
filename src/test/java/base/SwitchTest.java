package base;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class SwitchTest {

        @Test
        void when1ThenMonday() {
            int day = 1;
            String expected = "Понедельник";
            String result = Switch.nameOfDay1(day);
            assertThat(result).isEqualTo(expected);
        }

        @Test
        void when0ThenError() {
            int day = 0;
            String expected = "Ошибка";
            String result = Switch.nameOfDay1(day);
            assertThat(result).isEqualTo(expected);
        }
}