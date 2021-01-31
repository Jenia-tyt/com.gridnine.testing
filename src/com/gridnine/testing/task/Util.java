package com.gridnine.testing.task;

import com.gridnine.testing.task.filtres.Filter;
import com.gridnine.testing.task.testClasses.Flight;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;


public class Util {

    public static List<Flight> filtration (List<Flight> flights, Filter filter){
        List <Flight> result = new ArrayList<>();
        try {
            flights.stream()
                    .filter(filter::filter)
                    .forEach(result::add);
        } catch (NullPointerException e){
            System.out.println("Flight does't be null for filter [" + filter.getName() + "]");
        }
        return result;
    }

    public static List<Flight> filtration (List<Flight> flights, Filter ... filters) {
        List<Flight> result = new ArrayList<>();
        try {
            flights.forEach(flight -> {
                AtomicBoolean flag = new AtomicBoolean(true);
                for (Filter value : filters) {
                    if (!value.filter(flight)) {
                        flag.set(false);
                    }
                }
                if (flag.get()) {
                    result.add(flight);
                }
            });
        } catch (NullPointerException e) {
            System.out.println("Flight does't be null for filter");
        }
        return result;
    }
}
