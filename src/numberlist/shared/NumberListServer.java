package numberlist.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NumberListServer extends Remote {
    void addPerson(Person person) throws RemoteException;

    void getStatistics(StatisticsListener listener) throws RemoteException;

    void addBroadcastListener(BroadcastListener listener) throws RemoteException;
}
