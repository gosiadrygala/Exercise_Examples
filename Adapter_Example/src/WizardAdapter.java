public class WizardAdapter implements Fighter{

  private Wizard wizard;

  public WizardAdapter(Wizard wizard){
    this.wizard = wizard;
  }

  @Override public void attackYourEnemies(){
    wizard.castAMagicSpell();
  }

  @Override public void runAway() {
    wizard.portalAway();
  }

  @Override public void defendYourself(){
    wizard.putUpAShield();
  }
}

