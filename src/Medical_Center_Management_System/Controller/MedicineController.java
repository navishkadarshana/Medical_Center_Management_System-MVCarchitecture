package Medical_Center_Management_System.Controller;

import Medical_Center_Management_System.DBConnection.DBconnection;
import Medical_Center_Management_System.Modal.Medicine;
import Medical_Center_Management_System.Modal.Patient;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicineController {

    public static void MedicineData(ObservableList list) throws SQLException, ClassNotFoundException {
        Connection con = DBconnection.GetInstance().getConnection();
        ResultSet rst = con.createStatement().executeQuery("select * from Medicine");

        while (rst.next()){
            list.add(
                    new Medicine(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getDouble(4),
                            rst.getString(5),
                            rst.getString(6),
                            rst.getString(7),
                            rst.getString(8),
                            rst.getString(9),
                            rst.getString(10)


                    )
            );
        }

    }

    public boolean saveMedicine(Medicine medicine) throws SQLException, ClassNotFoundException {

        Connection con =DBconnection.GetInstance().getConnection();
        String sql = "INSERT INTO Medicine VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, medicine.getReference_No());
        stm.setString(2, medicine.getSuplier_ID());
        stm.setString(3, medicine.getName());
        stm.setDouble(4, medicine.getUnitPrice());
        stm.setString(5, medicine.getSide_effect());
        stm.setString(6, medicine.getQuntity_Ac());
        stm.setString(7, medicine.getExpirDate());
        stm.setString(8, medicine.getDose());
        stm.setString(9, medicine.getDaliyDose());
        stm.setString(10, medicine.getStorage());


        return stm.executeUpdate() > 0;
    }

    public Medicine getMedicine(String id) throws ClassNotFoundException, SQLException {
        Connection con = DBconnection.GetInstance().getConnection();
        String sql = "SELECT * FROM  Medicine WHERE Medicine_Reference_No=?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet set = stm.executeQuery();

        if (set.next()) {
            return new Medicine(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getDouble(4),
                    set.getString(5),
                    set.getString(6),
                    set.getString(7),
                    set.getString(8),
                    set.getString(9),
                    set.getString(10)


            );
        }
        return null;
    }


    public boolean updateMedicine(Medicine medicine) throws SQLException, ClassNotFoundException {
        Connection con =DBconnection.GetInstance().getConnection();
        String sql = "UPDATE  Medicine SET Suplier_ID=?, Name_Of_Tablet=?, unitPrice=?, Possible_side_effect=?, Quntity_Ac=?, ExpirDate =?, Dose=?,DaliyDose=?, Storage_Advice=?WHERE Medicine_Reference_No=?";
        PreparedStatement stm = con.prepareStatement(sql);


        stm.setString(1, medicine.getSuplier_ID());
        stm.setString(2, medicine.getName());
        stm.setDouble(3, medicine.getUnitPrice());
        stm.setString(4, medicine.getSide_effect());
        stm.setString(5, medicine.getQuntity_Ac());
        stm.setString(6, medicine.getExpirDate());
        stm.setString(7, medicine.getDose());
        stm.setString(8, medicine.getDaliyDose());
        stm.setString(9, medicine.getStorage());
        stm.setString(10, medicine.getReference_No());

        return stm.executeUpdate() > 0;
    }

    public boolean deleteMedicine(String id) throws ClassNotFoundException, SQLException{
        return DBconnection.GetInstance().
                getConnection().
                prepareStatement("DELETE FROM Medicine WHERE Medicine_Reference_No='"+id+"'")
                .executeUpdate()>0;
    }
}
