package PrimeServerCallback.shared;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PrimeServer extends Remote {
  void isPrime(int number, PrimeClientCallback clientCallback) throws RemoteException;
  void startServer() throws RemoteException, AlreadyBoundException;
}
