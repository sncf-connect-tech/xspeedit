package com.anthony.app.xspeedit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.anthony.app.xspeedit.Util.ControlUtils;
import com.anthony.app.xspeedit.exception.InvalidEntryException;
import com.anthony.app.xspeedit.model.Box;
import com.anthony.app.xspeedit.model.Item;
import com.anthony.app.xspeedit.model.NewRobot;
import com.anthony.app.xspeedit.model.OldRobot;
import com.anthony.app.xspeedit.model.Robot;

/**
 * Hello world!
 *
 */
public class App 
{	
    public static void main( String[] args ){
        Scanner scan = new Scanner(System.in); 
        List<Item> items = new ArrayList<Item>();
        
        System.out.println("######## XPEEDIT ########");
        System.out.println("######## CREATION DES OBJETS ########");
        System.out.println("Veuillez saisir la taille chaque objet, entre 0 et 9. (Appuyez sur entré pour arrêter la saisie) : ");
         
        OldRobot robot1 = new OldRobot("R2D2");
        NewRobot robot2 = new NewRobot("C3P8");
        
        boolean stopped = false;
        
        while (!stopped){	
            String itemSize = scan.nextLine();
            if (ControlUtils.isStopping(itemSize)) { 
                  scan.close();
                  stopped = true;
            }else {  
	            try {
	            	 ControlUtils.isValidEntry(itemSize);
	            	 items.add(new Item(Integer.parseInt(itemSize)));
	                 System.out.println("######## Objet de taille : " + itemSize + " fabriqué ########");
				} catch (InvalidEntryException e) {
					System.out.println(e.getMessage());
				}   
            }
        }
        
       System.out.println("######## SAISIE STOPPEE ########");
       System.out.println("######## DEBUT DE L'EMPAQUETAGE ########");
       System.out.println("........ Démarrage du " + robot1.toString() + "............." );
       System.out.println("........ Lancement du TRI " + robot1.toString() + "............." );
       robot1.fillBox(items);
       System.out.println();
       System.out.println("######## FIN DU TRI ########");
       System.out.println();
       System.out.println("######## DEBUT DE L'EMPAQUETAGE ########");
       System.out.println("........ Démarrage du " + robot2.toString() + "............." );
       System.out.println("........ Lancement du TRI " + robot2.toString() + "............." );
       robot2.fillBox(items).forEach(System.out::print);
       System.out.println();
       System.out.println("######## FIN DU TRI ########");

       System.exit(0);     
    }
    
    
    
}
