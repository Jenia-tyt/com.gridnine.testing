package com.gridnine.testing.task.filtres;

import com.gridnine.testing.task.testClasses.Flight;

public interface Filter {

    boolean filter (Flight flight);

    String getName();

}
