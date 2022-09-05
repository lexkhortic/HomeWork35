import java.util.ArrayList;

public class Bus extends Thread{
    private int numberBus;
    private int countBusStopMoved;
    private ArrayList<BusStop> busStops;

    public Bus(int numberBus, ArrayList<BusStop> busStops) {
        this.numberBus = numberBus;
        this.busStops = busStops;
        this.countBusStopMoved = 0;
    }

    @Override
    public void run() {
        startBus();
        moveBus();
    }

    public int getNumberBus() {
        return numberBus;
    }

    public void setNumberBus(int numberBus) {
        this.numberBus = numberBus;
    }

    public int getCountBusStopMoved() {
        return countBusStopMoved;
    }

    public void setCountBusStopMoved() {
        this.countBusStopMoved++;
    }

    public void startBus() {
            System.out.println("Автобус №" + numberBus + " начал движение");
    }

    public void moveBus() {
        while (countBusStopMoved != busStops.size()+1) {
            if (countBusStopMoved == busStops.size()) {
                System.out.println("Автобус №" + numberBus + " закончил движение");
                return;
            } else {
                System.out.println("Автобус №" + numberBus + " двигается к остановке №"
                        + busStops.get(countBusStopMoved).getNumberBusStop());
                this.stopBus(busStops.get(countBusStopMoved)); //остановка автобуса на остановке
            }
        }
    }

    public synchronized void stopBus(BusStop busStop) {
        while (!(busStop.getCountBusNow() < busStop.getMaxCountBus())) {
            try {
                System.out.println("Автобус №" + numberBus + " ждет очередь к остановке №" + busStop.getNumberBusStop());
                wait(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        busStop.setUpCountBusNow(); //увеличиваем кол-во автобусов на остановке
        System.out.println("Автобус №" + numberBus + " стоит на остановке №" + busStop.getNumberBusStop());
        busMoveNext(busStop);
        busStop.setDownCountBusNow();//уменьшаем кол-во автобусов на остановке(автобус уезжает)
        notify();
    }

    public void busMoveNext(BusStop busStop) {
        try {
            sleep(5000);
            this.setCountBusStopMoved();//увеличиавем кол-во пройденых остановок автобусом
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

}
