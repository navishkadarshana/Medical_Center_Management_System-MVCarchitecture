DROP DATABASE Medical_Center_Management_System;
CREATE DATABASE Medical_Center_Management_System;
USE Medical_Center_Management_System;


CREATE TABLE  Doctor(
	Doctor_ID VARCHAR(10) NOT NULL,
	Name VARCHAR(70) NOT NULL,
	NIC VARCHAR(20) NOT NULL,
	Address VARCHAR(70) NOT NULL, 
	AGE INT(5) NOT NULL,
	Gender VARCHAR(10) NOT NULL,
	DOB DATE,
	Phone_No VARCHAR(15) NOT NULL,
	Join_Date DATE NOT NULL,
	Specialtice VARCHAR(70),
	Days VARCHAR(50),
	Timing VARCHAR(50),
	CONSTRAINT PRIMARY KEY (Doctor_ID)
);

CREATE TABLE  Pationt(
	Pationt_ID VARCHAR(10) NOT NULL,
	PationtTitle VARCHAR(5)NOT NULL,
	Name VARCHAR(70) NOT NULL,
	NIC VARCHAR(20) NOT NULL,
	Address VARCHAR(70) NOT NULL, 
	AGE INT(5) NOT NULL,
	Gender VARCHAR(10) NOT NULL,
	DOB DATE,
	Phone_No VARCHAR(15) NOT NULL,
	Disease VARCHAR(50),
	Blood_Grup VARCHAR(20),
	CONSTRAINT PRIMARY KEY (Pationt_ID)
);

CREATE TABLE  Employee(
	Employee_ID VARCHAR(10) NOT NULL,
	Name VARCHAR(70) NOT NULL,
	NIC VARCHAR(20) NOT NULL,
	Address VARCHAR(70) NOT NULL,
	Salary DECIMAL(10,2) NOT NULL, 
	AGE INT(5) NOT NULL,
	Gender VARCHAR(10) NOT NULL,
	DOB DATE,
	Phone_No VARCHAR(15) NOT NULL,
	Role VARCHAR(30) NOT NULL,
	CONSTRAINT PRIMARY KEY (Employee_ID)
);

CREATE TABLE User(
	UserID VARCHAR(10) NOT NULL,
	Name VARCHAR(70)NOT NULL,
	Role VARCHAR(50)NOT NULL,
	UserName VARCHAR(30) NOT NULL,
	Password VARCHAR(30) NOT NULL,
	CONSTRAINT PRIMARY KEY (UserID)
);

CREATE TABLE  Appoinment(
	Appoinment_No VARCHAR(20) NOT NULL,
	Doctor_ID VARCHAR(10) NOT NULL,
	Pationt_ID VARCHAR(10) NOT NULL,
	Appoinment_Date DATE NOT NULL,
	Appoinment_Time VARCHAR(30) NOT NULL,
	CONSTRAINT PRIMARY KEY (Appoinment_No),
	CONSTRAINT FOREIGN KEY (Doctor_ID) REFERENCES Doctor(Doctor_ID) ON Delete Cascade On update cascade,
	CONSTRAINT FOREIGN KEY (Pationt_ID) REFERENCES Pationt(Pationt_ID) ON Delete Cascade On update cascade
);

CREATE TABLE Doctor_Schedule(
	Doctor_ID VARCHAR(10) NOT NULL,
	Appoinment_No VARCHAR(20) NOT NULL,
	Pationt_ID VARCHAR(10) NOT NULL,
	S_Date DATE NOT NULL,
	S_Time VARCHAR(30) NOT NULL,
	CONSTRAINT FOREIGN KEY (Doctor_ID) REFERENCES Doctor(Doctor_ID) ON Delete Cascade On update cascade,
	CONSTRAINT FOREIGN KEY (Appoinment_No) REFERENCES Appoinment(Appoinment_No) ON Delete Cascade On update cascade,
	CONSTRAINT FOREIGN KEY (Pationt_ID) REFERENCES Pationt(Pationt_ID) ON Delete Cascade On update cascade
);

