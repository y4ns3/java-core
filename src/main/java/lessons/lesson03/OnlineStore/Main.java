package lessons.lesson03.OnlineStore;

// пример использования
public class Main {
    public static void main(String[] args) {
        Store store = new Store();

        store.addProduct("A001", "Ноутбук", 1200.0, 5);
        store.addProduct("A002", "Мышь", 25.0, 10);

        store.getProducts();
        store.getProductInfo("A001");

        store.buyProduct("A001", 2);
        store.buyProduct("A001", 10);

        store.getProducts();
    }
}
