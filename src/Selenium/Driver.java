package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;

import java.util.concurrent.TimeUnit;

/**
 * Created by phucnguyen on 6/28/16.
 */
public class Driver {
    public static WebDriver Instance;
    public static String baseAddress = "http://localhost:8080/wordpress/";

    static {
        Instance = new ChromeDriver();
        turnOnWait();
    }

    public static void close() {
        Instance.close();
    }


    public static void turnOnWait() {
        Instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    public static void turnOffWait() {
        Instance.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

    }
}
