import java.beans.PropertyChangeEvent;

public class Parents
{
  public Parents(PropertyChangeSubject propertyChangeSubject){
    propertyChangeSubject.addListener(this::newsReaction);
  }

  public void newsReaction(PropertyChangeEvent evt)
  {
    String news = (String) evt.getNewValue();

    if(news.equals("Working from home is obligatory")){
     System.out.println("Wooooho");
    }
    else if(news.equals("Schools will close")){
      System.out.println("Parents: Oh no, oh no, o no no no no");
    }
    else if(news.equals("Bars will close")){
      System.out.println("Parents: I am too old for that anyways");
    }
  }
}
