public class Puzzle{

  public String puzzleMethod(String sentence) {
    
    String newSentence = sentence.replaceAll("[aeiouAEIOU]","-");

    return newSentence;
  }
}
