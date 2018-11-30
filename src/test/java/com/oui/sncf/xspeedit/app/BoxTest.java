package com.oui.sncf.xspeedit.app;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class BoxTest {

    private static final Parcel PARCEL_OF_SIZE_TWO = Parcel.ofSize(2);
    private static final Parcel PARCEL_OF_SIZE_ONE = Parcel.ofSize(1);

    @Test
    public void ofParcel_should_return_box_containing_only_given_parcel() {

        Box box = Box.ofParcel(PARCEL_OF_SIZE_TWO);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(box).isNotNull();
        softly.assertThat(box.getParcels().size()).isOne();
        softly.assertThat(box.getParcels()).isEqualTo(singletonList(PARCEL_OF_SIZE_TWO));
        softly.assertAll();
    }

    @Test
    public void add_should_not_throw_any_exception_if_parcel_can_fit() {
        assertThatCode(() -> boxWithOneRemainingSpace().add(PARCEL_OF_SIZE_ONE)).doesNotThrowAnyException();
    }

    @Test
    public void add_should_throw_boxFullException_if_parcel_cannot_fit() {
        assertThatExceptionOfType(Box.BoxFullException.class)

                .isThrownBy(() -> boxWithOneRemainingSpace().add(PARCEL_OF_SIZE_TWO))

                .withMessage("Failed to add parcel of size 2 - the box remaining space is 1");
    }

    @Test
    public void remainingSpaceAfterAdding_should_return_remaining_space_after_parcel_is_added() {

        //Arrange
        final Parcel parcelOfSizeZero = Parcel.ofSize(0);

        //Assert
        assertThat(boxWithOneRemainingSpace().remainingSpaceAfterAdding(parcelOfSizeZero)).isOne();
    }

    @Test
    public void remainingSpaceAfterAdding_should_return_MAX_BOX_SIZE_if_parcel_cannot_fit() {
        final int maxBoxSize = 10;
        assertThat(boxWithOneRemainingSpace().remainingSpaceAfterAdding(PARCEL_OF_SIZE_TWO)).isEqualTo(maxBoxSize);
    }

    @Test
    public void canFit_should_return_true_if_parcel_can_fit() {
        assertTrue(boxWithOneRemainingSpace().canFit(PARCEL_OF_SIZE_ONE));
    }

    @Test
    public void canFit_should_return_false_if_parcel_cannot_fit() {
        assertFalse(boxWithOneRemainingSpace().canFit(PARCEL_OF_SIZE_TWO));
    }

    @Test
    public void toString_should_correctly_describe_box_content() {

        //Arrange
        Box box = Box.ofParcel(PARCEL_OF_SIZE_ONE);
        box.add(PARCEL_OF_SIZE_TWO);

        //Assert
        assertEquals("[1, 2]", box.toString());
    }

    private Box boxWithOneRemainingSpace(){
        return Box.ofParcel(Parcel.ofSize(9));
    }


}