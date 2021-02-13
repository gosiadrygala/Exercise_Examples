package PrimeServer.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RunClient
{
  public static void main(String[] args)
      throws RemoteException, NotBoundException
  {
    RMIClient client = new RMIClient();
    client.startClient();

    Scanner input = new Scanner(System.in);
    int number;
    String proceed = "";
    while (true) {
      System.out.println("Insert the number -> ");
      number = input.nextInt();
      try {
        String prime = client.isPrime(number);
        System.out.println(prime);
      } catch(Exception e){
        System.out.println("Error: " + e.getMessage());
        break;
      }
      System.out.println("Do you want to continue? (To stop type exit).");
      input.nextLine();
      proceed = input.nextLine();
      if (proceed.equalsIgnoreCase("exit"))
        break;
    }
  }
}
