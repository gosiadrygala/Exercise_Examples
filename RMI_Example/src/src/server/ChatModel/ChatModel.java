package src.server.ChatModel;

import src.shared.util.PropertyChangeSubject;

import java.util.List;

public interface ChatModel extends PropertyChangeSubject
{
  void addNewActiveUser(String username);
  List<String> getUserList();
  void sendMessageToAll(String text);
  void removeUser(String userToLogOut);
}
