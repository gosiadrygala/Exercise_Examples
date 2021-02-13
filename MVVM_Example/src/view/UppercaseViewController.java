package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UppercaseViewController
{
  @FXML
  private TextField requestField;
  @FXML
  private TextField replyField;
  @FXML
  private Button submitButton;
  @FXML
  private Label errorLabel;

  private UppercaseViewModel uppercaseVM;

  public void init(UppercaseViewModel uppercaseVM){
    this.uppercaseVM = uppercaseVM;
    requestField.textProperty().bindBidirectional(uppercaseVM.requestProperty());
    replyField.textProperty().bind(uppercaseVM.replyProperty());
    errorLabel.textProperty().bind(uppercaseVM.errorProperty());
  }

  public void handleClickMe(ActionEvent actionEvent)
  {
    if (actionEvent.getSource() == submitButton)
    {
      uppercaseVM.convert();
    }
  }
}

