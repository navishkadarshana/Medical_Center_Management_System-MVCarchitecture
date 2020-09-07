package Medical_Center_Management_System.Modal;

public class Patient {

    private  String ID;
    private String Title;
    private  String fristName;
    private String secndName;
    private  String NIC;
    private String address;
    private  int age;
    private String gender;
    private String DOB;
    private String PhoneNumber;
    private String Disease;
    private String Blood_Grup;

    public Patient(String ID, String title, String fristName, String secndName, String NIC, String address, int age, String gender, String DOB, String phoneNumber, String disease, String blood_Grup) {
        this.ID = ID;
        Title = title;
        this.fristName = fristName;
        this.secndName = secndName;
        this.NIC = NIC;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.DOB = DOB;
        PhoneNumber = phoneNumber;
        Disease = disease;
        Blood_Grup = blood_Grup;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public String getSecndName() {
        return secndName;
    }

    public void setSecndName(String secndName) {
        this.secndName = secndName;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getDisease() {
        return Disease;
    }

    public void setDisease(String disease) {
        Disease = disease;
    }

    public String getBlood_Grup() {
        return Blood_Grup;
    }

    public void setBlood_Grup(String blood_Grup) {
        Blood_Grup = blood_Grup;
    }


    @Override
    public String toString() {
        return "Pataient{" +
                "ID='" + ID + '\'' +
                ", Title='" + Title + '\'' +
                ", fristName='" + fristName + '\'' +
                ", secndName='" + secndName + '\'' +
                ", NIC='" + NIC + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", DOB='" + DOB + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Disease='" + Disease + '\'' +
                ", Blood_Grup='" + Blood_Grup + '\'' +
                '}';
    }
}
