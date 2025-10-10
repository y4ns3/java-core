package lessons.lesson06;

import lessons.lesson06.enums.SeatClass;
import lessons.lesson06.enums.SeatStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Seat implements Serializable {
    private final int number;
    private final SeatClass seatClass;
    private SeatStatus status;
    private String passengerName;
    private LocalDateTime bookingTime;

    public Seat(int number, SeatClass seatClass) {
        this.number = number;
        this.seatClass = seatClass;
        this.status = SeatStatus.AVAILABLE;
    }

    public int getNumber() { return number; }
    public SeatClass getSeatClass() { return seatClass; }
    public SeatStatus getStatus() { return status; }
    public String getPassengerName() { return passengerName; }
    public LocalDateTime getBookingTime() { return bookingTime; }

    public boolean isBooked() {
        return status == SeatStatus.BOOKED || status == SeatStatus.PAID;
    }

    public void book(String name) {
        this.status = SeatStatus.BOOKED;
        this.passengerName = name;
        this.bookingTime = LocalDateTime.now();
    }

    public void pay() {
        if (status == SeatStatus.BOOKED)
            this.status = SeatStatus.PAID;
    }

    public void cancel() {
        this.status = SeatStatus.AVAILABLE;
        this.passengerName = null;
        this.bookingTime = null;
    }

    @Override
    public String toString() {
        String info = String.format("Seat %02d [%s] - %s",
            number, seatClass, status);
        if (passengerName != null)
            info += " | " + passengerName;
        if (bookingTime != null)
            info += " | Booked at: " + bookingTime;
        return info;
    }
}
