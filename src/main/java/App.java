import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";
    get("/", (request, response) ->{
      HashMap model = new HashMap();
      model.put("template", "templates/enterCoins.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/result", (request, response) ->{
      HashMap model = new HashMap();
      String centsString = request.queryParams("cents");
      Integer cents = Integer.parseInt(centsString);
      String result = countCoins(cents);
      model.put("change", result);
      model.put("template", "templates/result.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static String countCoins(Integer cents) {
    Integer quarters = 0;
    Integer dimes = 0;
    Integer nickels = 0;
    Integer quarterLimit = 2;
    Integer dimeLimit = 1;
    Integer nickelLimit = 1;
    String changeOutput = "";
    while (cents >= 25) {
      if(quarters == quarterLimit) {
        break;
      }
      cents -= 25;
      quarters++;
    }
    String quartersString = Integer.toString(quarters);
    if (quarters > 0) {
      if (quarters == 1){
        changeOutput += quartersString + " Quarter";
      }
      else {
        changeOutput += quartersString + " Quarters";
      }
      if((cents%10 == 0 || cents <= 5) && cents != 0) {
        changeOutput += " and ";
      } else if (cents > 0) {
        changeOutput += ", ";
      }
    }
    while (cents >= 10) {
      if(dimes == dimeLimit) {
        break;
      }
      cents -= 10;
      dimes++;
    }
    String dimesString = Integer.toString(dimes);
    if (dimes > 0) {
      if (dimes == 1){
        changeOutput += dimesString + " Dime";
      }
      else {
        changeOutput += dimesString + " Dimes";
      }
      if((cents%5 == 0 || cents <= 4) && cents != 0) {
        changeOutput += " and ";
      } else if (cents > 0) {
        changeOutput += ", ";
      }
    }
    while (cents >= 5) {
      if(nickels == nickelLimit) {
        break;
      }
      cents -= 5;
      nickels++;
    }
    String nickelsString = Integer.toString(nickels);
    if(nickels > 0) {
      changeOutput += nickelsString + " Nickel";
      if(cents > 0) {
        changeOutput += " and ";
      }
    }
    String penniesString = Integer.toString(cents);


    if (cents > 0) {
      if (cents == 1){
        changeOutput += penniesString + " Penny";
      }
      else {
        changeOutput += penniesString + " Pennies";
      }
    }
    changeOutput = changeOutput.trim();
    return changeOutput;
  }
}
