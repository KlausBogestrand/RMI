package numberlist.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BroadcastListener extends Remote {
    void listFull() throws RemoteException;
}
