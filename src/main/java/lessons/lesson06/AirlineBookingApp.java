package lessons.lesson06;

import java.io.*;
import java.util.*;

public class AirlineBookingApp {
    private static final String FILE = "seats.dat";

    public static void main(String[] args) {
        Airplane airplane = loadData();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== AIRLINE BOOKING SYSTEM ===");
            System.out.println("1. Show all seats");
            System.out.println("2. Draw airplane layout");
            System.out.println("3. Book a seat");
            System.out.println("4. Cancel booking");
            System.out.println("5. Find seat info");
            System.out.println("6. Pay for seat");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> airplane.showAllSeats();
                case 2 -> airplane.drawPlane();
                case 3 -> {
                    System.out.print("Enter seat number: ");
                    int num = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter passenger name: ");
                    String name = sc.nextLine();
                    if (airplane.bookSeat(num, name))
                        System.out.println("Seat booked successfully!");
                    else System.out.println("Seat already booked or not found.");
                }
                case 4 -> {
                    System.out.print("Enter seat number to cancel: ");
                    int num = sc.nextInt();
                    if (airplane.cancelBooking(num))
                        System.out.println("Booking cancelled.");
                    else System.out.println("Seat not booked or not found.");
                }
                case 5 -> {
                    System.out.print("Enter seat number: ");
                    int num = sc.nextInt();
                    airplane.showSeatInfo(num);
                }
                case 6 -> {
                    System.out.print("Enter seat number to pay: ");
                    int num = sc.nextInt();
                    if (airplane.payForSeat(num))
                        System.out.println("Seat paid successfully!");
                    else System.out.println("Seat not booked or already paid.");
                }
                case 7 -> {
                    saveData(airplane);
                    System.out.println("Data saved. Exiting...");
                    running = false;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void saveData(Airplane airplane) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
            oos.writeObject(airplane);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private static Airplane loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))) {
            return (Airplane) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new Airplane();
        }
    }
}
