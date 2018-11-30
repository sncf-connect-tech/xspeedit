package com.oui.sncf.xspeedit.app;

public class Parcel implements Comparable<Parcel> {

    private static final int MIN_SIZE = 0;
    private static final int MAX_SIZE = 9;
    private int size;

    public static Parcel ofSize(int size) {
        return new Parcel(size);
    }

    private Parcel(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new InvalidParcelSizeException("Failed to create parcel of size " + size + " - parcel size should be between 0 and 9");
        }
        this.size = size;
    }

    int getSize() {
        return size;
    }

    @Override
    public int compareTo(Parcel o) {
        return Integer.compare(this.getSize(), o.getSize());
    }

    @Override
    public String toString() {
        return String.valueOf(size);
    }

    public class InvalidParcelSizeException extends IllegalArgumentException {

        InvalidParcelSizeException(String message) {
            super(message);
        }
    }
}
