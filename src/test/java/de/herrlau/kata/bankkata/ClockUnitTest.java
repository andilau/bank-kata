package de.herrlau.kata.bankkata;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


class ClockUnitTest {

    @Test
    void should_give_date_as_string_in_dd_MM_yyyy_format() {
        var clock = new TestableClock();

        String date = clock.dateAsString();

        assertThat(date).isEqualTo("21/08/2014");
    }

    private static class TestableClock extends Clock {

        @Override
        protected LocalDate today() {
            return LocalDate.of(2014, 8,21);
        }
    }
}