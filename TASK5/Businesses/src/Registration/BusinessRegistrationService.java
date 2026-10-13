package Registration;

import Identification.NationalID;
import Identification.NationalIDservice;

public class BusinessRegistrationService {
    private NationalIDservice IDs = new NationalIDservice();
    // Returns null if the owner's NIN is not valid
    public Business register(String BusinessName, String ownerNin) {
        NationalID owner = IDs.find(ownerNin);
        if (owner == null) {
            return null;
        } else {
            return new Business(BusinessName, owner.getFullName());
        }
    }
}
