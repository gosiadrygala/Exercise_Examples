package src.client.views.registerView;

import src.client.core.ViewHandler;
import src.client.core.ViewModelFactory;
import src.client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegisterViewController implements ViewController
{
    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField repeatPasswordTextField;

    @FXML
    private Button registerButton;

    @FXML
    private Label errorLabel;

    private ViewHandler viewHandler;
    private RegisterViewModel registerViewModel;

    @FXML
    void handleClickMe(ActionEvent event) {
        if(event.getSource() == registerButton){
            if(passwordTextField.getText().isEmpty() || repeatPasswordTextField.getText().isEmpty() || usernameTextField.getText().isEmpty()){
                errorLabel.setText("Please fill all the fields");
            }
            else{
                if(!passwordTextField.getText().equals(repeatPasswordTextField.getText())){
                    errorLabel.setText("The passwords are not identical");
                }
                else{
                    String username = usernameTextField.getText();
                    String password = passwordTextField.getText();
                    String response = registerViewModel.validateUser(username, password);
                    if(response.equals("no user like this")){
                        String registerResponse = registerViewModel.registerUser(username, password);
                        try
                        {
                            Thread.sleep(2000);
                            viewHandler.openLoginView();
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }

                    }
                    else{
                        errorLabel.setText(response);
                    }
                }
            }
        }
    }

    @Override public void init(ViewHandler viewHandler,
        ViewModelFactory viewModelFactory)
    {
        this.viewHandler = viewHandler;
        this.registerViewModel = viewModelFactory.getRegisterViewModel();
    }
}
