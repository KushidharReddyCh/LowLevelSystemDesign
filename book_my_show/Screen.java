package book_my_show;
import java.util.*;
public class Screen {
	
	int screenId;
	List<Seat> seats = new ArrayList<>();
	// screen width, height, ...metaData
	
	public int getScreenId() {
		return this.screenId;
	}
	
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	
	public List<Seat> getSeats(){
		return this.seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	
}
