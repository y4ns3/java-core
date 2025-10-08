package lessons.lesson03.OnlineStore;

import java.util.ArrayList;
import java.util.List;

public class Store {
        private List<Product> products = new ArrayList<>();

        public void addProduct(String code, String name, double price, int count) {
            Product product = new Product(code, name, price, count);
            products.add(product);
            System.out.println("Товар добавлен: " + name);
        }

        public void buyProduct(String code, int quantity) {
            for (Product p : products) {
                if (p.code.equals(code)) {
                    if (p.count >= quantity) {
                        p.count -= quantity;
                        System.out.println("Вы купили " + quantity + " шт. " + p.name);
                    } else {
                        System.out.println("Недостаточно товара на складе!");
                    }
                    return;
                }
            }
            System.out.println("Товар с кодом " + code + " не найден!");
        }

        public void getProductInfo(String code) {
            for (Product p : products) {
                if (p.code.equals(code)) {
                    System.out.println(p.getInfo());
                    return;
                }
            }
            System.out.println("Товар не найден!");
        }

        public void getProducts() {
            if (products.isEmpty()) {
                System.out.println("Магазин пуст.");
                return;
            }
            System.out.println("Список товаров:");
            for (Product p : products) {
                System.out.println(p.getInfo());
            }
        }

}
