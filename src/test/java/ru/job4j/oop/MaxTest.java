package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class MaxTest {

    @Test
    public void when2and6Then6() {
        int result = Max.getMax(2, 6);
        int expected = 6;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void when2and6and10Then10() {
        int result = Max.getMax(2, 6, 10);
        int expected = 10;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void when2and6and10and15Then15() {
        int result = Max.getMax(2, 6, 10, 15);
        int expected = 15;
        assertThat(result).isEqualTo(expected);
    }
}