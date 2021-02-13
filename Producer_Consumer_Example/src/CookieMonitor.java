import java.util.ArrayList;

public class CookieMonitor
{
  private ArrayList<Cookie> cookieJar = new ArrayList<>();
  private int capacity = 20;

  public synchronized void startBaking(){
    while(cookieJar.size() == capacity || cookieJar.size() > 4){
      try{
        wait();
      }
      catch (InterruptedException e){e.printStackTrace();}
    }
    System.out.println("Baker starts to bake.");
  }

  public synchronized void finishedBaking(ArrayList<Cookie> cookies){
    if(cookieJar.size() == 0){
      cookieJar.addAll(cookies);
      notifyAll();
    }else{
      cookieJar.addAll(cookies);
    }

    System.out.println("Baker finished baking cookies, there are "
        + cookieJar.size() + " cookies in the jar.");
  }

  public synchronized void eatCookies(){
    while(cookieJar.size() == 0) {
      try {
        wait();
      }
      catch (InterruptedException e) { e.printStackTrace(); }
    }
    cookieJar.remove(0);
    if(cookieJar.size() == 4){
      notify();
    }
    System.out.println("Cookie eater eats a cookie, there are "
        + cookieJar.size() + " cookies in the jar.");
    }
  }

