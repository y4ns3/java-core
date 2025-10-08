package lessons.lesson06;

import lessons.lesson06.enums.SeatClass;

import java.io.Serializable;

public class Seat implements Serializable {
    private final int number;
    private final SeatClass seatClass;
    private boolean booked;
    private String passengerName;

    public Seat(int number, SeatClass seatClass) {
        this.number = number;
        this.seatClass = seatClass;
        this.booked = false;
        this.passengerName = "";
    }

    public int getNumber() { return number; }
    public SeatClass getSeatClass() { return seatClass; }
    public boolean isBooked() { return booked; }
    public String getPassengerName() { return passengerName; }

    public void book(String name) {
        booked = true;
        passengerName = name;
    }

    public void cancel() {
        booked = false;
        passengerName = "";
    }

    @Override
    public String toString() {
        return String.format("Seat %02d [%s] - %s",
            number, seatClass,
            booked ? "BOOKED by " + passengerName : "AVAILABLE");
    }
}


