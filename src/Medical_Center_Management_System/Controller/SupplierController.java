package Medical_Center_Management_System.Controller;

import Medical_Center_Management_System.DBConnection.DBconnection;
import Medical_Center_Management_System.Modal.Suplier;
import Medical_Center_Management_System.Modal.Test;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierController {

    public static void SuplierData(ObservableList list) throws SQLException, ClassNotFoundException {
        Connection con = DBconnection.GetInstance().getConnection();
        ResultSet rst = con.createStatement().executeQuery("select * from Suplier");

        while (rst.next()){
            list.add(
                    new Suplier(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4),
                            rst.getString(5)


                    )
            );
        }

    }

    public boolean saveSuplier(Suplier suplier) throws SQLException, ClassNotFoundException {

        Connection con =DBconnection.GetInstance().getConnection();
        String sql = "INSERT INTO Suplier VALUES(?,?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, suplier.getId());
        stm.setString(2, suplier.getName());
        stm.setString(3, suplier.getAddress());
        stm.setString(4, suplier.getPhoneNum());
        stm.setString(5, suplier.getCompani_Name());

        return stm.executeUpdate() > 0;
    }



    public boolean updateSuplier(Suplier suplier) throws SQLException, ClassNotFoundException {
        Connection con =DBconnection.GetInstance().getConnection();
        String sql = "UPDATE Suplier SET Suplier_Name=?,Address=?,Phone_No=?,Compani_Name=?  WHERE Suplier_ID=?";
        PreparedStatement stm = con.prepareStatement(sql);

        stm.setString(1, suplier.getName());
        stm.setString(2, suplier.getAddress());
        stm.setString(3, suplier.getPhoneNum());
        stm.setString(4, suplier.getCompani_Name());
        stm.setString(5, suplier.getId());


        return stm.executeUpdate() > 0;
    }
    public boolean deleteSuplier(String id) throws ClassNotFoundException, SQLException{
        return DBconnection.GetInstance().
                getConnection().
                prepareStatement("DELETE FROM Suplier WHERE Suplier_ID='"+id+"'")
                .executeUpdate()>0;
    }

}
