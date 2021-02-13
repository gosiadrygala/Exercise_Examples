package SimpleChatSystem.server;

import SimpleChatSystem.ChatMessage;
import SimpleChatSystem.ConnectionPool;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private ObjectInputStream objectInputStream;
  private ObjectOutputStream objectOutputStream;
  private ConnectionPool connectionPool;
  private String username;

  public ServerSocketHandler(Socket socket, ConnectionPool connectionPool){
    this.socket = socket;
    this.connectionPool = connectionPool;
    try{
      objectInputStream = new ObjectInputStream(socket.getInputStream());
      objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override public void run(){
    try {
      username = (String) objectInputStream.readObject();
      while(true){
        ChatMessage chatMessage = (ChatMessage) objectInputStream.readObject();
        String message = chatMessage.getMessage();
        if(message.equalsIgnoreCase("exit")){
          connectionPool.removeConnection(this);
          objectOutputStream.writeObject(chatMessage);
          socket.close();
          break;
        }
        connectionPool.broadcastMessage(chatMessage);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void sendMessage(ChatMessage message) {
    try {
      objectOutputStream.writeObject(message);
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String getClientUsername()
  {
    return username;
  }
}
