public class Zodiac
{
  private String name;
  private String startDate;
  private String endDate;

  public Zodiac(String name, String startDate, String endDate){
    this.name = name;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public String getName(){
    return name;
  }

  public String getInterval(){
    return startDate + " - " + endDate;
  }

  public String toString(){
    return name + " Starts on: " +
        startDate + " Ends on: " + endDate;
  }
}
