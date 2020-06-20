package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    Repository repository = new Repository();
    Book one = new Book(1, "10 негритят", 1000, "Агата Кристи");
    Book two = new Book(2, "Происхождение", 2000, "Дэн Браун");
    Smartphone three = new Smartphone(3, "A40", 25000, "Samsung");
    Smartphone four = new Smartphone(4, "S20", 70000, "Samsung");


    @BeforeEach
    public void sutUp() {
        repository.save(one);
        repository.save(two);
        repository.save(three);
        repository.save(four);
    }

    @Test
    void shouldRemoveById() {
        int idToRemove = 2;
        repository.removeById(idToRemove);

        Product[] expected = new Product[]{one, three, four};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }
}