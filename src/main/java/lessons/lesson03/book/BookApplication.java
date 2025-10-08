package lessons.lesson03.book;

public class BookApplication {
    public static void main(String[] args) {
        Book b = new Book("123","some book","Goethe",1897,false);
        b.getBookInfo();
        b.reserveBook();
        b.getBookInfo();
    }
}
