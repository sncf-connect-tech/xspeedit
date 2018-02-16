package com.ouisncf.test.xspeedit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ouisncf.test.xspeedit.exception.ArticleSizeException;
import com.ouisncf.test.xspeedit.exception.CartonSizeException;
import com.ouisncf.test.xspeedit.impl.Article;
import com.ouisncf.test.xspeedit.impl.Carton;
import com.ouisncf.test.xspeedit.impl.Robot;
import com.ouisncf.test.xspeedit.impl.UsineFactory;
import com.ouisncf.test.xspeedit.typecarton.GrandCarton;
import com.ouisncf.test.xspeedit.typecarton.MoyenCarton;
import com.ouisncf.test.xspeedit.typetri.FirstFitDecreasing;
import com.ouisncf.test.xspeedit.typeusine.UsineAncienne;
import com.ouisncf.test.xspeedit.typeusine.UsineRecente;
import com.ouisncf.test.xspeedit.util.TriUtil;

/**
 * Hello world!
 *
 */
public class App 
{
  
  private static Scanner sc;
  
    public static void main( String[] args ) throws ArticleSizeException, CartonSizeException
    {
     
      System.out.println("Taille des articles à trier séparé par des espaces :");
        sc = new Scanner(System.in);
        String chaineTaille = sc.nextLine();
        while(chaineTaille.length()<1 || !chaineTaille.matches(".*\\d+.*")){
          System.out.println("Veuillez saisir des chiffres :");
          sc = new Scanner(System.in);
          chaineTaille = sc.nextLine();
        }
        
    	//On creer 2 usines differentes
    	UsineFactory usineRecente = new UsineRecente();
    	UsineFactory usineAncienne = new UsineAncienne();
 
    	//Chaque usine creer un robot
    	Robot robotRecent = usineRecente.createRobot();
    	Robot robotAncien = usineAncienne.createRobot();
    	
   	
    	List<Article> listeArticle = new ArrayList<Article>();
    
    	
    	 listeArticle = TriUtil.createListeArticle(chaineTaille);
    	     	 
    	 List<Carton> totalCartonRecent = robotRecent.trier(listeArticle);
    	 List<Carton> totalCartonAncien = robotAncien.trier(listeArticle);
    	
    	System.out.println(robotRecent.toString());
    	System.out.println("Nombre total de cartons utlisés dans l'usine recente: "  + totalCartonRecent.size());
    	System.out.println(TriUtil.toString(totalCartonRecent));
    	
    	System.out.println(robotAncien.toString());
    	System.out.println("Nombre total de cartons utlisés dans l'usine ancienne: "  + totalCartonAncien.size());
    	System.out.println(TriUtil.toString(totalCartonAncien));
        
    	
    	
    }
}
