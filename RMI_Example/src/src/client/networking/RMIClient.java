package src.client.networking;

import src.shared.networking.ClientCallback;
import src.shared.networking.RMIServer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIClient implements Client, ClientCallback
{
  private RMIServer server;
  private PropertyChangeSupport support;


  public RMIClient(){
    support = new PropertyChangeSupport(this);
  }

  @Override public void startClient()
  {
    try {
      UnicastRemoteObject.exportObject(this, 0);
      Registry registry = LocateRegistry.getRegistry("localhost", 1099);
      server = (RMIServer) registry.lookup("ChatServer");
    }
    catch (RemoteException | NotBoundException e) {
      throw new RuntimeException("Could not contact server");
    }
  }

  @Override public String loginUser(String username, String password)
  {
    try {
      String response = server.loginUser(username, password, this);
      if(response.equals("User logged in")){
        return response;
      }
      else {
        return response;
      }
    } catch (RemoteException e) {
      throw new RuntimeException("Could not contact server");
    }
  }

  @Override public String registerUser(String username, String password)
  {
    try {
      return server.registerUser(username, password);
    } catch (RemoteException e) {
      throw new RuntimeException("Could not contact server");
    }
  }

  @Override public String validateUser(String username, String password)
  {
    try {
      return server.validateUser(username, password);
    } catch (RemoteException e) {
      throw new RuntimeException("Could not contact server");
    }
  }

  @Override public String loggedInAs()
  {
    try
    {
      return server.loggedInAs(this);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Could not contact server");
    }
  }

  @Override public List<String> getUserList()
  {
    try
    {
      return server.getUserList();
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Could not contact server");
    }
  }

  @Override public void sendMessageToAll(String text)
  {
    try
    {
      server.sendMessageToAll(text);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Could not contact server");
    }
  }

  @Override public void sendPM(String message, String userToSendMessageTo)
  {
    try
    {
      server.sendPM(message, userToSendMessageTo);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void logOut(String userToLogOut)
  {
    try
    {
      server.logOut(userToLogOut, this);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void update(String eventName,String newValue)
  {
    support.firePropertyChange(eventName, null, newValue);
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }

}
