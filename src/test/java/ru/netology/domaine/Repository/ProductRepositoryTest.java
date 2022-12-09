package ru.netology.domaine.Repository;

import org.junit.jupiter.api.Test;
import ru.netology.domaine.Data.Book;
import ru.netology.domaine.Data.Product;
import ru.netology.domaine.Data.Smartphone;
import ru.netology.domaine.Manager.ProductManager;
import ru.netology.domaine.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();


    Product book1 = new Book(1, "book", 100, "Petrov");
    Product book2 = new Book(2, "white", 200, "Ivanov");
    Product tel = new Smartphone(3, "samsung", 10000, "china");
    Product tel2 = new Smartphone(4, "apple", 20000, "USA");
    Product tel3 = new Smartphone(5, "xiaomi", 20000, "china");
    Product tel4 = new Smartphone(7, "xiaomi", 25000, "china");


    @Test
    void removeById() { //успешное удаление элмента
        repo.addProduct(book1);
        repo.addProduct(book2);
        repo.addProduct(tel2);
        repo.addProduct(tel4);

        repo.removeById(4);// удаляем элемент с id 4
        Product[] expected = {book1, book2, tel4};
        Product[] actual = repo.showAll(); //вызываем показать все

        assertArrayEquals(expected, actual);

    }

    @Test
    void removeByNotId() { //удаление по несуществющему id
        repo.addProduct(book1);
        repo.addProduct(book2);
        repo.addProduct(tel2);
        repo.addProduct(tel4);


        assertThrows(NotFoundException.class, () -> {
            repo.removeById(-100);
        });


    }
}