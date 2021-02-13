package src.client.views.registerView;

import src.client.loginRegisterModel.LoginRegisterModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RegisterViewModel
{
  public LoginRegisterModel loginRegisterModel;

  public RegisterViewModel(LoginRegisterModel loginRegisterModel)
  {
    this.loginRegisterModel = loginRegisterModel;
  }

  public String validateUser(String username, String password)
  {
    return loginRegisterModel.validateUser(username, password);
  }

  public String registerUser(String username, String password)
  {
    return loginRegisterModel.registerUser(username, password);
  }
}
