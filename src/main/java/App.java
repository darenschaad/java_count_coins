import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {}

  public static String countCoins(Integer cents) {
    Integer quarters = 0;
    Integer dimes = 0;
    Integer nickels = 0;
    String changeOutput = "";
    while (cents >= 25) {
      cents -= 25;
      quarters++;
    }
    while (cents >= 10) {
      cents -= 10;
      dimes++;
    }
    while (cents >= 5) {
      cents -= 5;
      nickels++;
    }
    String quartersString = Integer.toString(quarters);
    String dimesString = Integer.toString(dimes);
    String nickelsString = Integer.toString(nickels);
    String penniesString = Integer.toString(cents);
    if (quarters > 0) {
      if (quarters == 1){
        changeOutput += quartersString + " Quarter ";
      }
      else {
        changeOutput += quartersString + " Quarters ";
      }
    }
    if (dimes > 0) {
      if (dimes == 1){
        changeOutput += dimesString + " Dime ";
      }
      else {
        changeOutput += dimesString + " Dimes ";
      }
    }
    if(nickels > 0) {
      changeOutput += nickelsString + " Nickel ";
    }
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
