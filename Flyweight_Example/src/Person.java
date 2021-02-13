public class Person
{
  private String name;
  private Zodiac zodiac;

  public Person(String name, String zodiacName){
    this.name = name;
    zodiac = ZodiacFactory.getZodiac(zodiacName);
  }

  public String getName(){
    return name;
  }

  public Zodiac getZodiac(){
    return zodiac;
  }

  public String toString() {
    return "Name: " + name +
        " Zodiac: " + zodiac;
  }
}



