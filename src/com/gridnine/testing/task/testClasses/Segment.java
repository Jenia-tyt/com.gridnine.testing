package com.gridnine.testing.task.testClasses;

import java.time.LocalDateTime;
import java.util.Objects;

import static com.gridnine.testing.task.FormatterTime.formatterTime;

public class Segment {
    private final LocalDateTime departureDate;

    private final LocalDateTime arrivalDate;

    Segment(final LocalDateTime dep, final LocalDateTime arr) {
        Objects.requireNonNull(dep, "Departure date does not be null");
        Objects.requireNonNull(arr, "Arrival date does not be null");

//        I am formatting a date here because I have a problem in my test when comparing dates from main and DataFlight due to nano seconds
        departureDate = LocalDateTime.parse(formatterTime(dep));
        arrivalDate = LocalDateTime.parse(formatterTime(arr));

    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String toString() {
        return '[' + departureDate.toString() + '|' + arrivalDate.toString()
                + ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Segment segment = (Segment) o;

        if (!Objects.equals(departureDate, segment.departureDate))
            return false;
        return Objects.equals(arrivalDate, segment.arrivalDate);
    }

    @Override
    public int hashCode() {
        int result = departureDate.hashCode();
        result = 31 * result + arrivalDate.hashCode();
        return result;
    }

}
