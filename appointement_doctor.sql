create table doctor
(
    id                     bigint auto_increment
        primary key,
    age                    int          null,
    available_timings      varchar(255) null,
    birthday               date         null,
    education_background   varchar(50)  not null,
    email                  varchar(50)  null,
    name                   varchar(50)  not null,
    password               varchar(255) not null,
    reception_requirements varchar(255) null,
    resume                 varchar(255) null,
    sex                    varchar(255) not null,
    specialty              varchar(255) not null,
    phone                  int          not null,
    title                  varchar(255) null,
    role                   varchar(20)  not null,
    dept_name              varchar(255) not null,
    department_id          int          not null,
    hospital_name          varchar(255) null,
    hospital_id            int          not null
);

INSERT INTO appointement.doctor (id, age, available_timings, birthday, education_background, email, name, password, reception_requirements, resume, sex, specialty, phone, title, role, dept_name, department_id, hospital_name, hospital_id) VALUES (1, 0, '10:00 - 18:00 mon to sun', '2023-05-28', 'master', 'd1@d1', 'd1', '$2a$10$n0VkvDhi4itB8i7KYBtAjusGxoXxViIFIuOew88M2GSqgI7Hq2P/u', null, 'doctor1', 'Female', '123', 123456, '111', 'Doctor', 'dept1', 1, null, 1);
INSERT INTO appointement.doctor (id, age, available_timings, birthday, education_background, email, name, password, reception_requirements, resume, sex, specialty, phone, title, role, dept_name, department_id, hospital_name, hospital_id) VALUES (2, 0, null, '2023-05-11', 'medical doctor', 'd2@d2', 'd2', '$2a$10$MdJSm3wQaEATTiD/76dk1uwo1l2npsfW6Nyqq5jT1l2HeCyElZueq', null, null, 'Female', '2222', 222, null, 'Doctor', 'dept2', 2, null, 2);
INSERT INTO appointement.doctor (id, age, available_timings, birthday, education_background, email, name, password, reception_requirements, resume, sex, specialty, phone, title, role, dept_name, department_id, hospital_name, hospital_id) VALUES (3, 0, null, '2023-05-29', 'medical doctor', 'd3@d3', 'd3', '$2a$10$HnGBZpZ0DkrV6pUPqLUPEucsWOAWUTXvpyTcuTy/UkgtCO7H9FiJG', null, null, 'Male', '333', 333, null, 'Doctor', 'dept3', 3, null, 3);
INSERT INTO appointement.doctor (id, age, available_timings, birthday, education_background, email, name, password, reception_requirements, resume, sex, specialty, phone, title, role, dept_name, department_id, hospital_name, hospital_id) VALUES (4, 0, null, '2023-05-31', 'medical doctor', 'd4@d4', 'd4', '$2a$10$yQmGM5EDpivwhkpN1TpLy.Uv7khnaNOqj7PNPrnYuSGl7osKsixzO', null, null, 'Male', '444', 0, null, 'Doctor', 'dept1', 1, null, 4);
INSERT INTO appointement.doctor (id, age, available_timings, birthday, education_background, email, name, password, reception_requirements, resume, sex, specialty, phone, title, role, dept_name, department_id, hospital_name, hospital_id) VALUES (5, 0, null, '2023-05-30', 'medical doctor', 'd5@d5', 'd5', '$2a$10$.myE7rOLAeIjLK8GWElZlOTIyrQoEa/m3cM0AVxn8ExiQaQo9AXbW', null, null, 'Male', '555', 555, null, 'Doctor', 'dept1', 1, null, 5);
INSERT INTO appointement.doctor (id, age, available_timings, birthday, education_background, email, name, password, reception_requirements, resume, sex, specialty, phone, title, role, dept_name, department_id, hospital_name, hospital_id) VALUES (6, 0, null, '2023-05-30', 'medical doctor', 'd6@d6', 'd6', '$2a$10$DhVkiOnCmj.bexhQPW139.Gat3MWByWRz7y3Br/41xIsoP6kFX2ma', null, null, 'Female', '666', 0, null, 'Doctor', 'dept1', 1, null, 1);
INSERT INTO appointement.doctor (id, age, available_timings, birthday, education_background, email, name, password, reception_requirements, resume, sex, specialty, phone, title, role, dept_name, department_id, hospital_name, hospital_id) VALUES (7, 0, null, '2023-05-29', 'medical doctor', 'd7@d7', 'd7', '$2a$10$Exy39hiSJ/QF/TP0VnPGtOcLkoaAs6Dayou9ktqOKhXzkBod5JFwO', null, null, 'Other', '777', 777, null, 'Doctor', 'dept1', 1, null, 1);
INSERT INTO appointement.doctor (id, age, available_timings, birthday, education_background, email, name, password, reception_requirements, resume, sex, specialty, phone, title, role, dept_name, department_id, hospital_name, hospital_id) VALUES (8, 0, null, '2023-05-29', 'medical doctor', 'd8@d8', 'd8', '$2a$10$2v1VfvWFonleXdSPXmfhuuiwRFTKNNJ2XEw/A245r9MFA6FXSN.IS', null, null, 'Female', '888', 0, null, 'Doctor', 'dept2', 2, null, 2);
INSERT INTO appointement.doctor (id, age, available_timings, birthday, education_background, email, name, password, reception_requirements, resume, sex, specialty, phone, title, role, dept_name, department_id, hospital_name, hospital_id) VALUES (9, 0, null, '2023-05-29', '', 'd9@d9', 'd9', '$2a$10$zqjeK3IDN5RJb8q/3ZFWaukkI4Y7Um6krBozOgh2y5vtuYP2vkPO2', null, null, 'Female', '999', 0, null, 'Doctor', 'dept3', 3, null, 3);
INSERT INTO appointement.doctor (id, age, available_timings, birthday, education_background, email, name, password, reception_requirements, resume, sex, specialty, phone, title, role, dept_name, department_id, hospital_name, hospital_id) VALUES (10, 0, null, '2023-05-29', 'medical doctor', 'd10@d10', 'd10', '$2a$10$s/fRdX12Bo4m/e.Q4nF4F.NpYjUC4Y2tCGEO8x/m.RSyRVjiLEV4K', null, null, 'Male', '1010', 101010, null, 'Doctor', 'dept1', 1, null, 4);