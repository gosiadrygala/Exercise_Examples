package SimpleChatSystem.server;

import SimpleChatSystem.ConnectionPool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
  public void startServer()
  {
    try
    {
      ServerSocket serverSocket = new ServerSocket(2980);
      System.out.println("Server started succesfully.");
      ConnectionPool connectionPool = new ConnectionPool();
      while(true){
        Socket socket = serverSocket.accept();
        ServerSocketHandler serverSocketHandler = new ServerSocketHandler(socket, connectionPool);
        connectionPool.addConnection(serverSocketHandler);
        Thread newServerThread = new Thread(serverSocketHandler);
        newServerThread.start();
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

  }
}
