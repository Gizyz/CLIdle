package model;

public class Counter {
    public BasicMoney basicMoney = new BasicMoney("NOK", 500);
    public int tickTime;

    public Counter(int tickTime) {
        this.tickTime = tickTime;
    }

}
