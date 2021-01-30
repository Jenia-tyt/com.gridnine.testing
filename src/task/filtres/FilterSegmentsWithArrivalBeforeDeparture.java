package task.filtres;

import task.testClasses.Flight;

import java.util.Objects;

public class FilterSegmentsWithArrivalBeforeDeparture implements Filter{
    private final String name;

    public FilterSegmentsWithArrivalBeforeDeparture() {
        this.name = "Filter segments with arrival before departure";
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean filter(Flight flight) {
        return flight.getSegments().stream()
                .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate()));
    }

    @Override
    public String toString() {
        return name;
    }

    //    Maybe we want to apply filters in hashMap
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilterSegmentsWithArrivalBeforeDeparture that = (FilterSegmentsWithArrivalBeforeDeparture) o;

        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
