package book_my_show;

public class Seat {
	
	int seatId;
	float seatPrice;
	SeatCategory seatCategory;
	// seat row, seat col, etc... meta data...
	
	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public float getSeatPrice() {
		return seatPrice;
	}

	public SeatCategory getSeatCategory() {
		return seatCategory;
	}

	public void setSeatCategory(SeatCategory seatCategory) {
		this.seatCategory = seatCategory;
	}
	
	public void setSeatPrice(float seatPrice) {
		this.seatPrice = seatPrice;
	}
}
