package models;

public class Card {
    private String number;
    private String customerName;
    private double balance;

    public Card() {
    }

    public Card(final String number, final String customerName, final double balance) {
        this.number = number;
        this.customerName = customerName;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(final String customerName) {
        this.customerName = customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(final double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "models.Card{" +
            "number='" + number + '\'' +
            ", customerName='" + customerName + '\'' +
            ", balance=" + balance +
            '}';
    }
}