CREATE TABLE Medicine(
	Medicine_Reference_No VARCHAR(50) Not NULL,
	Name_Of_Tablet VARCHAR(50) NOT NULL,
	unitPrice DECIMAL(10,2) NOT NULL,
	Possible_side_effect VARCHAR(500), 
	Quntity_Ac VARCHAR(50) NOT NULL,
	ExpirDate DATE,
	Dose VARCHAR(20),
	DaliyDose VARCHAR(20),
	Storage_Advice VARCHAR(50),
	CONSTRAINT PRIMARY KEY (Medicine_Reference_No)
);

CREATE TABLE Test(
	Test_ID VARCHAR(20) NOT NULL,
	Name VARCHAR(50) NOT NULL,
	Amount DECIMAL(10,2) NOT NULL,
	CONSTRAINT PRIMARY KEY (Test_ID)
);

CREATE TABLE Suplier(
	Suplier_ID VARCHAR(20) NOT NULL,
	Medicine_Reference_No VARCHAR(20) NOT NULL,
	Suplier_Name VARCHAR(50) NOT NULL,
	Address VARCHAR(70) NOT NULL,
	Compani_Name VARCHAR(30) NOT NULL,
	CONSTRAINT PRIMARY KEY (Suplier_ID),
	CONSTRAINT FOREIGN KEY (Medicine_Reference_No) REFERENCES Medicine(Medicine_Reference_No) ON Delete Cascade On update cascade
);

CREATE TABLE Bill(
	Ref_No VARCHAR(20) NOT NULL,
	Pationt_ID VARCHAR(10) NOT NULL,
	Pationt_Name VARCHAR(40)NOT NULL,
	Bill_date DATE,
	Test_Name VARCHAR(40),
	Total DECIMAL(10,2) NOT NULL,
	CONSTRAINT PRIMARY KEY (Ref_No),
	CONSTRAINT FOREIGN KEY (Pationt_ID) REFERENCES Pationt(Pationt_ID) ON Delete Cascade On update cascade
);


