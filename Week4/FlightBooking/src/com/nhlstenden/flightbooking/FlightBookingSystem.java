package com.nhlstenden.flightbooking;

import java.util.ArrayList;
import java.util.List;

public class FlightBookingSystem
{
    private List<Flight> flights;

    public FlightBookingSystem() {
        this.flights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException("Flight cannot be null.");
        }

        this.flights.add(flight);
    }

    public Flight findAvailableFlight(
            Airport departureAirport,
            Airport arrivalAirport) throws FlightBookingException {

        for (Flight flight : this.flights) {

            boolean correctRoute =
                    flight.getDepartureAirport() == departureAirport
                            && flight.getArrivalAirport() == arrivalAirport;

            boolean hasNotDeparted =
                    flight.getStatus() != FlightStatus.DEPARTED
                            && flight.getStatus() != FlightStatus.LANDED;

            boolean hasEmptySeat =
                    flight.getAirplane().getEmptySeats() > 0;

            if (correctRoute && hasNotDeparted && hasEmptySeat) {
                return flight;
            }
        }

        throw new FlightBookingException(
                "No available flight found."
        );
    }

    public Ticket bookTicket(
            Person person,
            Airport departureAirport,
            Airport arrivalAirport,
            List<Luggage> luggage) throws FlightBookingException {

        if (person == null) {
            throw new FlightBookingException(
                    "Person cannot be null."
            );
        }

        Flight flight =
                findAvailableFlight(departureAirport, arrivalAirport);

        Ticket ticket = new Ticket(person, flight);

        if (luggage != null) {
            try {
                for (Luggage luggageItem : luggage) {
                    ticket.addLuggage(luggageItem);
                }
            } catch (IllegalStateException | IllegalArgumentException e) {
                throw new FlightBookingException(e.getMessage());
            }
        }

        try {
            flight.getAirplane().reserveSeat();
        } catch (IllegalStateException e) {
            throw new FlightBookingException(e.getMessage());
        }

        flight.addTicket(ticket);

        return ticket;
    }
}
