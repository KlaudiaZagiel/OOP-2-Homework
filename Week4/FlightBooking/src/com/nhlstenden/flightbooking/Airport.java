package com.nhlstenden.flightbooking;

public enum Airport
{
    JFK,
    AMX,
    MEX,
    LAX;

    public int distanceTo(Airport other) {
        if (this == other) {
            return 0;
        }

        if ((this == JFK && other == AMX) ||
                (this == AMX && other == JFK)) {
            return 5848;
        }

        if ((this == JFK && other == MEX) ||
                (this == MEX && other == JFK)) {
            return 3366;
        }

        if ((this == JFK && other == LAX) ||
                (this == LAX && other == JFK)) {
            return 3975;
        }

        if ((this == AMX && other == MEX) ||
                (this == MEX && other == AMX)) {
            return 9206;
        }

        if ((this == AMX && other == LAX) ||
                (this == LAX && other == AMX)) {
            return 8956;
        }

        if ((this == MEX && other == LAX) ||
                (this == LAX && other == MEX)) {
            return 2500;
        }

        throw new IllegalArgumentException("Unknown airport combination");
    }
}
