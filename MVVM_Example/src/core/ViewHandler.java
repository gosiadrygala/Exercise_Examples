package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.UppercaseViewController;

import java.io.IOException;

public class ViewHandler
{
  private Scene uppercaseScene;
  private ViewModelFactory vmf;
  private Stage stage;


  public ViewHandler(ViewModelFactory vmf){
     this.vmf = vmf;
  }

  public void start() throws IOException
  {
    stage = new Stage();
    openToUpperCase();
  }

  public void openToUpperCase() throws IOException
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("view/UppercaseView.fxml"));
    Parent root = loader.load();

    UppercaseViewController ctrl = loader.getController();
    ctrl.init(vmf.getUppercaseVM());

    stage.setTitle("Upper case");
    uppercaseScene = new Scene(root);

    stage.setScene(uppercaseScene);
    stage.show();
  }
}
