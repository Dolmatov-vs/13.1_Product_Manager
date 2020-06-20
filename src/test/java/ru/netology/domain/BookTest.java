package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book one = new Book(1, "10 негритят", 300, "Агата Кристи");

    @Test
    void shouldNameBookIsTrue() {
        assertTrue(one.matches("10 негритят"));
    }

    @Test
    void shouldNameBookIsFalse() {
        assertFalse(one.matches("11 негритят"));
    }

    @Test
    void shouldAuthorBookIsTrue() {
        assertTrue(one.matches("Агата Кристи"));
    }

    @Test
    void shouldAuthorBookIsFalse() {
        assertFalse(one.matches("Дэн Браун"));
    }
}