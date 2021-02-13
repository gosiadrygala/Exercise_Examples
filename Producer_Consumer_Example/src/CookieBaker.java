import java.util.ArrayList;

public class CookieBaker implements Runnable
{
  private CookieMonitor monitor;
  private ArrayList<Cookie> cookies;
  private int capacity = 16;

  public CookieBaker(CookieMonitor monitor) {
    this.monitor = monitor;
    cookies = new ArrayList<>();
  }

  @Override public void run() {
    for (int i = 0; i < capacity; i++) {
    cookies.add(new Cookie("ChocolateChip"));
    }
    while(true){
      monitor.startBaking();
      try {
        Thread.sleep(7000);
      }
      catch (InterruptedException e) { e.printStackTrace(); }
      monitor.finishedBaking(cookies);
    }
  }
}

