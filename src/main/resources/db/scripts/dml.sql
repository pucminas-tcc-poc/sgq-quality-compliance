USE sgq-quality-compliance;

-- DEPARTAMENT
INSERT INTO departament (id_departament, des_departament, des_location, dt_creation) VALUES (1, 'Production/Manufacturing', 'EUA', NOW());
INSERT INTO departament (id_departament, des_departament, des_location, dt_creation) VALUES (2, 'Maintenance and Utilities', 'EUA', NOW());
INSERT INTO departament (id_departament, des_departament, des_location, dt_creation) VALUES (3, 'Quality Assurance and Quality Systems', 'EUA', NOW());
INSERT INTO departament (id_departament, des_departament, des_location, dt_creation) VALUES (4, 'Supply Chain and Logistics', 'EUA', NOW());

-- PARTS
INSERT INTO part (id_part, des_name, des_model, num_serial_number, dt_creation) VALUES (1, 'Fenders', 'Automotive Metal Stamping', 11111, NOW());
INSERT INTO part (id_part, des_name, des_model, num_serial_number, dt_creation) VALUES (2, 'Tops', 'Automotive Metal Stamping', 22222, NOW());
INSERT INTO part (id_part, des_name, des_model, num_serial_number, dt_creation) VALUES (3, 'Body Parts', 'Automotive Metal Stamping', 33333, NOW());
INSERT INTO part (id_part, des_name, des_model, num_serial_number, dt_creation) VALUES (4, 'Axles', 'Transmissions and Powertrain', 44444, NOW());
INSERT INTO part (id_part, des_name, des_model, num_serial_number, dt_creation) VALUES (5, 'Clutches', 'Transmissions and Powertrain', 55555, NOW());
INSERT INTO part (id_part, des_name, des_model, num_serial_number, dt_creation) VALUES (6, 'Gears', 'Transmissions and Powertrain', 66666, NOW());
INSERT INTO part (id_part, des_name, des_model, num_serial_number, dt_creation) VALUES (7, 'Bearings', 'Engines and Engine Parts', 77777, NOW());
INSERT INTO part (id_part, des_name, des_model, num_serial_number, dt_creation) VALUES (8, 'Crankshafts', 'Engines and Engine Parts', 88888, NOW());
INSERT INTO part (id_part, des_name, des_model, num_serial_number, dt_creation) VALUES (9, 'Gasoline Engines', 'Engines and Engine Parts', 99999, NOW());

-- VEHICLES
INSERT INTO vehicle (id_vehicle, des_name, des_model, dt_release, dt_creation) VALUES (1, 'SUV CAR', 'SUV-1234', NOW(), NOW());
INSERT INTO vehicle (id_vehicle, des_name, des_model, dt_release, dt_creation) VALUES (2, 'COMPACT CAR', 'COMP-1234', NOW(), NOW());
INSERT INTO vehicle (id_vehicle, des_name, des_model, dt_release, dt_creation) VALUES (3, 'SPORT CAR', 'SPORT-1234', NOW(), NOW());
INSERT INTO vehicle (id_vehicle, des_name, des_model, dt_release, dt_creation) VALUES (4, 'WAGON CAR', 'WAG-1234', NOW(), NOW());

-- ROLES
INSERT INTO `role` (id_role, des_name, dt_creation) VALUES (1, 'Tire technician', NOW());
INSERT INTO `role` (id_role, des_name, dt_creation) VALUES (2, 'Process engineer', NOW());
INSERT INTO `role` (id_role, des_name, dt_creation) VALUES (3, 'Vehicle inspector', NOW());
INSERT INTO `role` (id_role, des_name, dt_creation) VALUES (4, 'Quality testing engineer', NOW());
INSERT INTO `role` (id_role, des_name, dt_creation) VALUES (5, 'Auto body repair technician', NOW());

-- PROFILES
INSERT INTO profile (id_profile, des_profile, dt_creation) VALUES (1, 'Super Admin', NOW());
INSERT INTO profile (id_profile, des_profile, dt_creation) VALUES (2, 'Gestor', NOW());
INSERT INTO profile (id_profile, des_profile, dt_creation) VALUES (3, 'Supervisor', NOW());
INSERT INTO profile (id_profile, des_profile, dt_creation) VALUES (4, 'Dados', NOW());

-- USERS
INSERT INTO `user` (id_user, des_name, des_email, des_document, des_phone, des_genre, id_role, id_departament, dt_creation)
VALUES (1, 'Joseph', 'joseph@mail.com', '00000000', '000 000 000', 'MALE', 2, 1, NOW());
INSERT INTO `user` (id_user, des_name, des_email, des_document, des_phone, des_genre, id_role, id_departament, dt_creation)
VALUES (2, 'Jacob', 'jacob@mail.com', '11111111', '111 111 111', 'MALE', 1, 4, NOW());
INSERT INTO `user` (id_user, des_name, des_email, des_document, des_phone, des_genre, id_role, id_departament, dt_creation)
VALUES (3, 'Faith', 'faith@mail.com', '33333333', '333 333 333', 'FEMALE', 4, 3, NOW());
INSERT INTO `user` (id_user, des_name, des_email, des_document, des_phone, des_genre, id_role, id_departament, dt_creation)
VALUES (4, 'John', 'john@mail.com', '44444444', '444 444 444', 'MALE', 3, 1, NOW());

-- USER_PROFILES
INSERT INTO user_profile (id_user, id_profile) VALUES (1, 1);
INSERT INTO user_profile (id_user, id_profile) VALUES (2, 3);
INSERT INTO user_profile (id_user, id_profile) VALUES (3, 2);
INSERT INTO user_profile (id_user, id_profile) VALUES (4, 4);

-- NON_COMPLIANCE

INSERT INTO non_compliance (id_non_compliance, des_non_compliance, des_operational_consequence, des_type, dt_creation)
VALUES(1, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.', 'HIGH_LEVEL',  NOW());