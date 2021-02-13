package src.client.core;

import src.client.views.chatView.ChatViewController;
import src.client.views.loginView.LoginViewController;
import src.client.views.mainView.MainViewController;
import src.client.views.registerView.RegisterViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(ViewModelFactory viewModelFactory){
    this.viewModelFactory = viewModelFactory;
  }

  public void start(){
    stage = new Stage();
    openMainView();
  }

  public void openMainView()
  {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("../views/mainView/main.fxml"));
      Parent root = loader.load();

      MainViewController view = loader.getController();
      view.init(this, viewModelFactory);
      Scene scene = new Scene(root);
      stage.setTitle("main");
      stage.setScene(scene);
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void openLoginView()
  {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("../views/loginView/login.fxml"));
      Parent root = loader.load();

      LoginViewController view = loader.getController();
      view.init(this, viewModelFactory);
      Scene scene = new Scene(root);
      stage.setTitle("login");
      stage.setScene(scene);
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void openRegisterView()
  {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("../views/registerView/register.fxml"));
      Parent root = loader.load();

      RegisterViewController view = loader.getController();
      view.init(this, viewModelFactory);
      Scene scene = new Scene(root);
      stage.setTitle("register");
      stage.setScene(scene);
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void openChatView(){
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("../views/chatView/chat.fxml"));
      Parent root = loader.load();

      ChatViewController view = loader.getController();
      view.init(this, viewModelFactory);
      Scene scene = new Scene(root);
      stage.setTitle("Chat");
      stage.setScene(scene);
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void close()
  {
    stage.close();
  }
}

