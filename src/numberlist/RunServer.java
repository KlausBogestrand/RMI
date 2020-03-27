package numberlist;

import numberlist.server.NumberServerImpl;
import numberlist.shared.Utils;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        NumberServerImpl server = new NumberServerImpl();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind(Utils.NUMBER_SERVER,server);
    }
}
