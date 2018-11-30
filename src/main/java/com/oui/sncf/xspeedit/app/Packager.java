package com.oui.sncf.xspeedit.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.oui.sncf.xspeedit.app.Box.MAX_BOX_SIZE;
import static java.util.Collections.reverseOrder;
import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

public class Packager {

    private final Collection<Box> boxes;

    public Packager() {
        boxes = new ArrayList<>();
    }

    /**
     * Packs given parcels in a way that minimizes the number of used boxes
     *
     * @param parcels
     * @return A collection of boxes containing all the parcels
     */
    @SuppressWarnings("JavaDoc")
    public Collection<Box> pack(final List<Parcel> parcels) {

        doSanityChecks(parcels);

        parcels.sort(reverseOrder());

        fillParcelsIntoBoxes(parcels);

        return boxes;
    }

    /**
     * Calculate the minimal number of boxes that are required given the parcel sizes
     * and the boxes capacity
     * @param parcels
     * @return the optimal number of boxes
     */
    public int computeOptimalBoxesNumber(Collection<Parcel> parcels) {
        double sum = parcels.stream().mapToInt(Parcel::getSize).sum();
        return (int) Math.ceil(sum / MAX_BOX_SIZE);
    }


    private void doSanityChecks(List<Parcel> parcels) {
        requireNonNull(parcels);
        if (parcels.isEmpty()) {
            throw new NoParcelToPackException();
        }
    }

    /**
     * For every parcel, if it can fit in an existing box while minimizing the remaining space
     * fill it in that box
     * Otherwise put it in a newly created box
     *
     * @param parcels
     */
    private void fillParcelsIntoBoxes(List<Parcel> parcels) {
        for (Parcel parcel : parcels) {
            Box targetBox = findBoxWithMinimumRemainingWhereCanFit(parcel);
            if (nonNull(targetBox)) {
                targetBox.add(parcel);
            } else {
                boxes.add(Box.ofParcel(parcel));
            }
        }
    }

    /**
     * Finds within the existing boxes, the one where once can add the given parcel
     * and keep the remaining space to the minimum.
     *
     * @param parcel
     * @return
     */
    private Box findBoxWithMinimumRemainingWhereCanFit(final Parcel parcel) {
        Box targetBox = null;
        int minRemainingSpace = MAX_BOX_SIZE;
        for (Box box : boxes) {
            final int remainingSpace = box.remainingSpaceAfterAdding(parcel);
            if (box.canFit(parcel) && remainingSpace < minRemainingSpace) {
                targetBox = box;
                minRemainingSpace = remainingSpace;
            }
        }
        return targetBox;
    }

    class NoParcelToPackException extends IllegalArgumentException {

        NoParcelToPackException() {
            super("Given list of parcel should not be empty");
        }
    }

}
