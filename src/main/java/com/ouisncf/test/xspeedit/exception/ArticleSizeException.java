package com.ouisncf.test.xspeedit.exception;


public class ArticleSizeException extends Exception{ 
  public ArticleSizeException(int taille){
    System.out.println(taille+" ne respectant pas les tailles min/max , elle est enlevée de la chaine de tri.");
  }  
}