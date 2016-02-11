import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {}

  public static String countCoins(Integer cents) {
    Integer quarters = 0;
    String changeOutput = "";
    while (cents >= 25) {
      cents -= 25;
      quarters++;
    }
    String quartersString = Integer.toString(quarters);
    String penniesString = Integer.toString(cents);
    if (quarters > 0) {
      if (quarters == 1){
        changeOutput += quartersString + " Quarter";
      }
      else {
        changeOutput += quartersString + " Quarters";
      }
    }
    if (cents > 0) {
      changeOutput += penniesString + " Pennies";
    }
    return changeOutput;
  }
}
