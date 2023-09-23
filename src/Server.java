import models.Card;
import utils.CardHelper;
import utils.MessageParser;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Server {

    private static final List<Card> cards = new ArrayList<>();
    private static final AtomicInteger nsuCounter = new AtomicInteger(1);
    private static final int port = 12345;

    public static void main(String[] args) throws IOException {
        cards.add(new Card("525977383695", "Frodo", 1770.00));
        cards.add(new Card("535898346986", "Bilbo", 5890.50));
        cards.add(new Card("558628902251", "Gandalf", 5560.40));

        final ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server awaiting connections...");

        while (true) {
            final Socket socket = serverSocket.accept();
            System.out.println("Connected client: " + socket.getInetAddress());
            final Thread clientThread = new Thread(() -> {
                try (
                    final InputStream input = socket.getInputStream();
                    final OutputStream output = socket.getOutputStream()
                ) {
                    while (true) {
                        final byte[] messageBytes = new byte[1024];
                        final int bytesRead = input.read(messageBytes);
                        final String message = new String(messageBytes, 0, bytesRead);
                        System.out.println("Received message: " + message);

                        final String response = processMessage(message);
                        final byte[] responseBytes = response.getBytes();
                        output.write(responseBytes);
                        System.out.println("Sent response: " + response);
                    }
                } catch (final IOException e) {
                    try {
                        socket.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

            clientThread.start();
        }
    }

    private static String processMessage(final String message) {
        final MessageParser parser = new MessageParser(message);
        double centsValue = parser.getCentsValue();
        String cardNumber = parser.getCardNumber();

        for (final Card card : cards) {
            if (findCard(cardNumber)) {
                if (centsValue > card.getBalance()) {
                    return "5100" + "0000";
                }
                CardHelper.performDebit(card, centsValue);
                final String nsu = generateNSU();
                return "0000" + nsu;
            }
        }
        return "0500" + "0000";
    }

    private static boolean findCard(final String cardNumber) {
        for (final Card card : cards) {
            if (card.getNumber().equals(cardNumber)) {
                return true;
            }
        }
        return false;
    }

    private static String generateNSU() {
        return String.format("%04d", nsuCounter.getAndIncrement());
    }
}
