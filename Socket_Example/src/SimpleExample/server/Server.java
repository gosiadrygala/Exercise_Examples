package SimpleExample.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
  public void startServer(){
    System.out.println("Starting the PrimeServer.server.....");

    try{
      ServerSocket welcomeSocket = new ServerSocket(2910);
      while(true){
        Socket socket = welcomeSocket.accept();
        System.out.println("Client successfully connected!");

        ObjectOutputStream outToClient = new ObjectOutputStream((socket.getOutputStream()));
        ObjectInputStream inFromClient = new ObjectInputStream((socket.getInputStream()));

        while (true)
        {
          String o = (String) inFromClient.readObject();
          if(o.toLowerCase().equals("exit")){
            socket.close();
            break;
          }
          System.out.println("Received from PrimeServer.client: " + o);
          String answer = o.toUpperCase();
          outToClient.writeObject(answer);
        }
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }
}
