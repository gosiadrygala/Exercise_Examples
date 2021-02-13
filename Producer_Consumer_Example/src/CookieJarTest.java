public class CookieJarTest
{
  public static void main(String[] args) {
    CookieMonitor monitor = new CookieMonitor();

    CookieBaker cookieBaker = new CookieBaker(monitor);
    Thread thread = new Thread(cookieBaker);

    CookieEater cookieEater = new CookieEater(monitor);
    Thread thread1 = new Thread(cookieEater);

    CookieEater cookieEater1 = new CookieEater(monitor);
    Thread thread2 = new Thread(cookieEater1);

    thread.start();
    thread1.start();
    thread2.start();
  }
}

