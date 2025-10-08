package lessons.lesson03.OnlineStore;

public class Product {
    String code;
    String name;
    double price;
    int count;

    public Product(String code, String name, double price, int count) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.count = count;
    }
    public String getInfo() {
        return "Код: " + code + ", Название: " + name + ", Цена: " + price + ", Количество: " + count;
    }
}
