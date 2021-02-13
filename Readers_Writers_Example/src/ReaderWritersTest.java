public class ReaderWritersTest
{
  public static void main(String[] args)
  {
    MonitorClass monitorClass = new MonitorClassImpl();
    Reader reader1 = new Reader(monitorClass);
    Reader reader2 = new Reader(monitorClass);

    Writer writer1 = new Writer(monitorClass);
    Writer writer2 = new Writer(monitorClass);

    Thread t1 = new Thread(reader1);
    Thread t2 = new Thread(reader2);
    Thread t3 = new Thread(writer1);
    Thread t4 = new Thread(writer2);
    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }
}


