package MultithreadedServer.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private final Socket socket;

  public ServerSocketHandler(Socket socket)
  {
    this.socket = socket;
  }

  @Override public void run()
  {
    try
    {
      ObjectOutputStream outToClient = new ObjectOutputStream((socket.getOutputStream())); //used to send objects to the multithreadedServer.multithreadedServer.PrimeServer.client.PrimeServer.client
      ObjectInputStream inFromClient = new ObjectInputStream((socket.getInputStream())); // to receive objects from multithreadedServer.multithreadedServer.PrimeServer.client.PrimeServer.client

      while (true)
      {
        String o = (String) inFromClient.readObject(); // actual receive of object
        if(o.toLowerCase().equals("exit")){
          socket.close();
          break;
        }
        System.out.println("Received from multithreadedServer.multithreadedServer.PrimeServer.client.PrimeServer.client: " + o);
        String answer = o.toUpperCase(); // multithreadedServer.multithreadedServer.PrimeServer.client.PrimeServer.client.PrimeServer.server response for the input from multithreadedServer.multithreadedServer.PrimeServer.client.PrimeServer.client
        outToClient.writeObject(answer); // send response to the multithreadedServer.multithreadedServer.PrimeServer.client.PrimeServer.client
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }
}
