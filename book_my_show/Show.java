package book_my_show;

import java.util.*;

public class Show {
	
	int showId;
	int showStartTime;
	int showEndTime;
	Movie movie;
	Screen screen;
	List<Integer> bookedSeatIds = new ArrayList<>();
	
	public int getShowEndTime() {
		return showEndTime;
	}

	public void setShowEndTime(int showEndTime) {
		this.showEndTime = showEndTime;
	}

	public List<Integer> getBookedSeatIds() {
		return bookedSeatIds;
	}

	public void setBookedSeatIds(List<Integer> bookedSeatIds) {
		this.bookedSeatIds = bookedSeatIds;
	}

	public int getShowStartTime() {
		return showStartTime;
	}

	public void setShowStartTime(int showStartTime) {
		this.showStartTime = showStartTime;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

}
