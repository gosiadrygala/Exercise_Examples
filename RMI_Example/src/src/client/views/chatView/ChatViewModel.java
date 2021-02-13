package src.client.views.chatView;

import src.client.chatModel.ChatModel;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import src.shared.util.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class ChatViewModel implements PropertyChangeSubject
{
  private ChatModel chatModel;
  private ObservableList<String> usersLoggedIn;
  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  public ChatViewModel(ChatModel chatModel)
  {
    this.chatModel = chatModel;
    chatModel.addListener("NewLogin", this:: onNewLogin);
    chatModel.addListener("NewMessage", this:: onNewMessage);
    chatModel.addListener("LogOut", this::onLogOut);
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
    Platform.runLater(()-> {
    usersLoggedIn.add((String) propertyChangeEvent.getNewValue());
    });
  }

  void loadLogs() {
    List<String> userList = chatModel.getUserList();
    usersLoggedIn = FXCollections.observableArrayList(userList);
  }


  ObservableList<String> getUserList() {
    return usersLoggedIn;
  }

  public String loggedInAs()
  {
    return chatModel.loggedInAs();
  }

  public void sendMessageToAll(String text)
  {
    chatModel.sendMessageToAll(text);
  }


  @Override
  public void addListener(String eventName, PropertyChangeListener listener) {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override
  public void removeListener(String eventName, PropertyChangeListener listener) {
    support.removePropertyChangeListener(eventName, listener);
  }

  public void sendPM(String message, String userToSendMessageTo)
  {
    chatModel.sendPM(message, userToSendMessageTo);
  }

  public void logOut(String userToLogOut)
  {
    chatModel.logOut(userToLogOut);
  }
}
