package numberlist.server;

import numberlist.shared.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class NumberServerImpl implements NumberListServer {
    private List<Person> personer;
    private List<BroadcastListener> listeners;

    public NumberServerImpl() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        personer = new ArrayList<Person>();
        listeners = new ArrayList<BroadcastListener>();
    }

    @Override
    public void addPerson(Person person) {
        personer.add(person);
        System.out.println(person.getNavn());
        if (personer.size() > 5) {
            broadCastToListeners();
        }
    }

    private Statistics computeStatistics() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Statistics(personer.size());
    }

    @Override
    public void getStatistics(StatisticsListener listener)  {
        try {
            listener.receiveStatistics(computeStatistics());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBroadcastListener(BroadcastListener listener) {
        listeners.add(listener);
    }

    private void broadCastToListeners()  {
        for (BroadcastListener listener : listeners) {
            try {
                listener.listFull();
            } catch (RemoteException e) {
                System.out.println("Klient svarer ikke");
            }
        }
    }
}
