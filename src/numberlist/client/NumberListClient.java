package numberlist.client;

import numberlist.shared.NumberListServer;
import numberlist.shared.Person;
import numberlist.shared.Utils;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class NumberListClient {
    private NumberListServer server;

    public void startClient() throws IOException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        server = (NumberListServer) registry.lookup(Utils.NUMBER_SERVER);

        BroadcastListenerImpl listener = new BroadcastListenerImpl();
        server.addBroadcastListener(listener);

        addPerson(new Person("Ole"));
        addPerson(new Person("Ib"));
        showNumberOfPersons();
        System.out.println("enter to stop");
        System.in.read();
        UnicastRemoteObject.unexportObject(listener, true);

    }

    public void addPerson(Person person) {
        try {
            server.addPerson(person);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    public void showNumberOfPersons(){
        try {
            server.getStatistics(new StatisticsListenerImpl());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
