package src.client.views.loginView;

import src.client.loginRegisterModel.LoginRegisterModel;

public class LoginViewModel
{
  public LoginRegisterModel loginRegisterModel;

  public LoginViewModel(LoginRegisterModel loginRegisterModel)
  {
    this.loginRegisterModel = loginRegisterModel;
  }

  public String loginUser(String username, String password)
  {
    return loginRegisterModel.loginUser(username, password);
  }
}
