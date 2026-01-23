package com.wipro.sgs.util;

public class InvalidUserException extends Exception {
    public String toString() {
        return "InvalidUserException: User not registered";
    }
}
