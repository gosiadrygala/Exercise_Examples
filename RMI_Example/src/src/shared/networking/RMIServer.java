package src.shared.networking;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIServer extends Remote
{
  void registerClient(ClientCallback client) throws RemoteException;
  String loginUser(String username, String password, ClientCallback client) throws RemoteException;
  String registerUser(String username, String password) throws RemoteException;
  String validateUser(String username, String password) throws RemoteException;
  String loggedInAs(ClientCallback client) throws RemoteException;
  List<String> getUserList() throws RemoteException;
  void sendMessageToAll(String text) throws RemoteException;
  void sendPM(String message, String userToSendMessageTo) throws RemoteException;
  void logOut(String userToLogOut, ClientCallback client) throws RemoteException;
}


