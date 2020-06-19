package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.repository.Repository;


public class ManagerItem {
    String text;
    Repository repository = new Repository();

    public ManagerItem() {
    }

    public String getSearch() {
        return text;
    }

    public void setSearch(String search) {
        this.text = search;
    }

    public void add (Product item){
        repository.save(item);
    }

    public Product[] getAll (){
        Product[] items = repository.findAll();
        Product[] result = new Product[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public Product[] searcyBy(String text) {
        Product[] result = new Product[0];
        for (Product product: repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }
        // ваш код
    }
}
