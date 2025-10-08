package lessons.lesson06;

import lessons.lesson06.enums.SeatClass;

import java.io.*;
import java.util.*;

public class Airplane implements Serializable {
    private final List<Seat> seats;

    public Airplane() {
        seats = new ArrayList<>();
        // Ряды 1–5 — бизнес, 6–21 — эконом (упрощённо)
        for (int i = 1; i <= 5; i++) seats.add(new Seat(i, SeatClass.BUSINESS));
        for (int i = 6; i <= 21; i++) seats.add(new Seat(i, SeatClass.ECONOMY));
    }

    public void showAllSeats() {
        for (Seat seat : seats) System.out.println(seat);
    }

    public void drawPlane() {
        System.out.println("\n=== AIRBUS A319 ===");
        for (Seat seat : seats) {
            String mark = seat.isBooked() ? "[X]" : "[ ]";
            System.out.print(mark);
            if (seat.getNumber() % 6 == 0) System.out.println();
        }
        System.out.println();
    }

    public boolean bookSeat(int number, String name) {
        Seat seat = findSeat(number);
        if (seat != null && !seat.isBooked()) {
            seat.book(name);
            return true;
        }
        return false;
    }

    public boolean cancelBooking(int number) {
        Seat seat = findSeat(number);
        if (seat != null && seat.isBooked()) {
            seat.cancel();
            return true;
        }
        return false;
    }

    public void showSeatInfo(int number) {
        Seat seat = findSeat(number);
        if (seat != null) System.out.println(seat);
        else System.out.println("Seat not found.");
    }

    private Seat findSeat(int number) {
        for (Seat s : seats)
            if (s.getNumber() == number)
                return s;
        return null;
    }
}
