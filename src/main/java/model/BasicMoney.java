package model;

public class BasicMoney implements ICurrency{
    public int amount;
    public String name;

    public BasicMoney(){
        this.name = "Basic Money";
        this.amount = 0;
    }
    public BasicMoney(String name, int startAmount) {
        this.amount = startAmount;
        this.name = name;
    }

    public void increaseAmount() {
        amount++;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int amount() {
        return amount;
    }
}
