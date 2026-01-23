package com.wipro.sgs.service;

import java.util.ArrayList;
import java.util.UUID;
import com.wipro.sgs.entity.*;
import com.wipro.sgs.util.*;

public class BookingService {

    private ArrayList<User> users;
    private ArrayList<Ground> grounds;
    private ArrayList<Booking> bookings;

    public BookingService(ArrayList<User> users,
                          ArrayList<Ground> grounds,
                          ArrayList<Booking> bookings) {
        this.users = users;
        this.grounds = grounds;
        this.bookings = bookings;
    }

    public boolean validateUser(String userId) throws InvalidUserException {
        for (User u : users) {
            if (u.getUserId().equals(userId)) {
                return true;
            }
        }
        throw new InvalidUserException();
    }

    public Ground findGround(String groundId) throws GroundNotFoundException {
        for (Ground g : grounds) {
            if (g.getGroundId().equals(groundId)) {
                return g;
            }
        }
        throw new GroundNotFoundException();
    }

    public boolean checkSlotAvailability(String groundId, String date, String timeSlot)
            throws GroundUnavailableException {
        for (Booking b : bookings) {
            if (b.getGroundId().equals(groundId)
                    && b.getDate().equals(date)
                    && b.getTimeSlot().equals(timeSlot)) {
                throw new GroundUnavailableException();
            }
        }
        return true;
    }

    public double calculateFare(Ground ground, String timeSlot)
            throws BookingOperationException {
        try {
            String[] parts = timeSlot.split("-");
            int start = Integer.parseInt(parts[0].trim().split(" ")[0]);
            int end = Integer.parseInt(parts[1].trim().split(" ")[0]);
            int hours = end - start;
            if (hours <= 0) throw new Exception();
            return hours * ground.getHourlyRate();
        } catch (Exception e) {
            throw new BookingOperationException();
        }
    }

    public Booking bookGround(String userId, String groundId,
                              String date, String timeSlot) throws Exception {

        validateUser(userId);
        Ground ground = findGround(groundId);
        checkSlotAvailability(groundId, date, timeSlot);

        double fare = calculateFare(ground, timeSlot);
        String bookingId = UUID.randomUUID().toString();

        Booking booking = new Booking(
                bookingId, userId, groundId, date, timeSlot, fare
        );

        bookings.add(booking);
        return booking;
    }

    public void cancelBooking(String bookingId)
            throws BookingNotFoundException {
        for (Booking b : bookings) {
            if (b.getBookingId().equals(bookingId)) {
                bookings.remove(b);
                return;
            }
        }
        throw new BookingNotFoundException();
    }

    public void printUserBookings(String userId) {
        for (Booking b : bookings) {
            if (b.getUserId().equals(userId)) {
                System.out.println(
                        b.getGroundId() + " | " +
                        b.getDate() + " | " +
                        b.getTimeSlot() + " | ₹" +
                        b.getTotalFare()
                );
            }
        }
    }

    public void printGroundSchedule(String groundId, String date) {
        for (Booking b : bookings) {
            if (b.getGroundId().equals(groundId)
                    && b.getDate().equals(date)) {
                System.out.println(
                        b.getTimeSlot() + " | Booking ID: " + b.getBookingId()
                );
            }
        }
    }
}
