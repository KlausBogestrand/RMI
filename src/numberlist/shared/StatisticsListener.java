package numberlist.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StatisticsListener extends Remote {
    void receiveStatistics(Statistics statistics) throws RemoteException;
}
