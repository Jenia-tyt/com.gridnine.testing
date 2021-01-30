package task.filtres;

import task.testClasses.Flight;
import java.time.LocalDateTime;
import java.util.Objects;

import static task.FormatterTime.formatterTime;

public class FilterBeforeTimeDepartureNow implements Filter{
    private final String name;
    private final LocalDateTime dateTimeDeparture;

    public FilterBeforeTimeDepartureNow() {
        LocalDateTime now = LocalDateTime.now();
        name = "Time' filter before " + formatterTime(now);
        dateTimeDeparture = now;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDateTimeDeparture() {
        return dateTimeDeparture;
    }

    @Override
    public boolean filter(Flight flight) {
        return flight.getSegments().stream().allMatch(s -> s.getDepartureDate().isAfter(dateTimeDeparture));
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

        FilterBeforeTimeDepartureNow that = (FilterBeforeTimeDepartureNow) o;

        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(dateTimeDeparture, that.dateTimeDeparture);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (dateTimeDeparture != null ? dateTimeDeparture.hashCode() : 0);
        return result;
    }
}
