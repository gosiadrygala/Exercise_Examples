package PrimeServerCallback.server;

import PrimeServerCallback.shared.PrimeServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer
{
  public static void main(String[] args)
      throws RemoteException, AlreadyBoundException {
    PrimeServer server = new RMIServerImpl();
    server.startServer();
  }
}
