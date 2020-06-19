package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    Book one = new Book(1, "10 негритят", 1000, "Агата Кристи");
    Book two = new Book(2, "Происхождение", 2000, "Дэн Браун");
    Smartphone three = new Smartphone(3, "A40", 25000, "Samsung");
    Smartphone four = new Smartphone(4, "S20", 70000, "Samsung");
    Repository repository = new Repository();

    @Test
    void shouldAddProductAndFindAll() {

        repository.save(one);
        repository.save(three);

        Product[] expected = new Product[]{one, three};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        int idToRemove = 2;
        repository.save(one);
        repository.save(two);
        repository.save(three);
        repository.save(four);

        repository.removeById(idToRemove);

        Product[] expected = new Product[]{one, three, four};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }
}