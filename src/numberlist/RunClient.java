package numberlist;

import numberlist.client.NumberListClient;
import numberlist.shared.Person;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RunClient {
    public static void main(String[] args) throws IOException, NotBoundException {
        NumberListClient client = new NumberListClient();
        client.startClient();
        System.out.println("Client finished");
    }
}
