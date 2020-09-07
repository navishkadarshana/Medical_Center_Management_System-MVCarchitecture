package Medical_Center_Management_System.Modal;

public class UserLogin {
    private String Id;
    private  String name;
    private  String role;
    private  String UserName;
    private String password;

    public UserLogin(String id, String name, String role, String userName, String password) {
        Id = id;
        this.name = name;
        this.role = role;
        UserName = userName;
        this.password = password;
    }

    public UserLogin() {
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", UserName='" + UserName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
