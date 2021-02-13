package src.client.networking;

import src.shared.util.PropertyChangeSubject;

import java.util.List;

public interface Client extends PropertyChangeSubject
{
  void startClient();
  String loginUser(String username, String password);
  String registerUser(String username, String password);
  String validateUser(String username, String password);
  String loggedInAs();
  List<String> getUserList();
  void sendMessageToAll(String text);
  void sendPM(String message, String userToSendMessageTo);
  void logOut(String userToLogOut);
}
