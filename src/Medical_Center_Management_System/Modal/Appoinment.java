package Medical_Center_Management_System.Modal;

public class Appoinment {

    private String Ano;
    private String DID;
    private String PID;
    private String Date;
    private String Time;

    public Appoinment(String ano, String DID, String PID, String date, String time) {
        Ano = ano;
        this.DID = DID;
        this.PID = PID;
        Date = date;
        Time = time;
    }

    public String getAno() {
        return Ano;
    }

    public void setAno(String ano) {
        Ano = ano;
    }

    public String getDID() {
        return DID;
    }

    public void setDID(String DID) {
        this.DID = DID;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    @Override
    public String toString() {
        return "Appoinment{" +
                "Ano='" + Ano + '\'' +
                ", DID='" + DID + '\'' +
                ", PID='" + PID + '\'' +
                ", Date='" + Date + '\'' +
                ", Time='" + Time + '\'' +
                '}';
    }
}
