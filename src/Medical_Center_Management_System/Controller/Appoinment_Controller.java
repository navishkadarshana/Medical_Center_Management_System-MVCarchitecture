package Medical_Center_Management_System.Controller;

import Medical_Center_Management_System.DBConnection.DBconnection;
import Medical_Center_Management_System.Modal.Appoinment;
import Medical_Center_Management_System.Modal.Employee;
import Medical_Center_Management_System.Modal.Suplier;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Appoinment_Controller {

    public static void AppoinmentData(ObservableList list) throws SQLException, ClassNotFoundException {
        Connection con = DBconnection.GetInstance().getConnection();
        ResultSet rst = con.createStatement().executeQuery("\n" +
                "SELECT Appoinment_No,PFirstName,DFrist_Name,Appoinment_Date,Appoinment_Time FROM Appoinment INNER JOIN Pationt  ON Pationt.Pationt_ID=Appoinment.Pationt_ID\n" +
                "INNER JOIN Doctor ON Doctor.Doctor_ID=Appoinment.Doctor_ID;");

        while (rst.next()){
            list.add(
                    new Appoinment(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4),
                            rst.getString(5)


                    )
            );
        }

    }
    public boolean saveAppoinment(Appoinment appoinment) throws SQLException, ClassNotFoundException {

        Connection con =DBconnection.GetInstance().getConnection();
        String sql = "INSERT INTO Appoinment VALUES(?,?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, appoinment.getAno());
        stm.setString(2, appoinment.getDID());
        stm.setString(3, appoinment.getPID());
        stm.setString(4, appoinment.getDate());
        stm.setString(5, appoinment.getTime());

        return stm.executeUpdate() > 0;
    }




    public Appoinment getAppoinment(String id) throws ClassNotFoundException, SQLException {
        Connection con = DBconnection.GetInstance().getConnection();
        String sql = "SELECT * FROM Appoinment WHERE Appoinment_No=?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet set = stm.executeQuery();

        if (set.next()) {
            return new Appoinment(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4),
                    set.getString(5)
            );
        }
        return null;
    }


    public boolean AppoinmentUpdate(Appoinment appoinment) throws SQLException, ClassNotFoundException {
        Connection con =DBconnection.GetInstance().getConnection();
        String sql = "UPDATE Appoinment SET Doctor_ID=?,Pationt_ID=?,Appoinment_Date=?,Appoinment_Time=?  WHERE Appoinment_No=?";
        PreparedStatement stm = con.prepareStatement(sql);

        stm.setString(1, appoinment.getDID());
        stm.setString(2, appoinment.getPID());
        stm.setString(3, appoinment.getDate());
        stm.setString(4, appoinment.getTime());
        stm.setString(5, appoinment.getAno());


        return stm.executeUpdate() > 0;
    }

    public boolean deleteAppoinment(String id) throws ClassNotFoundException, SQLException{
        return DBconnection.GetInstance().
                getConnection().
                prepareStatement("DELETE FROM Appoinment WHERE Appoinment_No='"+id+"'")
                .executeUpdate()>0;
    }

}
