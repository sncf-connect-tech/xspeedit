package com.test;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class XspeedltTest {
    private static final int MAX_CAPACITY = 10;
    private static final String DEFAULT_SEPARATOR = "/";

    private static String optimize(final Collection<Integer> articleList, int count, String result) {
        Integer article;
        int articleMax;

        final Iterator<Integer> articleIterator = articleList.iterator();
        while (articleIterator.hasNext()) {
            article = articleIterator.next();
            if ((count + article) <= MAX_CAPACITY) {
                count += article;
                result += "" + article;
            } else if (article <= MAX_CAPACITY) {
                count = article;
                result += DEFAULT_SEPARATOR + article;

                articleMax = 0;
                final Collection<Integer> truncatedArticleList = new LinkedList<>();
                while (articleIterator.hasNext()) {
                    article = articleIterator.next();
                    if ((count + article) <= MAX_CAPACITY) {
                        if (article > articleMax) {
                            articleMax = article;
                        }
                    }
                    truncatedArticleList.add(article);
                }

                final Collection<Integer> newTruncatedArticleList = new LinkedList<>();
                for (final Integer truncatedArticle : truncatedArticleList) {
                    if (((count + truncatedArticle) <= MAX_CAPACITY) && (articleMax == 0 || truncatedArticle == articleMax)) {
                        count += truncatedArticle;
                        result += "" + truncatedArticle;
                        articleMax = 0;
                    } else {
                        newTruncatedArticleList.add(truncatedArticle);
                    }
                }

                result = optimize(newTruncatedArticleList, count, result);
            } else {
                count = 0;
                result += DEFAULT_SEPARATOR;
            }
        }

        return result;
    }

    public static void main(final String[] args) {
        final int[] articles = {1, 6, 3, 8, 4, 1, 6, 8, 9, 5, 2, 5, 7, 7, 3};

        final Collection<Integer> articleList = new LinkedList<>();
        for (final int article : articles) {
            articleList.add(article);
        }

        final String result = optimize(articleList, 0, "");
        final String[] nbCartons = result.split("/");

        // Expected result: 163/82/46/19/8/55/73/7
        System.out.println("Robot optimisé: '" + result + "' -> " + nbCartons.length + " cartons utilisés");
    }
}
