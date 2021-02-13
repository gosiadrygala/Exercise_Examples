package PrimeServer.client;

import PrimeServer.shared.PrimeServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient implements PrimeClient
{
  private PrimeServer taxServer;

  public RMIClient(){
  }

  public void startClient() throws RemoteException, NotBoundException {
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    taxServer = (PrimeServer) registry.lookup("PrimeServer");
  }

  public String isPrime(int number){
    try {
      return taxServer.isPrime(number);
    }
    catch (RemoteException e) {
      throw new RuntimeException("Could not contact server.");
    }
  }
}
