package ru.netology.domaine.Repository;

import ru.netology.domaine.Data.Product;

import java.util.Arrays;

public class ProductRepository {
    //создал массив для хранения продуктов , изначально пустой
    public Product[] productList = new Product[0];

    //сохранить продукт
    public void addProduct(Product product) {
        Product[] tmp = Arrays.copyOf(productList, productList.length + 1);
        int lastIndex = tmp.length -1;
        tmp[lastIndex] = product;
        productList = tmp;

    }

    //показать все продукты
    public Product[] showAll() {
        return productList;
    }

    public void removeById(int id) {
        int length = productList.length - 1; //задаю переменную в которую кладу длинну нового массива (это длинна старого массива -1)
        Product[] tmp = new Product[length];//создаю новый массив
        int lastIndex = 0;// переменная с номером ячейки куда буду копировать
        for (Product product : productList) {//циклом перебираю элементы массива
            if (product.getId() != id) { //если  текущий элемент не равен указанному
                tmp[lastIndex] = product;// то скопируй (соотвественно если  равно - не копирует)
                lastIndex++; // для увеличения ячейки массива
            }

        }
        productList = tmp;

    }
}

