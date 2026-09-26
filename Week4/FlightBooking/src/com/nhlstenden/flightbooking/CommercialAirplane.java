package com.nhlstenden.flightbooking;

public class CommercialAirplane extends Airplane
{
    private int numberOfEconomySeats;
    private int numberOfBusinessSeats;
    private int economySeatsTaken;
    private int businessSeatsTaken;

    public CommercialAirplane(
            String code,
            double currentFuelLevel,
            int numberOfEconomySeats,
            int numberOfBusinessSeats) {

        super(code, currentFuelLevel);

        setNumberOfEconomySeats(numberOfEconomySeats);
        setNumberOfBusinessSeats(numberOfBusinessSeats);

        this.economySeatsTaken = 0;
        this.businessSeatsTaken = 0;
    }

    public int getNumberOfEconomySeats() {
        return this.numberOfEconomySeats;
    }

    public void setNumberOfEconomySeats(int numberOfEconomySeats) {
        if (numberOfEconomySeats < 0) {
            throw new IllegalArgumentException(
                    "Number of economy seats cannot be negative."
            );
        }

        if (numberOfEconomySeats < this.economySeatsTaken) {
            throw new IllegalArgumentException(
                    "Number of economy seats cannot be lower than occupied economy seats."
            );
        }

        this.numberOfEconomySeats = numberOfEconomySeats;
    }

    public int getNumberOfBusinessSeats() {
        return this.numberOfBusinessSeats;
    }

    public void setNumberOfBusinessSeats(int numberOfBusinessSeats) {
        if (numberOfBusinessSeats < 0) {
            throw new IllegalArgumentException(
                    "Number of business seats cannot be negative."
            );
        }

        if (numberOfBusinessSeats < this.businessSeatsTaken) {
            throw new IllegalArgumentException(
                    "Number of business seats cannot be lower than occupied business seats."
            );
        }

        this.numberOfBusinessSeats = numberOfBusinessSeats;
    }

    public int getEconomySeatsTaken() {
        return this.economySeatsTaken;
    }

    public int getBusinessSeatsTaken() {
        return this.businessSeatsTaken;
    }

    @Override
    public double calculateFuelUsage(Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException("Flight cannot be null.");
        }

        double distance = flight.getDistance();
        double luggageWeight = flight.getTotalLuggageWeight();

        return ((this.numberOfEconomySeats * 1.75)
                + (this.numberOfBusinessSeats * 1.98))
                * distance
                + (this.economySeatsTaken * 2.02)
                + (this.businessSeatsTaken * 2.87)
                + (luggageWeight * 0.3);
    }

    @Override
    public void reserveSeat() {
        if (this.economySeatsTaken < this.numberOfEconomySeats) {
            this.economySeatsTaken++;
            return;
        }

        if (this.businessSeatsTaken < this.numberOfBusinessSeats) {
            this.businessSeatsTaken++;
            return;
        }

        throw new IllegalStateException("No empty seats available.");
    }

    @Override
    public int getEmptySeats() {
        int totalSeats = this.numberOfEconomySeats + this.numberOfBusinessSeats;
        int totalSeatsTaken = this.economySeatsTaken + this.businessSeatsTaken;

        return totalSeats - totalSeatsTaken;
    }

    @Override
    public String getFlight24Info() {
        return String.format(
                "C: %s. %.0f liter fuel. %d empty seats.",
                getCode(),
                getCurrentFuelLevel(),
                getEmptySeats()
        );
    }
}
