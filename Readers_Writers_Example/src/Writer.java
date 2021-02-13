public class Writer implements Runnable
{
  private MonitorClass monitorClass;

  public Writer(MonitorClass monitorClass) {
    this.monitorClass = monitorClass;
  }

  @Override public void run()
  {
    while(true){
      monitorClass.acquireWrite();
      monitorClass.incrementInt();
      System.out.println("Writer incremented the number.");
      monitorClass.releaseWrite();
      try {
        Thread.sleep(3000);
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

