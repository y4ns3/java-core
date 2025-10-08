package lessons.lesson03.book;

public class Book {
    private String isbn;
    private String name;
    private String author;
    private int year;
    private boolean status; //reserved or not reserved

    public Book(String isbn, String name, String author, int year, boolean status) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.year = year;
        this.status = status;
    }
    public void getBookInfo(){
        System.out.println("isbn: " + isbn);
        System.out.println("name: " + name);
        System.out.println("author: " + author);
        System.out.println("year: " + year);
        System.out.println("status: " + status);
    }
    public void reserveBook(){
        this.status = true;
    }
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
