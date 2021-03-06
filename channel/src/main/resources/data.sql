create TABLE IF NOT EXISTS PATIENT  (
NIC VARCHAR(15) PRIMARY KEY,
FIRST_NAME VARCHAR(20) ,
LAST_NAME VARCHAR(20) ,
DATE_OF_BIRTH VARCHAR(20) ,
DIABETES  INT(1) ,
BLOOD_PRESSURE INT(1) ,
CHOLESTEROL INT(1) ,
ALLERGY INT(1) ,
NOTES VARCHAR(40),
CREATED_DATE TIMESTAMP,
LAST_MODIFIED_DATE TIMESTAMP ,
VERSION INT(3)
);


CREATE TABLE IF NOT EXISTS T_QUEUE (
QUEUE_ID INT NOT NULL auto_increment,
DOCTOR_ID VARCHAR(30) NOT NULL,
QUE_STATUS VARCHAR(10) NOT NULL,
CREATED_DATE TIMESTAMP,
LAST_MODIFIED_DATE TIMESTAMP ,
VERSION INT(3),
PRIMARY KEY (QUEUE_ID)
);


CREATE TABLE IF NOT EXISTS QUEUE_PATIENT  (
QUEUE_PATIENT_ID INT NOT NULL auto_increment,
PATIENT_NIC VARCHAR(30) NOT NULL,
QUEUE_NUMBER INT NOT NULL,
QUEUE_ID INT NOT NULL,
QUEUE_PATIENT_STATUS VARCHAR(10) NOT NULL,
CREATED_DATE TIMESTAMP,
LAST_MODIFIED_DATE TIMESTAMP ,
VERSION INT(3),
PRIMARY KEY (QUEUE_PATIENT_ID),
FOREIGN KEY (QUEUE_ID) REFERENCES T_QUEUE(QUEUE_ID) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS PATIENT_HISTORY  (
PATIENT_HISTORY_ID INT NOT NULL auto_increment,
PATIENT_NIC VARCHAR(30) NOT NULL,
DISEASE VARCHAR(10) NOT NULL,
DISEASE_STATUS VARCHAR(10) NOT NULL,
CREATED_DATE TIMESTAMP,
LAST_MODIFIED_DATE TIMESTAMP ,
VERSION INT(3),
PRIMARY KEY (PATIENT_HISTORY_ID)
);


CREATE TABLE IF NOT EXISTS PATIENT_MEDICINE  (
  PATIENT_MEDICINE_ID INT NOT NULL auto_increment,
  PATIENT_HISTORY_ID INT NOT NULL,
  QUEUE_ID INT NOT NULL,
  STATUS VARCHAR(20) NOT NULL,
  MEDICINE_AND_QUANTITY VARCHAR(150) NOT NULL,
  VERSION INT(3),
PRIMARY KEY (PATIENT_MEDICINE_ID),
FOREIGN KEY (PATIENT_HISTORY_ID) REFERENCES PATIENT_HISTORY(PATIENT_HISTORY_ID) ON DELETE CASCADE
);

