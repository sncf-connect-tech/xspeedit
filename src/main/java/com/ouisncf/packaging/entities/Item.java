package com.ouisncf.packaging.entities;

/**
 * Entity class representing the item intended to be packed into a box by the robot
 *
 * @author Seiffeddine BALLOUM
 */

public class Item {
    private int size;

    public Item(int size){
        this.size= size;
    }

    public int getSize() {
        return size;
    }
}
