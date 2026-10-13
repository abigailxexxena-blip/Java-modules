package Identification;

public class NationalIDservice{

    public NationalID find(String nin) {
        if ("CM90012345ABCD".equals(nin)) {
            return new NationalID("CM90012345ABCD", "KATO KENNETH");
        } else if ("CM85098765WXYZ".equals(nin)) {
            return new NationalID("CM85098765WXYZ", "ADUL ABIGAIL ENGWEDO");
        } else {
            return null;
        }
    }
}