package com.wipro.sgs.util;

public class GroundUnavailableException extends Exception {
    public String toString() {
        return "GroundUnavailableException: Ground already booked for this slot";
    }
}
