import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SampleSelenideTest {

  @BeforeMethod
  public void setUp() {
    Configuration.browser = "Chrome";
  }

  @Test
  public void loginTest() {
    open("https://jira.hillel.it/secure/Dashboard.jspa");
    $(By.id("login-form-username")).setValue("webinar5");
    $(By.id("login-form-password")).setValue("webinar5");
    $("#login").click();
    $(By.xpath("//*[contains(text(), 'Activity Stream')]")).shouldBe(Condition.visible);
  }

  @AfterMethod
  public void tearDown(){
    Selenide.closeWindow();
  }
}
