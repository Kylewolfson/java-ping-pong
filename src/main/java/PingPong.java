import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class PingPong {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/input.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/output", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/output.vtl");

      String numberString = request.queryParams("number");
      Integer number = Integer.parseInt(numberString);
      PingPong newPingPong = new PingPong();
      ArrayList result = PingPong.pingPong(number);

      model.put("result", result);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
  public static ArrayList pingPong(Integer number) {
    ArrayList<Object> responseArray = new ArrayList<Object>();
    for (Integer index = 1; index <= number; index++) {
      if (index % 15 == 0 ) {
        responseArray.add("PingPong");
      } else if (index % 3 == 0 ) {
        responseArray.add("Ping");
      } else if (index % 5 == 0) {
        responseArray.add("Pong");
      } else {
        responseArray.add(index);
      }
    }
    return responseArray;
  }
}
