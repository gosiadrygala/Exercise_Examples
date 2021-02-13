package PrimeServerCallback.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PrimeClientCallback extends Remote {
  void primeResult(String primeResult) throws RemoteException; // otherwise interface is illegal
}
