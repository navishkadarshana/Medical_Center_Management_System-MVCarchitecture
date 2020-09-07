package Medical_Center_Management_System.Controller;

import Medical_Center_Management_System.DBConnection.DBconnection;
import Medical_Center_Management_System.Modal.Appoinment;
import Medical_Center_Management_System.Modal.Medicine;
import Medical_Center_Management_System.Modal.Payment;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentController {
    public static void PaymentData(ObservableList list) throws SQLException, ClassNotFoundException {
        Connection con = DBconnection.GetInstance().getConnection();
        ResultSet rst = con.createStatement().executeQuery("SELECT Ref_No,PFirstName,Hospital_Charges,TName,Bill_date,Total FROM PaymentDetails INNER JOIN Pationt ON Pationt.Pationt_ID=PaymentDetails .Pationt_ID\n" +
                "INNER JOIN Test ON Test.Test_ID=PaymentDetails.Test_ID;\n");

        while (rst.next()){
            list.add(
                    new Payment(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getDouble(3),
                            rst.getString(4),
                            rst.getString(5),
                            rst.getDouble(6)




                    )
            );
        }

    }

    public boolean deletePayments(String id) throws ClassNotFoundException, SQLException{
        return DBconnection.GetInstance().
                getConnection().
                prepareStatement("DELETE FROM PaymentDetails WHERE Ref_No='"+id+"'")
                .executeUpdate()>0;
    }

    public Payment getpayment(String id) throws ClassNotFoundException, SQLException {
        Connection con = DBconnection.GetInstance().getConnection();
        String sql = "SELECT * FROM PaymentDetails WHERE Ref_No=?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet set = stm.executeQuery();

        if (set.next()) {
            return new Payment(
                    set.getString(1),
                    set.getString(2),
                    set.getDouble(3),
                    set.getString(4),
                    set.getString(5),
                    set.getDouble(6)
            );
        }
        return null;
    }

    public boolean savePayment(Payment payment) throws SQLException, ClassNotFoundException {

        Connection con =DBconnection.GetInstance().getConnection();
        String sql = "INSERT INTO PaymentDetails VALUES(?,?,?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1,payment.getBillNo() );
        stm.setString(2,payment.getPID() );
        stm.setDouble(3,payment.getHospital_Charges() );
        stm.setString(4,payment.getTestID() );
        stm.setString(5, payment.getBillDate());
        stm.setDouble(6,payment.getTotal() );



        return stm.executeUpdate() > 0;
    }

    public boolean paymentUpdate(Payment payment) throws SQLException, ClassNotFoundException {
        Connection con =DBconnection.GetInstance().getConnection();
        String sql = "UPDATE PaymentDetails SET Pationt_ID=?,Hospital_Charges=?,Test_ID=?,Bill_date=? ,Total=? WHERE Ref_No=?";
        PreparedStatement stm = con.prepareStatement(sql);

        stm.setString(1, payment.getPID());
        stm.setDouble(2, payment.getHospital_Charges());
        stm.setString(3, payment.getTestID());
        stm.setString(4, payment.getBillDate());
        stm.setDouble(5, payment.getTotal());
        stm.setString(6, payment.getBillNo());

        return stm.executeUpdate() > 0;
    }




}
