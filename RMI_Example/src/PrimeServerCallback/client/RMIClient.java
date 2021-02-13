package PrimeServerCallback.client;

import PrimeServerCallback.shared.PrimeClientCallback;
import PrimeServerCallback.shared.PrimeServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIClient implements PrimeClient, PrimeClientCallback
{
  private PrimeServer taxServer;

  public RMIClient(){
    try {
      UnicastRemoteObject.exportObject(this, 0);
    }
    catch (RemoteException e) {
      e.printStackTrace();
    }
  }

  public void startClient(){
    Registry registry = null;
    try {
      registry = LocateRegistry.getRegistry("localhost", 1099);
      taxServer = (PrimeServer) registry.lookup("PrimeServer");
    }
    catch (RemoteException | NotBoundException e)
    {
      throw new RuntimeException("Could not contact server.");
    }
  }

  public void isPrime(int number){
    try {
      taxServer.isPrime(number, this);
    }
    catch (RemoteException e) {
      throw new RuntimeException("Could not contact server.");
    }
  }

  @Override public void primeResult(String primeResult) {
    System.out.println("Result -> " + primeResult);
  }
}
