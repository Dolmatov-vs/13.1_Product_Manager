package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerItemTest {
    ManagerItem manager = new ManagerItem();
    Book one = new Book(1, "10 негритят", 1000, "Агата Кристи");
    Book two = new Book(2, "Происхождение", 2000, "Дэн Браун");
    Smartphone three = new Smartphone(3, "A40", 25000, "Samsung");
    Smartphone four = new Smartphone(4, "S20", 70000, "Samsung");

    @Test
    void add() {
        manager.add(one);
        manager.add(three);

        Product[] expected = new Product[]{three,one};
        Product[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
    }

}