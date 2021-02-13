package src.client.core;

import src.client.networking.Client;
import src.client.networking.RMIClient;

public class ClientFactory
{
  private Client client;

  public Client getClientModel()
  {
    if(client == null) {
      client = new RMIClient();
    }
    return client;
  }

}

