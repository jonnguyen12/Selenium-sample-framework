package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Selenium.Driver;


/**
 * Created by phucnguyen on 6/28/16.
 */
public class PostPage {
    public static String title;

    static {
        title = title();
    }

    public static String title() {
        WebElement title = Driver.Instance.findElement(By.className("entry-title"));
        if (title != null) {
            return title.getText();
        }
        return "";
    }

}
