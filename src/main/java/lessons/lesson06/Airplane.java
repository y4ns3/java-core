package lessons.lesson06;

import lessons.lesson06.enums.SeatClass;
import lessons.lesson06.enums.SeatStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Airplane implements Serializable {
    private final List<Seat> seats;
    private LocalDateTime flightDate;

    public Airplane() {
        seats = new ArrayList<>();
        // Ряды 1–5 — бизнес, 6–21 — эконом
        for (int i = 1; i <= 5; i++) seats.add(new Seat(i, SeatClass.BUSINESS));
        for (int i = 6; i <= 21; i++) seats.add(new Seat(i, SeatClass.ECONOMY));

        // по умолчанию вылет завтра в 12:00
        this.flightDate = LocalDateTime.now().plusDays(1).withHour(12).withMinute(0);
    }

    /** Отображение всех мест с автоочисткой просроченных броней */
    public void showAllSeats() {
        clearExpiredBookings();
        System.out.println("=== FLIGHT DATE: " + flightDate + " ===");
        for (Seat seat : seats) System.out.println(seat);
    }

    /** Схематичный рисунок самолёта */
    public void drawPlane() {
        clearExpiredBookings();
        System.out.println("\n=== AIRBUS A319 === (Flight: " + flightDate + ")");
        for (Seat seat : seats) {
            String mark = switch (seat.getStatus()) {
                case AVAILABLE -> "[ ]";
                case BOOKED -> "[B]";
                case PAID -> "[P]";
            };
            System.out.print(mark);
            if (seat.getNumber() % 6 == 0) System.out.println();
        }
        System.out.println();
    }

    /** Бронирование места */
    public boolean bookSeat(int number, String name) {
        Seat seat = findSeat(number);
        if (seat != null && seat.getStatus() == SeatStatus.AVAILABLE) {
            seat.book(name);
            return true;
        }
        return false;
    }

    /** Оплата забронированного места */
    public boolean payForSeat(int number) {
        Seat seat = findSeat(number);
        if (seat != null && seat.getStatus() == SeatStatus.BOOKED) {
            seat.pay();
            return true;
        }
        return false;
    }

    /** Отмена бронирования */
    public boolean cancelBooking(int number) {
        Seat seat = findSeat(number);
        if (seat != null && seat.isBooked()) {
            seat.cancel();
            return true;
        }
        return false;
    }

    /** Информация по конкретному месту */
    public void showSeatInfo(int number) {
        Seat seat = findSeat(number);
        if (seat != null) System.out.println(seat);
        else System.out.println("Seat not found.");
    }

    /** Сброс броней старше 24 минут */
    private void clearExpiredBookings() {
        LocalDateTime now = LocalDateTime.now();
        for (Seat seat : seats) {
            if (seat.getStatus() == SeatStatus.BOOKED && seat.getBookingTime() != null) {
                long minutes = ChronoUnit.MINUTES.between(seat.getBookingTime(), now);
                if (minutes >= 24) seat.cancel();
            }
        }
    }

    private Seat findSeat(int number) {
        for (Seat s : seats)
            if (s.getNumber() == number)
                return s;
        return null;
    }

    public LocalDateTime getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDateTime flightDate) {
        this.flightDate = flightDate;
    }
}
