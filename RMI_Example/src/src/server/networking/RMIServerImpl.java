package src.server.networking;

import src.server.ChatModel.ChatModel;
import src.server.LoginRegisterModel.LoginRegisterModel;
import src.shared.networking.ClientCallback;
import src.shared.networking.RMIServer;
import src.shared.util.ClientWithId;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RMIServerImpl implements RMIServer
{
  private final LoginRegisterModel loginRegisterModel;
  private final ChatModel chatModel;
  private List<ClientWithId> listOfUsers;
  private Map<ClientCallback, PropertyChangeListener> listeners = new HashMap<>();


  public RMIServerImpl(LoginRegisterModel loginRegisterModel, ChatModel chatModel)
      throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.loginRegisterModel = loginRegisterModel;
    this.chatModel = chatModel;
    listOfUsers = new ArrayList<>();
  }

  public void startServer()
      throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("ChatServer", this);
  }

  @Override public void registerClient(ClientCallback client)
  {
    PropertyChangeListener listener = new PropertyChangeListener() {
      @Override
      public void propertyChange(PropertyChangeEvent evt) {
        try {
          client.update(evt.getPropertyName(),(String) evt.getNewValue());
        } catch (RemoteException e) {
          e.printStackTrace();
        }
      }
    };
    listeners.put(client, listener);
    chatModel.addListener("NewLogin", listener);
    chatModel.addListener("NewMessage", listener);
    chatModel.addListener("LogOut", listener);
  }

  @Override public String loginUser(String username, String password, ClientCallback client)
  {
    String result = loginRegisterModel.loginUser(username, password);
    if(result.equals("User logged in")){
      listOfUsers.add(new ClientWithId(client, username));
      chatModel.addNewActiveUser(username);
      registerClient(client);
      return result;
    }
    else{
      return result;
    }
  }

  @Override public String registerUser(String username, String password)
  {
    return loginRegisterModel.registerUser(username, password);
  }

  @Override public String validateUser(String username, String password)
  {
    return loginRegisterModel.validateUser(username, password);
  }

  @Override public String loggedInAs(ClientCallback client)
  {
    String userName = null;
    for (ClientWithId listOfUser : listOfUsers)
    {
      if (listOfUser.getClient().equals(client))
      {
        userName = listOfUser.getUsername();
      }
    }
    return userName;
  }

  @Override public List<String> getUserList()
  {
    return chatModel.getUserList();
  }

  @Override public void sendMessageToAll(String text) throws RemoteException {
    chatModel.sendMessageToAll(text);
  }

  @Override public void sendPM(String message, String userToSendMessageTo)
      throws RemoteException
  {
    ClientCallback clientCallback = null;

    for (int i = 0; i < listOfUsers.size(); i++)
    {
      if(userToSendMessageTo.equals(listOfUsers.get(i).getUsername())){
        clientCallback = listOfUsers.get(i).getClient();
      }
    }

    clientCallback.update("NewMessage", message);
  }

  @Override public void logOut(String userToLogOut, ClientCallback client) throws RemoteException
  {
    listOfUsers.remove(new ClientWithId(client, userToLogOut));
    chatModel.removeUser(userToLogOut);
    listeners.remove(client);
  }
}
