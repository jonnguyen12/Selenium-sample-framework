package Tests;

import Pages.DashboardPage;
import Pages.ListPostsPage;
import Pages.NewPostPage;
import Pages.PostPage;
import Selenium.Driver;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WordpressTests {

    public static class LoginTests extends WordpressTest {

        @Test
        public void Admin_User_Can_Login() {
            assertTrue(DashboardPage.isAt());

        }

        @After
        public void tearDown() {
            Driver.close();
        }
    }

    public static class CreatePostTest extends WordpressTest {


        @Test
        public void can_create_a_basic_post() throws InterruptedException {
            NewPostPage.goTo();
            NewPostPage.createPost("This is the test post title")
                    .withBody("Hi, this is the body")
                    .publish();
            NewPostPage.goToNewPost();
            assertEquals("Title did not match", "This is the test post title", PostPage.title);

        }

    }

    public static class PageTest extends WordpressTest {
        @Test
        public void can_edit_a_page () {
            ListPostsPage.goTo(ListPostsPage.PostType.Page);
            ListPostsPage.selectPost("Sample Page");

            assertTrue("Wasn't in edit mode", NewPostPage.isInEditMode());
            assertEquals("Title did not match", "Sample Page", NewPostPage.title);
        }


    }

}
