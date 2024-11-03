package book_my_show;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class BookMyShow {

	MovieController movieController;
	TheatreController theatreController;
	
	BookMyShow(){
		movieController = new MovieController();
		theatreController = new TheatreController();
	}
	
	public static void main(String args[]) {
		
		BookMyShow bms = new BookMyShow();
		
		bms.initialize();
		
		// user1
		bms.createBooking(City.Banglore, "BAAHUBALI");
		
		// user2
		bms.createBooking(City.Banglore, "BAAHUBALI");

		// user3
		bms.createBooking(City.Delhi, "BAAHUBALI");
		
		// user3
		bms.createBooking(City.Delhi, "BAAHUBALI");
	}
	
	private void initialize() {
		// create movies
		createMovies();
		
		// create theater, with screens, seats and shows
		createTheatre();
	}
	
	private void createMovies() {
		
		// create Avengers Movie
		Movie avengers = new Movie();
		avengers.setMovieId(1);
		avengers.setMovieName("AVENGERS");
		avengers.setMovieDuration(128);
		
		// create Baahubali movie
		Movie baahubali = new Movie();
		baahubali.setMovieId(2);
		baahubali.setMovieName("BAAHUBALI");
		baahubali.setMovieDuration(180);
		
		// add movies against cities
		movieController.addMovie(avengers, City.Banglore);
		movieController.addMovie(avengers, City.Delhi);
		movieController.addMovie(baahubali, City.Banglore);
		movieController.addMovie(baahubali, City.Delhi);
		
	}
	
	private void createTheatre() {
		
		Movie avengers = movieController.getMovieByName("AVENGERS");
		Movie baahubali = movieController.getMovieByName("BAAHUBALI");
		
		Theatre inox = new Theatre();
		inox.setTheatreId(1);
		inox.setScreen(createScreens(10));
		inox.setCity(City.Banglore);
		List<Show> inoxShowList = new ArrayList<>();
		Show inoxMorningShow = createShows(1, inox.getScreen().get(0), avengers, 8);
		Show inoxEveningShow = createShows(2, inox.getScreen().get(0), baahubali, 16);
		inoxShowList.add(inoxMorningShow);
		inoxShowList.add(inoxEveningShow);
		inox.setShows(inoxShowList);
		
		
		 Theatre pvr = new Theatre();
	     pvr.setTheatreId(2);
	     pvr.setScreen(createScreens(5));
	     pvr.setCity(City.Delhi);
	     List<Show> pvrShowList = new ArrayList<>();
	     Show pvrMorningShow = createShows(3, pvr.getScreen().get(0), avengers, 13);
	     Show pvrEveningShow = createShows(4, pvr.getScreen().get(0), baahubali, 20);
	     pvrShowList.add(pvrMorningShow);
	     pvrShowList.add(pvrEveningShow);
	     pvr.setShows(pvrShowList);	
	     
	     theatreController.addTheatre(inox, City.Banglore);
	     theatreController.addTheatre(pvr, City.Delhi);
	}

	private Show createShows(int showId, Screen screen, Movie movie, int showStartTime) {
		
		Show show = new Show();
		show.setShowId(showId);
	    show.setScreen(screen);
	    show.setMovie(movie);
	    show.setShowStartTime(showStartTime); //24 hrs time ex: 14 means 2pm and 8 means 8AM
	    return show;		
	}

	private List<Screen> createScreens(int number) {
		
		List<Screen> screenList = new ArrayList<>();
		
		for(int id = 0; id < number; id++) {
			Screen screen = new Screen();
			screen.setScreenId(id);
			screen.setSeats(createSeats());
			screenList.add(screen);
		}	
		
		return screenList;
	}

	private List<Seat> createSeats() {
		
		//creating 100 seats for testing purpose, this can be generalised
        List<Seat> seats = new ArrayList<>();

        //1 to 40 : SILVER
        for (int i = 0; i < 40; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.SILVER);
            seats.add(seat);
        }

        //41 to 70 : SILVER
        for (int i = 40; i < 70; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.GOLD);
            seats.add(seat);
        }

        //1 to 40 : SILVER
        for (int i = 70; i < 100; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.PLATINUM);
            seats.add(seat);
        }

        return seats;

	}

    private void createBooking(City userCity, String movieName) {


        //1. search movie by my location
        List<Movie> movies = movieController.getMoviesByCity(userCity);

        //2. select the movie which you want to see. i want to see Baahubali
        Movie interestedMovie = null;
        for (Movie movie : movies) {

            if ((movie.getMovieName()).equals(movieName)) {
                interestedMovie = movie;
            }
        }

        //3. get all show of this movie in Bangalore location
        HashMap<Theatre, List<Show>> showsTheatreWise = theatreController.getAllShow(interestedMovie, userCity);

        //4. select the particular show user is interested in
        HashMap.Entry<Theatre,List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

        //5. select the seat
        int seatNumber = 30;
        List<Integer> bookedSeats = interestedShow.getBookedSeatIds();
        if(!bookedSeats.contains(seatNumber)){
            bookedSeats.add(seatNumber);
            //startPayment
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for(Seat screenSeat : interestedShow.getScreen().getSeats()) {
                if(screenSeat.getSeatId() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setBookedSeats(myBookedSeats);
            booking.setShow(interestedShow);
        } else {
            //throw exception
            System.out.println("seat already booked, try again");
            return;
        }

        System.out.println("BOOKING SUCCESSFUL");
    }

	
}
