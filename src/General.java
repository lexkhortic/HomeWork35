public class General {
    public static void main(String[] args) throws InterruptedException {

        Route route = new Route();

        for (int i = 10; i <= 30; i+=10) {
            Bus bus = new Bus(i, route.getRoute());
            bus.start();
        }
//        route.getRoute().forEach(System.out::println);
    }
}
