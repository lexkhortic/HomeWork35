import java.util.ArrayList;

public class Route {
    private ArrayList<BusStop> route = new ArrayList<>();

    Route() {
        BusStop busStop1 = new BusStop(1, 3);
        BusStop busStop2 = new BusStop(2, 1);
        BusStop busStop3 = new BusStop(3, 2);

        route.add(busStop1);
        route.add(busStop2);
        route.add(busStop3);
    }

    public ArrayList<BusStop> getRoute() {
        return route;
    }
}
