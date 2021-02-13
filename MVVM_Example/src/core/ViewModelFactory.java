package core;

import core.ModelFactory;
import view.UppercaseViewModel;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private UppercaseViewModel uppercaseVM;

  public ViewModelFactory(ModelFactory modelFactory){
    this.modelFactory = modelFactory;
  }

  public UppercaseViewModel getUppercaseVM()
  {
    if (uppercaseVM == null) {
      uppercaseVM = new UppercaseViewModel(modelFactory.getTextConverter());
    }
    return uppercaseVM;
  }
}


