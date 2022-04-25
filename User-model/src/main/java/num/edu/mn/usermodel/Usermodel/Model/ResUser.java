package num.edu.mn.usermodel.Usermodel.Model;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class ResUser
{
    private Long userId;
    private String firstName;
    private String lastName;
    private String requestry;
    private String allergies;
    private String address;
    private String education;
    private String profession;
    private String jobAddress;

    public ResUser() {
    }

    public ResUser(Long userId, String firstName, String lastName, String requestry, String allergies, String address, String education, String profession, String jobAddress) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.requestry = requestry;
        this.allergies = allergies;
        this.address = address;
        this.education = education;
        this.profession = profession;
        this.jobAddress = jobAddress;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRequestry() {
        return requestry;
    }

    public void setRequestry(String requestry) {
        this.requestry = requestry;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getJobAddress() {
        return jobAddress;
    }

    public void setJobAddress(String jobAddress) {
        this.jobAddress = jobAddress;
    }
}
