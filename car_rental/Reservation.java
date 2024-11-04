package car_rental;

import java.util.Date;

import car_rental.vehicles.Vehicle;

public class Reservation {
    int reservationId;
    User user;
    Vehicle vehicle;
    Date bookingDate;
    Date dateBookedFrom;
    Date dateBookedTo;
    Long fromTimeStamp;
    Long toTimeStamp;
    Location pickUpLocation;
    Location dropLocation;
    ReservationType reservationType;
    ReservationStatus reservationStatus;
    Location location;
    
    private static int lastReservationId = 0;
    
    public int createReserve(User user, Vehicle vehicle){

        reservationId = ++lastReservationId;
        this.user=user;
        this.vehicle=vehicle;
        reservationType = ReservationType.DAILY;
        reservationStatus = ReservationStatus.SCHEDULED;
        return reservationId;
    }

    //  CRUD operations 


}
