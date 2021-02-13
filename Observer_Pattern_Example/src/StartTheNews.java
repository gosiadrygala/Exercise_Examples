public class StartTheNews
{
  public static void main(String[] args)
  {
    CoronaNews coronaNews = new CoronaNews();
    Parents parents = new Parents(coronaNews);
    Teenagers teenagers = new Teenagers(coronaNews);
    coronaNews.startTheNews();
  }
}

