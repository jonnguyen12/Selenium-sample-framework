package Navigation;

import org.openqa.selenium.By;
import Selenium.Driver;

/**
 * Created by phucnguyen on 6/29/16.
 */
public class MenuSelector {
    public static void select(String topLevelName, String subMenuLinkText) {
        Driver.Instance.findElement(By.id(topLevelName)).click();
        Driver.Instance.findElement(By.linkText(subMenuLinkText)).click();
    }
}
