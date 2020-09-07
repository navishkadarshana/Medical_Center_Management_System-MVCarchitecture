package Medical_Center_Management_System.Controller.FXController;

import Medical_Center_Management_System.Controller.*;
import Medical_Center_Management_System.DBConnection.DBconnection;
import Medical_Center_Management_System.Modal.*;
import com.jfoenix.controls.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResepDashBordController implements Initializable {

    ObservableList<Doctor> data = FXCollections.observableArrayList();
    ObservableList<Patient> PatientData = FXCollections.observableArrayList();
    ObservableList<Employee> EmployeeData = FXCollections.observableArrayList();
    ObservableList<Medicine> MedicineData = FXCollections.observableArrayList();
    ObservableList<Suplier> SupplierData= FXCollections.observableArrayList();
    ObservableList<Test> TestData= FXCollections.observableArrayList();
    ObservableList<UserLogin> UserData= FXCollections.observableArrayList();
    ObservableList<Appoinment> AppoinmentData= FXCollections.observableArrayList();
    ObservableList<Payment> PaymentData= FXCollections.observableArrayList();



    Connection con = DBconnection.GetInstance().getConnection();
    PreparedStatement pst = null;
    ResultSet resultSet = null;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private JFXButton ButtonDashbord;

    @FXML
    private JFXButton ButtonDoctors;

    @FXML
    private JFXButton ButtonPatient;

    @FXML
    private JFXButton ButtonEmployee;

    @FXML
    private JFXButton ButtonAppoinment;

    @FXML
    private JFXButton ButtonMedicine;

    @FXML
    private JFXButton ButtonTest;

    @FXML
    private JFXButton ButtonSupplier;

    @FXML
    private JFXButton ButtonPaypal;

    @FXML
    private JFXButton ButtonLogout;

    @FXML
    private ImageView CloseButton;

    @FXML
    private Label LocationLable;

    @FXML
    private Label MainLable;

    @FXML
    private AnchorPane DoctorViewPane;

    @FXML
    private TableView<Doctor> TableView;

    @FXML
    private TableColumn<Doctor, String> ColID;

    @FXML
    private TableColumn<Doctor, String> ColTitel;

    @FXML
    private TableColumn<Doctor, String> ColFname;

    @FXML
    private TableColumn<Doctor, String> ColLname;

    @FXML
    private TableColumn<Doctor, String> ColNIC;

    @FXML
    private TableColumn<Doctor, String> ColAddress;

    @FXML
    private TableColumn<Doctor, Integer> ColAGE;

    @FXML
    private TableColumn<Doctor, String> ColGender;

    @FXML
    private TableColumn<Doctor, String> ColDOB;

    @FXML
    private TableColumn<Doctor, String> ColPhoneNo;

    @FXML
    private TableColumn<Doctor, String> ColSpe;


    @FXML
    private JFXTextField SearchDoctors;

    @FXML
    private AnchorPane PatientsViewPane;

    @FXML
    private TableView<Patient> TableViewPatient;

    @FXML
    private TableColumn<Patient, String> ColidP;

    @FXML
    private TableColumn<Patient, String> colTitelP;

    @FXML
    private TableColumn<Patient, String> ColFnameP;

    @FXML
    private TableColumn<Patient, String> ColLnameP;

    @FXML
    private TableColumn<Patient, String> ColNICP;

    @FXML
    private TableColumn<Patient, String> ColAddressP;

    @FXML
    private TableColumn<Patient, String> ColAGEP;

    @FXML
    private TableColumn<Patient, String> ColGenderP;

    @FXML
    private TableColumn<Patient, String> ColDOBP;

    @FXML
    private TableColumn<Patient, String> ColPhoneNoP;

    @FXML
    private TableColumn<Patient, String> ColDiseseP;

    @FXML
    private TableColumn<Patient, String> ColBloodGrupP;

    @FXML
    private JFXTextField SearchPatient;

    @FXML
    private JFXButton AddPatientButton;

    @FXML
    private AnchorPane PatientUpdatePane;

    @FXML
    private JFXTextField PtxtID;

    @FXML
    private JFXComboBox<String> PcomboTile;

    @FXML
    private JFXTextField PtxtFName;

    @FXML
    private JFXTextField PtxtSName;

    @FXML
    private JFXTextField PtxtNIC;

    @FXML
    private JFXTextArea PtxtAdddress1;

    @FXML
    private JFXTextField PtxtAGE;

    @FXML
    private JFXComboBox<String> PcomboGender;

    @FXML
    private JFXTextField PtxtPhoneno;

    @FXML
    private JFXComboBox<String> PcomboBloodgroup;

    @FXML
    private JFXDatePicker PdateDOB;

    @FXML
    private JFXButton updatePatientButton;

    @FXML
    private JFXButton SavePatientButton;

    @FXML
    private JFXButton PCanselButton;

    @FXML
    private JFXTextArea PtxtDisease;

    @FXML
    private AnchorPane EmoloyeeViewPane;

    @FXML
    private TableView<Employee> TableViewEmployee;

    @FXML
    private TableColumn<Employee, String> EColid;

    @FXML
    private TableColumn<Employee, String> EcolTitel;

    @FXML
    private TableColumn<Employee, String> EColFname;

    @FXML
    private TableColumn<Employee, String> EColLname;

    @FXML
    private TableColumn<Employee, String> EColNIC;

    @FXML
    private TableColumn<Employee, String> EColAddress;

    @FXML
    private TableColumn<Employee, String> EColRole;

    @FXML
    private TableColumn<Employee, Double> EColSalary;

    @FXML
    private TableColumn<Employee, Integer> EColAGE;

    @FXML
    private TableColumn<Employee, String> EColGender;

    @FXML
    private TableColumn<Employee, String> EColDOB;

    @FXML
    private TableColumn<Employee, String> EColPhoneNo;
    @FXML
    private JFXTextField SearchEmpolyee;

    @FXML
    private AnchorPane MedicineViewPane;

    @FXML
    private JFXTextField SearchMedicine;

    @FXML
    private TableView<Medicine> TableViewMedicine;

    @FXML
    private TableColumn<Medicine, String> McolRefNo;

    @FXML
    private TableColumn<Medicine, String> McolSupID;

    @FXML
    private TableColumn<Medicine, String> Mcolname;

    @FXML
    private TableColumn<Medicine, String> McolUnitprice;

    @FXML
    private TableColumn<Medicine, String> McolSIdeEffect;

    @FXML
    private TableColumn<Medicine, String> McolQunAc;

    @FXML
    private TableColumn<Medicine, String> McolExpireDate;

    @FXML
    private TableColumn<Medicine, String> McolDose;

    @FXML
    private TableColumn<Medicine, String> McolDaliyDose;

    @FXML
    private TableColumn<Medicine, String> McolStorge;

    @FXML
    private AnchorPane AppoinmentViewPane;

    @FXML
    private TableView<Appoinment> TableViewAppoinment;

    @FXML
    private TableColumn<Appoinment, String> AcolID;

    @FXML
    private TableColumn<Appoinment, String> AcolDName;

    @FXML
    private TableColumn<Appoinment, String> AcolPname;

    @FXML
    private TableColumn<Appoinment, String> AcolDate;

    @FXML
    private TableColumn<Appoinment, String> AcolTime;

    @FXML
    private JFXTextField SearchAppoinment;

    @FXML
    private JFXTextField AtxtID;

    @FXML
    private JFXTextField AtxtDID;

    @FXML
    private JFXTextField AtxtPname;

    @FXML
    private JFXTextField AtxtPID;

    @FXML
    private JFXDatePicker AdateSetDate;

    @FXML
    private JFXComboBox<String> AcomTime;

    @FXML
    private JFXTextField AtxtDname;

    @FXML
    private JFXButton updateAppoinmentButton;

    @FXML
    private JFXButton SaveAppoinmentButton;

    @FXML
    private JFXButton ACanselButton;


    @FXML
    private AnchorPane PaymentViewPane;

    @FXML
    private TableView<Payment> TableViewPayment;

    @FXML
    private TableColumn<Payment, String> PcolID;

    @FXML
    private TableColumn<Payment, String> PcolName;

    @FXML
    private TableColumn<Payment, Double> Pcolcharge;


    @FXML
    private TableColumn<Payment, String> PcolTname;

    @FXML
    private TableColumn<Payment, String> Pcoldate;

    @FXML
    private TableColumn<Payment, Double> PcolTotal;


    @FXML
    private JFXTextField SearchPayments;


    @FXML
    private JFXButton updatePaymentButton;

    @FXML
    private JFXButton SavePaymentButton;

    @FXML
    private JFXTextField BtxtBillNo;

    @FXML
    private JFXTextField BtxtName;

    @FXML
    private JFXTextField BtxtPID;

    @FXML
    private JFXTextField BtxtCharges;


    @FXML
    private JFXDatePicker Btxtdate;

    @FXML
    private JFXTextField BtxtTID;

    @FXML
    private JFXComboBox<String> BcomTextName;

    @FXML
    private JFXTextField BtxtTAmount;


    @FXML
    private JFXTextField BtxtTotal;

    @FXML
    private JFXButton BCanselButton;

    @FXML
    private AnchorPane DashBordViewPane;

    @FXML
    private Label Doctorcount;

    @FXML
    private Label EmployeeCount;

    @FXML
    private Label PatientCount;

    @FXML
    private Label SupplierCount;

    @FXML
    private AnchorPane SupplierViewPane;

    @FXML
    private TableView<Suplier> TableViewSupplier;

    @FXML
    private TableColumn<Suplier, String> ScolSupID;

    @FXML
    private TableColumn<Suplier, Suplier> Scolname;

    @FXML
    private TableColumn<Suplier, Suplier> ScolAddress;

    @FXML
    private TableColumn<Suplier, Suplier> ScolPhoneNo;

    @FXML
    private TableColumn<Suplier, Suplier> ScolCompaniName;

    @FXML
    private JFXTextField SearchSupplier;

    @FXML
    private JFXTextField StxtID;

    @FXML
    private JFXTextField StxtName;

    @FXML
    private JFXTextField StxtAddress;

    @FXML
    private JFXTextField StxtPhoneno;

    @FXML
    private JFXTextField StxtCompaniName;

    @FXML
    private AnchorPane TestViewPane;

    @FXML
    private TableView<Test> TableViewTest;

    @FXML
    private TableColumn<Test, String> TcolID;

    @FXML
    private TableColumn<Test, String> Tcolname;

    @FXML
    private TableColumn<Test, Double> TcolAmount;

    @FXML
    private JFXTextField SearchTest;

    @FXML
    private JFXTextField TtxtID;

    @FXML
    private JFXTextField TtxtName;

    @FXML
    private JFXTextField TtxtAmount;



    @FXML
    private Label TimeAndDate;

    @FXML
    private Label NowDate;

    @FXML
    private Label Day;

    public ResepDashBordController() throws SQLException, ClassNotFoundException {
    }

    @FXML
    void AddDoctor(MouseEvent event) {

        if (event.getSource() == AddPatientButton) {
            PatientUpdatePane.toFront();
            SavePatientButton.toFront();

        }
    }

    @FXML
    void ButtonLogOut(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../View/AdminLoginPanel.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage;
            stage = (Stage) rootPane.getScene().getWindow();
            stage.resizableProperty().setValue(false);
            stage.setTitle("Admin Login");
            stage.setScene(new Scene(root1));
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            System.out.println("Can't load new Window");
        }

    }

    @FXML
    void CancelButton(MouseEvent event) {


        if (event.getSource() == PCanselButton) {
            PatientsViewPane.toFront();
            clearFieldsPatient();

        }else if (event.getSource()==ACanselButton){
            SaveAppoinmentButton.toFront();
            clearFieldsAppoinment();

        } else if (event.getSource()==BCanselButton){
        SavePaymentButton.toFront();
        clearFieldsPayments();
    }


    }

    @FXML
    void CloseDashBoard(MouseEvent event) {

        if (event.getSource() == CloseButton) {
            System.exit(0);
        }

    }




    @FXML
    void SaveButtons(MouseEvent event) throws SQLException, ClassNotFoundException {

        if (event.getSource() == SavePatientButton) {

            String id = PtxtID.getText();
            String titel = PcomboTile.getSelectionModel().getSelectedItem().toString();
            String FirstName = PtxtFName.getText();
            String SecondName = PtxtSName.getText();
            String NIC = PtxtNIC.getText();
            String Address = PtxtAdddress1.getText();
            int AGE = Integer.parseInt(PtxtAGE.getText());
            String Gender = PcomboGender.getSelectionModel().getSelectedItem().toString();
            String DOB = PdateDOB.getEditor().getText();
            String PhoneNo = PtxtPhoneno.getText();
            String Dise = PtxtDisease.getText();
            String blood_grup = PcomboBloodgroup.getSelectionModel().getSelectedItem().toString();


            boolean isSaved =
                    new PatientController().
                            savePatient(new Patient(id, titel, FirstName, SecondName, NIC, Address, AGE, Gender, DOB, PhoneNo, Dise, blood_grup));

            if (isSaved) {
                clearFieldsPatient();
                Image img = new Image("Medical_Center_Management_System/Image/checkmark.png");
                Notifications notificationsbar = Notifications.create()
                        .title("Notification")
                        .graphic(new ImageView(img))
                        .text("Patient has been added!").position(Pos.CENTER);
                notificationsbar.show();

            } else {
                Image img = new Image("Medical_Center_Management_System/Image/worng.png");
                Notifications notificationsbar1 = Notifications.create()
                        .title("Notification")
                        .graphic(new ImageView(img))
                        .text("Something went wrong..!Please try again");
                notificationsbar1.show();

            }

        } else if (event.getSource()==SaveAppoinmentButton){

        String Aid=AtxtID.getText();
        String Did=AtxtDID.getText();
        String PID=AtxtPID.getText();
        String time=AdateSetDate.getEditor().getText();
        String date=AcomTime.getSelectionModel().getSelectedItem().toString();
        String Pname=AtxtPname.getText();
        String Dname=AtxtDname.getText();


        boolean isSaved=
                new Appoinment_Controller().
                        saveAppoinment(new Appoinment(Aid,Did,PID,time,date));


        if (isSaved) {
            RefreshTableAppoinment();
            clearFieldsAppoinment();
            Image img=new Image("Medical_Center_Management_System/Image/checkmark.png");
            Notifications notificationsbar= Notifications.create()
                    .title("Notification")
                    .graphic(new ImageView(img))
                    .text("PATIENT " + Pname + " Appointmented with DOCTOR  " + Dname+" On  "+date+" At  "+time).position(Pos.CENTER);
            notificationsbar.show();

        }else{
            Image img=new Image("Medical_Center_Management_System/Image/worng.png");
            Notifications notificationsbar1= Notifications.create()
                    .title("Notification")
                    .graphic(new ImageView(img))
                    .text("Something went wrong..!Please try again");
            notificationsbar1.show();

        }
    }else if (event.getSource()==SavePaymentButton){

            String BillNo=BtxtBillNo.getText();
            String PID=BtxtPID.getText();
            Double Hospital_Charges= Double.valueOf(BtxtCharges.getText());
            String TID=BtxtTID.getText();
            String Billdate=Btxtdate.getEditor().getText();
            Double Total= Double.valueOf(BtxtTotal.getText());


            boolean isSaved=
                    new PaymentController().
                            savePayment(new Payment(BillNo,PID,Hospital_Charges,TID,Billdate,Total));


            if (isSaved) {
                RefreshTablePayment();
                clearFieldsAppoinment();
                Image img=new Image("Medical_Center_Management_System/Image/checkmark.png");
                Notifications notificationsbar= Notifications.create()
                        .title("Notification")
                        .graphic(new ImageView(img))
                        .text("Bill has been added!").position(Pos.CENTER);
                notificationsbar.show();

            }else{
                Image img=new Image("Medical_Center_Management_System/Image/worng.png");
                Notifications notificationsbar1= Notifications.create()
                        .title("Notification")
                        .graphic(new ImageView(img))
                        .text("Something went wrong..!Please try again");
                notificationsbar1.show();

            }


        }

}



    @FXML
    void ShowOnClicks(MouseEvent event) throws SQLException {

        if (event.getSource()==TableViewSupplier){


            Suplier suplier=(Suplier) TableViewSupplier.getSelectionModel().getSelectedItem();
            String sql="SELECT * FROM Suplier";
            pst=con.prepareStatement(sql);

            StxtID.setText(suplier.getId());
            StxtName.setText(suplier.getName());
            StxtAddress.setText(suplier.getAddress());
            StxtPhoneno.setText(suplier.getPhoneNum());
            StxtCompaniName.setText(suplier.getCompani_Name());

            pst.close();


        }else if (event.getSource()==TableViewTest){

            Test test=(Test) TableViewTest.getSelectionModel().getSelectedItem();
            String sql="SELECT * FROM Test";
            pst=con.prepareStatement(sql);

            TtxtID.setText(test.getId());
            TtxtName.setText(test.getName());
            TtxtAmount.setText(String.valueOf(test.getAmount()));

            pst.close();


        }

    }

    @FXML
    void UpdateButtons(MouseEvent event) throws SQLException, ClassNotFoundException {

        if (event.getSource() == updatePatientButton) {
            clearFieldsPatient();


            Patient patient = new Patient(PtxtID.getText(),
                    PcomboTile.getSelectionModel().getSelectedItem().toString(),
                    PtxtFName.getText(),
                    PtxtSName.getText(),
                    PtxtNIC.getText(),
                    PtxtAdddress1.getText(),
                    Integer.parseInt(PtxtAGE.getText()),
                    PcomboGender.getSelectionModel().getSelectedItem().toString(),
                    PdateDOB.getEditor().getText(),
                    PtxtPhoneno.getText(),
                    PtxtDisease.getText(),
                    PcomboBloodgroup.getSelectionModel().getSelectedItem().toString()
            );

            boolean isUpdated = new PatientController().updatePatient(patient);
            if (isUpdated) {
                RefreshTablePatient();
                Image img = new Image("Medical_Center_Management_System/Image/UpdateNotifictionIcon.png");
                Notifications notificationsbar = Notifications.create()
                        .title("Notification")
                        .graphic(new ImageView(img))
                        .text("Patient has been Updated!").position(Pos.CENTER);
                notificationsbar.show();


            } else {

            }

        } else if (event.getSource()==updateAppoinmentButton){

            Appoinment appoinment=new Appoinment(
                    AtxtID.getText(),
                    AtxtDID.getText(),
                    AtxtPID.getText(),
                    AdateSetDate.getEditor().getText(),
                    AcomTime.getSelectionModel().getSelectedItem().toString()
            );

            boolean isUpdated=new Appoinment_Controller().AppoinmentUpdate(appoinment);
            if(isUpdated){
                System.out.println(appoinment);
                RefreshTableAppoinment();
                clearFieldsAppoinment();

                Image img=new Image("Medical_Center_Management_System/Image/UpdateNotifictionIcon.png");
                Notifications notificationsbar= Notifications.create()
                        .title("Notification")
                        .graphic(new ImageView(img))
                        .text("Patient has been Updated!").position(Pos.CENTER);
                notificationsbar.show();


            }else{

            }


        } else if (event.getSource()==updatePaymentButton){

            Payment payment =new Payment(

                    BtxtBillNo.getText(),
                    BtxtPID.getText(),
                    Double.parseDouble(BtxtCharges.getText()),
                    BtxtTID.getText(),
                    Btxtdate.getEditor().getText(),
                    Double.parseDouble(BtxtTotal.getText())

            );
            boolean isUpdated=new PaymentController().paymentUpdate(payment);
            if(isUpdated){
                RefreshTablePayment();
                clearFieldsAppoinment();

                Image img=new Image("Medical_Center_Management_System/Image/UpdateNotifictionIcon.png");
                Notifications notificationsbar= Notifications.create()
                        .title("Notification")
                        .graphic(new ImageView(img))
                        .text("Patient has been Updated!").position(Pos.CENTER);
                notificationsbar.show();


            }else{

            }


        }

    }

    @FXML
    void handleClick(ActionEvent event) {

        if (event.getSource() == ButtonDashbord) {
            LocationLable.setText("Medical Center Management System/Dashboard");
            MainLable.setText("Dashboard");
            DashBordViewPane.toFront();

        } else if (event.getSource() == ButtonDoctors) {
            LocationLable.setText("Medical Center Management System/Doctors");
            MainLable.setText("Doctors");
            DoctorViewPane.toFront();

        } else if (event.getSource() == ButtonPatient) {
            LocationLable.setText("Medical Center Management System/Patients");
            MainLable.setText("Patients");
            PatientsViewPane.toFront();


        } else if (event.getSource() == ButtonEmployee) {
            LocationLable.setText("Medical Center Management System/Employee");
            MainLable.setText("Employee");
            EmoloyeeViewPane.toFront();


        } else if (event.getSource() == ButtonAppoinment) {
            LocationLable.setText("Medical Center Management System/Appointment");
            MainLable.setText("Appointment");
            AppoinmentViewPane.toFront();


        } else if (event.getSource() == ButtonMedicine) {
            LocationLable.setText("Medical Center Management System/Medicine");
            MainLable.setText("Medicine");
            MedicineViewPane.toFront();

        } else if (event.getSource() == ButtonTest) {
            LocationLable.setText("Medical Center Management System/Test");
            MainLable.setText("Test");
            TestViewPane.toFront();

        } else if (event.getSource() == ButtonSupplier) {
            LocationLable.setText("Medical Center Management System/Supplier");
            MainLable.setText("Supplier");
            SupplierViewPane.toFront();

        } else if (event.getSource() == ButtonPaypal) {
            LocationLable.setText("Medical Center Management System/Payment");
            MainLable.setText("Payment");
            PaymentViewPane.toFront();

        }

    }

    ObservableList<String> titel = FXCollections.observableArrayList("Mr", "Miss", "Ms");
    ObservableList<String> Genderl = FXCollections.observableArrayList("Male", "Female", "Other");
    ObservableList<String> Spaec = FXCollections.observableArrayList("Cardiologist", "Dermatologists", "Neurologists", "Ophthhalmologists", "Pediatricians", "Phisiatrists",
            "Psychiatrists", "Urologist", "Sports Medicine Specialists", "Family/General Counceller", "Chest Specialist", "Urologist", "any");
    ObservableList<String> BloodGrup = FXCollections.observableArrayList("A+", "A-", "B+", "B-", "AB+", "AB-", "O-", "o+");
    ObservableList<String> role = FXCollections.observableArrayList("Receptionist", "Pharmacist", "Cashier", "Nurse", "Cleaners");
    ObservableList<String> time = FXCollections.observableArrayList("08.00AM-09.00PM", "09.00AM-10.00am", "10.00AM-11.00AM", "11.00AM-12.00PM", "12.00PM-01.00PM",
            "02.00PM-03.00PM", "03.00PM-04.00PM", "04.00PM-05.00PM","05.00PM-06.00PM","06.00PM-07.00PM","07.00AM-08.00PM");



    @Override
    public void initialize(URL location, ResourceBundle resources) {


        PcomboTile.setItems(titel);
        PcomboGender.setItems(Genderl);
        PcomboBloodgroup.setItems(BloodGrup);

        AcomTime.setItems(time);

        try {
            loadDoctor();
            loadPatient();
            loadEmployee();
            loadMedicine();
            loadSupplier();
            loadTest();
            loadAppoinment();
            loadPayments();
            CountDoctors();
            CountSupplier();
            CountPatient();
            CountEmployee();
            Date();
            DateT();
            FillComboBoxtext();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        SearchDoctor();
        SearchPatient();
        SearchEmployee();
        SearchMedicine();
        SearchSupplier();
        SearchTest();
        SearchTest();
        SearchAppoinments();
        DateTime();

    }


    public void loadDoctor() throws SQLException, ClassNotFoundException {

        DoctorController.DoctorData(data);
        ColID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        ColTitel.setCellValueFactory(new PropertyValueFactory<>("Title"));
        ColFname.setCellValueFactory(new PropertyValueFactory<>("fristName"));
        ColLname.setCellValueFactory(new PropertyValueFactory<>("secndName"));
        ColNIC.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        ColAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        ColAGE.setCellValueFactory(new PropertyValueFactory<>("age"));
        ColGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        ColDOB.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        ColPhoneNo.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        ColSpe.setCellValueFactory(new PropertyValueFactory<>("Specialtice"));


        TableView.setItems(data);


    }

    public void SearchDoctor() {
        FilteredList<Doctor> filteredList = new FilteredList<>(data, e -> true);

        SearchDoctors.setOnKeyReleased(e -> {
            SearchDoctors.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredList.setPredicate((Predicate<? super Doctor>) Doctor -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (Doctor.getID().contains(newValue)) {
                        return true;
                    } else if (Doctor.getFristName().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (Doctor.getSecndName().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }
                    return false;
                });
            });
            SortedList<Doctor> sortedList = new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(TableView.comparatorProperty());
            TableView.setItems(sortedList);
        });
    }

    //---------------------------------------------------------------------------------------------------

    public void loadPatient() throws SQLException, ClassNotFoundException {

        PatientController.PatientData(PatientData);
        ColidP.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colTitelP.setCellValueFactory(new PropertyValueFactory<>("Title"));
        ColFnameP.setCellValueFactory(new PropertyValueFactory<>("fristName"));
        ColLnameP.setCellValueFactory(new PropertyValueFactory<>("secndName"));
        ColNICP.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        ColAddressP.setCellValueFactory(new PropertyValueFactory<>("Address"));
        ColAGEP.setCellValueFactory(new PropertyValueFactory<>("age"));
        ColGenderP.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        ColDOBP.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        ColPhoneNoP.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        ColDiseseP.setCellValueFactory(new PropertyValueFactory<>("Disease"));
        ColBloodGrupP.setCellValueFactory(new PropertyValueFactory<>("Blood_Grup"));

        TableViewPatient.setItems(PatientData);
        addDeleteButtonToPatientTable();
        addUpdateButtonToPatientTable();


    }

    public void SearchPatient() {

        FilteredList<Patient> filteredList = new FilteredList<>(PatientData, e -> true);

        SearchPatient.setOnKeyReleased(e -> {
            SearchPatient.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredList.setPredicate((Predicate<? super Patient>) patient -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (patient.getID().contains(newValue)) {
                        return true;
                    } else if (patient.getFristName().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (patient.getSecndName().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }
                    return false;
                });
            });
            SortedList<Patient> sortedList = new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(TableViewPatient.comparatorProperty());
            TableViewPatient.setItems(sortedList);
        });
    }

    private void addDeleteButtonToPatientTable() {
        TableColumn<Patient, Void> colBtn = new TableColumn("Action");

        Callback<TableColumn<Patient, Void>, TableCell<Patient, Void>> cellFactory = new Callback<TableColumn<Patient, Void>, TableCell<Patient, Void>>() {

            @Override
            public TableCell<Patient, Void> call(final TableColumn<Patient, Void> param) {
                final TableCell<Patient, Void> cell = new TableCell<Patient, Void>() {

                    private final JFXButton btnDelete = new JFXButton("Delete");

                    {
                        btnDelete.setOnAction((ActionEvent event) -> {
                            String Pid = getTableView().getItems().get(getIndex()).getID();

                            DeleteParient(Pid);

                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btnDelete);

                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);
        TableViewPatient.getColumns().add(colBtn);

    }

    void DeleteParient(String Pid) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure to delete?");
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {

            try {
                if (new PatientController().deletePatient(Pid)) {
                    RefreshTablePatient();
                    Image img = new Image("Medical_Center_Management_System/Image/checkmark.png");
                    Notifications notificationsbar = Notifications.create()
                            .title("Notification")
                            .graphic(new ImageView(img))
                            .text("Deleted").position(Pos.CENTER);
                    notificationsbar.show();

                } else {
                    Image img = new Image("Medical_Center_Management_System/Image/worng.png");
                    Notifications notificationsbar = Notifications.create()
                            .title("Notification")
                            .graphic(new ImageView(img))
                            .text("Something went wrong..!Please try again").position(Pos.CENTER);
                    notificationsbar.show();
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DashBord_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private void addUpdateButtonToPatientTable() {
        TableColumn<Patient, Void> colBtn = new TableColumn("Update");

        Callback<TableColumn<Patient, Void>, TableCell<Patient, Void>> cellFactory = new Callback<TableColumn<Patient, Void>, TableCell<Patient, Void>>() {

            @Override
            public TableCell<Patient, Void> call(final TableColumn<Patient, Void> param) {
                final TableCell<Patient, Void> cell = new TableCell<Patient, Void>() {

                    private final JFXButton btnDelete = new JFXButton("Edit");

                    {
                        btnDelete.setOnAction((ActionEvent event) -> {
                            String Pid = getTableView().getItems().get(getIndex()).getID();
                            try {
                                FillTextFieldPatient(Pid);
                            } catch (SQLException | ClassNotFoundException throwables) {
                                throwables.printStackTrace();
                            }
                            PatientUpdatePane.toFront();
                            updatePatientButton.toFront();

                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btnDelete);

                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);
        TableViewPatient.getColumns().add(colBtn);

    }

    private void FillTextFieldPatient(String pid) throws SQLException, ClassNotFoundException {

        Patient patient =
                new PatientController().
                        getPatient(pid);

        if (patient != null) {


            PtxtID.setText(patient.getID());
            PcomboTile.getSelectionModel().select(patient.getTitle());
            PtxtFName.setText(patient.getFristName());
            PtxtSName.setText(patient.getSecndName());
            PtxtNIC.setText(patient.getNIC());
            PtxtAdddress1.setText(patient.getAddress());
            PtxtAGE.setText(String.valueOf(patient.getAge()));
            PcomboGender.getSelectionModel().select(patient.getGender());
            PdateDOB.getEditor().setText(patient.getDOB());
            PtxtPhoneno.setText(patient.getPhoneNumber());
            PtxtDisease.setText(patient.getDisease());
            PcomboBloodgroup.getSelectionModel().select(patient.getBlood_Grup());
        }

    }

    private void clearFieldsPatient() {
        PtxtID.clear();
        PcomboTile.getButtonCell().setText("");
        PcomboTile.getButtonCell().setItem(null);
        PtxtFName.clear();
        PtxtSName.clear();
        PtxtNIC.clear();
        PtxtAdddress1.clear();
        PtxtAGE.clear();
        PcomboGender.getButtonCell().setText("");
        PcomboGender.getButtonCell().setItem(null);
        PdateDOB.getEditor().clear();
        PtxtPhoneno.clear();
        PtxtDisease.clear();
        PcomboBloodgroup.getButtonCell().setText("");
        PcomboBloodgroup.getButtonCell().setItem(null);
    }

    public void RefreshTablePatient() throws SQLException, ClassNotFoundException {
        PatientData.clear();

        PatientController.PatientData(PatientData);
        ColidP.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colTitelP.setCellValueFactory(new PropertyValueFactory<>("Title"));
        ColFnameP.setCellValueFactory(new PropertyValueFactory<>("fristName"));
        ColLnameP.setCellValueFactory(new PropertyValueFactory<>("secndName"));
        ColNICP.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        ColAddressP.setCellValueFactory(new PropertyValueFactory<>("Address"));
        ColAGEP.setCellValueFactory(new PropertyValueFactory<>("age"));
        ColGenderP.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        ColDOBP.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        ColPhoneNoP.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        ColDiseseP.setCellValueFactory(new PropertyValueFactory<>("Disease"));
        ColBloodGrupP.setCellValueFactory(new PropertyValueFactory<>("Blood_Grup"));

    }


    //--------------------------------------------------------------------------------------------------------

    public void CountDoctors() throws SQLException {

        String query="select count(Doctor_ID) as count from doctor;";
        pst=con.prepareStatement(query);
        resultSet=pst.executeQuery();

        while (resultSet.next()){
            Doctorcount.setText(resultSet.getString("count"));
        }
        pst.close();
        resultSet.close();


    }

    public void CountPatient() throws SQLException {

        String query="select count(Pationt_ID) as count from  Pationt;";
        pst=con.prepareStatement(query);
        resultSet=pst.executeQuery();

        while (resultSet.next()){
            PatientCount.setText(resultSet.getString("count"));
        }


    }

    public void CountEmployee() throws SQLException {

        String query="select count(Employee_ID) as count from  Employee;";
        pst=con.prepareStatement(query);
        resultSet=pst.executeQuery();

        while (resultSet.next()){
            EmployeeCount.setText(resultSet.getString("count"));
        }


    }

    public void CountSupplier() throws SQLException {

        String query="select count(Suplier_ID) as count from  Suplier;";
        pst=con.prepareStatement(query);
        resultSet=pst.executeQuery();

        while (resultSet.next()){
            SupplierCount.setText(resultSet.getString("count"));
        }


    }

    public void Date() throws SQLException {

        String query="SELECT DAYNAME(now());";
        pst=con.prepareStatement(query);
        resultSet=pst.executeQuery();

        while (resultSet.next()){
            Day.setText(resultSet.getString("DAYNAME(now())"));
        }


    }

    public void DateT() throws SQLException {

        String query=" SELECT CURDATE();";
        pst=con.prepareStatement(query);
        resultSet=pst.executeQuery();

        while (resultSet.next()){
            NowDate.setText(resultSet.getString("CURDATE()"));
        }


    }

    private void DateTime(){

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            TimeAndDate.setText(currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();


    }

    //---------------------------------------------------------------------------------------------------------

    public void loadEmployee() throws SQLException, ClassNotFoundException {

        EmployeeController.EmployeeData(EmployeeData);
        EColid.setCellValueFactory(new PropertyValueFactory<>("ID"));
        EColFname.setCellValueFactory(new PropertyValueFactory<>("fristName"));
        EColLname.setCellValueFactory(new PropertyValueFactory<>("secndName"));
        EColNIC.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        EColAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        EColRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        EColSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        EColAGE.setCellValueFactory(new PropertyValueFactory<>("age"));
        EColGender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        EColDOB.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        EColPhoneNo.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));


        TableViewEmployee.setItems(EmployeeData);


    }

    public void SearchEmployee() {

        FilteredList<Employee> filteredList = new FilteredList<>(EmployeeData, e -> true);

        SearchEmpolyee.setOnKeyReleased(e -> {
            SearchEmpolyee.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredList.setPredicate((Predicate<? super Employee>) employee -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (employee.getID().contains(newValue)) {
                        return true;
                    } else if (employee.getFristName().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (employee.getSecndName().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }
                    return false;
                });
            });
            SortedList<Employee> sortedList = new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(TableViewEmployee.comparatorProperty());
            TableViewEmployee.setItems(sortedList);
        });
    }

    //---------------------------------------------------------------------------------------------------------

    public void loadMedicine() throws SQLException, ClassNotFoundException {

        MedicineController.MedicineData(MedicineData);
        McolRefNo.setCellValueFactory(new PropertyValueFactory<>("Reference_No"));
        McolSupID.setCellValueFactory(new PropertyValueFactory<>("Suplier_ID"));
        Mcolname.setCellValueFactory(new PropertyValueFactory<>("Name"));
        McolUnitprice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        McolSIdeEffect.setCellValueFactory(new PropertyValueFactory<>("side_effect"));
        McolQunAc.setCellValueFactory(new PropertyValueFactory<>("Quntity_Ac"));
        McolExpireDate.setCellValueFactory(new PropertyValueFactory<>("ExpirDate"));
        McolDose.setCellValueFactory(new PropertyValueFactory<>("Dose"));
        McolDaliyDose.setCellValueFactory(new PropertyValueFactory<>("DaliyDose"));
        McolStorge.setCellValueFactory(new PropertyValueFactory<>("Storage"));


        TableViewMedicine.setItems(MedicineData);



    }

    public void SearchMedicine() {

        FilteredList<Medicine> filteredList = new FilteredList<>(MedicineData, e -> true);

        SearchMedicine.setOnKeyReleased(e -> {
            SearchMedicine.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredList.setPredicate((Predicate<? super Medicine>) medicine -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (medicine.getReference_No().contains(newValue)) {
                        return true;
                    } else if (medicine.getName().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (medicine.getSuplier_ID().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }
                    return false;
                });
            });
            SortedList<Medicine> sortedList = new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(TableViewMedicine.comparatorProperty());
            TableViewMedicine.setItems(sortedList);
        });
    }

    //------------------------------------------------------------------------------------------------------------

    public void loadSupplier() throws SQLException, ClassNotFoundException {

        SupplierController.SuplierData(SupplierData);
        ScolSupID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Scolname.setCellValueFactory(new PropertyValueFactory<>("name"));
        ScolAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        ScolPhoneNo.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));
        ScolCompaniName.setCellValueFactory(new PropertyValueFactory<>("Compani_Name"));


        TableViewSupplier.setItems(SupplierData);


    }

    public void SearchSupplier(){
        FilteredList<Suplier> filteredList=new FilteredList<>(SupplierData, e ->true );
        SearchSupplier.setOnKeyReleased(e ->{
            SearchSupplier.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredList.setPredicate((Predicate<? super Suplier>) suplier ->{
                    if(newValue==null || newValue.isEmpty()){
                        return true;
                    }
                    String lowerCaseFilter=newValue.toLowerCase();
                    if (suplier.getId().contains(newValue)){
                        return true;
                    }else if (suplier.getName().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    }
                    return false;
                });
            });
            SortedList<Suplier> sortedList=new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(TableViewSupplier.comparatorProperty());
            TableViewSupplier.setItems(sortedList);
        });
    }

    //---------------------------------------------------------------------------------------------------------------

    public void loadTest() throws SQLException, ClassNotFoundException {

        TestController.TestData(TestData);
        TcolID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Tcolname.setCellValueFactory(new PropertyValueFactory<>("name"));
        TcolAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        TableViewTest.setItems(TestData);
    }

    public void SearchTest(){
            FilteredList<Test> filteredList=new FilteredList<>(TestData, e ->true );
            SearchTest.setOnKeyReleased(e ->{
                SearchTest.textProperty().addListener((observable, oldValue, newValue) -> {
                    filteredList.setPredicate((Predicate<? super Test>) test ->{
                        if(newValue==null || newValue.isEmpty()){
                            return true;
                        }
                        String lowerCaseFilter=newValue.toLowerCase();
                        if (test.getId().contains(newValue)){
                            return true;
                        }else if (test.getName().toLowerCase().contains(lowerCaseFilter)){
                            return true;
                        }
                        return false;
                    });
                });
                SortedList<Test> sortedList=new SortedList<>(filteredList);
                sortedList.comparatorProperty().bind(TableViewTest.comparatorProperty());
                TableViewTest.setItems(sortedList);
            });
        }

    //----------------------------------------------------------------------------------------------

    public void loadAppoinment() throws SQLException, ClassNotFoundException {

        Appoinment_Controller.AppoinmentData(AppoinmentData);
        AcolID.setCellValueFactory(new PropertyValueFactory<>("Ano"));
        AcolPname.setCellValueFactory(new PropertyValueFactory<>("DID"));
        AcolDName.setCellValueFactory(new PropertyValueFactory<>("PID"));
        AcolDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        AcolTime.setCellValueFactory(new PropertyValueFactory<>("Time"));


        TableViewAppoinment.setItems(AppoinmentData);
        addUpdateButtonToAppoinmentTable();
        addDeleteButtonToAppoinmentTable();

    }

    @FXML
    void EnterIDPID(ActionEvent event) throws SQLException, ClassNotFoundException {

        String query="SELECT PFirstName FROM Pationt Where Pationt_ID=?";
        pst=con.prepareStatement(query);
        pst.setString(1,AtxtPID.getText());
        resultSet=pst.executeQuery();

        while (resultSet.next()){
            AtxtPname.setText(resultSet.getString("PFirstName"));

        }
        pst.close();
        resultSet.close();


    }

    @FXML
    void EnterDID(ActionEvent event) throws SQLException {
        String query="SELECT DFrist_Name FROM Doctor Where Doctor_ID=?";
        pst=con.prepareStatement(query);
        pst.setString(1,AtxtDID.getText());
        resultSet=pst.executeQuery();

        while (resultSet.next()){
            AtxtDname.setText(resultSet.getString("DFrist_Name"));

        }
        pst.close();
        resultSet.close();


    }

    private void addUpdateButtonToAppoinmentTable() {
        TableColumn<Appoinment, Void> colBtn = new TableColumn("Update");

        Callback<TableColumn<Appoinment, Void>, TableCell<Appoinment, Void>> cellFactory = new Callback<TableColumn<Appoinment, Void>, TableCell<Appoinment, Void>>() {

            @Override
            public TableCell<Appoinment, Void> call(final TableColumn<Appoinment, Void> param) {
                final TableCell<Appoinment, Void> cell = new TableCell<Appoinment, Void>() {

                    private final JFXButton btnDelete = new JFXButton("Edit");

                    {
                        btnDelete.setOnAction((ActionEvent event) -> {
                            updateAppoinmentButton.toFront();
                            String AID = getTableView().getItems().get(getIndex()).getAno();
                            try {
                                FillTextFieldAppoinment(AID);
                                EnterDID(event);
                                EnterIDPID(event);
                            } catch (SQLException | ClassNotFoundException throwables) {
                                throwables.printStackTrace();
                            }



                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btnDelete);

                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);
        TableViewAppoinment.getColumns().add(colBtn);


    }

    private void FillTextFieldAppoinment(String Aid) throws SQLException, ClassNotFoundException {


        Appoinment appoinment =
                new Appoinment_Controller().
                        getAppoinment(Aid);

        if (appoinment != null) {

            AtxtID.setText(appoinment.getAno());
            AtxtDID.setText(appoinment.getDID());
            AtxtPID.setText(appoinment.getPID());
            AdateSetDate.getEditor().setText(appoinment.getDate());
            AcomTime.getSelectionModel().select(appoinment.getTime());

        }


    }

    private void addDeleteButtonToAppoinmentTable() {
        TableColumn<Appoinment, Void> colBtn = new TableColumn("Delete");

        Callback<TableColumn<Appoinment, Void>, TableCell<Appoinment, Void>> cellFactory = new Callback<TableColumn<Appoinment, Void>, TableCell<Appoinment, Void>>() {

            @Override
            public TableCell<Appoinment, Void> call(final TableColumn<Appoinment, Void> param) {
                final TableCell<Appoinment, Void> cell = new TableCell<Appoinment, Void>() {

                    private final JFXButton btnDelete = new JFXButton("Del");

                    {
                        btnDelete.setOnAction((ActionEvent event) -> {
                            String AID = getTableView().getItems().get(getIndex()).getAno();
                            DeleteAppoinments(AID);

                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btnDelete);

                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);
        TableViewAppoinment.getColumns().add(colBtn);


    }

    private void DeleteAppoinments(String AID){
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure to delete?");
        Optional<ButtonType> action=alert.showAndWait();
        if (action.get()==ButtonType.OK){

            try {
                if(new Appoinment_Controller().deleteAppoinment(AID)){
                    RefreshTableAppoinment();
                    Image img=new Image("Medical_Center_Management_System/Image/checkmark.png");
                    Notifications notificationsbar= Notifications.create()
                            .title("Notification")
                            .graphic(new ImageView(img))
                            .text("Deleted").position(Pos.CENTER);
                    notificationsbar.show();


                }else{
                    Image img=new Image("Medical_Center_Management_System/Image/worng.png");
                    Notifications notificationsbar= Notifications.create()
                            .title("Notification")
                            .graphic(new ImageView(img))
                            .text("Something went wrong..!Please try again").position(Pos.CENTER);
                    notificationsbar.show();
                } } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DashBord_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private void clearFieldsAppoinment() {
        AtxtID.clear();
        AtxtDID.clear();
        AtxtPID.clear();
        AcomTime.getButtonCell().setText("");
        AcomTime.getButtonCell().setText(null);
        AtxtPname.clear();
        AtxtDname.clear();
        AdateSetDate.getEditor().clear();
    }

    private void RefreshTableAppoinment() throws SQLException, ClassNotFoundException {

        AppoinmentData.clear();

        Appoinment_Controller.AppoinmentData(AppoinmentData);
        AcolID.setCellValueFactory(new PropertyValueFactory<>("Ano"));
        AcolPname.setCellValueFactory(new PropertyValueFactory<>("DID"));
        AcolDName.setCellValueFactory(new PropertyValueFactory<>("PID"));
        AcolDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        AcolTime.setCellValueFactory(new PropertyValueFactory<>("Time"));
    }

    public void SearchAppoinments(){

        FilteredList<Appoinment> filteredList=new FilteredList<>(AppoinmentData, e ->true );

        SearchAppoinment.setOnKeyReleased(e ->{
            SearchAppoinment.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredList.setPredicate((Predicate<? super Appoinment>) appoinment ->{
                    if(newValue==null || newValue.isEmpty()){
                        return true;
                    }
                    String lowerCaseFilter=newValue.toLowerCase();
                    if (appoinment.getAno().contains(newValue)){
                        return true;
                    }else if (appoinment.getDID().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    }else if (appoinment.getPID().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }
                    return false;
                });
            });
            SortedList<Appoinment> sortedList=new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(TableViewAppoinment.comparatorProperty());
            TableViewAppoinment.setItems(sortedList);
        });
    }

    //------------------------------------------------------------------------------------------------------------------

    public void loadPayments() throws SQLException, ClassNotFoundException {

        PaymentController.PaymentData(PaymentData);
        PcolID.setCellValueFactory(new PropertyValueFactory<>("billNo"));
        PcolName.setCellValueFactory(new PropertyValueFactory<>("PID"));
        Pcolcharge.setCellValueFactory(new PropertyValueFactory<>("Hospital_Charges"));
        PcolTname.setCellValueFactory(new PropertyValueFactory<>("testID"));
        Pcoldate.setCellValueFactory(new PropertyValueFactory<>("billDate"));
        PcolTotal.setCellValueFactory(new PropertyValueFactory<>("total"));


        TableViewPayment.setItems(PaymentData);
        addDeleteButtonToPaymentTable();
        addUpdateButtonToPaymentTable();



    }

    private void addDeleteButtonToPaymentTable() {
        TableColumn<Payment, Void> colBtn = new TableColumn("Delete");

        Callback<TableColumn<Payment, Void>, TableCell<Payment, Void>> cellFactory = new Callback<TableColumn<Payment, Void>, TableCell<Payment, Void>>() {

            @Override
            public TableCell<Payment, Void> call(final TableColumn<Payment, Void> param) {
                final TableCell<Payment, Void> cell = new TableCell<Payment, Void>() {

                    private final JFXButton btnDelete = new JFXButton("Del");

                    {
                        btnDelete.setOnAction((ActionEvent event) -> {
                            String PID = getTableView().getItems().get(getIndex()).getBillNo();
                            DeletePayment(PID);

                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btnDelete);

                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);
        TableViewPayment.getColumns().add(colBtn);


    }

    private void DeletePayment(String PID){
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure to delete?");
        Optional<ButtonType> action=alert.showAndWait();
        if (action.get()==ButtonType.OK){

            try {
                if(new PaymentController().deletePayments(PID)){
                    RefreshTablePayment();
                    Image img=new Image("Medical_Center_Management_System/Image/checkmark.png");
                    Notifications notificationsbar= Notifications.create()
                            .title("Notification")
                            .graphic(new ImageView(img))
                            .text("Deleted").position(Pos.CENTER);
                    notificationsbar.show();


                }else{
                    Image img=new Image("Medical_Center_Management_System/Image/worng.png");
                    Notifications notificationsbar= Notifications.create()
                            .title("Notification")
                            .graphic(new ImageView(img))
                            .text("Something went wrong..!Please try again").position(Pos.CENTER);
                    notificationsbar.show();
                } } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DashBord_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private void addUpdateButtonToPaymentTable() {
        TableColumn<Payment, Void> colBtn = new TableColumn("edit");

        Callback<TableColumn<Payment, Void>, TableCell<Payment, Void>> cellFactory = new Callback<TableColumn<Payment, Void>, TableCell<Payment, Void>>() {

            @Override
            public TableCell<Payment, Void> call(final TableColumn<Payment, Void> param) {
                final TableCell<Payment, Void> cell = new TableCell<Payment, Void>() {

                    private final JFXButton btnDelete = new JFXButton("edit");

                    {
                        btnDelete.setOnAction((ActionEvent event) -> {
                            String BillID = getTableView().getItems().get(getIndex()).getBillNo();
                            try {
                                FillTextFielPayment(BillID);
                                EnterPID(event);
                                EnterTID(event);
                            } catch (SQLException | ClassNotFoundException throwables) {
                                throwables.printStackTrace();
                            }
                            updatePaymentButton.toFront();


                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btnDelete);

                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);
        TableViewPayment.getColumns().add(colBtn);


    }

    private void FillTextFielPayment(String PID) throws SQLException, ClassNotFoundException {


        Payment payment=
                new PaymentController().
                        getpayment(PID);

        if (payment != null) {

            BtxtBillNo.setText(payment.getBillNo());
            BtxtPID.setText(payment.getPID());
            BtxtCharges.setText(String.valueOf(payment.getHospital_Charges()));
            BtxtTID.setText(payment.getTestID());
            Btxtdate.getEditor().setText(payment.getBillDate());
            BtxtTotal.setText(String.valueOf(payment.getTotal()));


        }


    }

    private void clearFieldsPayments() {
        BtxtBillNo.clear();
        BtxtPID.clear();
        BtxtName.clear();
        BtxtCharges.clear();
        BcomTextName.getButtonCell().setText("");
        BcomTextName.getButtonCell().setText(null);
        BtxtTID.clear();
        BtxtTAmount.clear();
        Btxtdate.getEditor().clear();
        BtxtTotal.clear();
    }

    private void RefreshTablePayment() throws SQLException, ClassNotFoundException {

        PaymentData.clear();
        PaymentController.PaymentData(PaymentData);
        PcolID.setCellValueFactory(new PropertyValueFactory<>("billNo"));
        PcolName.setCellValueFactory(new PropertyValueFactory<>("PID"));
        Pcolcharge.setCellValueFactory(new PropertyValueFactory<>("Hospital_Charges"));
        PcolTname.setCellValueFactory(new PropertyValueFactory<>("testID"));
        Pcoldate.setCellValueFactory(new PropertyValueFactory<>("billDate"));
        PcolTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
    }

    @FXML
    void EnterPID(ActionEvent event) throws SQLException {

        String query="SELECT PFirstName FROM Pationt Where Pationt_ID=?";
        pst=con.prepareStatement(query);
        pst.setString(1,BtxtPID.getText());
        resultSet=pst.executeQuery();

        while (resultSet.next()){
            BtxtName.setText(resultSet.getString("PFirstName"));

        }
        pst.close();
        resultSet.close();


    }

    @FXML
    void SelectText(ActionEvent event) throws SQLException {
        String query="select Test_ID,Amount from Test Where TName=?";
        pst=con.prepareStatement(query);
        pst.setString(1,BcomTextName.getSelectionModel().getSelectedItem());
        resultSet=pst.executeQuery();

        while (resultSet.next()){

            BtxtTID.setText(resultSet.getString("Test_ID"));
            BtxtTAmount.setText(resultSet.getString("Amount"));

        }
    }

    private void FillComboBoxtext() throws SQLException {
        String query="select TName from Test";
        pst=con.prepareStatement(query);
        resultSet=pst.executeQuery();

        while (resultSet.next()){
            BcomTextName.getItems().addAll(resultSet.getString("TName"));


        }

    }

    @FXML
    void EnterTID(ActionEvent event) throws SQLException {
        String query="SELECT TName FROM Test Where Test_ID=?";
        pst=con.prepareStatement(query);
        pst.setString(1,BtxtTID.getText());
        resultSet=pst.executeQuery();

        while (resultSet.next()){
            BcomTextName.getSelectionModel().select(resultSet.getString("TName"));
            //BtxtTAmount.setText(String.valueOf(resultSet.getDouble("Amount")));

        }
        pst.close();
        resultSet.close();


    }

    @FXML
    void ClickTotal(MouseEvent event) {


        double TextAmount= Double.parseDouble(BtxtTAmount.getText());
        double Charges= Double.parseDouble(BtxtCharges.getText());
        double total=TextAmount+Charges;
        BtxtTotal.setText(String.valueOf(total));


    }


}