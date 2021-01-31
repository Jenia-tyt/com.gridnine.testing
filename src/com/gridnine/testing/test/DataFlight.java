package com.gridnine.testing.test;

import com.gridnine.testing.task.testClasses.Flight;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.gridnine.testing.task.testClasses.FlightBulder.createFlight;
import static com.gridnine.testing.task.testClasses.FlightBulder.createFlights;

public class DataFlight {
    protected static final List<Flight> ALL_FLIGHTS = createFlights();

    private final static LocalDateTime THREE_DAYS_FROM_NOW = LocalDateTime.now().plusDays(3);

    private final static Flight A_NORMAL_FLIGHT_WITH_TWO_HOUR_DURATION = createFlight(THREE_DAYS_FROM_NOW, THREE_DAYS_FROM_NOW.plusHours(2));
    private final static Flight A_NORMAL_MULTI_SEGMENT_FLIGHT = createFlight(THREE_DAYS_FROM_NOW, THREE_DAYS_FROM_NOW.plusHours(2),
            THREE_DAYS_FROM_NOW.plusHours(3), THREE_DAYS_FROM_NOW.plusHours(5));
    private final static Flight A_FLIGHT_DEPARTING_IN_THE_PAST = createFlight(THREE_DAYS_FROM_NOW.minusDays(6), THREE_DAYS_FROM_NOW);
    private final static Flight A_FLIGHT_THAT_DEPARTS_BEFORE_IT_ARRIVES = createFlight(THREE_DAYS_FROM_NOW, THREE_DAYS_FROM_NOW.minusHours(6));
    private final static Flight A_FLIGHT_WITH_MORE_THAN_TWO_HOURS_GROUND_TIME = createFlight(THREE_DAYS_FROM_NOW, THREE_DAYS_FROM_NOW.plusHours(2),
            THREE_DAYS_FROM_NOW.plusHours(5), THREE_DAYS_FROM_NOW.plusHours(6));
    private final static Flight ANOTHER_FLIGHT_WITH_MORE_THAN_TWO_HOURS_GROUND_TIME = createFlight(THREE_DAYS_FROM_NOW, THREE_DAYS_FROM_NOW.plusHours(2),
            THREE_DAYS_FROM_NOW.plusHours(3), THREE_DAYS_FROM_NOW.plusHours(4),
            THREE_DAYS_FROM_NOW.plusHours(6), THREE_DAYS_FROM_NOW.plusHours(7));

    protected static final List<Flight> LIST_FLIGHTS_FOR_FILlTER_BEFORE_TIME_DEPARTURE_NOW = Arrays.asList(A_NORMAL_FLIGHT_WITH_TWO_HOUR_DURATION,
            A_NORMAL_MULTI_SEGMENT_FLIGHT, A_FLIGHT_THAT_DEPARTS_BEFORE_IT_ARRIVES, A_FLIGHT_WITH_MORE_THAN_TWO_HOURS_GROUND_TIME,
            ANOTHER_FLIGHT_WITH_MORE_THAN_TWO_HOURS_GROUND_TIME);

    protected static final List<Flight> LIST_FLIGHTS_FOR_FILlTER_SEGMENTS_WITH_ARRIVAL_BEFORE_DEPARTURE = Arrays.asList(A_NORMAL_FLIGHT_WITH_TWO_HOUR_DURATION,
            A_NORMAL_MULTI_SEGMENT_FLIGHT, A_FLIGHT_DEPARTING_IN_THE_PAST, A_FLIGHT_WITH_MORE_THAN_TWO_HOURS_GROUND_TIME,
            ANOTHER_FLIGHT_WITH_MORE_THAN_TWO_HOURS_GROUND_TIME);

    protected static final List<Flight> LIST_FLIGHTS_FOR_FILlTER_TIME_ON_EARTH = Collections.singletonList(A_NORMAL_MULTI_SEGMENT_FLIGHT);


    private final static Flight TIME_ON_EARTH_TWO_HOURS_FAITH_MINTS = createFlight(THREE_DAYS_FROM_NOW, THREE_DAYS_FROM_NOW.plusHours(2),
            THREE_DAYS_FROM_NOW.plusHours(4).plusMinutes(5), THREE_DAYS_FROM_NOW.plusHours(6));

    private final static Flight TIME_ON_EARTH_ONE_HOURS_FIFTY_FIVE_MINTS = createFlight(THREE_DAYS_FROM_NOW, THREE_DAYS_FROM_NOW.plusHours(2),
            THREE_DAYS_FROM_NOW.plusHours(3).plusMinutes(55), THREE_DAYS_FROM_NOW.plusHours(6));

    protected static final List<Flight> FOR_TEST_FILTER_TIME_ON_EARTH = Arrays.asList(TIME_ON_EARTH_TWO_HOURS_FAITH_MINTS, TIME_ON_EARTH_ONE_HOURS_FIFTY_FIVE_MINTS);

    protected static final List<Flight> RESULT_FOR_FILTER_TIME_ON_EARTH = Collections.singletonList(TIME_ON_EARTH_ONE_HOURS_FIFTY_FIVE_MINTS);

}
