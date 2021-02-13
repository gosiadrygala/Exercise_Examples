package SeaBear;

public class SeaBearGuard implements VisitSeaBear
{
  private SeaBear seaBear;

  public SeaBearGuard(SeaBear seaBear){
    this.seaBear = seaBear;
  }

  @Override public void view(String personType)
  {
    seaBear.view(personType);
  }

  @Override public void feed(String personType) {
    if(personType.toLowerCase().equals("zookeeper")){
      seaBear.feed(personType);
    }
    else{
      System.out.println(personType + " is/ are not allowed to feed the sea bear.");
    }
  }

  @Override public void pet(String personType) {
    if(personType.toLowerCase().equals("child") || personType.toLowerCase().equals("children") ){
      seaBear.pet(personType);
    }
    else{
      System.out.println(personType + " is/ are not allowed to pet the sea bear.");
    }
  }
}


