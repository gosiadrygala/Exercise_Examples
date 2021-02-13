package src.shared.networking;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallback extends Remote
{
  void update(String eventName, String newValue) throws
      RemoteException;
}
