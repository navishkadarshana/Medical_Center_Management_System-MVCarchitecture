package Medical_Center_Management_System.Modal;

public class Payment {

    private  String BillNo;
    private  String PID;
    private double Hospital_Charges;
    private  String TestID;
    private  String BillDate;
    private  double Total;

    public Payment(String billNo, String PID, double hospital_Charges, String testID, String billDate, double total) {
        BillNo = billNo;
        this.PID = PID;
        Hospital_Charges = hospital_Charges;
        TestID = testID;
        BillDate = billDate;
        Total = total;
    }

    public String getBillNo() {
        return BillNo;
    }

    public void setBillNo(String billNo) {
        BillNo = billNo;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public double getHospital_Charges() {
        return Hospital_Charges;
    }

    public void setHospital_Charges(double hospital_Charges) {
        Hospital_Charges = hospital_Charges;
    }

    public String getTestID() {
        return TestID;
    }

    public void setTestID(String testID) {
        TestID = testID;
    }

    public String getBillDate() {
        return BillDate;
    }

    public void setBillDate(String billDate) {
        BillDate = billDate;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "BillNo='" + BillNo + '\'' +
                ", PID='" + PID + '\'' +
                ", Hospital_Charges=" + Hospital_Charges +
                ", TestID='" + TestID + '\'' +
                ", BillDate='" + BillDate + '\'' +
                ", Total=" + Total +
                '}';
    }
}
