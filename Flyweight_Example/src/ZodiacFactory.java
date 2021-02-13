import java.util.HashMap;
import java.util.Map;

public class ZodiacFactory
{
  private static Map<String, Zodiac> zodiacs = new HashMap<>();

  public static Zodiac getZodiac(String name)
  {
    Zodiac zodiac = zodiacs.get(name.toLowerCase());
    if (zodiac == null)
    {
      synchronized (zodiacs)
      {
        zodiac = zodiacs.get(name.toLowerCase());
        if (zodiac == null)
        {
         switch(name.toLowerCase())
         {
           case "aries":{
             zodiac = new Zodiac(name, "21st March", "19th April");
             break;
           }
           case "taurus":{
             zodiac = new Zodiac(name, "20th April", "20th May");
             break;
           }
           case "gemini":{
             zodiac = new Zodiac(name, "21st May", "20th June");
             break;
           }
           case "cancer":{
             zodiac = new Zodiac(name, "21st June", "22nd July");
             break;
           }
           case "leo":{
             zodiac = new Zodiac(name, "23rd July", "22nd August");
             break;
           }
           case "virgo":{
             zodiac = new Zodiac(name, "23rd August", "22nd September");
             break;
           }
           case "libra":{
             zodiac = new Zodiac(name, "23rd September", "22nd October");
             break;
           }
           case "scorpio":{
             zodiac = new Zodiac(name, "23rd October", "21st November");
             break;
           }
           case "sagittarius":{
             zodiac = new Zodiac(name, "22nd November", "21st December");
             break;
           }
           case "capricorn":{
             zodiac = new Zodiac(name, "22nd December", "19th January");
             break;
           }
           case "aquarius":{
             zodiac = new Zodiac(name, "20th January", "18th February");
             break;
           }
           case "pisces":{
             zodiac = new Zodiac(name, "19th February", "20th March");
             break;
           }
           default:{
             throw new IllegalArgumentException("The specified zodiac does not exist.");
           }
         }
        }
      }
      zodiacs.put(name.toLowerCase(), zodiac);
    }
    return zodiac;
  }
}
