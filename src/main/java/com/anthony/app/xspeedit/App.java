package com.anthony.app.xspeedit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.anthony.app.xspeedit.Util.ControlUtils;
import com.anthony.app.xspeedit.exception.InvalidEntryException;
import com.anthony.app.xspeedit.model.Item;

/**
 * Hello world!
 *
 */
public class App 
{
	 private static Scanner sc;
	
    public static void main( String[] args )
    {
    	
//    	System.out.println("Veuillez saisir la liste des articles à embaler:");
//        sc = new Scanner(System.in);
//        String chaineTaille = sc.nextLine();
//        while(chaineTaille.length()<1 || !chaineTaille.matches(".*\\d+.*")){
//          System.out.println("Veuillez saisir   :");
//          sc = new Scanner(System.in);
//          chaineTaille = sc.nextLine();
//        }
//        
//        System.out.println( chaineTaille );
        
        Scanner scan = new Scanner(System.in);
        
        List<Item> items = new ArrayList<Item>();
        
        System.out.println("######## XPEEDIT ########");
        System.out.println("######## CREATION DES OBJETS ########");
        System.out.println("Veuillez saisir la taille chaque objet, entre 0 et 9. (Appuyez sur entré pour arrêter la saisie) : ");
        
        while (scan.hasNextLine()){
        	
            String itemSize = scan.nextLine();

            if (ControlUtils.isStopping(itemSize)) {
            	  System.exit(0);
                  scan.close();
                  for(Item item : items) {
                  	System.out.println(item.getSize());
                  }
            }
                 
            try {
            	 ControlUtils.isValidEntry(itemSize);
            	 items.add(new Item(Integer.parseInt(itemSize)));
			} catch (InvalidEntryException e) {
				System.out.println(e.getMessage());
			}                     
        }
        
        
           
    }
    
   
    
    
}