#-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO Doctor VALUES('D001','Dr.Rathnayaka','73880932v','No.24 ,Colombo',32,'Mail','1973-01-03','+94778965486','2001-01-05','Cardiologist','Mon - wed','4.00 PM-7.00PM');
INSERT INTO Doctor VALUES('D002','Dr.Danapala','73750932v','No.87,Colombo',40,'Mail','1973-05-07','+94778979343','2011-02-25','Dermatologists','Sat - Sun','8.00 AM-10.00AM');
INSERT INTO Doctor VALUES('D003','Dr.Abewicrama','83880932v','No.24 ,Kaduwela',47,'Mail','1983-09-27','+9477485543','2007-01-28','Neurologists','Mon - Tus','11.00 AM-01.00PM');
INSERT INTO Doctor VALUES('D004','Dr.Jayasinha','93880932v','No.37,Colombo',43,'Mail','1993-06-03','+94719665647','2002-12-05','Ophthhalmologists','Mon - wed','4.00 PM-7.00PM');
INSERT INTO Doctor VALUES('D005','Dr.Budipala','78880832v','No.106 ,ragama',52,'Mail','1978-04-15','+94727846543','2005-05-05','Pediatricians','Mon - wed','3.30 PM-6.00PM');
INSERT INTO Doctor VALUES('D006','Dr.Anoma Rathnayaka','73880932v','No74 ,Madakalapuwa',36,'Femail','1973-09-05','+94777976546','2005-01-05','Phisiatrists','Sat - Sun','4.00 PM-7.00PM');
INSERT INTO Doctor VALUES('D007','Dr.Asela','68880932v','No.24 ,Colombo',35,'Mail','1968-05-21','+94778975309','2005-01-05','Psychiatrists','Mon - wed','4.00 PM-7.00PM');
INSERT INTO Doctor VALUES('D008','Dr.Sachinthni','83880932v','No.244 ,Panadura',28,'Femail','1980-09-25','+94758967805','2008-04-21','Urologist','Mon - wed','8.00 PM-12.00PM');
INSERT INTO Doctor VALUES('D009','Dr.Jayawardana','93880972v','No.56 ,Pannipitiya',36,'Mail','1993-01-05','+94778935890','2012-05-05','Sports Medicine Specialists','Mon - Fri','4.00 PM-6.00PM');
INSERT INTO Doctor VALUES('D010','Dr.Balawardana','83880932v','No.102/4 ,Rathanapura',55,'Mail','1983-01-03','+94778934682','2005-01-05','any','Wed - Fri','6.00 AM-9.00AM');
INSERT INTO Doctor VALUES('D011','Dr.Achini','73880992v','No.245/5 ,Colombo 07',30,'Femail','1973-04-27','+94718968741','2011-03-10','Chest Specialist','Mon','4.00 PM-7.00PM');
INSERT INTO Doctor VALUES('D012','Dr.Disna','93880976v','No.25 ,Kaluthara',32,'Mail','1993-01-03','+9477835781','2008-01-15','Family/General Counceller','Mon - wed','8.00 PM-10.00PM');
INSERT INTO Doctor VALUES('D013','Dr.Sakunthala','89880936v','No.67 ,papiliyana',38,'Femail','1989-11-14','+94778764243','2005-11-05','Cardiologist','Sun - wed','8.00 AM-7.00PM');
INSERT INTO Doctor VALUES('D014','Dr.H.S Perera','76880962v','No.24 ,walana',56,'Mail','1976-12-02','+94756896543','2005-07-25','Neurologists','Mon - wed','4.00 PM-7.00PM');
INSERT INTO Doctor VALUES('D015','Dr.Makuluduwa','74880938v','No.24/1 ,Kandy',48,'Mail','1974-10-22','+94778698543','206-08-05','any','Tus','4.00 PM-7.00PM');
INSERT INTO Doctor VALUES('D016','Dr.Charunika','65080982v','No.34 ,Ampara',40,'Femail','1973-11-15','+94718965549','2007-11-07','Cardiologist','Mon','1.00 PM-5.00PM');
INSERT INTO Doctor VALUES('D017','Dr.Nipuna','74880972v','No.67 ,Maharagama',34,'Mail','1974-04-23','+94768965583','2009-01-30','Urologist','Sun','4.00 PM-7.00PM');
INSERT INTO Doctor VALUES('D018','Dr.Lasantha','96880962v','No.89 ,Avisawella',32,'Mail','1996-04-14','+9477896586','2016-01-09','Chest Specialist','Sun - Fri','8.00 AM-10.00AM');
INSERT INTO Doctor VALUES('D019','Dr.Lalith Perera','67880932v','No.277 ,Piliyandara',32,'Mail','1967-05-09','+94777796569','2002-03-06','Phisiatrists','wed','4.00 PM-7.00PM');
INSERT INTO Doctor VALUES('D020','Dr.Thulsi Perera','78880998v','No.876 ,Nugegoda',38,'Femail','1978-07-12','+94758968586','2006-01-05','Cardiologist','Mon - Wed','6.00 PM-7.30PM');

