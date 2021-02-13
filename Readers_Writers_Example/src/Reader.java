public class Reader implements Runnable
{
  private MonitorClass monitorClass;

  public Reader(MonitorClass monitorClass) {
    this.monitorClass = monitorClass;
  }

  @Override public void run()
  {
    while(true){
      monitorClass.acquireRead();
      System.out.println("Reader: " + monitorClass.readInt());
      monitorClass.releaseRead();
      try {
        Thread.sleep(3000);
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

