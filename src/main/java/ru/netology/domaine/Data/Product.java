package ru.netology.domaine.Data;

import java.util.Objects;

public class Product { //класс
    private int id; //поле класса содержащие id
    private String name; // поле класса содержащие имя
    private int price; // поле класса содержащие цену

    public Product() {  //конструктор без параметров
    }

    public Product(int id, String name, int price) { //конструктов со всеми параметрами
        this.id = id;
        this.name = name;
        this.price = price;
    }
//getter & setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && name == product.name && price == product.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name=" + name +
                ", price=" + price +
                '}';
    }
}
