package src.client.loginRegisterModel;

import src.shared.util.PropertyChangeSubject;

public interface LoginRegisterModel extends PropertyChangeSubject
{
  String loginUser(String username, String password);

  String registerUser(String username, String password);

  String validateUser(String username, String password);

}
