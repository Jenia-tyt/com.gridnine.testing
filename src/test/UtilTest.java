package test;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import task.Util;
import task.filtres.FilterBeforeTimeDepartureNow;
import task.filtres.FilterSegmentsWithArrivalBeforeDeparture;
import task.filtres.FilterTimeOnEarth;
import task.testClasses.Flight;

import java.util.List;

import static test.DataFlight.*;

class UtilTest {

    @Test
    void filtrationWithFilterBeforeTimeDepartureNow() {
        FilterBeforeTimeDepartureNow filterBeforeTimeDepartureNow = new FilterBeforeTimeDepartureNow();
        List <Flight> flightsAfterFilter = Util.filtration(ALL_FLIGHTS, filterBeforeTimeDepartureNow);
        assertThat(flightsAfterFilter).isEqualTo(LIST_FLIGHTS_FOR_FILlTER_BEFORE_TIME_DEPARTURE_NOW);
    }

    @Test
    void filtrationSegmentsWithArrivalBeforeDeparture() {
        FilterSegmentsWithArrivalBeforeDeparture filterSegmentsWithArrivalBeforeDeparture = new FilterSegmentsWithArrivalBeforeDeparture();
        List <Flight> flightsAfterFilter = Util.filtration(ALL_FLIGHTS, filterSegmentsWithArrivalBeforeDeparture);
        assertThat(flightsAfterFilter).isEqualTo(LIST_FLIGHTS_FOR_FILlTER_SEGMENTS_WITH_ARRIVAL_BEFORE_DEPARTURE);
    }

    @Test
    void filtrationTimeOnEarth2Hours() {
        FilterTimeOnEarth filterTimeOnEarth = new FilterTimeOnEarth(2);
        List <Flight> flightsAfterFilter = Util.filtration(ALL_FLIGHTS, filterTimeOnEarth);
        assertThat(flightsAfterFilter).isEqualTo(LIST_FLIGHTS_FOR_FILlTER_TIME_ON_EARTH);
    }

    @Test
    void testFilterTimeOnEarthWithDifferentTime(){
        FilterTimeOnEarth filterTimeOnEarth = new FilterTimeOnEarth(2);
        List <Flight> flightsAfterFilter = Util.filtration(FOR_TEST_FILTER_TIME_ON_EARTH, filterTimeOnEarth);
        assertThat(flightsAfterFilter).isEqualTo(RESULT_FOR_FILTER_TIME_ON_EARTH);
    }
}