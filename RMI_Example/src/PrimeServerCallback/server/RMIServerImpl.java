package PrimeServerCallback.server;
import PrimeServerCallback.shared.PrimeClientCallback;
import PrimeServerCallback.shared.PrimeServer;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServerImpl implements PrimeServer
{
  public RMIServerImpl() throws RemoteException {
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override public void startServer()
      throws RemoteException, AlreadyBoundException {
    Registry registry = LocateRegistry.createRegistry(1099); // default RMI port
    registry.bind("PrimeServer", this);
  }

  @Override public void isPrime(int number, PrimeClientCallback primeClient) throws RemoteException
  {
    boolean isPrime = false;
    for (int i = 2; i <= number / 2; i++){
      if (number % i == 0) {
        isPrime = true;
        break;
      }
    }
    String result ="";
    if (!isPrime)
      result += "" +number + " is a prime number.";
    else
      result += "" + number + " is not a prime number.";
    try {
      Thread.sleep(2000);
    }
    catch (InterruptedException e){
      e.printStackTrace();
    }
    primeClient.primeResult(result);
  }


}
