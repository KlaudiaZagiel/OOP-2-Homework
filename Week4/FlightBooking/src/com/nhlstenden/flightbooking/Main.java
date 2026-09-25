package com.nhlstenden.flightbooking;

public class Main
{
    public static void main(String[] args) {

        int distance1 = Airport.JFK.distanceTo(Airport.LAX);
        int distance2 = Airport.MEX.distanceTo(Airport.AMX);

        System.out.println("JFK to LAX: " + distance1 + " km");
        System.out.println("MEX to AMX: " + distance2 + " km");
    }
}
