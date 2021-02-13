package SeaBear;

public class ZooTest
{
  public static void main(String[] args) {
    SeaBear seaBear = new SeaBear();
    VisitSeaBear seaBearGuard = new SeaBearGuard(seaBear);

    //children
    System.out.println("Children: ");
    seaBearGuard.feed("Children");
    seaBearGuard.pet("Children");
    seaBearGuard.view("Children");

    //zookeeper
    System.out.println("Zookeeper: ");
    seaBearGuard.feed("Zookeeper");
    seaBearGuard.pet("Zookeeper");
    seaBearGuard.view("Zookeeper");

    //adult
    System.out.println("Adult: ");
    seaBearGuard.feed("Adult");
    seaBearGuard.pet("Adult");
    seaBearGuard.view("Adult");
  }
}
