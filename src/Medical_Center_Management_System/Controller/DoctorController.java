package Medical_Center_Management_System.Controller;

import Medical_Center_Management_System.DBConnection.DBconnection;
import Medical_Center_Management_System.Modal.Doctor;
import Medical_Center_Management_System.Modal.Patient;
import javafx.collections.ObservableList;

import java.sql.*;

public class DoctorController {

    public static void DoctorData(ObservableList list) throws SQLException, ClassNotFoundException {
        Connection con = DBconnection.GetInstance().getConnection();
        ResultSet rst = con.createStatement().executeQuery("select * from Doctor");

        while (rst.next()){
            list.add(
                    new Doctor(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4),
                            rst.getString(5),
                            rst.getString(6),
                            rst.getInt(7),
                            rst.getString(8),
                            rst.getString(9),
                            rst.getString(10),
                            rst.getString(11)

                    )
            );
        }

    }

    public boolean saveDoctor(Doctor doctor) throws SQLException, ClassNotFoundException {

        Connection con =DBconnection.GetInstance().getConnection();
        String sql = "INSERT INTO DOCTOR VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        con.setAutoCommit(false);
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, doctor.getID());
        stm.setString(2, doctor.getTitle());
        stm.setString(3, doctor.getFristName());
        stm.setString(4, doctor.getSecndName());
        stm.setString(5, doctor.getNIC());
        stm.setString(6, doctor.getAddress());
        stm.setInt(7, doctor.getAge());
        stm.setString(8, doctor.getGender());
        stm.setString(9, doctor.getDOB());
        stm.setString(10, doctor.getPhoneNumber());
        stm.setString(11, doctor.getSpecialtice());

        Boolean isSaved=stm.executeUpdate()>0;
        if (isSaved){
            con.commit();
            return true;
        }else {
            con.rollback();
            return false;
        }

    }

    public boolean updateDoctor(Doctor doctor) throws SQLException, ClassNotFoundException {
        Connection con =DBconnection.GetInstance().getConnection();
        con.setAutoCommit(false);
        String sql = "UPDATE Doctor SET DoctorTitle=?, DFrist_Name=?, DSecon_Name=?, NIC=?, Address=?, AGE=?, Gender=?, DOB=?, Phone_No=?,  Specialtice=? WHERE Doctor_ID=?";
        PreparedStatement stm = con.prepareStatement(sql);

        stm.setString(1, doctor.getTitle());
        stm.setString(2, doctor.getFristName());
        stm.setString(3, doctor.getSecndName());
        stm.setString(4, doctor.getNIC());
        stm.setString(5, doctor.getAddress());
        stm.setInt(6, doctor.getAge());
        stm.setString(7, doctor.getGender());
        stm.setString(8, doctor.getDOB());
        stm.setString(9, doctor.getPhoneNumber());
        stm.setString(10, doctor.getSpecialtice());
        stm.setString(11, doctor.getID());

       Boolean isSaved=stm.executeUpdate()>0;
        if (isSaved){
            con.commit();
            return true;
        }else {
            con.rollback();
            return false;
        }
    }

    public Doctor getDoctor(String id) throws ClassNotFoundException, SQLException {
        Connection con = DBconnection.GetInstance().getConnection();
        String sql = "SELECT * FROM Doctor WHERE Doctor_ID=?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet set = stm.executeQuery();

        if (set.next()) {
            return new Doctor(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4),
                    set.getString(5),
                    set.getString(6),
                    set.getInt(7),
                    set.getString(8),
                    set.getString(9),
                    set.getString(10),
                    set.getString(11)

            );
        }
        return null;
    }


    public boolean deleteDoctor(String id) throws ClassNotFoundException, SQLException{
        Connection con =DBconnection.GetInstance().getConnection();
        con.setAutoCommit(false);
        PreparedStatement pst=con.prepareStatement("DELETE FROM Doctor WHERE Doctor_ID='"+id+"'");
        boolean isSave=pst.executeUpdate()>0;
        if (isSave){
            con.commit();
            return true;
        }else {
            con.rollback();
            return false;
        }
    }

}
