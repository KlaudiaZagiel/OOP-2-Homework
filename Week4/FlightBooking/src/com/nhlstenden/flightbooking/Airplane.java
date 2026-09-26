package com.nhlstenden.flightbooking;

public abstract class Airplane
{
    private String code;
    private double currentFuelLevel;

    protected Airplane(String code, double currentFuelLevel) {
        setCode(code);
        setCurrentFuelLevel(currentFuelLevel);
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Airplane code cannot be empty.");
        }

        this.code = code;
    }

    public double getCurrentFuelLevel() {
        return this.currentFuelLevel;
    }

    public void setCurrentFuelLevel(double currentFuelLevel) {
        if (currentFuelLevel < 0) {
            throw new IllegalArgumentException("Fuel level cannot be negative.");
        }

        this.currentFuelLevel = currentFuelLevel;
    }

    public abstract double calculateFuelUsage(Flight flight);

    public abstract void reserveSeat();

    public abstract int getEmptySeats();

    public abstract String getFlight24Info();
}
