package Medical_Center_Management_System.Controller;


import Medical_Center_Management_System.DBConnection.DBconnection;
import Medical_Center_Management_System.Modal.Employee;
import Medical_Center_Management_System.Modal.Patient;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeController {

    public static void EmployeeData(ObservableList list) throws SQLException, ClassNotFoundException {
        Connection con = DBconnection.GetInstance().getConnection();
        ResultSet rst = con.createStatement().executeQuery("select * from Employee");

        while (rst.next()){
            list.add(new Employee(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4),
                            rst.getString(5),
                            rst.getString(6),
                            rst.getDouble(7),
                            rst.getInt(8),
                            rst.getString(9),
                            rst.getString(10),
                            rst.getString(11)


                    )
            );
        }

    }

    public boolean saveEmployee(Employee employee) throws SQLException, ClassNotFoundException {

        Connection con =DBconnection.GetInstance().getConnection();
        String sql = "INSERT INTO Employee VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, employee.getID());
        stm.setString(2, employee.getFristName());
        stm.setString(3, employee.getSecndName());
        stm.setString(4, employee.getNIC());
        stm.setString(5, employee.getAddress());
        stm.setString(6, employee.getRole());
        stm.setDouble(7, employee.getSalary());
        stm.setInt(8, employee.getAge());
        stm.setString(9, employee.getGender());
        stm.setString(10, employee.getDOB());
        stm.setString(11, employee.getPhoneNumber());

        return stm.executeUpdate() > 0;
    }

    public Employee getEmployee(String id) throws ClassNotFoundException, SQLException {
        Connection con = DBconnection.GetInstance().getConnection();
        String sql = "SELECT * FROM  Employee WHERE Employee_ID=?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet set = stm.executeQuery();

        if (set.next()) {
            return new Employee(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4),
                    set.getString(5),
                    set.getString(6),
                    set.getDouble(7),
                    set.getInt(8),
                    set.getString(9),
                    set.getString(10),
                    set.getString(11)

            );
        }
        return null;
    }

    public boolean updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        Connection con =DBconnection.GetInstance().getConnection();
        String sql = "UPDATE  Employee SET  FirstName=?, SecondName=?, NIC=?, Address=?,Role=?,Salary=?, AGE=?, Gender=?, DOB=?, Phone_No=? WHERE Employee_ID=?";
        PreparedStatement stm = con.prepareStatement(sql);


        stm.setString(1, employee.getFristName());
        stm.setString(2, employee.getSecndName());
        stm.setString(3, employee.getNIC());
        stm.setString(4, employee.getAddress());
        stm.setString(5, employee.getRole());
        stm.setDouble(6, employee.getSalary());
        stm.setInt(7, employee.getAge());
        stm.setString(8, employee.getGender());
        stm.setString(9, employee.getDOB());
        stm.setString(10, employee.getPhoneNumber());
        stm.setString(11, employee.getID());

        return stm.executeUpdate() > 0;
    }

    public boolean deleteEmployee(String id) throws ClassNotFoundException, SQLException{
        return DBconnection.GetInstance().
                getConnection().
                prepareStatement("DELETE FROM Employee WHERE Employee_ID='"+id+"'")
                .executeUpdate()>0;
    }



}
