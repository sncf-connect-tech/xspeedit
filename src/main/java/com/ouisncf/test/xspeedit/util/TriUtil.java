package com.ouisncf.test.xspeedit.util;

import java.util.ArrayList;
import java.util.List;

import com.ouisncf.test.xspeedit.constant.Constant;
import com.ouisncf.test.xspeedit.exception.ArticleSizeException;
import com.ouisncf.test.xspeedit.impl.Article;
import com.ouisncf.test.xspeedit.impl.Carton;

/**
 * Classe utilitaire de l'application tri
 *
 * @author crabiller
 */
public class TriUtil {


	
/**
 * Permet de creer la liste d'articles a partir d'un tableau d'entier
 * 
 * @param chaineTaille
 * @return la liste des articles

 */
	public static List<Article> createListeArticle(String chaineTaille) {
		
	  String[] tabTailleArticles = chaineTaille.split(" ");
	  
	  
		 List<Article> listeArticle = new ArrayList<Article>();
    
		 for(int i = 0; i < tabTailleArticles.length; i++) {
   
		   if(notEmpty(tabTailleArticles[i])){
    	 try{
		     if(Integer.parseInt(tabTailleArticles[i]) >= Constant.TAILLE_MINI_ARTICLE && Integer.parseInt(tabTailleArticles[i]) <= Constant.TAILLE_MAXI_ARTICLE ){
    			
		       listeArticle.add( new Article(Integer.parseInt(tabTailleArticles[i])));
    		   
		     }else{ 	  
		       try {
            throw new ArticleSizeException(Integer.parseInt(tabTailleArticles[i]));
          } catch (ArticleSizeException e) {
          //on affiche pas volontairement l'execption
          }
		     }
    	}catch (NumberFormatException e){
    	  System.out.println("La taille d'un articles doit etre un nombre, tout les autres caracteres sont ignorés");
    	}
		   }
   }		
		 
		return listeArticle;
		
	}
	
	/**
	 * 
  * Méthode peremttant de retourner l'index du meilleur carton 
  * pouvant accueillir l'article. 
  * Par meilleur est sous-entendu le carton dans lequel l'article laissera le moins de place libre possible
	 * 
	 * @param listeCarton
	 * @param article
	 * @return l'index du meilleur carton
	 */
	public static int getBestEligibleCarton( List<Carton> listeCarton, Article article){
		 
		int indexCarton = -1;
		
		//On prends le premier en reference
		Carton cartonReference = listeCarton.get(0);
		
		for(int iterator =0; iterator < listeCarton.size() ; iterator++){	

			
			  if(listeCarton.get(iterator).getPlaceLibre() - article.getTaille() >=0){
			  
			  if(article.getTaille() - listeCarton.get(iterator).getPlaceLibre() <= article.getTaille()- cartonReference.getPlaceLibre()  )  {
			    
 			  cartonReference = listeCarton.get(iterator);
 			  
 			  indexCarton = iterator;
			  }
		}
			  
			 
			
			}
		
		
		
		return indexCarton;
	}
	/**
	 * 
	 * Méthode peremttant de retourner l'index du premier carton 
	 * pouvant accueillir l'article
	 * 
	 * 
	 * @param listeCarton
	 * @param article
	 * @return l'index du premier carton eligible
	 */
	public static int getFirstEligibleCarton( List<Carton> listeCarton, Article article){
		
		int indexCarton = -1;
	
		for(int iterator =0; iterator < listeCarton.size() ; iterator++){	
		
		  if(listeCarton.get(iterator).getPlaceLibre() - article.getTaille() >=0){
				
		    return iterator;
			
		  }
		
		}
		
		return indexCarton;
	}

	/**
	 * Permet de verifier la nullité d'un objet
	 * 
	 * @param obj
	 * @return true si non vide, false sinon
	 */
	public static boolean notEmpty(Object obj){
		
	  if(obj != null ){
			
	    return true;
		
	  }else{
			
	    return false;
	
	  }
	}
	
	
	
/**
 * Methode toString	
 * @param totalCartonRecent
 * @return La liste formatter pour l'affichage
 */
  public static String toString(List<Carton> totalCartonRecent) {

    String toString = "";
    if (notEmpty(totalCartonRecent)) {
      for (Carton carton : totalCartonRecent) {
        toString += carton.toString()+Constant.SEPARATION_CHAR;
      }
      return toString;
    }else{

    return "0"+Constant.SEPARATION_CHAR;
    }
  }
}
