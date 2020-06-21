package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerItemTest {
    Repository repository;
    ManagerItem manager = new ManagerItem(repository);
    Book one = new Book(1, "10 негритят", 300, "Агата Кристи");
    Book two = new Book(2, "Происхождение", 600, "Дэн Браун");
    Book three = new Book(3, "Код Да Винчи", 500, "Дэн Браун");
    Smartphone four = new Smartphone(4, "A40", 25000, "Samsung");
    Smartphone five = new Smartphone(5, "Pixel 4", 70000, "Google");
    Smartphone six = new Smartphone(6, "IPhone 11", 90000, "Apple");

    @BeforeEach
    public void sutUp() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
    }

    @Test
    void shouldSearchIfAuthorBookIsFind() {
        Product[] actual = manager.searchBy("Дэн Браун");
        Product[] expected = new Product[]{two, three};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchIfNameBookIsFind() {
        Product[] actual = manager.searchBy("10 негритят");
        Product[] expected = new Product[]{one};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchIfManufacturerPhonesIsFind() {
        Product[] actual = manager.searchBy("samsung");
        Product[] expected = new Product[]{four};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchIfNamePhoneIsFind() {
        Product[] actual = manager.searchBy("IPhone 11");
        Product[] expected = new Product[]{six};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchIfStringNotFind() {
        Product[] actual = manager.searchBy("java school");
        Product[] expected = new Product[0];

        assertArrayEquals(expected, actual);
    }
}