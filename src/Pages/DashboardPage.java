package Pages;

import Selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by phucnguyen on 6/28/16.
 */
public class DashboardPage {

    public static boolean isAt() {
        List<WebElement> h1s = Driver.Instance.findElements(By.tagName("h1"));

        return h1s.size() > 0 && h1s.get(0).getText().equals("Dashboard");
    }
}
