package Identification;

public class NationalID {
    private String nin;
    private String fullName;

    public NationalID(String nin, String fullName) {
        this.nin = nin;
        if (fullName == null) {
            this.fullName = "Unknown";
        } else {
            this.fullName = fullName;
        }
    }
    public String getNin()
    { return nin; }
    public String getFullName() { return fullName; }
}

