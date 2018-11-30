package com.oui.sncf.xspeedit.app;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class PackagerTest {

    private static final int[] INPUT_0 = {1, 6, 3, 8, 4, 1, 6, 8, 9, 5, 2, 5, 7, 7, 3};
    private static final int[] INPUT_1 = {1, 1, 2, 3, 3};
    private static final int[] INPUT_2 = {9, 9, 9};

    private final Packager sut = new Packager();

    @Test
    public void computeOptimalBoxesNumber_should_return_eight_if_total_size_of_parcel_is_seventyFive() {

        //Act
        List<Parcel> parcelToPack = buildParcels(INPUT_0);
        final int optimalBoxNumber = sut.computeOptimalBoxesNumber(parcelToPack);

        //Assert
        final int expected = 8;
        assertThat(optimalBoxNumber).isEqualTo(expected);
    }

    @Test
    public void computeOptimalBoxesNumber_should_return_one_if_total_size_of_parcel_is_ten() {

        //Act
        List<Parcel> parcelToPack = buildParcels(INPUT_1);
        final int optimalBoxNumber = sut.computeOptimalBoxesNumber(parcelToPack);

        //Assert
        assertThat(optimalBoxNumber).isOne();
    }

    @Test
    public void computeOptimalBoxesNumber_should_return_three_if_total_size_of_parcel_is_twenty_seven() {

        //Act
        List<Parcel> parcelToPack = buildParcels(INPUT_2);
        final int optimalBoxNumber = sut.computeOptimalBoxesNumber(parcelToPack);

        //Assert
        final int expected = 3;
        assertThat(optimalBoxNumber).isEqualTo(expected);
    }

    @Test
    public void pack_should_throw_noParcelToPackException_if_empty_parcel_list_is_given() {

        assertThatExceptionOfType(Packager.NoParcelToPackException.class)

                .isThrownBy(() -> sut.pack(Collections.emptyList()))

                .withMessage("Given list of parcel should not be empty");
    }

    @Test
    public void pack_should_return_collection_of_boxes_of_optimal_size() {

        //Arrange

        List<Parcel> parcelToPack = buildParcels(INPUT_0);
        final int optimalBoxNumber = sut.computeOptimalBoxesNumber(parcelToPack);

        //Act
        Collection<Box> result = sut.pack(parcelToPack);

        //Assert
        final String expected = "[[9, 1], [8, 2], [8, 1], [7, 3], [7, 3], [6, 4], [6], [5, 5]]";
        validate(expected, result, optimalBoxNumber);
    }

    @Test
    public void pack_should_return_singleton_collection_if_all_parcels_fit_in_one_box() {

        //Arrange
        List<Parcel> parcelToPack = buildParcels(INPUT_1);
        final int optimalBoxNumber = sut.computeOptimalBoxesNumber(parcelToPack);

        //Act
        Collection<Box> result = sut.pack(parcelToPack);

        //Assert
        final String expected = "[[3, 3, 2, 1, 1]]";
        validate(expected, result, optimalBoxNumber);
    }

    @Test
    public void pack_should_return_as_many_boxes_as_parcels_if_every_duo_of_them_exceed_max_box_size() {

        //Arrange
        List<Parcel> parcelToPack = buildParcels(INPUT_2);
        final int optimalBoxNumber = sut.computeOptimalBoxesNumber(parcelToPack);

        //Act
        Collection<Box> result = sut.pack(parcelToPack);

        //Assert
        final String expected = "[[9], [9], [9]]";
        validate(expected, result, optimalBoxNumber);
    }

    private void validate(String expected, Collection<Box> result, int optimalBoxNumber) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(result.size()).isEqualTo(optimalBoxNumber);
        softly.assertThat(result.toString()).isEqualTo(expected);
        softly.assertAll();
    }

    private List<Parcel> buildParcels(int... parcelSizes) {
        return Arrays.stream(parcelSizes).mapToObj(Parcel::ofSize).collect(Collectors.toList());
    }

}