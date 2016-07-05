package Pages;

import Navigation.LeftNavigation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Selenium.Driver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phucnguyen on 6/28/16.
 */
public class ListPostsPage {
    private static int lastCount;
    public static int previousPostCount() {
        return lastCount;
    }
    public static int currentPostCount() {
        return getPostCount();
    }




    public static void goTo(PostType postType) {
        switch (postType) {
            case Page:
                LeftNavigation.Pages.AllPages.select();
                break;
            case Posts:
                LeftNavigation.Posts.AllPosts.select();break;
        }
    }

    public static void selectPost(String title) {
        WebElement postLink = Driver.Instance.findElement(By.linkText("Sample Page"));
        postLink.click();
    }

    public static void storeCount() {
        lastCount = getPostCount();
    }

    private static int getPostCount() {
        String countText = Driver.Instance.findElement(By.className("displaying-num")).getText();
        return Integer.parseInt(countText.split(" ")[0]);
    }

    public static boolean doesPostExistWithTitle(String title) {
        return !Driver.Instance.findElements(By.linkText(title)).isEmpty();
    }

    public static void trashPost(String title) {
        List<WebElement> rows = Driver.Instance.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            Driver.turnOffWait();
            List<WebElement> links = row.findElements(By.linkText(title));
            Driver.turnOnWait();
            if (links.size() > 0) {
                Actions action = new Actions(Driver.Instance);
                action.moveToElement(links.get(0));
                action.perform();
                row.findElement(By.className("submitdelete")).click();
                return;
            }
        }
    }

    public static void searchForPost(String searchString) {
        WebElement searchBox = Driver.Instance.findElement(By.id("post-search-input"));
        searchBox.sendKeys(searchString);

        WebElement searchButton = Driver.Instance.findElement(By.id("search-submit"));
        searchButton.click();

    }


    public enum PostType {
        Posts, Page
    }
}
