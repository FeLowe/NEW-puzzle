import java.util.HashMap;
public class Puzzle{

  public String puzzleMethod(String sentence) {
    String newSentece = sentence.replaceAll("[aeiou]","-");

    return newSentece;
  }
}
