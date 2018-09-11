package com.anthony.app.xspeedit.Util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.anthony.app.xspeedit.model.Box;
import com.anthony.app.xspeedit.model.Item;
import com.anthony.app.xspeedit.model.NewRobot;
import com.anthony.app.xspeedit.model.OldRobot;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class FillingUtilsTest{

    /**
     * Alimentation d'un jeux de test d'objets
     * @return
     */
    private List<Item> getItemsTest(){
		List<Item> items = new ArrayList<Item>();
		Item item1 = new Item(9);
		Item item2 = new Item(8);
		Item item3 = new Item(5);



		items.add(item1);
		items.add(item2);
		items.add(item3);
		
		return items;
    }
    
    /**
     * Test de l'algo basique de remplissage
     */
    @Test
    public void testFillingBasic() {
		List<Item> items = getItemsTest();
		List<Box> listBox = new ArrayList<Box>();
		OldRobot robot1 = new OldRobot("AnthoD2");
		listBox = robot1.fillBox(items);
		assertTrue(CollectionUtils.isNotEmpty(listBox));
		System.out.println();
    }
    
    /**
     * Test de l'algo optimisé de remplissage
     */
    @Test
    public void testFillingOptimised() {
 		List<Item> items = getItemsTest();
		List<Box> listBox = new ArrayList<Box>();
 		listBox = FillingUtils.optimisedFilling(items);
 		listBox.forEach(System.out::print);
		assertTrue(CollectionUtils.isNotEmpty(listBox));
		System.out.println();
     }
    
}
