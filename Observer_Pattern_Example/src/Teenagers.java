import java.beans.PropertyChangeEvent;

public class Teenagers
{
  public Teenagers(PropertyChangeSubject propertyChangeSubject){
    propertyChangeSubject.addListener(this::newsReaction);
  }

  public void newsReaction(PropertyChangeEvent evt)
  {
    String news = (String) evt.getNewValue();

    if(news.equals("Working from home is obligatory")){
      System.out.println("Teenagers: Oh no my parents at home???");
    }
    else if(news.equals("Schools will close")){
      System.out.println("Teenagers: WOOOOOOHOOO");
    }
    else if(news.equals("Bars will close")){
      System.out.println("Teenagers: WHAT THE DAMN HELL?");
    }
  }
}




