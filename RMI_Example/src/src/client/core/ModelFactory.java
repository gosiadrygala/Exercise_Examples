package src.client.core;

import src.client.chatModel.ChatModel;
import src.client.chatModel.ChatModelManager;
import src.client.loginRegisterModel.LoginRegisterModel;
import src.client.loginRegisterModel.LoginRegisterModelManager;

public class ModelFactory
{
  private LoginRegisterModel loginRegisterModel;
  private ChatModel chatModel;
  private ClientFactory clientFactory;


  public ModelFactory(ClientFactory clientFactory){
    this.clientFactory = clientFactory;
  }

  public LoginRegisterModel getLoginRegisterModel()
  {
    if(loginRegisterModel == null) {
      loginRegisterModel = new LoginRegisterModelManager(clientFactory.getClientModel());
    }
    return loginRegisterModel;
  }

  public ChatModel getChatModel()
  {
    if(chatModel == null) {
      chatModel = new ChatModelManager(clientFactory.getClientModel());
    }
    return chatModel;
  }

}