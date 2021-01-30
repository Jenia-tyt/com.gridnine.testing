package task.filtres;

import task.testClasses.Flight;

public interface Filter {

    boolean filter (Flight flight);

    String getName();

}
