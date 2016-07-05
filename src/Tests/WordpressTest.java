package Tests;

import Pages.LoginPage;
import Selenium.Driver;
import org.junit.After;
import org.junit.Before;

/**
 * Created by phucnguyen on 6/29/16.
 */
public class WordpressTest {
    @Before
    public void setup() {
        LoginPage.goTo();
        LoginPage.loginAs("admin", "phuc");
    }

    @After
    public void tearDown() {
        Driver.close();
    }
}
