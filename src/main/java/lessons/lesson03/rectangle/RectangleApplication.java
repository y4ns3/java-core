package lessons.lesson03.rectangle;

public class RectangleApplication {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(2,3);
        System.out.println("perimeter is: "+r.calculatePerimeter());
        System.out.println("square is: "+r.calculateSquare());
    }
}
