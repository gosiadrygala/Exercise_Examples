package SimpleChatSystem;

import SimpleChatSystem.server.ServerSocketHandler;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool
{
  private List<ServerSocketHandler> serverSocketHandlers;

  public ConnectionPool(){
    serverSocketHandlers = new ArrayList<>();
  }

  public void addConnection(ServerSocketHandler serverSocketHandler){
    serverSocketHandlers.add(serverSocketHandler);
  }

  public void broadcastMessage(ChatMessage message){
    for(ServerSocketHandler serverSocketHandler : serverSocketHandlers){
      if(!serverSocketHandler.getClientUsername().equals(message.getUser())){
        serverSocketHandler.sendMessage(message);
      }
    }
  }

  public void removeConnection(ServerSocketHandler serverSocketHandler) {
    serverSocketHandlers.remove(serverSocketHandler);
  }
}
