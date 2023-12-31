DROP TABLE  COURSE_ENROLLMENT;
DROP TABLE  COURSE;
DROP TABLE  TUTOR;
DROP TABLE  STUDENT;
DROP TABLE  ADDRESS;

DROP SEQUENCE ADDRESS_ADDR_ID_SEQ;
DROP SEQUENCE STUDENT_STUD_ID_SEQ;
DROP SEQUENCE TUTOR_TUTOR_ID_SEQ;
DROP SEQUENCE COURSE_COURSE_ID_SEQ;
DROP SEQUENCE COURSE_ENROLLMENT_ID_SEQ;

CREATE SEQUENCE ADDRESS_ADDR_ID_SEQ;
CREATE SEQUENCE STUDENT_STUD_ID_SEQ;
CREATE SEQUENCE TUTOR_TUTOR_ID_SEQ;
CREATE SEQUENCE COURSE_COURSE_ID_SEQ;
CREATE SEQUENCE COURSE_ENROLLMENT_ID_SEQ;

CREATE TABLE ADDRESS
(
  ADDR_ID NUMBER(11) NOT NULL,
  STREET VARCHAR2(50) NOT NULL,
  CITY VARCHAR2(50) NOT NULL,
  STATE VARCHAR2(50) NOT NULL,
  ZIP VARCHAR2(10) DEFAULT NULL,
  COUNTRY VARCHAR2(50) NOT NULL,
  PRIMARY KEY (ADDR_ID)
);
CREATE TABLE STUDENT
(
  STUD_ID NUMBER(11) NOT NULL,
  NAME VARCHAR2(50) NOT NULL,
  EMAIL VARCHAR2(50) NOT NULL,
  PHONE VARCHAR2(15) DEFAULT NULL,  
  DOB DATE DEFAULT NULL,
  ADDR_ID NUMBER(11) DEFAULT NULL, 
  PRIMARY KEY (STUD_ID),
  
  CONSTRAINT FK_STUDENTS_ADDR FOREIGN KEY (ADDR_ID) REFERENCES ADDRESSES (ADDR_ID)
);

CREATE TABLE TUTOR 
(
  TUTOR_ID NUMBER(11) NOT NULL,
  NAME VARCHAR2(50) NOT NULL,
  EMAIL VARCHAR2(50) NOT NULL,
  PHONE VARCHAR2(15) DEFAULT NULL,  
  DOB DATE DEFAULT NULL,
  ADDR_ID NUMBER(11) DEFAULT NULL,
  PRIMARY KEY (TUTOR_ID),
  CONSTRAINT FK_TUTORS_ADDR FOREIGN KEY (ADDR_ID) REFERENCES ADDRESSES (ADDR_ID)  
);


CREATE TABLE COURSE 
(
  COURSE_ID NUMBER(11) NOT NULL,
  NAME VARCHAR2(100) NOT NULL,
  DESCRIPTION VARCHAR2(512) DEFAULT NULL,
  START_DATE DATE DEFAULT NULL,
  END_DATE DATE DEFAULT NULL,
  TUTOR_ID NUMBER(11) NOT NULL,
  PRIMARY KEY (COURSE_ID),
  CONSTRAINT FK_COURSE_TUTOR FOREIGN KEY (TUTOR_ID) REFERENCES TUTORS (TUTOR_ID)
);


CREATE TABLE COURSE_ENROLLMENT
(
  COURSE_ENROLLMENT_ID NUMBER(11) NOT NULL,
  COURSE_ID NUMBER(11) NOT NULL,
  STUD_ID NUMBER(11) NOT NULL,
  PRIMARY KEY (COURSE_ENROLLMENT_ID),
  CONSTRAINT FK_ENROLLMENT_STUD FOREIGN KEY (STUD_ID) REFERENCES STUDENTS (STUD_ID),
  CONSTRAINT FK_ENROLLMENT_COURSE FOREIGN KEY (COURSE_ID) REFERENCES COURSES (COURSE_ID)
);




