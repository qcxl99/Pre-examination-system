create table reservation
(
    id               int auto_increment
        primary key,
    location         varchar(255) null,
    status           varchar(255) not null,
    doctor_name      varchar(255) not null,
    patient_name     varchar(255) not null,
    appointment_time datetime     null,
    doctor_id        bigint       null,
    patient_id       bigint       null
)
    engine = MyISAM;

create index FKmh96fg24x7cdhex42l051fmhp
    on reservation (doctor_id);

create index FKrrjvkskqqxgliwmqgbl3ijc4n
    on reservation (patient_id);

INSERT INTO appointement.reservation (id, location, status, doctor_name, patient_name, appointment_time, doctor_id, patient_id) VALUES (5, 'p', 'enabled', 'd1', '222', '2023-05-12 00:03:00', 1, 14);
INSERT INTO appointement.reservation (id, location, status, doctor_name, patient_name, appointment_time, doctor_id, patient_id) VALUES (6, 'p', 'enabled', 'd1', '333', '2023-05-25 01:04:00', 1, 15);
INSERT INTO appointement.reservation (id, location, status, doctor_name, patient_name, appointment_time, doctor_id, patient_id) VALUES (13, 'address1', 'canceled', 'd6', '111', '2023-05-31 18:27:00', 6, 14);
INSERT INTO appointement.reservation (id, location, status, doctor_name, patient_name, appointment_time, doctor_id, patient_id) VALUES (8, 'address5', 'pending', 'd5', 'Chen', '2023-05-30 20:54:00', 5, 12);
INSERT INTO appointement.reservation (id, location, status, doctor_name, patient_name, appointment_time, doctor_id, patient_id) VALUES (9, 'address4', 'enabled', 'd4', 'p1', '2023-05-31 22:19:00', 4, 25);
INSERT INTO appointement.reservation (id, location, status, doctor_name, patient_name, appointment_time, doctor_id, patient_id) VALUES (10, 'address3', 'pending', 'd3', 'Chen', '2023-05-31 12:00:00', 3, 12);
INSERT INTO appointement.reservation (id, location, status, doctor_name, patient_name, appointment_time, doctor_id, patient_id) VALUES (11, 'address1', 'enabled', 'd1', 'p2', '2023-05-31 15:33:00', 1, 26);
INSERT INTO appointement.reservation (id, location, status, doctor_name, patient_name, appointment_time, doctor_id, patient_id) VALUES (12, 'address3', 'canceled', 'd3', 'Chen', '2023-05-30 01:43:00', 3, 12);