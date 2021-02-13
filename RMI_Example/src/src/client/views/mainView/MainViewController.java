package src.client.views.mainView;

import src.client.core.ViewHandler;
import src.client.core.ViewModelFactory;
import src.client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainViewController implements ViewController {
  @FXML
  private Button loginBtn;

  @FXML
  private Button registerBtn;

  private ViewHandler viewHandler;

  @FXML
  void handleClickMe(ActionEvent event) {
    if(event.getSource() == loginBtn){
      viewHandler.openLoginView();
    }
    else if(event.getSource() == registerBtn){
      viewHandler.openRegisterView();
    }
  }

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
  }
}
