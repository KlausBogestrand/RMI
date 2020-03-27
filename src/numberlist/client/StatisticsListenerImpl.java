package numberlist.client;

import numberlist.shared.Statistics;
import numberlist.shared.StatisticsListener;

import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StatisticsListenerImpl implements StatisticsListener {
    public StatisticsListenerImpl() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public void receiveStatistics(Statistics statistics) throws NoSuchObjectException {
        System.out.println("Antal personer:" + statistics.getNumberOfPersons());
        UnicastRemoteObject.unexportObject(this, true);
    }
}
