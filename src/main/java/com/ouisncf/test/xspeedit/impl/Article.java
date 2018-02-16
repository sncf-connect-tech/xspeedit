package com.ouisncf.test.xspeedit.impl;

/**
 * @author crabiller Classe représentant un article à emballer
 */

public class Article {

  // Taille par defaut des cartons
  protected int taille;

  /**
   * Constructeur de la classe Article
   * 
   * @param taille
   *          - Taille de l'article
   */
  public Article(int taille) {
    this.taille = taille;
  }

  /**
   * Récupere la taille de l'article
   * 
   * @return taille de l'article
   */
  public int getTaille() {
    return taille;
  }

  /**
   * Permet de modifier la taille de l'article
   * 
   * @param taille
   *          de l'article
   */
  public void setTaille(int taille) {
    this.taille = taille;
  }

  /**
   * Affiche la taille de l'article
   */
  public String toString() {
    return "Taille de l'article : " + this.getTaille();
  }
}