#-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO Pationt VALUES('P001','Mr','Danapala','73880932v','No.21 ,Ampara',40,'Mail','1973-01-03','+94778965486','Heart Disease','O-');
INSERT INTO Pationt VALUES('P002','Mr','Siripala','69880939v','No.24 ,Avisawella',45,'Mail','1969-06-13','+947189455486','Liver Disease','AB-');
INSERT INTO Pationt VALUES('P003','Mr','Gunpala','71880966v','No.243 ,Nugegoda',31,'Mail','1971-12-06','+94768965583','Allergies & Asthma','O+');
INSERT INTO Pationt VALUES('P004','Mr','Ariyapala','60880532v','No.24/A ,Piliyandara',51,'Mail','1973-11-23','+94764365486','Heart Disease','B-');
INSERT INTO Pationt VALUES('P005','Mr','Siridasa','73880967v','No.88 ,Kandy',48,'Mail','1973-01-17','+94778965486','Infection Disease','A+');
INSERT INTO Pationt VALUES('P006','Miss','NansiNona','61880932v','No.24 ,Maharagama',51,'Femail','1961-01-03','+94777865489','Allergies & Asthma','B+');
INSERT INTO Pationt VALUES('P007','Mr','Weerasinha','76880962v','No.94 ,Colombo',32,'Mail','1959-12-03','+94779525486','Kidney Disease','O-');
INSERT INTO Pationt VALUES('P008','Mr','Anushka','59880932v','No.105 ,Colombo 07',42,'Mail','1979-01-09','+94778578543','Heart Disease','AB-');
INSERT INTO Pationt VALUES('P009','Miss','Somawathee','79880934v','No.107 ,Panadura',42,'Femail','1974-09-03','+94778965487','Cancer','A+');
INSERT INTO Pationt VALUES('P010','Ms','Leelawathee','74880936v','No.67 ,Ginigthhena',39,'Femail','1974-07-03','94778935890','Liver Disease','O-');
INSERT INTO Pationt VALUES('P011','Mr','Jinadasa','81880939v','No.68 ,walana',32,'Mail','1981-01-02','+94718965441','Heart Disease','B-');
INSERT INTO Pationt VALUES('P012','Mr','Kavind','96880998v','No.21 ,Colombo',24,'Mail','1996-11-15','+9477896578','Allergies & Asthma','A+');

#------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO Employee VALUES('E001','Kavindi','73880932v','No.21 ,Ampara',30000.00,40,'Mail','1973-04-23','+94777965468','Receptionist');
INSERT INTO Employee VALUES('E002','Somapala','72460956v','No.24 ,Colombo',30000.00,40,'Mail','1972-11-13','+94771965468','Pharmacist');
INSERT INTO Employee VALUES('E003','Jinadasa','73880945v','No.213 ,Kaduwela',30000.00,40,'Mail','1973-12-03','+94718965458','Pharmacist');
INSERT INTO Employee VALUES('E004','Danapala','73880932v','No.253 ,walana',35000.00,40,'Mail','1973-01-07','+94768965435','Pharmacist');
INSERT INTO Employee VALUES('E005','Danapala','73880332v','No.24 ,Ampara',45000.00,40,'Mail','1973-01-04','+94778965447','Cashier');
INSERT INTO Employee VALUES('E006','Danapala','69480935v','No.45 ,Panadura',45000.00,40,'Femail','1969-05-03','+94778965464','Nurse');
INSERT INTO Employee VALUES('E007','Danapala','73880932v','No.256 ,Kirinda',45000.00,40,'Femail','1973-06-02','+94758965424','Nurse');
INSERT INTO Employee VALUES('E008','Danapala','75880937v','No.12 ,Gampaha',45000.00,40,'Femail','1975-04-01','+94718965892','Nurse');
INSERT INTO Employee VALUES('E009','Danapala','73880937v','No.265 ,Ampara',40000.00,40,'Femail','1973-01-04','+94778965464','Nurse');
INSERT INTO Employee VALUES('E010','Danapala','81880932v','No.21 ,Pasyala',40000.00,40,'Femail','1981-03-06','+94728965486','Nurse');
INSERT INTO Employee VALUES('E011','Danapala','98880939v','No.245 ,Ampara',40000.00,40,'Femail','1998-08-07','+94728965484','Nurse');
INSERT INTO Employee VALUES('E012','Danapala','84880900v','No.206/3 ,Ampara',40000.00,40,'Femail','1984-01-06','+94778965465','Nurse');
INSERT INTO Employee VALUES('E013','Danapala','71880932v','No.26 ,Ginigthhena',40000.00,40,'Femail','1975-07-03','+94718965425','Nurse');
INSERT INTO Employee VALUES('E014','Danapala','75880932v','No.245 kandy,',40000.00,40,'Femail','1973-04-05','+94778965985','Nurse');
INSERT INTO Employee VALUES('E015','Danapala','96880939v','No.53,Maharagama',40000.00,40,'Femail','1996-04-01','+94758965455','Nurse');
INSERT INTO Employee VALUES('E016','Danapala','67880932v','No.34 ,Kaluthara',40000.00,40,'Femail','1972-03-03','+94718965411','Nurse');
INSERT INTO Employee VALUES('E017','Danapala','72880932v','No.34 ,Panadura',40000.00,40,'Femail','1972-01-05','+94718965465','Nurse');
INSERT INTO Employee VALUES('E018','Danapala','73880937v','No.24 Colombo,',30000.00,40,'Mail','1973-02-03','+94778965487','Cleaners');
INSERT INTO Employee VALUES('E019','Danapala','75880936v','No.43 ,Avisawella',30000.00,40,'Mail','1975-04-06','+94718965467','Cleaners');
INSERT INTO Employee VALUES('E020','Danapala','79880933v','No.23 ,Mihirigama',30000.00,40,'Mail','1979-06-07','+94778965431','Cleaners');
INSERT INTO Employee VALUES('E021','Danapala','68880952v','No.51 ,Ragama',30000.00,40,'Femail','1968-07-08','+94777965497','Cleaners');
INSERT INTO Employee VALUES('E022','Danapala','81880932v','No.61 ,Ambalamgoda',30000.00,40,'Femail','1981-09-02','+94778965481','Cleaners');

