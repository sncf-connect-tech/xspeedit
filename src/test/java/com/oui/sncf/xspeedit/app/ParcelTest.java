package com.oui.sncf.xspeedit.app;

import com.oui.sncf.xspeedit.app.Parcel;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.text.MessageFormat;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ParcelTest {

    private final String invalidParcelMessage = "Failed to create parcel of size {0} - parcel size should be between 0 and 9";

    @Test
    public void of_should_create_parcel_of_given_size() {

        //Arrange
        final int parcelSize = 2;

        //Act
        Parcel parcel = Parcel.ofSize(parcelSize);

        //Assert
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(parcel).isNotNull();
        softly.assertThat(parcel.getSize()).isEqualTo(parcelSize);
        softly.assertAll();
    }

    @Test
    public void of_should_throw_InvalidParcelSizeException_if_given_size_is_lt_zero() {

        //Arrange
        final int parcelSize = -1;

        //Assert
        assertThatExceptionOfType(Parcel.InvalidParcelSizeException.class)
                .isThrownBy(() -> Parcel.ofSize(parcelSize))
                .withMessage(MessageFormat.format(invalidParcelMessage, parcelSize));
    }

    @Test
    public void of_should_throw_InvalidParcelSizeException_if_given_size_is_gt_nine() {

        //Arrange
        final int parcelSize = 10;

        //Assert
        assertThatExceptionOfType(Parcel.InvalidParcelSizeException.class)
                .isThrownBy(() -> Parcel.ofSize(parcelSize))
                .withMessage(MessageFormat.format(invalidParcelMessage, parcelSize));
    }

}