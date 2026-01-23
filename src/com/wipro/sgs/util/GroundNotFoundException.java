package com.wipro.sgs.util;

public class GroundNotFoundException extends Exception {
    public String toString() {
        return "GroundNotFoundException: Ground ID does not exist";
    }
}
