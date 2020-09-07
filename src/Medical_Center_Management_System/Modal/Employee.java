package Medical_Center_Management_System.Modal;

public class Employee {

    private  String ID;
    private  String fristName;
    private String secndName;
    private  String NIC;
    private String address;
    private String role;
    private double salary;
    private  int age;
    private String gender;
    private String DOB;
    private String PhoneNumber;

    public Employee(String ID, String fristName, String secndName, String NIC, String address, String role, double salary, int age, String gender, String DOB, String phoneNumber) {
        this.ID = ID;
        this.fristName = fristName;
        this.secndName = secndName;
        this.NIC = NIC;
        this.address = address;
        this.role = role;
        this.salary = salary;
        this.age = age;
        this.gender = gender;
        this.DOB = DOB;
        PhoneNumber = phoneNumber;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    @Override
    public String toString() {
        return "Employee{" +
                "ID='" + ID + '\'' +
                ", fristName='" + fristName + '\'' +
                ", secndName='" + secndName + '\'' +
                ", NIC='" + NIC + '\'' +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", DOB='" + DOB + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                '}';
    }
}
