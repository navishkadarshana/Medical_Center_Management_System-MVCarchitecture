package Medical_Center_Management_System.Controller;

import Medical_Center_Management_System.DBConnection.DBconnection;
import Medical_Center_Management_System.Modal.Doctor;
import Medical_Center_Management_System.Modal.Patient;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientController {

    public static void PatientData(ObservableList list) throws SQLException, ClassNotFoundException {
        Connection con = DBconnection.GetInstance().getConnection();
        ResultSet rst = con.createStatement().executeQuery("select * from Pationt");

        while (rst.next()){
            list.add(
                    new Patient(
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
                            rst.getString(11),
                            rst.getString(12)

                    )
            );
        }

    }

    public boolean savePatient(Patient patient) throws SQLException, ClassNotFoundException {

        Connection con =DBconnection.GetInstance().getConnection();
        String sql = "INSERT INTO Pationt VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, patient.getID());
        stm.setString(2, patient.getTitle());
        stm.setString(3, patient.getFristName());
        stm.setString(4, patient.getSecndName());
        stm.setString(5, patient.getNIC());
        stm.setString(6, patient.getAddress());
        stm.setInt(7, patient.getAge());
        stm.setString(8, patient.getGender());
        stm.setString(9, patient.getDOB());
        stm.setString(10, patient.getPhoneNumber());
        stm.setString(11,patient.getDisease());
        stm.setString(12, patient.getBlood_Grup());

        return stm.executeUpdate() > 0;
    }

    public Patient getPatient(String id) throws ClassNotFoundException, SQLException {
        Connection con = DBconnection.GetInstance().getConnection();
        String sql = "SELECT * FROM  Pationt WHERE Pationt_ID=?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet set = stm.executeQuery();

        if (set.next()) {
            return new Patient(
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
                    set.getString(11),
                    set.getString(12)

            );
        }
        return null;
    }

    public boolean updatePatient(Patient patient) throws SQLException, ClassNotFoundException {
        Connection con =DBconnection.GetInstance().getConnection();
        String sql = "UPDATE  Pationt SET PationtTitle=?, PFirstName=?, PSecondName=?, NIC=?, Address=?, AGE=?, Gender=?, DOB=?, Phone_No=?, Disease=?, Blood_Grup=? WHERE Pationt_ID=?";
        PreparedStatement stm = con.prepareStatement(sql);

        stm.setString(1, patient.getTitle());
        stm.setString(2, patient.getFristName());
        stm.setString(3, patient.getSecndName());
        stm.setString(4, patient.getNIC());
        stm.setString(5, patient.getAddress());
        stm.setInt(6, patient.getAge());
        stm.setString(7, patient.getGender());
        stm.setString(8, patient.getDOB());
        stm.setString(9, patient.getPhoneNumber());
        stm.setString(10, patient.getDisease());
        stm.setString(11, patient.getBlood_Grup());
        stm.setString(12, patient.getID());

        return stm.executeUpdate() > 0;
    }

    public boolean deletePatient(String id) throws ClassNotFoundException, SQLException{
        return DBconnection.GetInstance().
                getConnection().
                prepareStatement("DELETE FROM Pationt WHERE Pationt_ID='"+id+"'")
                .executeUpdate()>0;
    }

}
