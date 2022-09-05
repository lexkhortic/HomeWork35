public class BusStop {
    private int numberBusStop;
    private int maxCountBus;
    private int countBusNow;

    public BusStop(int numberBusStop, int countBus) {
        this.numberBusStop = numberBusStop;
        this.maxCountBus = countBus;
        this.countBusNow = 0;
    }

    public int getNumberBusStop() {
        return numberBusStop;
    }

    public void setNumberBusStop(int numberBusStop) {
        this.numberBusStop = numberBusStop;
    }

    public int getMaxCountBus() {
        return maxCountBus;
    }

    public void setMaxCountBus(int maxCountBus) {
        this.maxCountBus = maxCountBus;
    }

    public int getCountBusNow() {
        return countBusNow;
    }

    public void setUpCountBusNow() {
        this.countBusNow++;
    }

    public void setDownCountBusNow() {
        this.countBusNow--;
    }
}
