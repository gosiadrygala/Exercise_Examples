package src.server.ChatModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ChatModelManager implements ChatModel
{
  private PropertyChangeSupport support;
  private List<String> activeUsers;

  public ChatModelManager(){
    support = new PropertyChangeSupport(this);
    activeUsers = new ArrayList<>();
  }

  @Override public void addNewActiveUser(String username)
  {
    activeUsers.add(username);
    support.firePropertyChange("NewLogin", null, username); //TODO the remove active user
  }

  @Override public List<String> getUserList()
  {
    return activeUsers;
  }

  @Override public void sendMessageToAll(String text)
  {
    support.firePropertyChange("NewMessage", null, text);
  }

  @Override public void removeUser(String userToLogOut)
  {
    activeUsers.remove(userToLogOut);
    support.firePropertyChange("LogOut", null, userToLogOut);
  }

  @Override
  public void addListener(String eventName, PropertyChangeListener listener) {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override
  public void removeListener(String eventName, PropertyChangeListener listener) {
    support.removePropertyChangeListener(eventName, listener);
  }
}
