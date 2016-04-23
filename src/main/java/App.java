import java.util.Map;
import spark.ModelAndView;
import java.util.HashMap;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/output", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/output.vtl");

      Puzzle myPuzzle = new Puzzle();

      String userInput = request.queryParams("word-sentence");
      String myResults = myPuzzle.puzzleMethod(userInput);

      model.put("result", myResults);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
