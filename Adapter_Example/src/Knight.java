public class Knight implements Fighter
{
  @Override public void attackYourEnemies() {
    System.out.println("Knight is attacking the enemies!");
  }

  @Override public void runAway() {
    System.out.println("Run knight run...");
  }

  @Override public void defendYourself() {
    System.out.println("Knight is trying to defend");
  }
}
