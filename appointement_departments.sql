create table departments
(
    id   int auto_increment
        primary key,
    name varchar(50) not null
)
    engine = MyISAM;

INSERT INTO appointement.departments (id, name) VALUES (1, 'dept1');
INSERT INTO appointement.departments (id, name) VALUES (2, 'dept2');
INSERT INTO appointement.departments (id, name) VALUES (3, 'dept3');