package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Smartphone three = new Smartphone(1, "Pixel", 70000, "Google");

    @Test
    void shouldNameSmartphoneIsTrue() {
        assertTrue(three.matches("Pixel"));
    }

    @Test
    void shouldNameSmartphoneIsFalse() {
        assertFalse(three.matches("Pixel XL"));
    }

    @Test
    void shouldManufacturerSmartphoneIsTrue() {
        assertTrue(three.matches("Google"));
    }

    @Test
    void shouldManufacturerSmartphoneIsFalse() {
        assertFalse(three.matches("Samsung"));
    }
}