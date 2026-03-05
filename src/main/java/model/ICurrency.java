package model;

public interface ICurrency {
    /**
     Returns name of currency
     @return name
     */
    public String name();

    /**
     Returns amount of money in currency
     @return amount
     */
    public int amount();
}
