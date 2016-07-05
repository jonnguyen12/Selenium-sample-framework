package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Navigation.*;
import Selenium.Driver;

/**
 * Created by phucnguyen on 6/28/16.
 */
public class NewPostPage {

    public static String title;

    static {
        WebElement pageTitle = Driver.Instance.findElement(By.id("title"));
        if (pageTitle != null) {
            title =  pageTitle.getAttribute("value");
        }
        title = "";
    }

    public static void goTo() {
        LeftNavigation.Posts.addNew.select();

        WebElement addNew = Driver.Instance.findElement(By.linkText("Add New"));
        addNew.click();

    }

    public static CreatePostCommand createPost(String title) {
        return new CreatePostCommand(title);
    }

    public static void goToNewPost() {
        WebElement message = Driver.Instance.findElement(By.id("message"));
        WebElement newPostLink = message.findElements(By.tagName("a")).get(0);
        newPostLink.click();
    }

    public static boolean isInEditMode() {
        return Driver.Instance.findElement(By.id("icon-edit-pages")) != null;
    }


    public static class CreatePostCommand {
        private String title;
        private String body;

        public CreatePostCommand(String title) {
            this.title = title;
        }

        public CreatePostCommand withBody(String body) {
            this.body = body;
            return this;
        }

        public void publish() throws InterruptedException {
            Driver.Instance.findElement(By.id("title")).sendKeys(title);
            Driver.Instance.switchTo().frame("content_ifr");
            Driver.Instance.switchTo().activeElement().sendKeys("body");
            Driver.Instance.switchTo().defaultContent();

            Thread.sleep(1000);

            Driver.Instance.findElement(By.id("publish")).click();
        }
    }

}
