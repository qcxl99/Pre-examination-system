create table confirmation_token
(
    id           bigint auto_increment
        primary key,
    confirmed_at datetime     null,
    created_at   datetime     not null,
    expired_at   datetime     not null,
    token        varchar(255) not null,
    patient      bigint       not null
)
    engine = MyISAM;

create index FKlxna2o5slh3hkit8mtbsu8sgt
    on confirmation_token (patient);

INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (1, null, '2023-05-20 15:49:15', '2023-05-20 16:04:15', '3e0c9cb4-16d9-449e-855a-097d1ff7ec9e', 1);
INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (2, '2023-05-20 17:05:47', '2023-05-20 17:04:17', '2023-05-20 17:19:17', '963176ab-f7f5-4a24-ae74-3bb973be75b3', 2);
INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (3, null, '2023-05-20 18:01:25', '2023-05-20 18:16:25', 'fb633d87-2c2d-4b85-b3fd-9f94aeef41c5', 3);
INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (4, '2023-05-20 18:11:05', '2023-05-20 18:05:34', '2023-05-20 18:20:34', '40dfb241-d93e-4b09-ab35-6b44b4538ca2', 4);
INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (5, null, '2023-05-20 18:14:33', '2023-05-20 18:29:33', '0c58e534-5863-42bc-9628-4c3749f74d4a', 5);
INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (6, '2023-05-20 18:19:32', '2023-05-20 18:16:59', '2023-05-20 18:31:59', 'ed407103-b946-4b0d-bb31-0f2e7e252049', 6);
INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (7, null, '2023-05-20 18:37:02', '2023-05-20 18:52:02', '876ae646-8566-4808-a103-028245da6806', 7);
INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (8, '2023-05-20 18:59:12', '2023-05-20 18:58:39', '2023-05-20 19:13:39', '1a965ea2-eba6-4aa6-a47c-c9c23f425aef', 8);
INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (9, '2023-05-20 19:03:06', '2023-05-20 19:02:48', '2023-05-20 19:17:48', 'dea24377-f039-415d-96c6-e29cad1ae853', 9);
INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (10, '2023-05-20 19:20:22', '2023-05-20 19:18:16', '2023-05-20 19:33:16', 'a721b767-5729-4dc6-bd21-0a09c0106648', 10);
INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (11, '2023-05-21 14:20:00', '2023-05-21 14:19:33', '2023-05-21 16:19:33', '4d1c5b59-b47a-41db-b02e-3116c5a1f5c2', 11);
INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (12, '2023-05-21 16:23:10', '2023-05-21 16:22:24', '2023-05-21 18:22:24', 'acb1ff8c-f146-41fa-a501-f4f758566e66', 12);
INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (13, '2023-05-21 17:26:13', '2023-05-21 17:25:58', '2023-05-21 19:25:58', 'e9f09c3a-6d03-441a-8dda-50bbf5fe9740', 13);
INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (14, null, '2023-05-22 14:28:03', '2023-05-22 16:28:03', '701e6c0e-4d87-403d-bbd0-7dbca9c1344a', 14);
INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (15, '2023-05-22 14:35:25', '2023-05-22 14:35:18', '2023-05-22 16:35:18', '7e2ca0ab-cb34-46db-b9dd-25f6a736096e', 15);
INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (16, null, '2023-05-27 13:29:28', '2023-05-27 15:29:28', '4bf76889-3769-47f4-ae85-dbc8c93fc9b0', 16);
INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (17, null, '2023-05-27 13:30:07', '2023-05-27 15:30:07', '41679d55-52e0-43bb-8dc3-90feac263ef1', 17);
INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (18, '2023-05-28 12:12:47', '2023-05-28 12:12:41', '2023-05-28 14:12:41', 'f522e667-adb0-468f-bf56-1dc8849292ec', 18);
INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (19, '2023-05-28 12:15:34', '2023-05-28 12:15:13', '2023-05-28 14:15:13', '028a411a-d86d-45b6-9136-4a5d38c61965', 19);
INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (20, '2023-05-28 12:19:12', '2023-05-28 12:19:09', '2023-05-28 14:19:09', '0748a986-94ed-4e0a-9abf-334d5ecc819f', 20);
INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (21, '2023-05-28 12:22:58', '2023-05-28 12:22:32', '2023-05-28 14:22:32', '6d5dd064-d927-44a5-88d7-e7dd34ebf9e2', 21);
INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (22, '2023-05-28 12:26:07', '2023-05-28 12:23:18', '2023-05-28 14:23:18', '26f83213-a1d9-49db-8943-3124ef94e52c', 22);
INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (23, '2023-05-28 13:21:21', '2023-05-28 13:21:17', '2023-05-28 15:21:17', '1a7e6660-2c8f-4ba0-adf0-e0383962c640', 23);
INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (24, '2023-05-28 13:21:39', '2023-05-28 13:21:35', '2023-05-28 15:21:35', '59a1515b-d17c-44c0-9e32-fe268b1a2c74', 24);
INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (25, '2023-05-29 20:13:35', '2023-05-29 20:13:30', '2023-05-29 22:13:30', '7629b0a1-7c6c-4f8c-a9d3-1ad70c635254', 25);
INSERT INTO appointement.confirmation_token (id, confirmed_at, created_at, expired_at, token, patient) VALUES (26, '2023-05-30 13:24:43', '2023-05-30 13:23:50', '2023-05-30 15:23:50', 'a30d1607-6736-44ff-9281-798fcf39818e', 26);