package src.client.views.loginView;

import src.client.core.ViewHandler;
import src.client.core.ViewModelFactory;
import src.client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginViewController implements ViewController
{
  @FXML
  private TextField usernameTextField;

  @FXML
  private TextField passwordTextField;

  @FXML
  private Label errorLabel;

  @FXML
  private Button loginButton;

  private ViewHandler viewHandler;

  private LoginViewModel loginViewModel;

  @FXML
  void handleClickMe(ActionEvent event) {
    if(event.getSource() == loginButton){
      if(usernameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty()){
        errorLabel.setText("Please fill all the fields");
      }
      else{
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        String response = loginViewModel.loginUser(username, password);
        if(response.equals("Wrong credentials")){
          errorLabel.setText(response);
        }
        else{
          viewHandler.openChatView();
        }
      }
    }
  }

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    this.loginViewModel = viewModelFactory.getLoginViewModel();
  }
}
