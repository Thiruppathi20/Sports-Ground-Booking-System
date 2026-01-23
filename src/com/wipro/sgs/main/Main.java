package com.wipro.sgs.main; 
 
import java.util.ArrayList; 
import com.wipro.sgs.entity.*; 
import com.wipro.sgs.service.BookingService; 
import com.wipro.sgs.util.*; 
 
public class Main { 
    public static void main(String[] args) { 
 
        ArrayList<User> users = new ArrayList<>(); 
        users.add(new User("U001", "Rohan", "9876543210")); 
        users.add(new User("U002", "Anita", "9123456780")); 
 
        ArrayList<Ground> grounds = new ArrayList<>(); 
        grounds.add(new Ground("G101", "Turf Arena", "Football", 1200.0)); 
        grounds.add(new Ground("G202", "Smash Court", "Badminton", 800.0)); 
 
        ArrayList<Booking> bookings = new ArrayList<>(); 
 
        BookingService service = new BookingService(users, grounds, bookings); 
 
        try { 
            Booking b1 = service.bookGround("U001", "G101", "2025-08-12", "6 PM - 8 PM"); 
            System.out.println("Booking Successful! ID: " + b1.getBookingId()); 
 
            System.out.println("\n--- User Bookings (U001) ---"); 
            service.printUserBookings("U001"); 
 
            System.out.println("\nCancelling booking..."); 
            service.cancelBooking(b1.getBookingId()); 
            System.out.println("Booking Cancelled!"); 
 
        } catch (InvalidUserException | GroundUnavailableException | 
                 GroundNotFoundException | BookingNotFoundException | 
                 BookingOperationException ex) { 
            System.out.println(ex); 
        } 
        catch (Exception ex) { 
            System.out.println("Unexpected Error: " + ex); 
        } 
    } 
} 
