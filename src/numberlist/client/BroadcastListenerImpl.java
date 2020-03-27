package numberlist.client;

import numberlist.shared.BroadcastListener;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BroadcastListenerImpl implements BroadcastListener {
    public BroadcastListenerImpl() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public void listFull() {
        System.out.println("List full");
    }
}
