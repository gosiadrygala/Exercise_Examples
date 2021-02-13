import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class CoronaNews implements PropertyChangeSubject
{
  private String[] coronaUpdates;
  private PropertyChangeSupport support;

  public CoronaNews(){
    coronaUpdates = new String[] {"Schools will close",
        "Bars will close", "Working from home is obligatory"};
    support = new PropertyChangeSupport(this);
  }

  public void startTheNews(){
    Random randomNumber = new Random();
    for (int i = 0; i < 10; i++) {
      System.out.println("\nThere are some new corona updates.\n");
      try {
        Thread.sleep(2000);
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
      int newsNo = randomNumber.nextInt(2);
      System.out.println(coronaUpdates[newsNo]);
      support.firePropertyChange("New corona news", null, coronaUpdates[newsNo]);
    }
  }

  @Override public void addListener(PropertyChangeListener listener) {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(PropertyChangeListener listener) {
    support.removePropertyChangeListener(listener);
  }
}
