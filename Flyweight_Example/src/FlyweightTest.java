public class FlyweightTest
{
  public static void main(String[] args){

    Person person1 = new Person("Georgie", "Virgo");
    Person person2 = new Person("Jackie", "Virgo");
    System.out.println(person1.getZodiac() == person2.getZodiac());
    System.out.println(person1 + "\n" + person2);
  }
}

