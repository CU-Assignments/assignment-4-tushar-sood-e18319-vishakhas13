import java.util.*;

class TicketBooking {
    private final Set<Integer> bookedSeats = new HashSet<>();
    public synchronized boolean bookSeat(int seatNumber, String customerType) {
        if (bookedSeats.contains(seatNumber)) {
            System.out.println(customerType + " Booking failed! Seat " + seatNumber + " is already booked.");
            return false;
        }
        bookedSeats.add(seatNumber);
        System.out.println(customerType + " Successfully booked seat " + seatNumber);
        return true;
    }
}
class BookingThread extends Thread {
    private final TicketBooking system;
    private final int seatNumber;
    private final String customerType;
    public BookingThread(TicketBooking system, int seatNumber, String customerType, int priority) {
        this.system = system;
        this.seatNumber = seatNumber;
        this.customerType = customerType;
        setPriority(priority);
    }
    @Override
    public void run() {
        system.bookSeat(seatNumber, customerType);
    }
}
public class TicketBookingSystem {
    public static void main(String[] args) {
        TicketBooking system = new TicketBooking();
        BookingThread vip1 = new BookingThread(system, 1, "VIP", Thread.MAX_PRIORITY);
        BookingThread vip2 = new BookingThread(system, 2, "VIP", Thread.MAX_PRIORITY);
        BookingThread regular1 = new BookingThread(system, 1, "Regular", Thread.MIN_PRIORITY);
        BookingThread regular2 = new BookingThread(system, 2, "Regular", Thread.MIN_PRIORITY);
        vip1.start();
        vip2.start();
        regular1.start();
        regular2.start();
    }
}
