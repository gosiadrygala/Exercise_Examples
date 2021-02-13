package src.server;

import src.server.ChatModel.ChatModelManager;
import src.server.LoginRegisterModel.LoginRegisterModelManager;
import src.server.networking.RMIServerImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer
{
  public static void main(String[] args)
      throws AlreadyBoundException,
      RemoteException
  {
    RMIServerImpl ss = new RMIServerImpl(new LoginRegisterModelManager(), new ChatModelManager());
    ss.startServer();
  }
}
