package Pages; /**
 * Created by phucnguyen on 6/28/16.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Timer;
import java.util.function.Predicate;
import Selenium.Driver;

public class LoginPage {

    public static void goTo() {
        Driver.Instance.get(Driver.baseAddress + "wp-login");
        WebDriverWait wait = new WebDriverWait(Driver.Instance, 10);
        wait.until(ExpectedConditions.attributeToBe(By.id("user_login"), "id", "user_login"));
    }

    public static LoginCommand loginAs(String admin, String password) {
        return new LoginCommand(admin, password);
    }

    private static class LoginCommand {
        private String username;
        private String password;

        public LoginCommand(String username, String password) {
            this.username = username;
            this.password = password;
            login();
        }

        public void login() {
            WebElement loginInput = Driver.Instance.findElement(By.id("user_login"));
            loginInput.sendKeys(username);

            WebElement passwordInput = Driver.Instance.findElement(By.id("user_pass"));
            passwordInput.sendKeys(password);

            WebElement loginButton = Driver.Instance.findElement(By.id("wp-submit"));
            loginButton.click();

        }
    }
}
