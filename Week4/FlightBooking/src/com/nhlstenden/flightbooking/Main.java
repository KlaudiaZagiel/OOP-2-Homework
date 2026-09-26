package com.nhlstenden.flightbooking;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) {
        //distance
        int distance1 = Airport.JFK.distanceTo(Airport.LAX);
        int distance2 = Airport.MEX.distanceTo(Airport.AMX);

        System.out.println("JFK to LAX: " + distance1 + " km");
        System.out.println("MEX to AMX: " + distance2 + " km");

        //flight status
        FlightStatus status = FlightStatus.AWAITING_DEPARTURE;

        System.out.println(status);

        status = FlightStatus.DEPARTED;

        System.out.println(status);

        //luggage type
        LuggageType luggageType = LuggageType.CARRY_ON;

        System.out.println(luggageType);

        luggageType = LuggageType.HOLD;

        System.out.println(luggageType);

        Luggage carryOn = new Luggage(
                8.5,
                LuggageType.CARRY_ON
        );

        Luggage holdLuggage = new Luggage(
                20.0,
                LuggageType.HOLD
        );

        System.out.println(
                "Carry-on: "
                        + carryOn.getWeight()
                        + " kg"
        );

        System.out.println(
                "Hold luggage: "
                        + holdLuggage.getWeight()
                        + " kg"
        );



         //create a person

        Person person = new Person("John");

        System.out.println("Person: " + person.getName());


        //create airplanes

        PrivateAirplane privateAirplane =
                new PrivateAirplane(
                        "PH-ABC",
                        400000,
                        4
                );

        CommercialAirplane commercialAirplane =
                new CommercialAirplane(
                        "KLM124",
                        50000,
                        3,
                        2
                );

        System.out.println(
                "Private airplane empty seats: "
                        + privateAirplane.getEmptySeats()
        );

        System.out.println(
                "Commercial airplane empty seats: "
                        + commercialAirplane.getEmptySeats()
        );



        //create flights

        Flight commercialFlight = new Flight(
                Airport.JFK,
                Airport.LAX,
                LocalDateTime.of(
                        2026,
                        9,
                        26,
                        12,
                        54
                ),
                commercialAirplane
        );

        Flight privateFlight = new Flight(
                Airport.AMX,
                Airport.LAX,
                LocalDateTime.of(
                        2026,
                        9,
                        27,
                        10,
                        30
                ),
                privateAirplane
        );

        System.out.println(
                "Commercial flight distance: "
                        + commercialFlight.getDistance()
                        + " km"
        );

        System.out.println(
                "Private flight distance: "
                        + privateFlight.getDistance()
                        + " km"
        );


        //create booking system

        FlightBookingSystem bookingSystem =
                new FlightBookingSystem();

        bookingSystem.addFlight(commercialFlight);
        bookingSystem.addFlight(privateFlight);


       //book commercial flight

        List<Luggage> luggage = new ArrayList<>();

        luggage.add(carryOn);
        luggage.add(holdLuggage);

        try {

            Ticket ticket = bookingSystem.bookTicket(
                    person,
                    Airport.JFK,
                    Airport.LAX,
                    luggage
            );

            System.out.println("Ticket booked.");

            System.out.println(
                    "Passenger: "
                            + ticket.getPerson().getName()
            );

            System.out.println(
                    "Total luggage weight: "
                            + ticket.getTotalLuggageWeight()
                            + " kg"
            );

            System.out.println(
                    "Empty seats after booking: "
                            + commercialAirplane.getEmptySeats()
            );

        } catch (FlightBookingException e) {

            System.out.println(
                    "Booking error: "
                            + e.getMessage()
            );
        }



        //calculate fuel usage

        double fuelNeeded =
                commercialAirplane.calculateFuelUsage(
                        commercialFlight
                );

        System.out.println(
                "Fuel needed: "
                        + fuelNeeded
                        + " liters"
        );


        //try to depart

        try {

            commercialFlight.depart();

            System.out.println(
                    "Flight status after departure: "
                            + commercialFlight.getStatus()
            );

        } catch (IllegalStateException e) {

            System.out.println(
                    "Departure error: "
                            + e.getMessage()
            );
        }



        //flight24 information

        System.out.println(
                commercialFlight.getFlight24Info()
        );

        System.out.println(
                commercialAirplane.getFlight24Info()
        );

        System.out.println(
                privateAirplane.getFlight24Info()
        );



        //upload Flight24 data to file


        Flight24Uploader uploader =
                new Flight24Uploader();

        uploader.addFlight(commercialFlight);
        uploader.addFlight(privateFlight);

        uploader.addAirplane(commercialAirplane);
        uploader.addAirplane(privateAirplane);

        try {

            uploader.upload("flight24.txt");

            System.out.println(
                    "Flight24 data written to flight24.txt"
            );

        } catch (IOException e) {

            System.out.println(
                    "Could not write Flight24 file: "
                            + e.getMessage()
            );
        }
    }
    }
