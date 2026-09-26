package com.nhlstenden.flightbooking;

import java.util.ArrayList;
import java.util.List;

public class Ticket
{
    private Person person;
    private Flight flight;
    private List<Luggage> luggage;

    public Ticket(Person person, Flight flight) {
        setPerson(person);
        setFlight(flight);

        this.luggage = new ArrayList<>();
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null.");
        }

        this.person = person;
    }

    public Flight getFlight() {
        return this.flight;
    }

    public void setFlight(Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException("Flight cannot be null.");
        }

        this.flight = flight;
    }

    public List<Luggage> getLuggage() {
        return this.luggage;
    }

    public void addLuggage(Luggage luggageItem) {
        if (luggageItem == null) {
            throw new IllegalArgumentException("Luggage cannot be null.");
        }

        if (luggageItem.getType() == LuggageType.CARRY_ON) {
            int carryOnCount = 0;

            for (Luggage item : luggage) {
                if (item.getType() == LuggageType.CARRY_ON) {
                    carryOnCount++;
                }
            }

            if (carryOnCount >= 1) {
                throw new IllegalStateException(
                        "A passenger can only have one carry-on bag."
                );
            }
        }

        if (luggageItem.getType() == LuggageType.HOLD
                && this.flight.getAirplane() instanceof PrivateAirplane) {

            throw new IllegalStateException(
                    "Private airplanes cannot carry hold luggage."
            );
        }

        this.luggage.add(luggageItem);
    }

    public double getTotalLuggageWeight() {
        double totalWeight = 0;

        for (Luggage item : this.luggage) {
            totalWeight += item.getWeight();
        }

        return totalWeight;
    }
}
