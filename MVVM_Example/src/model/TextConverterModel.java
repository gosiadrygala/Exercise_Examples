package model;

public class TextConverterModel implements TextConverter
{
  public TextConverterModel(){

  }
  @Override public String toUpperCase(String text)
  {
    return text.toUpperCase();
  }
}
