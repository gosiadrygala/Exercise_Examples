public class BattlefieldTest
{
  public static void main(String[] args) {
    Wizard wizard = new Wizard();
    Fighter knightFighter = new Knight();
    Fighter wizardFighter = new WizardAdapter(wizard);

    //Knight
    knightFighter.attackYourEnemies();
    knightFighter.defendYourself();
    knightFighter.runAway();

    //Wizard
    wizardFighter.defendYourself();
    wizardFighter.attackYourEnemies();
    wizardFighter.runAway();
  }
}

