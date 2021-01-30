package task;

import task.filtres.FilterBeforeTimeDepartureNow;
import task.filtres.FilterSegmentsWithArrivalBeforeDeparture;
import task.filtres.FilterTimeOnEarth;
import task.testClasses.Flight;
import task.testClasses.FlightBulder;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flightList = FlightBulder.createFlights();
        System.out.println("All flights");
        flightList.forEach(System.out::println);

        System.out.println();
        FilterBeforeTimeDepartureNow filterBeforeTimeDepartureNow = new FilterBeforeTimeDepartureNow();
        System.out.println(filterBeforeTimeDepartureNow.toString());
        Util.filtration(flightList, filterBeforeTimeDepartureNow)
                .forEach(System.out::println);

        System.out.println();
        FilterSegmentsWithArrivalBeforeDeparture filterSegmentsWithArrivalBeforeDeparture = new FilterSegmentsWithArrivalBeforeDeparture();
        System.out.println(filterSegmentsWithArrivalBeforeDeparture.toString());
        Util.filtration(flightList, filterSegmentsWithArrivalBeforeDeparture)
                .forEach(System.out::println);

        System.out.println();
        FilterTimeOnEarth filterTimeOnEarth = new FilterTimeOnEarth(2);
        System.out.println(filterTimeOnEarth.toString());
        Util.filtration(flightList, filterTimeOnEarth)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("All filters");
        Util.filtration(flightList, filterBeforeTimeDepartureNow, filterSegmentsWithArrivalBeforeDeparture, filterTimeOnEarth)
                .forEach(System.out::println);

    }
}
