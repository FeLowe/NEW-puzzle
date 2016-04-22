public class Puzzle{

  public String puzzleMethod(String sentence) {
     String newSentence = new String ();
     if (sentence.equals("cat")){
       newSentence = sentence;
     } else if (sentence == "cat"){
       newSentence = sentence.replaceAll("a", "-");
     }
     return newSentence;
   }
 }
