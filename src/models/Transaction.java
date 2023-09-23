package models;

public class Transaction {
    private double value;
    private String date;
    private String hour;
    private String transmittingNetwork;
    private String paymentMethod;
    private String NSU;
    private String responseCode;

    public Transaction() {
    }

    public Transaction(final double value,
                       final String date,
                       final String hour,
                       final String transmittingNetwork,
                       final String paymentMethod,
                       final String NSU,
                       final String responseCode) {
        this.value = value;
        this.date = date;
        this.hour = hour;
        this.transmittingNetwork = transmittingNetwork;
        this.paymentMethod = paymentMethod;
        this.NSU = NSU;
        this.responseCode = responseCode;
    }

    public double getValue() {
        return value;
    }

    public void setValue(final double value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(final String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(final String hour) {
        this.hour = hour;
    }

    public String getTransmittingNetwork() {
        return transmittingNetwork;
    }

    public void setTransmittingNetwork(final String transmittingNetwork) {
        this.transmittingNetwork = transmittingNetwork;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(final String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getNSU() {
        return NSU;
    }

    public void setNSU(final String NSU) {
        this.NSU = NSU;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(final String responseCode) {
        this.responseCode = responseCode;
    }

    @Override
    public String toString() {
        return "models.Transaction{" +
            "value=" + value +
            ", date='" + date + '\'' +
            ", hour='" + hour + '\'' +
            ", transmittingNetwork='" + transmittingNetwork + '\'' +
            ", paymentMethod='" + paymentMethod + '\'' +
            ", NSU='" + NSU + '\'' +
            ", responseCode='" + responseCode + '\'' +
            '}';
    }
}
