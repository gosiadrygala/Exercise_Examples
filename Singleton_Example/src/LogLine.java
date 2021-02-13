public class LogLine
{
  private String logEntry;
  private String time;

  public LogLine(String logEntry, String time){
    this.logEntry = logEntry;
    this.time = time;
  }

  public String getLogEntry(){
    return logEntry;
  }

  public String getTime() { return time; }

  public String toString(){
    return time + " " + logEntry;
  }
}

