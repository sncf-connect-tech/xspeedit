package com.anthony.app.xspeedit.Interface;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.anthony.app.xspeedit.Util.FillingUtils;
import com.anthony.app.xspeedit.model.Box;
import com.anthony.app.xspeedit.model.Item;

/**
 * Interface logiciel des robots 
 * @author aarchamb
 *
 */
public interface Logiciel {
	
	/**
	 * <p>
	 * Remplie un ou plusieurs cartons avec une liste d'objets.
	 * La méthode par défaut est celle utilisée par les robots anciennes génération.
	 * </p>
	 */
	public default List<Box> fillBox(List<Item> items) {
		return FillingUtils.basicFilling(items);
	}
	
}
