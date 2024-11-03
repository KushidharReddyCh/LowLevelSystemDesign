package book_my_show;

import java.util.*;


public class Booking {
	static int BOOKING_ID = 0;
	
	int bookindId;
	Show show;
	Payment payment;
	List<Seat> bookedSeats = new ArrayList<>();
	
	public Booking() {
		this.bookindId = BOOKING_ID;
		BOOKING_ID = BOOKING_ID + 1;
	}
	
    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getBookedSeats() {
        return this.bookedSeats;
    }

    public void setBookedSeats(List<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
