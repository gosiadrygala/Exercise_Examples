package PrimeServer.server;

import PrimeServer.shared.PrimeServer;

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
