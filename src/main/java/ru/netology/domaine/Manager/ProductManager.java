package ru.netology.domaine.Manager;

import ru.netology.domaine.Data.Book;
import ru.netology.domaine.Data.Product;
import ru.netology.domaine.Data.Smartphone;
import ru.netology.domaine.Repository.ProductRepository;

import java.util.Arrays;

public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product productList) {
        repo.addProduct(productList);
    }


    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repo.showAll()) {
            if (matches(product, text)) {
                // "добавляем в конец" массива result продукт product
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = product;
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    /*private boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);}


    }*/
    public boolean matches(Product product, String search) {

        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().contains(search)) {
                return true;
            }
            if (book.getAuthor().contains(search)) {
                return true;
            }
            return false;
        } else if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getCreator().contains(search)) {
                return true;
            }
            if (smartphone.getName().contains(search)) {
                return true;
            }
        }

        return false;
    }
}

