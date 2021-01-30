package task.filtres;

import task.testClasses.Flight;

import java.time.LocalDateTime;
import java.util.Objects;


import static java.time.temporal.ChronoUnit.HOURS;

public class FilterTimeOnEarth implements Filter{
    private final String name;
    private int timeLimitOnEarth;

    public FilterTimeOnEarth(int timeLimitOnEarth) {
        this.name = "Filter time on earth";
        this.timeLimitOnEarth = timeLimitOnEarth;
    }

    public int getTimeLimitOnEarth() {
        return timeLimitOnEarth;
    }

    public void setTimeLimitOnEarth(int timeLimitOnEarth) {
        this.timeLimitOnEarth = timeLimitOnEarth;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean filter(Flight flight) {
        if (flight.getSegments().size() > 1) {
            long between = 0;
            for (int i = 0; i < flight.getSegments().size() - 1; ++i){
                LocalDateTime arrivalDate = flight.getSegments().get(i).getArrivalDate();
                LocalDateTime departureDate = flight.getSegments().get(i + 1).getDepartureDate();
                between += HOURS.between(arrivalDate,  departureDate);
            }
            return timeLimitOnEarth > between;
        }
       return false;
    }

    @Override
    public String toString() {
        return name + " < " + timeLimitOnEarth + " hours";
    }

//    Maybe we want to apply filters in hashMap
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilterTimeOnEarth that = (FilterTimeOnEarth) o;

        if (timeLimitOnEarth != that.timeLimitOnEarth) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + timeLimitOnEarth;
        return result;
    }
}
