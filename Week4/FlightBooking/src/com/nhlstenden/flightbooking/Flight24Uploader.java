package com.nhlstenden.flightbooking;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Flight24Uploader
{
    private List<Flight> flights;
    private List<Airplane> airplanes;

    public Flight24Uploader() {
        this.flights = new ArrayList<>();
        this.airplanes = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException("Flight cannot be null.");
        }

        this.flights.add(flight);
    }

    public void addAirplane(Airplane airplane) {
        if (airplane == null) {
            throw new IllegalArgumentException("Airplane cannot be null.");
        }

        this.airplanes.add(airplane);
    }

    public void upload(String fileName) throws IOException
    {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("File name cannot be empty.");
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

            for (Flight flight : this.flights) {
                writer.println(flight.getFlight24Info());
            }

            for (Airplane airplane : this.airplanes) {
                writer.println(airplane.getFlight24Info());
            }
        }
    }
}
