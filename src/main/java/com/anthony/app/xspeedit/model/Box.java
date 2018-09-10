package com.anthony.app.xspeedit.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.anthony.app.xspeedit.constant.Constant;

public class Box {

	// Le nombre max d'objets par carton
	private int maxItem = Constant.BOX_MAX_ITEM;
	
	// La liste des objets contenus dans le carton 
	private List<Item> items = new ArrayList<Item>();

	public int getMaxItem() {
		return maxItem;
	}

	public void setMaxItem(int maxItem) {
		this.maxItem = maxItem;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	
	public int getRemainingPlace() {
		int remainingPlace = this.maxItem;
		for(Item item : this.items) {
			remainingPlace = remainingPlace - item.getSize();
		}
		return remainingPlace;	
	}
	
	  public String toString(){
		    String description = "" ;
		    if(CollectionUtils.isNotEmpty(this.getItems())){
		      for(Item item : this.getItems()){
		    	  description += item.getSize() + "/";
		      }
		      return description;
		    }  
		    return description;
		}
	
}
