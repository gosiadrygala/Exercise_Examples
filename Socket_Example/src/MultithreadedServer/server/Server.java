package MultithreadedServer.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{

  public void startServer(){
    System.out.println("Starting the multithreadedServer.multithreadedServer.PrimeServer.client.PrimeServer.client.PrimeServer.server.....");

    try{
      ServerSocket welcomeSocket = new ServerSocket(2910); // multithreadedServer.multithreadedServer.PrimeServer.client.PrimeServer.client.PrimeServer.server socket receiving all incoming connections requests

      while(true){
        Socket socket = welcomeSocket.accept(); // multithreadedServer.multithreadedServer.PrimeServer.client.PrimeServer.client.PrimeServer.server accepts the connection
        System.out.println("Client successfully connected!");

        ServerSocketHandler handler = new ServerSocketHandler(socket);
        Thread newThread = new Thread(handler);
        newThread.start();
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
