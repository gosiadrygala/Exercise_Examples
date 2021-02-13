package src.client.views.chatView;

import src.client.core.ViewHandler;
import src.client.core.ViewModelFactory;
import src.client.views.ViewController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.beans.PropertyChangeEvent;

public class ChatViewController implements ViewController
{

  @FXML
  private ListView<String> activeUsersListView;

  @FXML
  private Button sendPMButton;

  @FXML
  private TextArea chatTextArea;

  @FXML
  private TextField messageTextArea;

  @FXML
  private Button sendToAllButton;

  @FXML
  private Label loggedInAs;

  @FXML
  private Button logOutButton;

  private ViewHandler viewHandler;

  private ChatViewModel chatViewModel;

  @FXML
  void handleClickMe(ActionEvent event) {
    if(event.getSource() == sendToAllButton){
      chatViewModel.sendMessageToAll( "[" + loggedInAs.getText() + "] "+ messageTextArea.getText() + "\n");
      messageTextArea.clear();
    }
    else if(event.getSource() == sendPMButton){
      if(activeUsersListView.getSelectionModel().getSelectedItem().equals(loggedInAs.getText())){
        chatTextArea.appendText("Sending a private message to yourself is a bit sad...\n");
        messageTextArea.clear();

      }else{
        chatViewModel.sendPM("[ Private message from: "+ loggedInAs.getText() + "] " + messageTextArea.getText() + "\n", activeUsersListView.getSelectionModel().getSelectedItem());
        chatTextArea.appendText("[" + loggedInAs.getText() + "] " + messageTextArea.getText()+ "\n");
        messageTextArea.clear();
      }

    }
    else if(event.getSource() == logOutButton){
      chatViewModel.logOut(loggedInAs.getText());
      viewHandler.close();
    }
  }
  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    this.chatViewModel = viewModelFactory.getChatViewModel();
    loggedInAs.setText(chatViewModel.loggedInAs());
    chatViewModel.loadLogs();
    activeUsersListView.setItems(chatViewModel.getUserList());
   chatViewModel.addListener("NewMessage", this :: onNewMessage);
    chatViewModel.addListener("LogOut", this::onLogOut);
  }

  private void onLogOut(PropertyChangeEvent propertyChangeEvent)
  {
    Platform.runLater(()-> {
    chatViewModel.loadLogs();
    activeUsersListView.setItems(chatViewModel.getUserList());
    });
  }

  private void onNewMessage(PropertyChangeEvent propertyChangeEvent)
  {
    Platform.runLater(()-> {
     chatTextArea.appendText((String) propertyChangeEvent.getNewValue());
      });
  }
}
