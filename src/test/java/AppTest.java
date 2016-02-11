import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  // @Test
  // public void rootTest() {
  //     goTo("http://localhost:4567/");
  //     assertThat(pageSource()).contains("");
  // }

  @Test
  public void countCoins_countPennies_returnNumberOfPennies() {
    App testApp = new App();
    assertEquals("2 Pennies", testApp.countCoins(2));
  }
  @Test
  public void countCoins_countQuarters_returnNumberOfQuarters() {
    App testApp = new App();
    assertEquals("2 Quarters", testApp.countCoins(50));
  }
  @Test
  public void countCoins_countDimes_returnNumberOfDimes() {
    App testApp = new App();
    assertEquals("2 Dimes", testApp.countCoins(20));
  }
  @Test
  public void countCoins_countNickels_returnNumberOfNickels() {
    App testApp = new App();
    assertEquals("1 Nickel", testApp.countCoins(5));
  }
  @Test
  public void countCoins_countMultipleCoinTypes_returnNumberOfCoins() {
    App testApp = new App();
    assertEquals("1 Quarter 1 Dime 1 Nickel 1 Penny", testApp.countCoins(41));
  }
}
