package Medical_Center_Management_System.Controller;

import Medical_Center_Management_System.DBConnection.DBconnection;
import Medical_Center_Management_System.Modal.Suplier;
import Medical_Center_Management_System.Modal.UserLogin;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserController {

    public static void UserData(ObservableList list) throws SQLException, ClassNotFoundException {
        Connection con = DBconnection.GetInstance().getConnection();
        ResultSet rst = con.createStatement().executeQuery("select * from User");

        while (rst.next()){
            list.add(
                    new UserLogin(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4),
                            rst.getString(5)


                    )
            );
        }

    }

    public boolean saveUser(UserLogin userLogin) throws SQLException, ClassNotFoundException {

        Connection con =DBconnection.GetInstance().getConnection();
        String sql = "INSERT INTO User VALUES(?,?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, userLogin.getId());
        stm.setString(2, userLogin.getName());
        stm.setString(3, userLogin.getRole());
        stm.setString(4, userLogin.getUserName());
        stm.setString(5, userLogin.getPassword());

        return stm.executeUpdate() > 0;
    }

    public boolean updateUser(UserLogin userLogin) throws SQLException, ClassNotFoundException {
        Connection con =DBconnection.GetInstance().getConnection();
        String sql = "UPDATE User SET Name=?,Role=?,UserName=?,Password=?  WHERE UserID=?";
        PreparedStatement stm = con.prepareStatement(sql);


        stm.setString(1, userLogin.getName());
        stm.setString(2, userLogin.getRole());
        stm.setString(3, userLogin.getUserName());
        stm.setString(4, userLogin.getPassword());
        stm.setString(5, userLogin.getId());

        return stm.executeUpdate() > 0;
    }
    public boolean deleteUser(String id) throws ClassNotFoundException, SQLException{
        return DBconnection.GetInstance().
                getConnection().
                prepareStatement("DELETE FROM Suplier WHERE Suplier_ID='"+id+"'")
                .executeUpdate()>0;
    }
}
