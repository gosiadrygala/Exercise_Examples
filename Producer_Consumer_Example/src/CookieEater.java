import java.util.Random;

public class CookieEater implements Runnable
{
  private CookieMonitor monitor;
  private Random random;

  public CookieEater(CookieMonitor monitor) {
    this.monitor = monitor;
    random = new Random();
  }

  @Override public void run() {
    while(true){
      monitor.eatCookies();
      try{
        Thread.sleep(random.nextInt(3000) + 2000);
      }
      catch (InterruptedException e) { e.printStackTrace(); }
    }
  }
}



