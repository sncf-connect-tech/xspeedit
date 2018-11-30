package com.oui.sncf.xspeedit;


import com.oui.sncf.xspeedit.app.Box;
import com.oui.sncf.xspeedit.app.Packager;
import com.oui.sncf.xspeedit.app.Parcel;

import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;

class Main {

    private static final String SEPARATOR = "\\s+";

    public static void main(String... args) {

        out.println("Please enter your parcel sizes (size should be between 0 and 9) separated by SPACES : ");
        Scanner scanner = new Scanner(in);
        String input = scanner.nextLine();

        List<Parcel> parcels = new ArrayList<>();
        try {
            Arrays.stream(input.split(SEPARATOR)).forEach(v -> parcels.add(Parcel.ofSize(Integer.parseInt(v))));

            Packager packager = new Packager();
            Collection<Box> result = packager.pack(parcels);
            int optimalNumberOfBoxes = packager.computeOptimalBoxesNumber(parcels);

            out.println("The optimal number of boxes you can use is : " + optimalNumberOfBoxes );
            out.println(result);

        } catch (NumberFormatException e) {
            out.println("Invalid Entry : parcel size should be integers");
        }catch (Parcel.InvalidParcelSizeException e){
            out.println("Invalid Entry : parcel size should be between 0 and 9");
        }

    }
}
