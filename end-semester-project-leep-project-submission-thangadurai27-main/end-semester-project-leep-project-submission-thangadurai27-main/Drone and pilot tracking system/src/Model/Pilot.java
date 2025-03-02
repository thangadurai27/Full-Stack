package Model;

public class Pilot {
    private int pilotId;
    private String name;
    private String licenseNumber;
    private int experience;
    private String certifications;

    public Pilot(String name, String licenseNumber, int experience, String certifications) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.experience = experience;
        this.certifications = certifications;
    }

    public Pilot(int pilotId, String name, String licenseNumber, int experience, String certifications) {
        this.pilotId = pilotId;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.experience = experience;
        this.certifications = certifications;
    }

    public int getPilotId() {
        return pilotId;
    }

    public void setPilotId(int pilotId) {
        this.pilotId = pilotId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getCertifications() {
        return certifications;
    }

    public void setCertifications(String certifications) {
        this.certifications = certifications;
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "pilotId=" + pilotId +
                ", name='" + name + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", experience=" + experience +
                ", certifications='" + certifications + '\'' +
                '}';
    }
}
