create table patient
(
    id               bigint auto_increment
        primary key,
    address          varchar(255) null,
    age              int          not null,
    allergens        longtext     null,
    birthday         date         not null,
    cases            varchar(255) null,
    chronic_diseases longtext     null,
    enabled          bit          null,
    genetic_diseases longtext     null,
    id_number        varchar(20)  not null,
    job              varchar(20)  null,
    locked           bit          null,
    email            varchar(50)  not null,
    name             varchar(50)  not null,
    password         varchar(255) not null,
    role             varchar(20)  not null,
    sex              varchar(255) not null,
    phone            int          not null
);

INSERT INTO appointement.patient (id, address, age, allergens, birthday, cases, chronic_diseases, enabled, genetic_diseases, id_number, job, locked, email, name, password, role, sex, phone) VALUES (8, null, 0, null, '2023-05-26', null, null, true, null, '', null, true, '222@qq.com', '222', '$2a$10$ObbdId9ZQ3rkRbaH7ZHp4.RZB.1pdg9udHxxV6WbriFBRr9A7ZQu6', 'ADMIN', 'female', 0);
INSERT INTO appointement.patient (id, address, age, allergens, birthday, cases, chronic_diseases, enabled, genetic_diseases, id_number, job, locked, email, name, password, role, sex, phone) VALUES (9, null, 0, null, '2023-05-20', null, null, true, null, '', null, true, '333@qq.com', '333', '$2a$10$zurKM7fnXvqtbeQfyUgpDOCtD2C2UBfGAqghyyF2N/KlcGDXkVsiG', 'Patient', 'female', 0);
INSERT INTO appointement.patient (id, address, age, allergens, birthday, cases, chronic_diseases, enabled, genetic_diseases, id_number, job, locked, email, name, password, role, sex, phone) VALUES (12, '136 Boulevard de l''Hopital', 0, 'no', '2023-01-01', null, 'no', true, 'no', '11111111', 'workwork', true, 'qcxl99@gmail.com', 'Chen', '$2a$10$H4ECqmUuMMwPJbJkIHFcKO.EthUbznJz9.r1XifBuU6XrQ5E0PQcO', 'ADMIN', 'Male', 623767031);
INSERT INTO appointement.patient (id, address, age, allergens, birthday, cases, chronic_diseases, enabled, genetic_diseases, id_number, job, locked, email, name, password, role, sex, phone) VALUES (14, null, 0, 'no', '2023-05-26', 'sick', 'no', true, 'no', '', null, true, '222@222', '111', '$2a$10$i61t8RCZpRpOq7F7XiD2deZsSEImjDwx5EV3YNtos6COFIulNxkpm', 'Patient', 'Male', 0);
INSERT INTO appointement.patient (id, address, age, allergens, birthday, cases, chronic_diseases, enabled, genetic_diseases, id_number, job, locked, email, name, password, role, sex, phone) VALUES (15, null, 0, null, '2023-05-26', null, null, true, null, '', null, true, '123@222', '333', '$2a$10$jcrfjUAHEkyesIsBhZPqAuC.70.bDx1PzyAGLwN2COs.Bl5qDSd.m', 'Patient', 'female', 0);
INSERT INTO appointement.patient (id, address, age, allergens, birthday, cases, chronic_diseases, enabled, genetic_diseases, id_number, job, locked, email, name, password, role, sex, phone) VALUES (16, null, 0, null, '2023-05-27', null, null, false, null, '', null, true, '123@123', '123', '$2a$10$GTkrDTd95K2pr4oHqVIuN.b8z/xj0JFYylqoxNpkn8tJEPl9PDwSK', 'Patient', 'male', 0);
INSERT INTO appointement.patient (id, address, age, allergens, birthday, cases, chronic_diseases, enabled, genetic_diseases, id_number, job, locked, email, name, password, role, sex, phone) VALUES (19, null, 0, null, '2023-05-28', null, null, false, null, '22', null, true, '22@22', '22', '$2a$10$noQFp8WIsVWSO9LYc2V.GuHK2116egVoVbhsjfGRrmds1rwDYBnuK', 'Patient', 'Male', 0);
INSERT INTO appointement.patient (id, address, age, allergens, birthday, cases, chronic_diseases, enabled, genetic_diseases, id_number, job, locked, email, name, password, role, sex, phone) VALUES (20, null, 0, null, '2023-05-28', null, null, false, null, '33', null, true, '33@33', '33', '$2a$10$0WcGHOGeR2HC4tyh7kbgJuU0FE3JbCdpEd7GOc8rWtZlsRkyaFkKm', 'Patient', 'Female', 0);
INSERT INTO appointement.patient (id, address, age, allergens, birthday, cases, chronic_diseases, enabled, genetic_diseases, id_number, job, locked, email, name, password, role, sex, phone) VALUES (21, null, 0, null, '2023-06-04', null, null, true, null, '44', null, true, '44@44', '44', '$2a$10$EfRvydq9Dti2W4UjPyE6zeySDOdT8aMqGjdql5/tQm//LGfJXtjtu', 'Patient', 'Male', 44);
INSERT INTO appointement.patient (id, address, age, allergens, birthday, cases, chronic_diseases, enabled, genetic_diseases, id_number, job, locked, email, name, password, role, sex, phone) VALUES (22, null, 0, null, '2023-05-28', null, null, true, null, '', null, true, '55@55', '55', '$2a$10$AGfNnaz2abShb8pKuwd1PeS1S4GYcrlqmpMkYpp87sGz5GufN9EL2', 'Patient', 'male', 55);
INSERT INTO appointement.patient (id, address, age, allergens, birthday, cases, chronic_diseases, enabled, genetic_diseases, id_number, job, locked, email, name, password, role, sex, phone) VALUES (23, null, 0, null, '2023-05-28', null, null, true, null, '', null, true, '11@11', '11', '$2a$10$rqf2wmU6AX2gMVBPM0W90.Rm.AMd5qlJ2qkk9XJ8fLXhLltNDG2OW', 'Patient', 'Male', 0);
INSERT INTO appointement.patient (id, address, age, allergens, birthday, cases, chronic_diseases, enabled, genetic_diseases, id_number, job, locked, email, name, password, role, sex, phone) VALUES (24, null, 0, null, '2023-05-29', null, null, true, null, '66', null, true, '66@66', '66', '$2a$10$gHAqpG/UauywCaXcl/ga5uU9KmY6wE6ckEE62iy4oZWnyWprYWOCm', 'Patient', 'Female', 0);
INSERT INTO appointement.patient (id, address, age, allergens, birthday, cases, chronic_diseases, enabled, genetic_diseases, id_number, job, locked, email, name, password, role, sex, phone) VALUES (25, '111', 0, 'no', '2023-05-30', null, 'no', true, 'no', '111', 'workwork', true, 'p1@p1', 'p1', '$2a$10$rW90NHXnSB.967jEdmDkIezWxjE44enr1NRC..U2rV5Muq4VASEky', 'Patient', 'Male', 111);
INSERT INTO appointement.patient (id, address, age, allergens, birthday, cases, chronic_diseases, enabled, genetic_diseases, id_number, job, locked, email, name, password, role, sex, phone) VALUES (26, null, 0, null, '2023-05-30', null, null, true, null, '222', null, true, 'p2@p2', 'p2', '$2a$10$3JpGWYwtRGv8zApCiEcrru358xBFXtD5QkUD2Lb6ZhmGTYj/RkWi.', 'Patient', 'male', 222);