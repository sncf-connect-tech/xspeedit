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
	 private static Scanner sc;
	
    public static void main( String[] args ){
        Scanner scan = new Scanner(System.in); 
        List<Item> items = new ArrayList<Item>();
        
        System.out.println("######## XPEEDIT ########");
        System.out.println("######## CREATION DES OBJETS ########");
        System.out.println("Veuillez saisir la taille chaque objet, entre 0 et 9. (Appuyez sur entré pour arrêter la saisie) : ");
         
        OldRobot robot2 = new OldRobot("R2D2");
        
        while (scan.hasNextLine()){
        	
            String itemSize = scan.nextLine();

            if (ControlUtils.isStopping(itemSize)) {
            	  System.exit(0);
                  scan.close();
                  robot2.fillBox(items);
            } try {
            	 ControlUtils.isValidEntry(itemSize);
            	 items.add(new Item(Integer.parseInt(itemSize)));
			} catch (InvalidEntryException e) {
				System.out.println(e.getMessage());
			}                     
        }
                    
    }
    
   
    
    
}
