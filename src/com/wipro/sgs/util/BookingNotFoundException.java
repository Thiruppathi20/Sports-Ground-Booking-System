package com.wipro.sgs.util;

public class BookingNotFoundException extends Exception {
    public String toString() {
        return "BookingNotFoundException: Booking ID not found";
    }
}
