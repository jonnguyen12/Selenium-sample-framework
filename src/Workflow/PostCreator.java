package Workflow;

import Pages.NewPostPage;

import java.util.Random;

/**
 * Created by phucnguyen on 7/1/16.
 */
public class PostCreator {
    public static String previousTitle, previousBody;


    public static void createPost() throws InterruptedException {
        NewPostPage.goTo();
        previousTitle = createTitle();
        previousBody = createBody();
        NewPostPage.createPost(previousTitle).withBody(previousBody).publish();

    }

    private static String createTitle() {
        return createRandomString() + ", title";
    }

    public static String previousTitle() {
        previousTitle = createTitle();
        return previousTitle;
    }

    public static String previousBody() {
        previousBody = createBody();
        return previousBody;
    }

    public static String createBody() {
        return createRandomString() + ", body";
    }

    public static String createRandomString() {
        StringBuilder s = new StringBuilder();
        Random random = new Random();
        int cycles = random.nextInt(5 + 1);

        for (int i = 0; i < cycles; i++) {
            s.append(words[random.nextInt(words.length)]);
            s.append(" ");
            s.append(articles[random.nextInt(articles.length)]);
            s.append(" ");
            s.append(words[random.nextInt(words.length)]);
            s.append(" ");
        }

        return s.toString();
    }


    private static String[] words = new String []{
        "boy", "cat", "dog", "rabbit", "baseball", "throw", "find", "scary", "mustard"
    };

    private static String[] articles = new String[]{
        "the", "an", "and", "a", "of", "to", "it","as"
    };




}
