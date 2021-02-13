package src.client.chatModel;

import src.shared.util.PropertyChangeSubject;

import java.util.List;

public interface ChatModel extends PropertyChangeSubject
{
  String loggedInAs();
  List<String> getUserList();
  void sendMessageToAll(String text);
  void sendPM(String message, String userToSendMessageTo);
  void logOut(String userToLogOut);
}
