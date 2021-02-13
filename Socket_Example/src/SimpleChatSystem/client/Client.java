package SimpleChatSystem.client;

import SimpleChatSystem.ChatMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
  private ObjectInputStream inFromServer;
  private Socket socket;

  public void startClient(){
    try {
      socket = new Socket("localhost", 2980);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      inFromServer = new ObjectInputStream(socket.getInputStream());
      Scanner input = new Scanner(System.in);

      Thread thread = new Thread(() -> listenToServer());
      thread.start();
      System.out.println("Insert username -> ");
      String username = input.nextLine();
      outToServer.writeObject(username);
      while(true){
        System.out.println("Type a message ->");
        String chatMessage = input.nextLine();
        ChatMessage newMessage = new ChatMessage(chatMessage, username);
        outToServer.writeObject(newMessage);
        if(chatMessage.equalsIgnoreCase("exit")){
          break;
        }
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void listenToServer() {
    ChatMessage message = null;
    try {
      while (true){
        message = (ChatMessage) inFromServer.readObject();
        if(message.getMessage().equalsIgnoreCase("exit")){
          socket.close();
          break;
        }
        System.out.println(message);
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }
}