#-------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO User VALUES('U001','Navishka','Owner','Admin','1519');
INSERT INTO User VALUES('U002','Kavindi','Receptionist','recep_01','1679');

#-------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO Appoinment VALUES('A001','D003','P001','2020-02-28','4.00 PM');
INSERT INTO Appoinment VALUES('A002','D002','P003','2020-03-08','3.00 PM');
INSERT INTO Appoinment VALUES('A003','D001','P007','2020-02-12','9.00 AM');
INSERT INTO Appoinment VALUES('A004','D003','P005','2020-02-28','4.30 PM');
INSERT INTO Appoinment VALUES('A005','D010','P003','2020-01-05','8.00 AM');
INSERT INTO Appoinment VALUES('A006','D002','P002','2020-02-28','4.00 PM');
INSERT INTO Appoinment VALUES('A007','D019','P011','2020-06-26','1.00 PM');
INSERT INTO Appoinment VALUES('A008','D003','P006','2020-02-21','4.00 PM');
INSERT INTO Appoinment VALUES('A009','D015','P009','2020-03-28','5.00 PM');
INSERT INTO Appoinment VALUES('A010','D003','P005','2020-02-12','4.00 PM');
INSERT INTO Appoinment VALUES('A011','D004','P002','2020-04-13','7.00 PM');
INSERT INTO Appoinment VALUES('A012','D003','P005','2020-02-16','10.00 AM');
INSERT INTO Appoinment VALUES('A013','D016','P006','2020-04-28','4.00 PM');
INSERT INTO Appoinment VALUES('A014','D003','P002','2020-03-22','6.00 PM');
INSERT INTO Appoinment VALUES('A015','D009','P001','2020-03-05','4.00 PM');
INSERT INTO Appoinment VALUES('A016','D003','P012','2020-02-01','9.30 AM');
#---------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO Doctor_Schedule VALUES('D001','A003','P001','2020-02-28','4.00 PM');
INSERT INTO Doctor_Schedule VALUES('D002','A002','P007','2020-03-08','3.00 PM');
INSERT INTO Doctor_Schedule VALUES('D003','A001','P002','2020-02-12','9.00 AM');
INSERT INTO Doctor_Schedule VALUES('D004','A003','P007','2020-02-28','4.30 PM');
INSERT INTO Doctor_Schedule VALUES('D005','A010','P006','2020-01-05','8.00 AM');
INSERT INTO Doctor_Schedule VALUES('D006','A002','P007','2020-02-28','4.00 PM');
INSERT INTO Doctor_Schedule VALUES('D007','A016','P008','2020-06-26','1.00 PM');
INSERT INTO Doctor_Schedule VALUES('D008','A003','P002','2020-02-21','4.00 PM');
INSERT INTO Doctor_Schedule VALUES('D009','A015','P012','2020-03-28','5.00 PM');
INSERT INTO Doctor_Schedule VALUES('D010','A003','P007','2020-02-12','4.00 PM');
INSERT INTO Doctor_Schedule VALUES('D011','A004','P003','2020-04-13','7.00 PM');
INSERT INTO Doctor_Schedule VALUES('D012','A003','P006','2020-02-16','10.00 AM');
INSERT INTO Doctor_Schedule VALUES('D013','A016','P007','2020-04-28','4.00 PM');
INSERT INTO Doctor_Schedule VALUES('D014','A003','P009','2020-03-22','6.00 PM');
INSERT INTO Doctor_Schedule VALUES('D015','A009','P004','2020-03-05','4.00 PM');
INSERT INTO Doctor_Schedule VALUES('D016','A003','P002','2020-02-01','9.30 AM');




