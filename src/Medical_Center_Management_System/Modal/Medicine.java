package Medical_Center_Management_System.Modal;

public class Medicine {

    private String Reference_No;
    private String Suplier_ID;
    private String Name;
    private Double unitPrice;
    private String side_effect;
    private String Quntity_Ac;
    private String ExpirDate;
    private String Dose;
    private String DaliyDose;
    private String Storage;


    public Medicine(String reference_No, String suplier_ID, String name, Double unitPrice, String side_effect, String quntity_Ac, String expirDate, String dose, String daliyDose, String storage) {
        Reference_No = reference_No;
        Suplier_ID = suplier_ID;
        Name = name;
        this.unitPrice = unitPrice;
        this.side_effect = side_effect;
        Quntity_Ac = quntity_Ac;
        ExpirDate = expirDate;
        Dose = dose;
        DaliyDose = daliyDose;
        Storage = storage;
    }

    public String getReference_No() {
        return Reference_No;
    }

    public void setReference_No(String reference_No) {
        Reference_No = reference_No;
    }

    public String getSuplier_ID() {
        return Suplier_ID;
    }

    public void setSuplier_ID(String suplier_ID) {
        Suplier_ID = suplier_ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getSide_effect() {
        return side_effect;
    }

    public void setSide_effect(String side_effect) {
        this.side_effect = side_effect;
    }

    public String getQuntity_Ac() {
        return Quntity_Ac;
    }

    public void setQuntity_Ac(String quntity_Ac) {
        Quntity_Ac = quntity_Ac;
    }

    public String getExpirDate() {
        return ExpirDate;
    }

    public void setExpirDate(String expirDate) {
        ExpirDate = expirDate;
    }

    public String getDose() {
        return Dose;
    }

    public void setDose(String dose) {
        Dose = dose;
    }

    public String getDaliyDose() {
        return DaliyDose;
    }

    public void setDaliyDose(String daliyDose) {
        DaliyDose = daliyDose;
    }

    public String getStorage() {
        return Storage;
    }

    public void setStorage(String storage) {
        Storage = storage;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "Reference_No='" + Reference_No + '\'' +
                ", Suplier_ID='" + Suplier_ID + '\'' +
                ", Name='" + Name + '\'' +
                ", unitPrice=" + unitPrice +
                ", side_effect='" + side_effect + '\'' +
                ", Quntity_Ac='" + Quntity_Ac + '\'' +
                ", ExpirDate='" + ExpirDate + '\'' +
                ", Dose='" + Dose + '\'' +
                ", DaliyDose='" + DaliyDose + '\'' +
                ", Storage='" + Storage + '\'' +
                '}';
    }
}
