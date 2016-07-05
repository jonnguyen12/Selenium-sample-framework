package PostsTests;

import Pages.ListPostsPage;
import Pages.NewPostPage;
import Tests.WordpressTest;
import Workflow.PostCreator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by phucnguyen on 7/1/16.
 */
public class AllPostsTests extends WordpressTest {
    //Added posts show up in all posts
    // can trash a post
    // can search posts

    @Test
    public void Added_Posts_Show_Up() throws InterruptedException {
        // go to posts, get post count, store
        ListPostsPage.goTo(ListPostsPage.PostType.Posts);
        ListPostsPage.storeCount();

        // add a new post
        PostCreator.createPost();

        // go to posts, get a new post count
        ListPostsPage.goTo(ListPostsPage.PostType.Posts);
        assertEquals("Count of posts did not increase",ListPostsPage.previousPostCount() + 1, ListPostsPage.currentPostCount());

        // check for added post
        assertTrue(ListPostsPage.doesPostExistWithTitle(PostCreator.previousTitle()));

        // trash post (clean up)
        ListPostsPage.trashPost(PostCreator.previousTitle());
        assertEquals("Could not trash post",ListPostsPage.previousPostCount(), ListPostsPage.currentPostCount());
    }

    @Test
    public void can_search_posts() throws InterruptedException {
        // create a new post
        PostCreator.createPost();

        // go to list posts
        ListPostsPage.goTo(ListPostsPage.PostType.Posts);

        // search for post
        ListPostsPage.searchForPost(PostCreator.previousTitle);

        // check for post shows up in results
        assertTrue(ListPostsPage.doesPostExistWithTitle(PostCreator.previousTitle));

        // cleanup (trash post)
        ListPostsPage.trashPost(PostCreator.previousTitle);

    }
}
