public class LogTest
{
  public static void main(String[] args) {
    Log log1  = Log.getLog();
    log1.add("First singleton test");
    System.out.println(log1.getAll());

    Log log2 = Log.getLog();
    log2.add("Second singleton test");
    System.out.println(log2.getAll());

    System.out.println("Log 1 one reference: " + log1);
    System.out.println("Log 2 one reference: " + log2);
  }
}
