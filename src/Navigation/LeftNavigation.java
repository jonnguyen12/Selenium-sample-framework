package Navigation;

import java.awt.*;

/**
 * Created by phucnguyen on 6/29/16.
 */
public class LeftNavigation {
    public static class Posts{
        public static class addNew {
            public static  void select() {
                MenuSelector.select("menu-posts", "Add New");
            }
        }


        public static class AllPosts {
            public static void select() {
                MenuSelector.select("menu-posts", "All Posts");
            }
        }
    }

    public static class Pages {
        public static class AllPages {
            public static void select() {
                MenuSelector.select("menu-pages", "All Pages");
            }
        }
    }
}