#---------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO Medicine VALUES('REF-001','Lexapro',350.00,'ataxia,blurred vision, constipation, diplopia, dizziness','200 Tablets','2022-08-22','500mg','2 Tablets','cool place');
INSERT INTO Medicine VALUES('REF-002','Abilify',550.00,'dizziness, drowsiness, lethargy, sedated state,urinaryincontinence','400 Tablets','2024-05-04','10mg','1 Tablets','cool place');
INSERT INTO Medicine VALUES('REF-003','Acetaminophen',200.00,' fever','600 Tablets','2022-03-06','400mg','1 Tablets','cool place');
INSERT INTO Medicine VALUES('REF-004','Adderall',150.00,'No side effect','200 Tablets','2023-09-07','500mg','2 Tablets','cool place');
INSERT INTO Medicine VALUES('REF-005','Alprazolam',750.00,'ataxia, cognitive dysfunction, constipation, depression','200 Tablets','2020-08-05','750mg','1 Tablets','cool place');
INSERT INTO Medicine VALUES('REF-006','Melatonin',900.00,'No side effect','150 Tablets','2021-08-07','500mg','2 Tablets','cool place');
INSERT INTO Medicine VALUES('REF-007','Meloxicam',450.00,'abdominal pain, anemia, and edema','200 Tablets','2020-06-08','500mg','2/1 Tablets','cool place');
INSERT INTO Medicine VALUES('REF-008','Ambien',650.00,'dizziness','350 Tablets','2022-08-08','20mg','2 Tablets','cool place');
INSERT INTO Medicine VALUES('REF-009','Metformin',350.00,'lactic acidosis, diarrhea, nausea, nausea and vomiting','200 Tablets','2020-11-08','500mg','1 Tablets','cool place');
INSERT INTO Medicine VALUES('REF-010','Methocarbamol',450.00,'No side effect','250 Tablets','2025-08-04','500mg','1 Tablets','cool place');
INSERT INTO Medicine VALUES('REF-011','Metoprolol',150.00,'cardiac failure, bradycardia, and hypotension','200 Tablets','2024-06-03','300mg','1 Tablets','cool place');
INSERT INTO Medicine VALUES('REF-012','Amlodipine',350.00,'edema','300 Tablets','2026-08-07','500mg','2 Tablets','cool place');
INSERT INTO Medicine VALUES('REF-013','Baclofen',1550.00,'drowsiness','150 Tablets','2025-06-07','200mg','2/1 Tablets','cool place');
INSERT INTO Medicine VALUES('REF-014','MiraLAX',750.00,'No side effect','200 Tablets','2027-08-22','500mg','2 Tablets','cool place');
INSERT INTO Medicine VALUES('REF-015','Ativan',950.00,'dizziness','500 Tablets','2024-06-22','10mg','1 Tablets','cool place');

