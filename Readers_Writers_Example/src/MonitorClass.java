public interface MonitorClass {
  void acquireRead();
  void releaseRead();
  void acquireWrite();
  void releaseWrite();
  int readInt();
  void incrementInt();
}


