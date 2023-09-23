import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final int serverPort = 12345;
    private static final String serverAddress = "127.0.0.1";

    public static void main(final String[] args) {
        try {
            final Socket socket = new Socket(serverAddress, serverPort);
            final DataInputStream input = new DataInputStream(socket.getInputStream());
            final DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            final Scanner scanner = new Scanner(System.in);

//          *** Inputs that can be used ***
//
//          Example 1: 0200-000000010000080015091504010452597738369521
//          type: 0200
//          value:  -00000001000 (R$-10)
//          time: 080015
//          date: 0915
//          network: 040104
//          card number: 525977383695
//          payment method: 2 (credit)
//
//          Example 2: 0200000000250001432150915040104535898346986063911
//          type: 0200
//          value: 00000025000 (R$ 250)
//          time: 143215
//          date: 0915
//          network: 040104
//          card number: 5358983469860633
//          payment method: 1 (debit)
//
//          Example 3: 02000000010000090930091504010455862890225121
//          type: 0200
//          value: 00000010000 (R$ 100)
//          time: 090930
//          date: 0915
//          network: 040104
//          card number: 558628902251
//          payment method: 2 (credit)

            while (true) {
                System.out.println("Enter a message (or 'exit' to quit):");
                final String userInput = scanner.nextLine();

                if ("exit".equalsIgnoreCase(userInput)) {
                    break;
                }

                final byte[] messageBytes = userInput.getBytes();
                output.write(messageBytes);
                System.out.println("Sent message: " + userInput);

                final byte[] responseBytes = new byte[1024];
                final int bytesRead = input.read(responseBytes);
                String response = new String(responseBytes, 0, bytesRead);
                System.out.println("Received response: " + response);
            }

            socket.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
