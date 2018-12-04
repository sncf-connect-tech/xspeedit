package com.ouisncf.packaging.service;

import com.ouisncf.packaging.entities.Box;
import com.ouisncf.packaging.entities.Item;
import com.ouisncf.packaging.util.CommonUtil;

import java.util.*;

/**
 * This class represent the implementation of the packaging robot using an optimized way
 * <p>
 * To pack the provided items in entry by using a minimum number of boxes and ensure
 * to maximise the content of each one
 * <p>
 * the main business logic idea is to select, each time, the first item of the input list
 * and look for the combination which may fulfill the entire content of the box
 *
 * @author Seiffeddine BALLOUM
 */
public class SmartPackingRobot implements PackagingRobot {

    // Set the maximum of item size that can be contained into a box
    private static final int MAX_BOX_SIZE = 10;

    private String inputItems;

    private List<Box> usedBoxes;

    public SmartPackingRobot(String inputItems) {
        this.inputItems = inputItems;
    }

    // Packing input items business logic implementation
    @Override
    public String packReceivedItems() {
        if (this.inputItems != null && this.inputItems.length() != 0) {
            if (this.inputItems.matches("[0-9]+")) {
                return processPackaging();
            } else {
                return CommonUtil.NO_NUMERIC_INPUT;
            }
        } else {
            return CommonUtil.INPUT_MISSING;
        }
    }

    // Packaging process - main business logic
    private String processPackaging() {
        //Extract input items into a List
        List<Item> items = extractItems(this.inputItems);
        usedBoxes = new ArrayList<>();
        // the main item always corresponds to the first item
        int mainItemIndex = 0;
        // Manage the case if the input item list contains more than one item
        if (items.size() > 1) {
            int startSearchingFromIndex = 1;
            // Iterate until main input list of items become empty, which mean that all items were packed
            do {
                // Initialize a list to host the indexes of the items to be packed in order to be removed later
                List<Integer> packedItemsIndex = new ArrayList<>();
                packedItemsIndex.add(mainItemIndex);

                Box currentBox = new Box(MAX_BOX_SIZE);
                currentBox.addNewItem(items.get(mainItemIndex));

                // Iterate starting from 'startSearchingFromIndex' and try to add the items of the current box
                // until it becomes filled or overflowed
                for (int i = startSearchingFromIndex; i < items.size(); i++) {
                    // If 'addNewItem' return true, it means that the current item was added correctly
                    // and the process should continue.
                    // Otherwise, if the current box reaches its maximum or more than that, the loop must end its task
                    if (currentBox.addNewItem(items.get(i))) {
                        packedItemsIndex.add(i);
                    } else {
                        break;
                    }
                }
                // In case the current box is completely filled by items, add it to the list of used boxes
                if (currentBox.isFull()) {
                    usedBoxes.add(currentBox);
                    // Remove packed items from the input item list
                    removePackedItems(items, packedItemsIndex);
                    startSearchingFromIndex = 1;
                } else {
                    // Increment the starting position of the search of the best fit item to the current box
                    startSearchingFromIndex++;
                    // In case, all available item were processed and no one could fulfill
                    // what remain in the current box, a new one is create to host the main selected item
                    if (startSearchingFromIndex >= items.size()) {
                        usedBoxes.add(currentBox);
                        // Remove only the main selected item from the input item list
                        removePackedItems(items, Collections.singletonList(mainItemIndex));
                        startSearchingFromIndex = 1;
                    }
                }
            } while (!items.isEmpty());
        } else {
            // Manage the case if the input item list contains only one item
            Box uniqueBox = new Box(MAX_BOX_SIZE);
            uniqueBox.addNewItem(items.get(mainItemIndex));
            usedBoxes.add(uniqueBox);
        }
        return this.toString();
    }

    // Convert input items from String format to a list of integer representing the size of each items
    private List<Item> extractItems(String inputItems) {
        List<Item> itemsSizeList = new ArrayList<>();
        for (char itemSizeChar : inputItems.toCharArray()) {
            itemsSizeList.add(new Item(Character.getNumericValue(itemSizeChar)));
        }
        return itemsSizeList;
    }

    // Remove managed items using their respective indexes
    private void removePackedItems(List<Item> items, List<Integer> itemsIndexToBeRemoved) {
        // Sort items index in reverse order to avoid shifting problem when removing an item
        itemsIndexToBeRemoved.sort(Comparator.reverseOrder());
        for (int index : itemsIndexToBeRemoved) {
            items.remove(index);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("/");
        usedBoxes.forEach(box -> joiner.add(box.toString()));
        return joiner.toString();
    }
}
