package src.client.core;

import src.client.views.chatView.ChatViewModel;
import src.client.views.loginView.LoginViewModel;
import src.client.views.registerView.RegisterViewModel;


public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private ChatViewModel chatViewModel;
  private LoginViewModel loginViewModel;
  private RegisterViewModel registerViewModel;

  public ViewModelFactory(ModelFactory modelFactory){
    this.modelFactory = modelFactory;
  }

  public ChatViewModel getChatViewModel()
  {
    if (chatViewModel == null)
      chatViewModel = new ChatViewModel(modelFactory.getChatModel());

    return chatViewModel;
  }

  public LoginViewModel getLoginViewModel()
  {
    if (loginViewModel == null)
      loginViewModel = new LoginViewModel(modelFactory.getLoginRegisterModel());

    return loginViewModel;
  }

  public RegisterViewModel getRegisterViewModel()
  {
    if (registerViewModel == null)
      registerViewModel = new RegisterViewModel(modelFactory.getLoginRegisterModel());

    return registerViewModel;
  }
}
