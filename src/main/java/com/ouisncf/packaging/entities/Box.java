package com.ouisncf.packaging.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represent the box entity
 * Each box includes the following properties:
 *  - a maximum size that the box can host
 *  - a current filling level which increase each time an item is added
 *  - a list of the items that are currently stored in the box
 *
 * @author Seiffeddine BALLOUM
 */

public class Box {
    private int maximumSize;
    private int fillingLevel;
    private List<Integer> storedItems;

    public Box(int maximumSize){
        this.maximumSize = maximumSize;
        this.fillingLevel =0;
        this.storedItems = new ArrayList<>();
    }

    public boolean addNewItem(Item newItem) {
        if(this.fillingLevel + newItem.getSize() <= this.maximumSize){
            this.storedItems.add(newItem.getSize());
            this.fillingLevel += newItem.getSize();
            return true;
        }
        return false;
    }

    public boolean isFull(){
        return fillingLevel == maximumSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        storedItems.forEach(sb::append);
        return sb.toString();
    }
}
