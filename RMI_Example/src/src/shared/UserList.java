package src.shared;

import java.io.Serializable;
import java.util.ArrayList;

public class UserList implements Serializable
{
  private ArrayList<User> users;
  public UserList(){
    users = new ArrayList<>();
  }

  public void addUser(User user){
    users.add(user);
  }

  public ArrayList<User> getListOfUsers()
  {
    return users;
  }

}
