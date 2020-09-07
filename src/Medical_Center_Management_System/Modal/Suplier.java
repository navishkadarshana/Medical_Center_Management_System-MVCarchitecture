package Medical_Center_Management_System.Modal;

public class Suplier {

    private String id;
    private String name;
    private String address;
    private String phoneNum;
    private String Compani_Name;

    public Suplier(String id, String name, String address, String phoneNum, String compani_Name) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        Compani_Name = compani_Name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getCompani_Name() {
        return Compani_Name;
    }

    public void setCompani_Name(String compani_Name) {
        Compani_Name = compani_Name;
    }

    @Override
    public String toString() {
        return "Suplier{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", Compani_Name='" + Compani_Name + '\'' +
                '}';
    }
}
