package src.client.loginRegisterModel;

import src.client.networking.Client;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoginRegisterModelManager implements LoginRegisterModel
{
  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private Client client;

  public LoginRegisterModelManager(Client client)
  {
    this.client = client;
    client.startClient();
  }

  @Override public String loginUser(String username, String password)
  {
    return client.loginUser(username, password);
  }

  @Override public String registerUser(String username, String password)
  {
    return client.registerUser(username, password);
  }

  @Override public String validateUser(String username, String password)
  {
    return client.validateUser(username, password);
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