#-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO Test VALUES('T001','Blood analysis',3500.00);
INSERT INTO Test VALUES('T002','gastric fluid analysis',25000.00);
INSERT INTO Test VALUES('T003','kidney function test',3500.00);
INSERT INTO Test VALUES('T004','liver function test',3500.00);
INSERT INTO Test VALUES('T005','X ray',2500.00);
INSERT INTO Test VALUES('T006','ECG ',2000.00);
INSERT INTO Test VALUES('T007','pregnancy test',1500.00);
INSERT INTO Test VALUES('T008','syphilis test',10000.00);
INSERT INTO Test VALUES('T009','toxicology test',3500.00);
INSERT INTO Test VALUES('T010','malabsorption test',8500.00);

#---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO Suplier VALUES('S001','REF-001','Sarath','No.211 ,Piliyandara','Acella Pharmaceuticals, LLC');
INSERT INTO Suplier VALUES('S002','REF-002','Anushka','No.21 ,Colomabo','Aclaris Therapeutics, Inc.');
INSERT INTO Suplier VALUES('S003','REF-003','Supun','No.54 ,Ranala','Adamas Pharmaceuticals, Inc.');
INSERT INTO Suplier VALUES('S004','REF-004','Kanishka','No.67 ,Piliyandara','Acella Pharmaceuticals, LLC');
INSERT INTO Suplier VALUES('S005','REF-005','Darshana','No.201 ,Ragama','Acella Pharmaceuticals, LLC');
INSERT INTO Suplier VALUES('S006','REF-006','Akalanka','No.20/1 Kaduwela','Akrimax Pharmaceuticals, LLC');
INSERT INTO Suplier VALUES('S007','REF-007','Pahan','No.105 ,Panadura','Acella Pharmaceuticals, LLC');
INSERT INTO Suplier VALUES('S008','REF-008','Kalpana','No.01 ,Pannipitiya','Actavis Pharma, Inc.');
INSERT INTO Suplier VALUES('S009','REF-009','Kokila','No.25 ,Awisawella','Acella Pharmaceuticals, LLC');
INSERT INTO Suplier VALUES('S010','REF-010','Kavinda','No.29 ,Kandy','Acella Pharmaceuticals, LLC');
INSERT INTO Suplier VALUES('S011','REF-011','Sachin','No.231 ,Kirinda','Adamas Pharmaceuticals, Inc.');

#-----------------------------------------------------------------------------------------------------------------------------------

INSERT INTO Bill VALUES('REF-001','P003','Gunapala','2020-03-21','Blood analysis',3500.00);
INSERT INTO Bill VALUES('REF-002','P002','Danapala','2020-03-24','X ray',3500.00);
INSERT INTO Bill VALUES('REF-003','P001','Siripala','2020-05-21','Blood analysis',3500.00);
INSERT INTO Bill VALUES('REF-004','P003','Gunapala','2020-03-23','kidney function test',3500.00);
INSERT INTO Bill VALUES('REF-005','P005','Siridasa','2020-06-21','syphilis test',3500.00);
INSERT INTO Bill VALUES('REF-006','P007','Weerasinha','2020-03-22','Blood analysis',3500.00);
INSERT INTO Bill VALUES('REF-007','P002','Danapala','2020-07-25','Blood analysis',3500.00);





#------------------------------------------------------------------------------------------------------------------------------------
SELECT * FROM Doctor;
SELECT * FROM Pationt;
SELECT * FROM Employee;
SELECT * FROM User;
SELECT * FROM Appoinment;
SELECT * FROM Doctor_Schedule;
SELECT * FROM Medicine;
SELECT * FROM Test;
SELECT * FROM Suplier;
SELECT * FROM Bill;