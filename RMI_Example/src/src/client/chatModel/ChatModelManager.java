package src.client.chatModel;

import src.client.networking.Client;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class ChatModelManager implements ChatModel
{
  private Client client;
  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  public ChatModelManager(Client client)
  {
    this.client = client;
    client.addListener("NewLogin", this::onNewLogin);
    client.addListener("NewMessage", this::onNewMessage);
    client.addListener("LogOut", this::onLogOut);
  }

  private void onLogOut(PropertyChangeEvent propertyChangeEvent)
  {
    support.firePropertyChange(propertyChangeEvent);
  }

  private void onNewMessage(PropertyChangeEvent propertyChangeEvent)
  {
    support.firePropertyChange(propertyChangeEvent);
  }

  private void onNewLogin(PropertyChangeEvent propertyChangeEvent)
  {
    support.firePropertyChange(propertyChangeEvent);
  }

  @Override public String loggedInAs()
  {
    return client.loggedInAs();
  }

  @Override public List<String> getUserList()
  {
    return client.getUserList();
  }

  @Override public void sendMessageToAll(String text)
  {
    client.sendMessageToAll(text);
  }

  @Override public void sendPM(String message, String userToSendMessageTo)
  {
    client.sendPM(message, userToSendMessageTo);
  }

  @Override public void logOut(String userToLogOut)
  {
    client.logOut(userToLogOut);
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
