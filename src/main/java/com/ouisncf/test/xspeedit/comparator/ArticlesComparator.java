package com.ouisncf.test.xspeedit.comparator;

import java.util.Comparator;

import com.ouisncf.test.xspeedit.impl.Article;

/**
 * Comprator d'Articles Permet de trier les articles dans le sens décroissant en
 * fonction de leur taille
 * 
 * @author crabiller
 *
 */
public class ArticlesComparator implements Comparator<Article> {

  /**
   * Méthode de comparaison
   */
  public int compare(Article articles1, Article articles2) {

    // object nullity check
    if (articles1 == null) {
      return (articles2 == null) ? 0 : 1;
    }
    if (articles2 == null) {
      return -1;
    }

    int taille1 = articles1.getTaille();
    int taille2 = articles2.getTaille();

    int res = Integer.compare(taille2, taille1);
    if (res != 0) {
      return res;
    } else {
      return -1;
    }

  }

}
