package car_rental;

import car_rental.vehicles.*;
import java.util.List;
import java.util.ArrayList;

public class Main {
	
	public static void main(String args[]) {
		
		List<User> userList = addUsers();
		List<Vehicle> vehicleList = addVehicles();
		List<Store> storeList = addStores(vehicleList);
		
		VehicleRentalSystem rentalSystem = new VehicleRentalSystem(storeList, userList);
		
		//0. user comes
		User user = userList.get(0);
		
		//1. user search store based on location
		Location location = new Location(403012, "Bangalore", "Karnataka", "India");
		Store store = rentalSystem.getStore(location);
		
		//2. get all vehicles you are intrested in (based on diff filters)
		List<Vehicle> storeVehicles = store.getVehicles(VehicleType.CAR);
		
		//3. Reserving the particular vehicle
		Reservation reservation = store.createReservation(storeVehicles.get(0), userList.get(0));
		
		//4. generate the bill
		Bill bill = new Bill(reservation);
		
		//5. make payment
		Payment payment = new Payment();
		payment.payBill(bill);
		
		//6. trip completed, submit the vehicle and close the reservation.
		store.completeReservation(reservation.reservationId);
		
		System.out.println("process completed");
		
	}
	public static List<Vehicle> addVehicles(){

        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle vehicle1 = new Car();
        vehicle1.setVehicleID(1);
        vehicle1.setVehicleType(VehicleType.CAR);

        Vehicle vehicle2 = new Car();
        vehicle1.setVehicleID(2);
        vehicle1.setVehicleType(VehicleType.CAR);

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        return vehicles;
    }

    public static List<User> addUsers(){

        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setUserId(1);

        users.add(user1);
        return users;
    }

    public static List<Store> addStores(List<Vehicle> vehicles){
//    	addStores
        List<Store> stores = new ArrayList<>();
        Store store1 = new Store();
        store1.storeId=1;
        store1.setVehicles(vehicles);

        stores.add(store1);
        return stores;
    }


}
