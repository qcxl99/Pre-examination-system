create table hospital
(
    id      int auto_increment
        primary key,
    name    varchar(50)  not null,
    address varchar(255) null
)
    engine = MyISAM;

INSERT INTO appointement.hospital (id, name, address) VALUES (1, 'Hospital1', 'address1');
INSERT INTO appointement.hospital (id, name, address) VALUES (2, 'Hospital2', 'address2');
INSERT INTO appointement.hospital (id, name, address) VALUES (3, 'Hospital3', 'address3');
INSERT INTO appointement.hospital (id, name, address) VALUES (4, 'Hospital4', 'address4');
INSERT INTO appointement.hospital (id, name, address) VALUES (5, 'Hospital5', 'address5');