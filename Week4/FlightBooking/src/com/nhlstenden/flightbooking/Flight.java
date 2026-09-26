package com.nhlstenden.flightbooking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Flight
{
    private Airport departureAirport;
    private Airport arrivalAirport;
    private LocalDateTime departureDateTime;
    private FlightStatus status;
    private Airplane airplane;
    private List<Ticket> tickets;

    public Flight(
            Airport departureAirport,
            Airport arrivalAirport,
            LocalDateTime departureDateTime,
            Airplane airplane) {

        setDepartureAirport(departureAirport);
        setArrivalAirport(arrivalAirport);
        setDepartureDateTime(departureDateTime);
        setAirplane(airplane);

        this.status = FlightStatus.AWAITING_DEPARTURE;
        this.tickets = new ArrayList<>();
    }

    public Airport getDepartureAirport() {
        return this.departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        if (departureAirport == null) {
            throw new IllegalArgumentException("Departure airport cannot be null.");
        }

        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return this.arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        if (arrivalAirport == null) {
            throw new IllegalArgumentException("Arrival airport cannot be null.");
        }

        this.arrivalAirport = arrivalAirport;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        if (departureDateTime == null) {
            throw new IllegalArgumentException("Departure date and time cannot be null.");
        }

        this.departureDateTime = departureDateTime;
    }

    public FlightStatus getStatus() {
        return this.status;
    }

    public Airplane getAirplane() {
        return this.airplane;
    }

    public void setAirplane(Airplane airplane) {
        if (airplane == null) {
            throw new IllegalArgumentException("Airplane cannot be null.");
        }

        this.airplane = airplane;
    }

    public int getDistance() {
        return this.departureAirport.distanceTo(this.arrivalAirport);
    }

    public void addTicket(Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket cannot be null.");
        }

        this.tickets.add(ticket);
    }

    public double getTotalLuggageWeight() {
        double totalWeight = 0;

        for (Ticket ticket : this.tickets) {
            totalWeight += ticket.getTotalLuggageWeight();
        }

        return totalWeight;
    }

    public void depart() {
        double fuelNeeded = this.airplane.calculateFuelUsage(this);

        if (this.airplane.getCurrentFuelLevel() < fuelNeeded) {
            throw new IllegalStateException("Not enough fuel to depart.");
        }

        this.status = FlightStatus.DEPARTED;
    }

    public String getFlight24Info() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        return "F: "
                + this.departureAirport
                + " -> "
                + this.arrivalAirport
                + ". Departure "
                + this.departureDateTime.format(formatter)
                + ".";
    }
}
