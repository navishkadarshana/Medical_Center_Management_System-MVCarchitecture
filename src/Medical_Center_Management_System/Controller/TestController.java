package Medical_Center_Management_System.Controller;

import Medical_Center_Management_System.DBConnection.DBconnection;
import Medical_Center_Management_System.Modal.Doctor;
import Medical_Center_Management_System.Modal.Test;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestController {

    public static void TestData(ObservableList list) throws SQLException, ClassNotFoundException {
        Connection con = DBconnection.GetInstance().getConnection();
        ResultSet rst = con.createStatement().executeQuery("select * from Test");

        while (rst.next()){
            list.add(
                    new Test(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getDouble(3)

                    )
            );
        }

    }


    public boolean saveText(Test test) throws SQLException, ClassNotFoundException {

        Connection con =DBconnection.GetInstance().getConnection();
        String sql = "INSERT INTO Test VALUES(?,?,?)";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, test.getId());
        stm.setString(2, test.getName());
        stm.setDouble(3, test.getAmount());

        return stm.executeUpdate() > 0;
    }

    public boolean updateTest(Test test) throws SQLException, ClassNotFoundException {
        Connection con =DBconnection.GetInstance().getConnection();
        String sql = "UPDATE Test SET TName=?,Amount=?  WHERE Test_ID=?";
        PreparedStatement stm = con.prepareStatement(sql);

        stm.setString(1, test.getName());
        stm.setDouble(2, test.getAmount());
        stm.setString(3,test.getId() );


        return stm.executeUpdate() > 0;
    }

    public boolean deleteTest(String id) throws ClassNotFoundException, SQLException{
        return DBconnection.GetInstance().
                getConnection().
                prepareStatement("DELETE FROM Test WHERE Test_ID='"+id+"'")
                .executeUpdate()>0;
    }



}
