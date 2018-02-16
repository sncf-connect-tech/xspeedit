package com.ouisncf.test.xspeedit.exception;

import com.ouisncf.test.xspeedit.impl.Article;

public class CartonSizeException extends Exception{ 
  public CartonSizeException(Article article){
    System.out.println("Les cartons utlisés par le robot ne sont pas assez grand pour cet article : "+ article.getTaille() + ". L'article est enlevé de la chaine de trie");
  }  
}