package com.oui.sncf.xspeedit.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box {

    static final int MAX_BOX_SIZE = 10;
    private static final int INITIAL_CONTENT_SIZE = 0;

    private final List<Parcel> parcels;

    private int contentSize;

    private Box() {
        this.parcels = new ArrayList<>();
        this.contentSize = INITIAL_CONTENT_SIZE;
    }

    static Box ofParcel(Parcel p) {
        Box box = new Box();
        box.add(p);
        return box;
    }

    void add(Parcel parcel) {
        if (!canFit(parcel)) {
            throw new BoxFullException("Failed to add parcel of size " + parcel.getSize() + " - the box remaining space is " + remainingSpace());
        }
        this.parcels.add(parcel);
        contentSize += parcel.getSize();
    }

    boolean canFit(Parcel parcel) {
        return MAX_BOX_SIZE - contentSize >= parcel.getSize();
    }


    int remainingSpaceAfterAdding(Parcel parcelToTest) {
        if (!canFit(parcelToTest)) {
            return MAX_BOX_SIZE;
        }
        return remainingSpace() - parcelToTest.getSize();
    }

    private int remainingSpace() {
        return MAX_BOX_SIZE - contentSize;
    }

    List<Parcel> getParcels() {
        return parcels;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(parcels.stream().map(Parcel::toString).toArray());
    }

    class BoxFullException extends IllegalArgumentException {

        BoxFullException(String message) {
            super(message);
        }

    }
}
