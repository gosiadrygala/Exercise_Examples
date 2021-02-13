package SimpleExample.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
  public void startClient(){
    try{
      Socket socket = new Socket("localhost", 2910); // creating a socket that is trying to connect to a multithreadedServer.multithreadedServer.PrimeServer.client.PrimeServer.client.PrimeServer.server at the given IP on the given port


      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream()); //used to send object to the multithreadedServer.multithreadedServer.PrimeServer.client.PrimeServer.client.PrimeServer.server
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream()); // used to read objects from multithreadedServer.multithreadedServer.PrimeServer.client.PrimeServer.client.PrimeServer.server

      while (true)
      {
        Scanner inputFromUser = new Scanner(System.in);
        System.out.println("What do you want translate to uppercase?");
        String text = inputFromUser.nextLine();
        outToServer.writeObject(text); // sending the string
        if(text.toLowerCase().equals("exit")){
          socket.close();
          break;
        }
        String o = (String) inFromServer.readObject(); // reading the object from multithreadedServer.multithreadedServer.PrimeServer.client.PrimeServer.client.PrimeServer.server, receiving the response

        System.out.println("Received from Server: " + o);
      }

    }catch (IOException | ClassNotFoundException e){
      e.printStackTrace();
    }
  }
}
