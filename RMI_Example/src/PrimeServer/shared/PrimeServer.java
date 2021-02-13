package PrimeServer.shared;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PrimeServer extends Remote {
  String isPrime(int number) throws RemoteException;
  void startServer() throws RemoteException, AlreadyBoundException;
}
