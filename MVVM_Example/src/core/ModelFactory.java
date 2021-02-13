package core;

import model.*;

public class ModelFactory
{
  private TextConverter textConverter;

  public TextConverter getTextConverter() {
    if(textConverter == null) {
      textConverter = new TextConverterModel();
    }
    return textConverter;
  }

}
