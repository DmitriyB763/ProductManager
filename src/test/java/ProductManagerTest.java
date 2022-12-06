import org.junit.jupiter.api.Test;
import ru.netology.domaine.Data.Book;
import ru.netology.domaine.Data.Product;
import ru.netology.domaine.Manager.ProductManager;
import ru.netology.domaine.Repository.ProductRepository;
import ru.netology.domaine.Data.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(1,"book",100,"Petrov");
    Product book2= new Book(2,"white",200,"Ivanov");
    Product tel = new Smartphone(3,"samsung",10000,"china");
    Product tel2 = new Smartphone(4,"apple",20000,"USA");
    Product tel3 = new Smartphone(5,"xiaomi",20000,"china");
    Product tel4 = new Smartphone(7,"xiaomi",25000,"china");

    @Test
    void add() {
        manager.add(book1);
        manager.add(book2);



        //Product[] expected = {book1,book2};
        //Product[] actual = repo.showAll();

        assertArrayEquals(new Product[]{book1,book2},repo.showAll());
    }
    @Test
    void addWhenProductNotAdded(){
        //не добавляем ничего

        Product[] expected = {};
        Product[] actual = repo.showAll();

        assertArrayEquals(expected,actual);
    }

    @Test
    void searchByCreator() { //поиск по изготовителю
        manager.add(tel);
        manager.add(book1);
        manager.add(tel2);


        Product[] expected = {tel};
        Product[] actual = manager.searchBy("samsung");

        assertArrayEquals(expected,actual);
    }
    @Test
    void searchByAuthor(){ //поиск книги по автору
        manager.add(book1);
        manager.add(book2);

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Petrov");

        assertArrayEquals(expected,actual);
    }
    @Test
    void searchByNameBook(){// поис книги по названию
        manager.add(book1);
        manager.add(book2);

        Product[] expected = {book2};
        Product[] actual = manager.searchBy("white");

        assertArrayEquals(expected,actual);
    }
    @Test
    void searchBySeveralCreator(){ // поиск по изготовителю . если несколько моделей подходят
        manager.add(book2);
        manager.add(tel);
        manager.add(tel2);
        manager.add(tel3);

        Product[] expected = {tel,tel3};
        Product[] actual = manager.searchBy("china");

        assertArrayEquals(expected,actual);
    }
    @Test
    void serchByNotFound(){ //поиск несуществющего товара

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("rus");

        assertArrayEquals(expected,actual);
    }
    @Test
    void searchByNameSmarfone(){
        manager.add(book1);
        manager.add(tel);
        manager.add(tel2);
        manager.add(tel3);
        manager.add(tel4);

        Product[] expected = {tel3,tel4};
        Product[] actual = manager.searchBy("xiaomi");

        assertArrayEquals(expected,actual);

    }


}