package SimpleChatSystem;

import java.io.Serializable;

public class ChatMessage implements Serializable
{
  private String message;
  private String user;

  public ChatMessage(String message, String user){
    this.message = message;
    this.user = user;
  }

  public String getMessage(){
    return message;
  }

  public String getUser() { return user; }

  @Override public String toString()
  {
    return user + ": " + message;
  }
}
