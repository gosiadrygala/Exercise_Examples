package PrimeServer.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public interface PrimeClient
{
  void startClient() throws RemoteException, NotBoundException;
  String isPrime(int number);
}
