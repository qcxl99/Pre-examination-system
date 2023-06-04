create table departments_hospital
(
    departments_id int not null,
    hospital_id    int not null,
    primary key (departments_id, hospital_id)
)
    engine = MyISAM;

create index FKpcosvwwvqgb23jx62fiedvxwy
    on departments_hospital (hospital_id);

INSERT INTO appointement.departments_hospital (departments_id, hospital_id) VALUES (1, 1);
INSERT INTO appointement.departments_hospital (departments_id, hospital_id) VALUES (1, 2);
INSERT INTO appointement.departments_hospital (departments_id, hospital_id) VALUES (1, 3);
INSERT INTO appointement.departments_hospital (departments_id, hospital_id) VALUES (1, 4);
INSERT INTO appointement.departments_hospital (departments_id, hospital_id) VALUES (1, 5);
INSERT INTO appointement.departments_hospital (departments_id, hospital_id) VALUES (2, 1);
INSERT INTO appointement.departments_hospital (departments_id, hospital_id) VALUES (2, 2);
INSERT INTO appointement.departments_hospital (departments_id, hospital_id) VALUES (2, 4);
INSERT INTO appointement.departments_hospital (departments_id, hospital_id) VALUES (2, 5);
INSERT INTO appointement.departments_hospital (departments_id, hospital_id) VALUES (3, 1);
INSERT INTO appointement.departments_hospital (departments_id, hospital_id) VALUES (3, 2);
INSERT INTO appointement.departments_hospital (departments_id, hospital_id) VALUES (3, 3);
INSERT INTO appointement.departments_hospital (departments_id, hospital_id) VALUES (3, 4);