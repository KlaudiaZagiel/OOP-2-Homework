package com.nhlstenden.flightbooking;

public class PrivateAirplane extends Airplane
{
    private int numberOfSeats;
    private int seatsTaken;

    public PrivateAirplane(String code, double currentFuelLevel, int numberOfSeats) {
        super(code, currentFuelLevel);
        setNumberOfSeats(numberOfSeats);
        this.seatsTaken = 0;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        if (numberOfSeats <= 0) {
            throw new IllegalArgumentException("Number of seats must be greater than 0.");
        }

        if (numberOfSeats < seatsTaken) {
            throw new IllegalArgumentException(
                    "Number of seats cannot be lower than the number of occupied seats."
            );
        }

        this.numberOfSeats = numberOfSeats;
    }

    public int getSeatsTaken() {
        return seatsTaken;
    }

    @Override
    public double calculateFuelUsage(Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException("Flight cannot be null.");
        }

        double distance = flight.getDistance();
        double luggageWeight = flight.getTotalLuggageWeight();

        return (numberOfSeats * 1.31 * distance)
                + (seatsTaken * 1.87)
                + (luggageWeight * 0.4);
    }

    @Override
    public void reserveSeat() {
        if (seatsTaken >= numberOfSeats) {
            throw new IllegalStateException("No empty seats available.");
        }

        seatsTaken++;
    }

    @Override
    public int getEmptySeats() {
        return this.numberOfSeats - this.seatsTaken;
    }

    @Override
    public String getFlight24Info() {
        return String.format(
                "P: %s. %.0f liter fuel. %d empty seats.",
                getCode(),
                getCurrentFuelLevel(),
                getEmptySeats()
        );
    }
}
