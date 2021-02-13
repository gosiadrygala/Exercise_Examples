package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.TextConverter;

public class UppercaseViewModel
{
  private TextConverter textConverter;
  private StringProperty request;
  private StringProperty reply;
  private StringProperty error;

  public UppercaseViewModel(TextConverter textConverter){
    this.textConverter = textConverter;
    request = new SimpleStringProperty();
    reply = new SimpleStringProperty();
    error = new SimpleStringProperty();
  }

  public void convert(){
    String input = request.get();
    if(input != null && !"".equals(input)) {
      String result = textConverter.toUpperCase(input);
      reply.set(result);
    } else {
      error.set("Please insert something?");
    }
  }

  public StringProperty errorProperty(){
    return error;
  }

  public StringProperty requestProperty(){
    return request;
  }

  public StringProperty replyProperty(){
    return reply;
  }

}
