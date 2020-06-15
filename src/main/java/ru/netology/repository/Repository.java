package ru.netology.repository;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class Repository {

    private Book[] books = new Book[0];
    private Smartphone[] smartphones = new Smartphone[0];
//    Product[] products = new Product[0];



    public Product[] findAll() {
        Product[] products = new Product[books.length + smartphones.length];
        System.arraycopy(books, 0, products, 0, books.length);
        System.arraycopy(smartphones, 0, products, books.length, smartphones.length);
        return products;
    }

    public void save(Book book) {
        int length = books.length + 1;
        Book[] tmp = new Book[length];
        System.arraycopy(books, 0, tmp, 0, books.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = book;
        books = tmp;
    }

    public void save(Smartphone smartphone) {
        int length = smartphones.length + 1;
        Smartphone[] tmp = new Smartphone[length];
        System.arraycopy(smartphones, 0, tmp, 0, smartphones.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = smartphone;
        smartphones = tmp;
    }

    public void removeById(int id) {
        int lengthBook = books.length - 1;
        Book[] tmpBook = new Book[lengthBook];
        for (Book book : books) {
            if (book.getId() != id) {
                int index = 0;
                tmpBook[index] = book;
                index++;
            }
        }
        books = tmpBook;

        int lengthSmart = smartphones.length;
        Smartphone[] tmpSmart = new Smartphone[lengthSmart];
        for (Smartphone smartphone : smartphones) {
            if (smartphone.getId() != id) {
                int index = 0;
                tmpSmart[index] = smartphone;
                index++;
            }
        }
        smartphones = tmpSmart;
    }
}
