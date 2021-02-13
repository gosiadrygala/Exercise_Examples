package src.server.LoginRegisterModel;

import src.shared.User;
import src.shared.UserList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class LoginRegisterModelManager implements LoginRegisterModel
{
  private UserList userList;
  private PropertyChangeSupport support;

  public LoginRegisterModelManager(){
    userList = new UserList();
    support = new PropertyChangeSupport(this);
    userList.addUser(new User("Gosia", "lol"));
    userList.addUser(new User("Karlo", "lol"));
    userList.addUser(new User("Someone", "lol"));
  }

  @Override public String loginUser(String username, String password)
  {
    ArrayList<User> allUsers = userList.getListOfUsers();
    User user = new User(username, password);
    for (int i = 0; i < allUsers.size(); i++)
    {
      if(allUsers.get(i).getUsername().equals(user.getUsername()) && allUsers.get(i).getPassword().equals(user.getPassword())){

        return "User logged in";
      }
      else{

      }
    }
    return "Wrong credentials";
  }

  @Override public String registerUser(String username, String password)
  {
    User user = new User(username, password);
    userList.addUser(user);
    return "User registered";
  }

  @Override public String validateUser(String username, String password)
  {
    ArrayList<User> allUsers = userList.getListOfUsers();
    User user = new User(username, password);
    for (int i = 0; i < allUsers.size(); i++)
    {
      if(allUsers.get(i).getUsername().equals(user.getUsername())){
        return "User with this name already exists";
      }
      else{

      }
    }
    return "no user like this";
  }

  @Override
  public void addListener(String eventName, PropertyChangeListener listener) {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override
  public void removeListener(String eventName, PropertyChangeListener listener) {
    support.removePropertyChangeListener(eventName, listener);
  }

}
