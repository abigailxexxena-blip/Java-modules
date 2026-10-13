import Registration.Business;
import Registration.BusinessRegistrationService;
import Taxes.TaxReceipt;
import Taxes.Taxservice;
import Identification.NationalID;
import Identification.NationalIDservice;
import Passport.PassportApplication;
import Passport.PassportService;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Uganda e-Government Portal ===");

        // 1. National ID
        NationalIDservice ids = new NationalIDservice();
        NationalID id = ids.find("CM90012345ABCD");
        if (id != null) {
            System.out.println("National ID: VALID for " + id.getFullName());
        } else {
            System.out.println("National ID: INVALID");
        }
        // 2. Passport (valid NIN)
        PassportService passports = new PassportService();
        PassportApplication p = passports.apply("CM85098765WXYZ");
        if (p != null) {
            System.out.println("Passport: " + p.getPassportNumber() + " for " + p.getHolderName());
        } else {
            System.out.println("Passport REFUSED: invalid NIN");
        }

        // 2b. Passport (fake NIN)
        PassportApplication fake = passports.apply("FAKE123");
        if (fake != null) {
            System.out.println("Passport: " + fake.getPassportNumber());
        } else {
            System.out.println("Passport REFUSED: invalid NIN");
        }

        // 3. Business registration
        BusinessRegistrationService registry = new BusinessRegistrationService();
        Business b = registry.register("ADUL Coffee Ltd", "CM90012345ABCD");
        if (b != null) {
            System.out.println("Business registered: " + b.getName() + " (owner: " + b.getOwnerName() + ")");
        } else {
            System.out.println("Registration REFUSED: invalid owner NIN");
        }

        // 4. Tax
        Taxservice taxService = new Taxservice();
        TaxReceipt r = taxService.fileTax(b, 1000000);
        if (r != null) {
            System.out.println("Tax for " + r.getBusinessName() + ": UGX " + r.getAmount());
        } else {
            System.out.println("Tax REFUSED: business not registered");
        }
    }
}

