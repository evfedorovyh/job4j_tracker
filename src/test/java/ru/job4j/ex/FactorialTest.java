package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertThrows;

class FactorialTest {

    @Test
    public void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Factorial().calc(-1);
                });
        assertThat(exception.getMessage()).isEqualTo("Число не может быть меньше 0");
    }

    @Test
    public void whenFactorialIs() {
        int result = new Factorial().calc(6);
        int excepted = 720;
        assertThat(result).isEqualTo(excepted);
    }
}