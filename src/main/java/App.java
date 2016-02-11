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
    String quartersString = Integer.toString(quarters);
    if (quarters > 0) {
      if (quarters == 1){
        changeOutput += quartersString + " Quarter";
      }
      else {
        changeOutput += quartersString + " Quarters";
      }
      if((cents%5 == 0 || cents <= 4) && cents != 0) {
        changeOutput += " and ";
      } else if (cents > 0) {
        changeOutput += ", ";
      }
    }
    while (cents >= 10) {
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
