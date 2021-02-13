package src.shared.util;

import src.shared.networking.ClientCallback;

public class ClientWithId
{
  private ClientCallback client;
  private String username;

  public ClientWithId(ClientCallback client, String username){
    this.client = client;
    this.username = username;
  }

  public ClientCallback getClient()
  {
    return client;
  }

  public String getUsername()
  {
    return username;
  }
}
