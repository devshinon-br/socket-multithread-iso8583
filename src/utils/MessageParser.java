package utils;

public class MessageParser {
    private final String message;

    public MessageParser(final String message) {
        this.message = message;
    }

    public String getType() {
        return message.substring(0, 4);
    }

    public double getCentsValue() {
        String centsValueStr = message.substring(5, 15);
        return Double.parseDouble(centsValueStr) / 100.0;
    }

    public String getLocalTransactionTime() {
        return message.substring(15, 21);
    }

    public String getTransactionDate() {
        return message.substring(22, 25);
    }

    public String getTransmittingNetwork() {
        return message.substring(25, 31);
    }

    public String getCardNumber() {
        return message.substring(31, 43);
    }

    public String getPaymentMethod() {
        return message.substring(43);
    }
}