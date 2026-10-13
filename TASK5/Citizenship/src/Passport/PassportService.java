package Passport;

import Identification.NationalID;
import Identification.NationalIDservice;

public class PassportService {
    private NationalIDservice IDs = new NationalIDservice();
    private int counter = 1000;

    // Returns null if the NIN is not valid
    public PassportApplication apply(String nin) {
        NationalID ID = IDs.find(nin);
        if (ID == null) {
            return null;
        } else {
            counter++;
            return new PassportApplication("B" + counter, ID.getFullName());
        }
    }
}
