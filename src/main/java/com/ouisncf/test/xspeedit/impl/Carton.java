package com.ouisncf.test.xspeedit.impl;

import java.util.ArrayList;
import java.util.List;

import com.ouisncf.test.xspeedit.constant.Constant;
import com.ouisncf.test.xspeedit.util.TriUtil;

/**
 * Classe abstraite représentant un carton d'emballage
 * 
 * 
 * 
 * @author crabiller
 *
 */
public abstract class Carton implements Cloneable {

  // Taille par defaut des cartons
  protected int taille = Constant.TAILLE_CARTON_DEFAUT;

  // Liste d'article que contient le carton
  protected List<Article> contenu = new ArrayList<Article>();

  // Place restante dans le carton
  protected int placeLibre = Constant.TAILLE_CARTON_DEFAUT;

  /**
   * Constructeur par défaut
   */
  public Carton() {
  }

  /**
   * Constructeur avec paramètres
   * 
   * @param taille
   *          du carton
   * @param contenu
   *          du carton
   */
  public Carton(int taille, List<Article> contenu) {
    this.contenu = contenu;
    this.taille = taille;
    this.placeLibre = taille;
  }

  /**
   * Retourne la liste des articles present dans le carton
   * 
   * @return La liste des articles
   */
  public List<Article> getContenu() {
    return contenu;
  }

  /**
   * Retourne la place libre dans le carton
   * 
   * @return placeLibre
   */

  public int getPlaceLibre() {
    return placeLibre;
  }

  /**
   * Permet d'ajouter un article dans le carton
   * 
   * @param contenu
   */
  public void addArticle(Article contenu) {
    this.contenu.add(contenu);
    placeLibre = placeLibre - contenu.getTaille();
  }

  /**
   * Recupere la taille du carton
   * 
   * @return taille du carton
   */
  public int getTaille() {
    return taille;
  }

  /**
   * Methode permettant de supprime le contenu d'un carton
   */
   public  void clearContenu(){
   this.contenu.clear();
  }
  

  
  /**
   * Methode toString
   */
  public String toString(){
    String toString = "" ;
    if(TriUtil.notEmpty(contenu)){
      for(Article article : contenu){
        toString += article.getTaille();
      }
      return toString;
    }else{
      return "0"+Constant.SEPARATION_CHAR;
    }
   
  }
  
}