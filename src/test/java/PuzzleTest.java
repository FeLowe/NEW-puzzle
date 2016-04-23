import org.junit.*;
import static org.junit.Assert.*;
import org.fluentlenium.adapter.FluentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class PuzzleTest extends FluentTest{
    public WebDriver webDriver = new HtmlUnitDriver();

  @Override
 public WebDriver getDefaultDriver() {
   return webDriver;
 }

 @ClassRule
 public static ServerRule server = new ServerRule();

 @Test
 public void rootTest() {
   goTo("http://localhost:4567/");
    fill("#word-sentence").with("caterpillar");
    submit(".btn");
    assertThat(pageSource()).contains("c-t-rp-ll-r");
 }

  @Test
  public void puzzleMethod_TakesVowelAndRepacesItWithAdash_string(){
    Puzzle testPuzzle = new Puzzle();
    String expected = "-";
    assertEquals(expected, testPuzzle.puzzleMethod("a"));
  }
  @Test
  public void puzzleMethod_TakesWordAndReplacesTwoVowelsWithAdash_string(){
    Puzzle userSentence = new Puzzle();
    String expected = "c-rr-t";
    assertEquals(expected, userSentence.puzzleMethod("carrot"));
  }
  @Test
  public void puzzleMethod_TakesWordAndReplacesAllVowelsWithAdash_string(){
    Puzzle userSentence = new Puzzle();
    String expected = "--r--l-";
    assertEquals(expected, userSentence.puzzleMethod("aureola"));
  }
}
