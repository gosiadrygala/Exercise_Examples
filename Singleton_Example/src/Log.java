import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Log
{
  private Queue<LogLine> logQueue = new LinkedList<>();
  private static Log log;
  private static Lock lock = new ReentrantLock();

  private Log(){
  }

  public static Log getLog(){
    if(log == null) {
      synchronized (lock){
        if(log == null){
          log = new Log();
        }
      }
    }
    return log;
  }

  public void add(String LogEntry){
    if (LogEntry == null || "".equals(LogEntry)) return;
    else {
      Calendar calendar = Calendar.getInstance();
      SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
      String time = formatter.format(calendar.getTime());
      LogLine logLine = new LogLine(LogEntry, time);
      logQueue.add(logLine);
    }
  }

  public Queue<LogLine> getAll(){
    return logQueue;
  }
}
